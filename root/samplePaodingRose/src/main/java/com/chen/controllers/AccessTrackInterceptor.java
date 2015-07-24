package com.chen.controllers;


import java.lang.annotation.Annotation;

import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Invocation;

import org.apache.log4j.Logger;

public class AccessTrackInterceptor extends ControllerInterceptorAdapter {
	
	protected final static Logger logger = Logger.getLogger(AccessTrackInterceptor.class);
	
	public AccessTrackInterceptor() {
		setPriority(29600);
	}

	@Override
	public Class<? extends Annotation> getRequiredAnnotationClass() {
		return PriCheckRequired.class; // 这是一个注解，只有标过的controller才会接受这个拦截器的洗礼。
	}

	@Override
	public Object before(Invocation inv) throws Exception {
		// TODO ....
		logger.info("------------------------before interptor");
		return super.before(inv);
	}

	@Override
	public void afterCompletion(final Invocation inv, Throwable ex)
			throws Exception {
		// TODO ....
		logger.info("------------------------afterCompletion");
	}
}
