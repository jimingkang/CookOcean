package com.topshare.airshuttle.controllers.manager;

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

import com.topshare.airshuttle.common.util.ConstantsUtil;
import com.topshare.airshuttle.common.util.DBEncrypt;
import com.topshare.airshuttle.common.util.Page;
import com.topshare.airshuttle.common.util.ResponseObject;
import com.topshare.airshuttle.controllers.BaseController;
import com.topshare.airshuttle.dao.userManager.RoleDAO;
import com.topshare.airshuttle.dao.userManager.UserDAO;
import com.topshare.airshuttle.model.userManager.TAirshuttleUser;
import com.topshare.airshuttle.service.userManager.UserService;

@Path("/user")
public class UserController extends BaseController{

	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private RoleDAO roleDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private UserService userService;
	
	/***
	 *
	 * 功能描述：airshuttle项目
	 * 获取当前用户用户名
	 * @author xieyun
	 * <p>创建日期 ：2014-7-22 上午11:04:03</p>
	 *
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	@Get("/getSessionUserName")
	public String getSessionUserName(Invocation inv){
		HttpSession session = inv.getRequest().getSession();
		TAirshuttleUser user = (TAirshuttleUser) session.getAttribute(ConstantsUtil.SESSION_USER_ATTRIBUTE_KEY);
		return "@"+this.returnObjectToJson(user.getUsername());
	}
	
	/***
	 *
	 * 功能描述：airshuttle项目 新增用户
	 *
	 * @author xieyun
	 *         <p>
	 *         创建日期 ：2014-7-16 下午7:46:29
	 *         </p>
	 *
	 *
	 *         <p>
	 *         修改历史 ：(修改人，修改时间，修改原因/内容)
	 *         </p>
	 */
	@Post("/insertUser")
	public String insertUser(Invocation inv,@Param("username") String username,@Param("description") String description,
			@Param("password") String password,@Param("sex") Integer sex,@Param("enabled") Integer enabled) throws Exception{
		
		ResponseObject ro = new ResponseObject();
		TAirshuttleUser user = new TAirshuttleUser();
			
		HttpSession session = inv.getRequest().getSession();
		TAirshuttleUser sessionUser = (TAirshuttleUser) session.getAttribute(ConstantsUtil.SESSION_USER_ATTRIBUTE_KEY);
		Integer curUserId = sessionUser == null ? null : sessionUser.getId();
			
		if(username == null || username.equals("") || sex == null){
			
			ro.setSuccess(false);
			ro.setErrorMessage("用户名，性别不能为空");
			return "@"+this.returnObjectToJson(ro);
		}

		if(sex != 0  && sex != 1){
			ro.setSuccess(false);
			ro.setErrorMessage("性别填写格式错误");
			return "@"+this.returnObjectToJson(ro);
		}

		TAirshuttleUser searchUser = new TAirshuttleUser();
		searchUser.setUsername(username);
		if(userDAO.vertifyExistsUserName(searchUser) > 0){
			ro.setSuccess(false);
			ro.setErrorMessage("用户名重复");
			return "@"+this.returnObjectToJson(ro);
		}
		
		user.setUsername(username);
		//密码加密
		DBEncrypt dBEncrypt = new DBEncrypt();
		if(password == null || password.equals("")){
			user.setPassword(dBEncrypt.eCode(ConstantsUtil.DEFAULT_INIT_USER_PASSWORD));
		}else{
			user.setPassword(dBEncrypt.eCode(password));
		}
		
		Date curDate = new Date();
		user.setSex(sex);
		user.setCreatePerson(curUserId);
		user.setEnabled(enabled);
		user.setModifyPerson(curUserId);
		user.setCreateTime(curDate);
		user.setModifyTime(curDate);
		user.setDescription(description);
		Integer userId = userDAO.insert(user);
		user.setId(userId);
		
		user.setPassword(null);
		return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject(user));
	}

	/***
	 * 修改用户个人信息
	 * @return
	 */
	@Post("/modifyPersonMsg")
	public String modifyPersonMsg(TAirshuttleUser user) throws Exception{
		
		ResponseObject ro = new ResponseObject();
		
		if(user.getConfirmPwd() != null && user.getPassword().equals(user.getConfirmPwd()) == false){
			
			ro.setSuccess(false);
			ro.setErrorMessage("密码，确认密码必须相同");
			return "@"+this.returnObjectToJson(ro);
		}

		userDAO.updateParamById(user);
		return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject("修改成功"));
	}
	
	/***
	 * 显示用户描述信息
	 * @return
	 * @throws Exception
	 */
	@Get("/getShowUserDesc")
	public String getShowUserDesc(Invocation inv) throws Exception{
		
		
		//获取当前session用户
		TAirshuttleUser sessionUser =  this.getSessionUser(inv);
		
		//获取用户角色
		List<String> roleNameList = roleDAO.getByUserId(sessionUser.getId());
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("sessionUser", sessionUser);
		map.put("roleNameList", roleNameList);
		
		return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject(map));
	}
	
	/***
	 *
	 * 功能描述：airshuttle项目 修改用户
	 * 可以同时修改用户角色
	 * @author xieyun
	 *         <p>
	 *         创建日期 ：2014-7-16 下午7:46:52
	 *         </p>
	 *
	 *
	 *         <p>
	 *         修改历史 ：(修改人，修改时间，修改原因/内容)
	 *         </p>
	 */
	@Post("/updateUser")
	public String updateUser(Invocation inv,@Param("userId")  Integer userId,@Param("username")  String username,
			@Param("description")  String description,@Param("sex")  Integer sex,@Param("enabled")  Integer enabled) throws Exception{
		ResponseObject ro = new ResponseObject();
		TAirshuttleUser user = new TAirshuttleUser();
		HttpSession session = inv.getRequest().getSession();
		TAirshuttleUser sessionUser = (TAirshuttleUser) session.getAttribute(ConstantsUtil.SESSION_USER_ATTRIBUTE_KEY);
		Integer curUserId = sessionUser == null ? null : sessionUser.getId();
		
		if(username == null || username.equals("") || enabled == null || enabled.equals("") || sex == null || sex.equals("") ){
			ro.setSuccess(false);
			ro.setErrorMessage("用户名，性别,是否启用不能为空");
			return "@"+this.returnObjectToJson(ro);
		}

		if(sex != 0  && sex != 1){
			ro.setSuccess(false);
			ro.setErrorMessage("性别填写格式错误");
			return "@"+this.returnObjectToJson(ro);
		}

		if(enabled != 0 && enabled != 1){
			ro.setSuccess(false);
			ro.setErrorMessage("是否启用格式错误");
			return "@"+this.returnObjectToJson(ro);
		}

		user.setId(userId);
		user.setUsername(username);
		user.setDescription(description);
		
		TAirshuttleUser searchUser = new TAirshuttleUser();
		searchUser.setId(userId);
		searchUser.setUsername(username);
		if(userDAO.vertifyExistsUserName(searchUser) > 0){
			
			ro.setSuccess(false);
			ro.setErrorMessage("用户名重复");
			return "@"+this.returnObjectToJson(ro);
		}
		user.setSex(sex);
		user.setEnabled(enabled);
		user.setModifyPerson(curUserId);
		user.setModifyTime(new Date());
		userDAO.updateParamById(user);
		
		//判断是否是修改自己的信息
		if(curUserId.equals(userId)){
			sessionUser.setUsername(username);
			if(sex != null){
				sessionUser.setSex(sex);
			}
		}

		return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject(user));
	}

	/***
	 * 
	 * @param rows 每页行数
	 * @param page 当前页数
	 * @param search_key 搜索
	 * @return
	 */
	@Get("/userList")
	public String userList(@Param("rows") final Integer pageSize,@Param("page") final Integer pageNumber,
			@Param("search_key") String search_key) throws Exception{
		
		TAirshuttleUser user = new TAirshuttleUser();
		
		if(search_key != null && !search_key.equals("")){
			
			user.setUsername("%"+search_key+"%");
		}
		
		Page<TAirshuttleUser> page = userService.getPageByParam(user, pageNumber, pageSize);

		HashMap<String,Object> hashmap = new HashMap<String,Object>();
			
		hashmap.put("total", page.getTotalCount());								//总行数
		hashmap.put("rows", page.getItems() == null ? "" : page.getItems());
		return "@"+this.returnObjectToJson(hashmap);
	}
	
	/***
	 *
	 * 功能描述：airshuttle项目
	 * 删除用户表，同时删除用户角色关联表
	 * @author xieyun
	 * <p>创建日期 ：2014-7-17 上午9:41:11</p>
	 *
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	@Post("/deleteUserByIds")
	public String deleteUserByIds(@Param("userIds") List<Integer> userIds) throws Exception{
			
		userService.deleteByIds(userIds);
		return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject(null));
	}
	
	
}
