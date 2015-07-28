package com.topshare.airshuttle.controllers;

import org.apache.log4j.Logger;

import com.topshare.airshuttle.common.util.ResponseObject;

import net.paoding.rose.web.ControllerErrorHandler;
import net.paoding.rose.web.Invocation;

/***
 * 统一异常处理，前期不用通过异常进行区分处理，简单点，后面业务发展需要再延伸
 * @author root
 *
 */
public class ErrorHandler extends BaseController implements ControllerErrorHandler {

	private Logger logger = Logger.getLogger(this.getClass());
	
    public Object onError(Invocation inv, Throwable ex) throws Throwable {

    	ResponseObject ro = new ResponseObject();
    	
    	logger.error("handle err:", ex);
    	
        if (ex instanceof Exception) {
           
        	ro.setSuccess(false);
			ro.setErrorMessage("系统出现异常，请稍候再试");
			return "@"+this.returnObjectToJson(ro);
        }
        
        return "@error";
    }
}
