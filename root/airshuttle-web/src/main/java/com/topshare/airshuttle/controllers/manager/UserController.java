package com.topshare.airshuttle.controllers.manager;


import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.topshare.airshuttle.common.util.Constants;
import com.topshare.airshuttle.common.util.DBEncrypt;
import com.topshare.airshuttle.common.util.ResponseObject;
import com.topshare.airshuttle.controllers.BaseController;
import com.topshare.airshuttle.dao.userManager.RoleDAO;
import com.topshare.airshuttle.dao.userManager.UserDAO;
import com.topshare.airshuttle.model.userManager.TAirshuttleUser;
import com.topshare.airshuttle.service.userManager.UserService;

/***
 * 用户管理模块
 * @author root
 *
 */
@Path("/user")
public class UserController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private RoleDAO roleDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private UserService userService;
	
	/***
	 * 个人用户注册
	 * @return
	 */
	@Get("/registerPerson")
	public String registerPerson(Invocation inv,TAirshuttleUser user)  throws Exception{
		
		ResponseObject ro = new ResponseObject();
			
		if(user.getUsername() == null || user.getPassword() == null ||
				user.getConfirmPwd() == null || user.getEmail() == null){
			
			ro.setSuccess(false);
			ro.setErrorMessage("用户名，密码，确认密码，邮件不能为空");
			return "@"+this.returnObjectToJson(ro);
		}else if(user.getPassword().equals(user.getConfirmPwd()) == false){
			
			ro.setSuccess(false);
			ro.setErrorMessage("密码，确认密码必须相同");
			return "@"+this.returnObjectToJson(ro);
			
			//判断登陆账户是否重复
		}else if(userDAO.judgeUserNameIsExists(user.getUsername()) > 0 ){
			
			ro.setSuccess(false);
			ro.setErrorMessage("用户名已经被注册");
			return "@"+this.returnObjectToJson(ro);
		}else if(userDAO.judgeEmailIsExists(user.getEmail()) > 0 ){
			
			ro.setSuccess(false);
			ro.setErrorMessage("邮件已经被注册");
			return "@"+this.returnObjectToJson(ro);
		}
		
		DBEncrypt dBEncrypt = new DBEncrypt();
		user.setPassword(dBEncrypt.eCode(user.getPassword()));
		
		//判断角色是否存在(这里是容灾，防止配置错误)
		if(roleDAO.getRoleById(Constants.USER_ROLE_ID) == null){
			
			logger.info("普通用户配置的角色编号有问题(user.role.id):"+Constants.USER_ROLE_ID);
			ro.setSuccess(false);
			ro.setErrorMessage("系统出现异常，请稍候再试");
			return "@"+this.returnObjectToJson(ro);
		}else{
			
			TAirshuttleUser sessionUser =  this.getSessionUser(inv);
			user.setCreatePerson(sessionUser.getId());
			user.setModifyPerson(sessionUser.getId());
			
			//同时插入普通用户和用户角色关联关系
			userService.registerUser(user);
			return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject("注册成功"));
		}
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
			
			//判断登陆账户是否重复
		}

		userDAO.updateParamById(user);
		//TODO 这里应该删除历史文件
		return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject("修改成功"));
	}
	
	/***
	 * 获取个人信息
	 * @return
	 */
	@Get("/getPersonMsg")
	public String getPersonMsg(Invocation inv) throws Exception{
		
		Integer curUserId = this.getCurUserId(inv);
		
		TAirshuttleUser user = userDAO.getUserById(curUserId);
		user.setPassword(null);
		return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject(user));
	}
}
