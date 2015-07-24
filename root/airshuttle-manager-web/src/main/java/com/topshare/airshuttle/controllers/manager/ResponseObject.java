package com.topshare.airshuttle.controllers.manager;

/**
 * 请求的返回结果。 如果:success=true resultObject=处理结果； 如果:success=false
 * errorMessage=错误信息
 * 
 * @author liyong
 *
 */
public class ResponseObject {

	private boolean success;

	private String errorMessage;

	private Object resultObject;

	public static ResponseObject newErrorResponseObject(String errorMessage) {
		ResponseObject res = new ResponseObject();
		res.setSuccess(false);
		res.setErrorMessage(errorMessage);
		return res;
	}

	public static ResponseObject newSuccessResponseObject(Object resultObject) {
		ResponseObject res = new ResponseObject();
		res.setSuccess(true);
		res.setResultObject(resultObject);
		return res;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Object getResultObject() {
		return resultObject;
	}

	public void setResultObject(Object resultObject) {
		this.resultObject = resultObject;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
