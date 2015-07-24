package com.topshare.airshuttle.controllers.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.topshare.airshuttle.common.util.ConstantsUtil;
import com.topshare.airshuttle.common.util.Page;
import com.topshare.airshuttle.controllers.BaseController;
import com.topshare.airshuttle.dao.userManager.RoleDAO;
import com.topshare.airshuttle.dao.userManager.RoleRescDAO;
import com.topshare.airshuttle.dao.userManager.UserRoleDAO;
import com.topshare.airshuttle.model.userManager.TAirshuttleRole;
import com.topshare.airshuttle.model.userManager.TAirshuttleUser;
import com.topshare.airshuttle.model.userManager.TAirshuttleUserRole;
import com.topshare.airshuttle.service.userManager.RoleRescService;
import com.topshare.airshuttle.service.userManager.RoleService;
import com.topshare.airshuttle.service.userManager.UserRoleService;


/**
*
* 项目名:airshuttle项目
*
* 功能描述：
*
* @author xieyun
*
* <p>日期：2014-7-17-下午10:37:12
*/
@Path("/role")
public class RoleController extends BaseController{

	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private RoleDAO roleDAO;
	
	@Autowired
	private UserRoleDAO userRoleDAO;
	
	@Autowired
	private RoleRescDAO roleRescDAO;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RoleRescService roleRescService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	/***
	 * 
	 * 功能描述：airshuttle项目
	 * 插入用户角色关联关系
	 * @author xieyun
	 * <p>创建日期 ：2014-7-21 下午4:13:58</p>
	 *
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	@Post("/insertUserRole")
	public String insertUserRole(Invocation inv,@Param("roleIds") List<Integer> roleIds,@Param("userId") Integer userId){
		
		ResponseObject ro = new ResponseObject();
		
		try {
			
			List<TAirshuttleUserRole> userRoleList = new ArrayList<TAirshuttleUserRole>();
			
			for(Integer roleId : roleIds){
				
				TAirshuttleUserRole userRole = new TAirshuttleUserRole();
				userRole.setUserId(userId);
				userRole.setRoleId(roleId);
				userRoleList.add(userRole);
			}
			
			if(userRoleList.size() > 0){
				userRoleService.insertUserRole(userRoleList,userId);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			ro.setSuccess(false);
			ro.setErrorMessage("系统出现异常，请稍候再试");
			return "@"+this.returnObjectToJson(ro);
		}

		return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject(null));
	}
	
	/***
	 * 
			* 功能描述：airshuttle项目
			* 新增角色资源
			* @author xieyun
			* <p>创建日期 ：2014-7-21 下午10:08:37</p>
			*
			*
			* <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	@Post("/insertRoleResc")
	public String insertRoleResc(@Param("roleId") Integer roleId,@Param("rescIds") List<String> rescIds){
		
		ResponseObject ro = new ResponseObject();
		
		try {
			
			//先删除关联，然后再插入
			roleRescService.insertRoleResc(roleId, rescIds);
		} catch (Exception e) {
			e.printStackTrace();
			ro.setSuccess(false);
			ro.setErrorMessage("系统出现异常，请稍候再试");
			return "@"+this.returnObjectToJson(ro);
		}
		
		return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject(null));
	}
	
	/***
	 * 
	 * 功能描述：airshuttle项目
	 * 查询角色对应资源编号
	 * @author xieyun
	 * <p>创建日期 ：2014-7-17 下午10:31:34</p>
	 *
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	@Get("/searchRoleSelectResc")
	public String searchRoleSelectResc(@Param("roleId") Integer roleId){
		ResponseObject ro = new ResponseObject();
		
		try {
			
			List<String> rescIdsList = roleRescDAO.getRescByRoleId(roleId);
			return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject(rescIdsList));
		} catch (Exception e) {
			e.printStackTrace();
			ro.setSuccess(false);
			ro.setErrorMessage("系统出现异常，请稍候再试");
			return "@"+this.returnObjectToJson(ro);
		}
	}
	
	/***
	 * 
	 * 功能描述：airshuttle项目
	 * 角色不多，就不分页了
	 * @author xieyun
	 * <p>创建日期 ：2014-7-16 下午9:44:21</p>
	 *
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	@Get("/queryRoleList")
	public String queryRoleList(@Param("rows") final Integer pageSize,@Param("page") final Integer pageNumber){

		Page<TAirshuttleRole> page =  roleService.getPageByParam(null,pageNumber, pageSize);
		HashMap<String,Object> hashmap = new HashMap<String,Object>();
			
		hashmap.put("total", page.getTotalCount());//总行数
		hashmap.put("rows", page.getItems()  == null ? "" : page.getItems());
		return "@"+this.returnObjectToJson(hashmap);
	}
	
	/***
	 * 
	 * 功能描述：airshuttle项目
	 * 通过用户编号查询用户角色
	 * @author xieyun
	 * <p>创建日期 ：2014-7-16 下午9:44:21</p>
	 *
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	@Get("/queryRoleListByUserId")
	public String queryRoleListByUserId(@Param("userId") Integer userId,@Param("pageSize") Integer pageSize,
			@Param("curPageNum") Integer curPageNum){

		List<TAirshuttleRole> list =  this.roleDAO.getByParam(null,null, null);
		
		TAirshuttleUserRole userRole = new TAirshuttleUserRole();
		userRole.setUserId(userId);
		List<Integer> userRoleIdList = userRoleDAO.getByParam(userRole);
		
		if(userRoleIdList != null){
			
			for(TAirshuttleRole role : list){
				
				//查询用户选中的权限
				for(Integer roleId : userRoleIdList){
					
					if(role.getId() == roleId){
						
						role.setChecked("true");
					}
				}
			}
		}
		
		return "@"+this.returnObjectToJson(list);
	}
	
	/***
	 * 
	 * 功能描述：airshuttle项目
	 * 通过角色名称搜索角色
	 * @author xieyun
	 * <p>创建日期 ：2014-7-16 下午9:35:46</p>
	 *
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	@Get("/searchRoleByName")
	public String searchRoleByName(@Param("rolename") String rolename,@Param("pageSize") Integer pageSize,
			@Param("curPageNum") Integer curPageNum){
		
		ResponseObject ro = new ResponseObject();
		
		try {
			if(rolename == null || rolename.equals("") ){

				return "@"+this.returnObjectToJson(ResponseObject.newErrorResponseObject("角色名不能为空"));
			}
			
			TAirshuttleRole role = new TAirshuttleRole();
			role.setName("%"+rolename+"%");
			Page<TAirshuttleRole> page =  roleService.getPageByParam(role,curPageNum, pageSize);
			HashMap<String,Object> hashmap = new HashMap<String,Object>();
			if(page != null){
				
				hashmap.put("total", page.getTotalCount());//总行数
				hashmap.put("rows", page.getItems());
				return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject(hashmap));
			}
			
			return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject(null));
		} catch (Exception e) {
			
			e.printStackTrace();
			ro.setSuccess(false);
			ro.setErrorMessage("系统出现异常，请稍候再试");
			return "@"+this.returnObjectToJson(ro);
		}
	}
	
	/***
	 * 
	 * 功能描述：airshuttle项目
	 * 新增角色
	 * @author xieyun
	 * <p>创建日期 ：2014-7-16 下午8:09:24</p>
	 *
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	@Post("/insertRole")
	public String insertRole(Invocation inv,@Param("rolename") String rolename,@Param("description") String description){
		
		ResponseObject ro = new ResponseObject();
		TAirshuttleRole role = new TAirshuttleRole();
		try {
			HttpSession session = inv.getRequest().getSession();
			TAirshuttleUser sessionUser = (TAirshuttleUser) session.getAttribute(ConstantsUtil.SESSION_USER_ATTRIBUTE_KEY);
			Integer curUserId = sessionUser == null ? null : sessionUser.getId();

			if(rolename == null || rolename.equals("") ){

				return "@"+this.returnObjectToJson(ResponseObject.newErrorResponseObject("角色名不能为空"));
			}
			
			TAirshuttleRole roleSearch = new TAirshuttleRole();
			roleSearch.setName(rolename);
			
			if(roleDAO.vertifyExistsRoleName(roleSearch) > 0){
				
				return "@"+this.returnObjectToJson(ResponseObject.newErrorResponseObject("角色名称已经存在"));
			}
			
			role.setName(rolename);
			if(description != null && !description.equals("")){
				
				role.setDescription(description);
			}
			
			role.setCreatePerson(curUserId);
			role.setModifyPerson(curUserId);
			roleDAO.insert(role);
			
		} catch (Exception e) {
			e.printStackTrace();
			ro.setSuccess(false);
			ro.setErrorMessage("系统出现异常，请稍候再试");
			return "@"+this.returnObjectToJson(ro);
		}

		return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject(null));
	}
	
	@Post("/updateRole")
	public String updateRoleById(Invocation inv,@Param("roleId") Integer roleId,@Param("rolename") String rolename,
			@Param("description") String description){
		
		ResponseObject ro = new ResponseObject();
		TAirshuttleRole role = new TAirshuttleRole();
		try {
			
			HttpSession session = inv.getRequest().getSession();
			TAirshuttleUser sessionUser = (TAirshuttleUser) session.getAttribute(ConstantsUtil.SESSION_USER_ATTRIBUTE_KEY);
			Integer curUserId = sessionUser == null ? null : sessionUser.getId();
			
			if(rolename == null || rolename.equals("") ){
				
				return "@"+this.returnObjectToJson(ResponseObject.newErrorResponseObject("角色名不能为空"));
			}
			
			
			role.setId(roleId);
			role.setName(rolename);
			
			TAirshuttleRole roleSearch = new TAirshuttleRole();
			roleSearch.setId(roleId);
			roleSearch.setName(rolename);
			
			if(roleDAO.vertifyExistsRoleName(roleSearch) > 0){
				
				return "@"+this.returnObjectToJson(ResponseObject.newErrorResponseObject("角色名称已经存在"));
			}
			
			if(description != null && !description.equals("")){

				role.setDescription(description);
			}
			role.setModifyPerson(curUserId);
			
			roleDAO.updateByParam(role);
			
			return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject(role));
		} catch (Exception e) {
			
			e.printStackTrace();
			ro.setSuccess(false);
			ro.setErrorMessage("系统出现异常，请稍候再试");
			return "@"+this.returnObjectToJson(ro);
		}
	}
	
	/***
	 * 
	 * 功能描述：airshuttle项目
	 * （删除一个角色，会同时删除角色和用户的关联关系）
	 * @author xieyun
	 * <p>创建日期 ：2014-7-16 下午8:23:31</p>
	 *
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	@Post("/deleteRoleByRoleIds")
	public String deleteRoleByRoleIds(@Param("roleIds") List<Integer> roleIds){
		
		ResponseObject ro = new ResponseObject();
		try {
			
			roleService.deleteRole(roleIds);;
		} catch (Exception e) {
			e.printStackTrace();
			ro.setSuccess(false);
			ro.setErrorMessage("系统出现异常，请稍候再试");
			return "@"+this.returnObjectToJson(ro);
		}

		return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject("SUCCESS"));
	}
}
