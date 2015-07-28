package com.topshare.airshuttle.controllers;

import javax.servlet.http.HttpSession;

import net.paoding.rose.web.Invocation;

import com.google.gson.Gson;
import com.topshare.airshuttle.common.util.ConstantsUtil;
import com.topshare.airshuttle.model.userManager.TAirshuttleUser;


public class BaseController {

	/***
	 * 将json信息发送给前台展现
	 * 
	 * @param fangleComments
	 */
	//json/jsonp格式
	public String returnObjectToJson(Object obj) {
		Gson g = new Gson();
		return g.toJson(obj);
	}
	
	/***
	 * 获取会话用户
	 * @param inv
	 * @return
	 */
	public TAirshuttleUser getSessionUser(Invocation inv){
		
		HttpSession session = inv.getRequest().getSession();
		TAirshuttleUser sessionUser = (TAirshuttleUser) session.getAttribute(ConstantsUtil.SESSION_USER_ATTRIBUTE_KEY);
		return sessionUser;
	}
	
	/***
	 * 获取当前用户编号
	 * @param inv
	 * @return
	 */
	public Integer getCurUserId(Invocation inv){
		
		HttpSession session = inv.getRequest().getSession();
		TAirshuttleUser sessionUser = (TAirshuttleUser) session.getAttribute(ConstantsUtil.SESSION_USER_ATTRIBUTE_KEY);
		Integer curUserId = sessionUser == null ? null : sessionUser.getId();
		
		return curUserId;
	}
}
