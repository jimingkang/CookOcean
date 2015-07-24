package com.topshare.airshuttle.controllers;


import net.paoding.rose.web.annotation.Path;

import org.springframework.beans.factory.annotation.Autowired;

import com.topshare.airshuttle.service.userManager.UserService;


@Path("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
}
