package com.chen.controllers.ajax;


import java.util.HashMap;
import java.util.Map;

import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

import org.json.JSONObject;

@Path("")
public class AjaxController {
	
	@Get("home")
	public String home(){
		
		return "home";
	}
	
	@Get("json")
	public String returnJson(){
		
		Map<String,String> showMap = new HashMap<String,String>();
		showMap.put("show", "test");
		
	    JSONObject jo = new JSONObject(showMap);	
	    return "@json:"+jo.toString();
	}
	
	@Get("text")
	public String returnText(){
		
	    return "@text";
	}
}
