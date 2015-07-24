package com.topshare.airshuttle.controllers;

import com.google.gson.Gson;


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
}
