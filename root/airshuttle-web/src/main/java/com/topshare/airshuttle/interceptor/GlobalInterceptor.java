package com.topshare.airshuttle.interceptor;

import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Invocation;

import org.apache.log4j.Logger;


/***
 * 全局拦截器(全局拦截器)
 * rose框架能够处理的流程才能被拦截，如果直接请求jsp，rose框架不走流程，就不会执行拦截器
 * @author root
 *
 */
public class GlobalInterceptor extends ControllerInterceptorAdapter {

	protected static final Logger logger = Logger.getLogger(GlobalInterceptor.class);
	
	@Override
    protected Object after(Invocation inv, Object instruction) throws Exception {
        //System.out.println("GlobalInterceptor -> after");
        return super.after(inv, instruction);
    }

    @Override
    protected Object before(Invocation inv) throws Exception {
    	
        return super.before(inv);
    }
    
}