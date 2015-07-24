package com.chen.controllers;

import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

import com.chen.model.Test;

@Path("/")
public class ObjectController {

	@Get("objectConvert")
	public String objectConvert(Test test){
		
		return "@Test:"+test.getId()+";"+test.getMsg();
	}
}
