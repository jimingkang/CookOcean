package com.chen.controllers;

import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.portal.Portal;

@Path("/")
public class PortalController {

	@Get("/3.7")
    public String portal(Portal portal) {
        portal.addWindow("p1", "/wp1");
        portal.addWindow("p2", "/wp2");
        return "portal";
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
