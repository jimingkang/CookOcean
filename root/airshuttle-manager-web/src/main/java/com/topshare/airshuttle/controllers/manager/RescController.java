package com.topshare.airshuttle.controllers.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.topshare.airshuttle.common.util.ConstantsUtil;
import com.topshare.airshuttle.common.util.IdTool;
import com.topshare.airshuttle.common.util.ResponseObject;
import com.topshare.airshuttle.controllers.BaseController;
import com.topshare.airshuttle.dao.userManager.RescDAO;
import com.topshare.airshuttle.dao.userManager.RoleRescDAO;
import com.topshare.airshuttle.dao.userManager.UserDAO;
import com.topshare.airshuttle.model.userManager.TAirshuttleResc;
import com.topshare.airshuttle.model.userManager.TAirshuttleUser;
import com.topshare.airshuttle.model.userManager.biz.RescView;
import com.topshare.airshuttle.service.userManager.RescService;

@Path("/resc")
public class RescController extends BaseController{

	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private RescService rescService;
	
	@Autowired
	private RescDAO rescDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RoleRescDAO roleRescDAO;
	
	/***
	 * 
	 * 功能描述：airshuttle项目
	 * 校验资源名称是否重复
	 * @author xieyun
	 * <p>创建日期 ：2014-7-17 下午9:45:38</p>
	 *
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	@Get("/vertifyExistsRescName")
	public String vertifyExistsRescName(@Param("resId") String resId,@Param("rescName") String rescName) throws Exception{
		
		ResponseObject ro = new ResponseObject();
		
		TAirshuttleResc searchResc = new TAirshuttleResc();
		
		searchResc.setId(resId);
		searchResc.setName(rescName);
		if(rescDAO.vertifyExistsRescName(searchResc) > 0){
			ro.setSuccess(false);
			ro.setErrorMessage("资源名重复");
			return "@"+this.returnObjectToJson(ro);
		}
		
		return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject(null));
	}
	
	/***
	 * 
	 * 功能描述：airshuttle项目
	 * 前端页面创建资源编号
	 * @author xieyun
	 * <p>创建日期 ：2014-7-21 下午3:11:29</p>
	 *
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	@Get("/createResId")
	public String createResId() throws Exception{
		
		String resId = IdTool.getId();
		return "@"+resId;
	}
	
	/***
	 * 
	 * 功能描述：airshuttle项目
	 * 菜单显示，按照当前用户获取角色资源
	 * @author xieyun
	 * <p>创建日期 ：2014-7-22 上午9:28:46</p>
	 *
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	@Get("/selectchildLevelResByUserId")
	public String selectchildLevelResByUserId(Invocation inv,@Param("parentId") String parentId,@Param("belong") Integer belong) throws Exception{
		
		HttpSession session = inv.getRequest().getSession();
		TAirshuttleUser sessionUser = (TAirshuttleUser) session.getAttribute(ConstantsUtil.SESSION_USER_ATTRIBUTE_KEY);
		
		if(parentId == null){
			
			//查询默认父节点编号
			List<TAirshuttleResc>  airshuttleRescList = rescDAO.selectResByParentId(null, belong);
			if(airshuttleRescList.size() > 0){
				parentId = airshuttleRescList.get(0).getId();
			}
		}
		
		List<TAirshuttleResc>  airshuttleRescList = rescDAO.selectchildLevelResByUserId(parentId, sessionUser.getId(), belong);
		return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject(airshuttleRescList));
	}
	
	/***
	 * 
	 * 功能描述：airshuttle项目
	 * 通过角色id查询关联资源，及所有资源
	 * @author xieyun
	 * <p>创建日期 ：2014-7-21 下午8:55:12</p>
	 *
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	@Get("/selectAllResNodeByRoleId")
	public String selectAllResNodeByRoleId(@Param("id") String id,@Param("roleId") Integer roleId,@Param("belong") Integer belong) throws Exception{
		
		if(id == null){
			
			//查询默认父节点编号
			List<TAirshuttleResc>  airshuttleRescList = rescDAO.selectResByParentId(null, belong);
			if(airshuttleRescList.size() > 0){
				id = airshuttleRescList.get(0).getId();
			}
		}
		List<String> roleRescList = roleRescDAO.getRescByRoleId(roleId);
		return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject(getNodes(id,roleRescList,belong)));
	}
	
	public List<Map<String,String>> getNodes(String parentRescId,List<String> roleRescList,Integer belong) throws Exception{
		List<Map<String,String>> showMapData = new ArrayList<Map<String,String>>();
		List<TAirshuttleResc> rescList = rescDAO.selectchildLevelRes(parentRescId,belong);
		for(TAirshuttleResc resc : rescList){
			Map<String,String> showMap = rescConvertToShowMap(resc,roleRescList);
			if(rescDAO.selectchildLevelRes(resc.getId(),belong).size() > 0){
				showMap.remove("checked");
				Gson g = new Gson();
				String json = g.toJson(getNodes(resc.getId(),roleRescList,belong));
				showMap.put("children",json);	
			}
			showMapData.add(showMap);		
		}
		return showMapData;
	}
	
	private Map<String,String> rescConvertToShowMap (TAirshuttleResc resc,List<String> roleRescList){
		Map<String,String> showMap = new HashMap<String,String>();
		showMap.put("id", String.valueOf(resc.getId()));
		showMap.put("text", resc.getName());
		if(roleRescList != null && roleRescList.contains(resc.getId())){
			showMap.put("checked", "true");
		}
		return showMap;
	}
	
	/***
	 *
	 * 功能描述：airshuttle项目
	 * 查询所有资源
	 * @author xieyun
	 * <p>创建日期 ：2014-7-21 下午5:41:51</p>
	 *
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	@Get("/selectAllResNode")
	public String selectAllResNode(@Param("belong") Integer belong){
		
		ResponseObject ro = new ResponseObject();
		try {
			List<TAirshuttleResc>  rescList = rescDAO.selectchildLevelRes(null,belong);
			List<RescView> rescViewList = new ArrayList<RescView>();
			
			if(rescList != null && rescList.size() > 0){
				
				TAirshuttleUser user = userDAO.getUserById(rescList.get(0).getCreatePerson());
				
				for(TAirshuttleResc resc : rescList){
					RescView rescView = new RescView();
					rescView.set_parentId(resc.getParentId());
					rescView.setCreatePerson(user.getUsername());
					rescView.setCreateTime(resc.getCreateTime());
					rescView.setDescription(resc.getDescription());
					rescView.setId(resc.getId());
					rescView.setModifyTime(resc.getModifyTime());
					rescView.setName(resc.getName());
					rescView.setNodeOrder(resc.getNodeOrder());
					rescView.setUri(resc.getUri());
					rescView.setUriCustomer(resc.getUriCustomer());
					rescView.setBelong(resc.getBelong());
					rescViewList.add(rescView);
				}
			}
			HashMap<String,List<RescView>> map = new HashMap<String,List<RescView>>();
			map.put("rows", rescViewList);
			return "@"+this.returnObjectToJson(map);
		} catch (Exception e) {
			e.printStackTrace();
			ro.setSuccess(false);
			ro.setErrorMessage("系统出现异常，请稍候再试");
			return "@"+this.returnObjectToJson(ro);
		}
	}
	
	@Post("/insertResc")
	public String insertResc(Invocation inv,TAirshuttleResc resc) throws Exception{
		
		HttpSession session = inv.getRequest().getSession();
		TAirshuttleUser sessionUser = (TAirshuttleUser) session.getAttribute(ConstantsUtil.SESSION_USER_ATTRIBUTE_KEY);
		
		Integer createPerson = sessionUser == null ? null : sessionUser.getId();
		
		if(resc.getName() == null || resc.getName().equals("") || resc.getUri() == null || resc.getUri().equals("") ||
		   resc.getUriCustomer() == null || resc.getUriCustomer().equals("") ||
		   resc.getNodeOrder() == null){
			
			return "@"+this.returnObjectToJson(ResponseObject.newErrorResponseObject("资源名，uri，排序，页面自定义显示 不能为空"));
		}
		
		Date curDate = new Date();
		resc.setCreatePerson(createPerson);
		resc.setModifyPerson(createPerson);
		resc.setCreateTime(curDate);
		resc.setModifyTime(curDate);
		
		rescDAO.insert(resc);
		
		return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject(resc));
	}
	
	@Post("/updateResc")
	public String updateResc(Invocation inv,TAirshuttleResc resc) throws Exception{
		
		HttpSession session = inv.getRequest().getSession();
		TAirshuttleUser sessionUser = (TAirshuttleUser) session.getAttribute(ConstantsUtil.SESSION_USER_ATTRIBUTE_KEY);

		Integer createPerson = sessionUser == null ? null :sessionUser.getId();
		
		if(resc.getName() == null || resc.getName().equals("") || resc.getUri() == null || resc.getUri().equals("") ||
				   resc.getUriCustomer() == null || resc.getUriCustomer().equals("") ||
				   resc.getNodeOrder() == null){
			
			return "@"+this.returnObjectToJson(ResponseObject.newErrorResponseObject("资源名，uri，排序，页面自定义显示 不能为空"));
		}
		
		resc.setModifyPerson(createPerson);
		
		rescDAO.updateByParam(resc);
		
		return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject(resc));
	}
	
	/***
	 * 
	 * 功能描述：airshuttle项目
	 * 同时删除角色和资源关联表
	 * @author xieyun
	 * <p>创建日期 ：2014-7-16 下午11:01:13</p>
	 *
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	@Post("/deleteRescByIds")
	public String deleteRescByIds(@Param("resIds") List<String> resIds) throws Exception{
			
		rescService.deleteResc(resIds);
		return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject(null));
	}
}
