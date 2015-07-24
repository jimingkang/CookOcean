package com.chen.controllers;

/**
 * @author chenzhen@xiaomi.com
 * 2010-12-1 
 */
import org.apache.log4j.Logger;

import net.paoding.rose.web.ControllerErrorHandler;
import net.paoding.rose.web.Invocation;

public class ErrorHandler implements ControllerErrorHandler {

	protected final static Logger logger = Logger.getLogger(AccessTrackInterceptor.class);
	
    public Object onError(Invocation inv, Throwable ex) throws Throwable {

    	// TODO logger.error("handle err:", ex);
        if (ex instanceof RuntimeException) {
            return "@runtime";
        }
        
        logger.error("handle err:", ex);

        return "@error";
    }
}
