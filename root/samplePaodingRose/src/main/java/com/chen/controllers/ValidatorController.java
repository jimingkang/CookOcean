package com.chen.controllers;

import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

@Path("/")
public class ValidatorController {

	@Get("/notBlank")
    public String notBlank(@NotBlank @Param("messages") String messages) throws Exception {
        return "@notBlank:"+messages;
    }
}
