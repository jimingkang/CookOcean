package com.chen.controllers;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.var.Flash;

@Path("/")
public class FlashController {

	@Get("/flash1")
	public String flashStep1(Flash flash) {
		flash.add("msg", "修改成功！");
		return "r:/flash2";
	}

	@Get("/flash2")
	public String flashStep2(Invocation inv, Flash flash) {
		inv.addModel("info", flash.get("msg"));
		return "flash";
	}
}
