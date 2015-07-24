package com.chen.controllers;

import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.portal.Pipe;

@Path("/")
public class PipeController {

	@Get("/3.8")
	public String pipe(Pipe pipe) {
		pipe.addWindow("p1", "/wp1");
		pipe.addWindow("p2", "/wp2");
		return "pipe";
	}

	@Get("/wp1")
	public String portal1() {
		return "@this is p1";
	}

	@Get("/wp2")
	public String portal2() {
		return "@this is p2";
	}
}
