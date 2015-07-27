package com.topshare.airshuttle.common.util;

/**
 * 系统常量文件Constants.java
 * <p>
 * Description:系统有关产量的定义要求全部定义到本文件里来。
 */
public class Constants {
	public static final String DRIVER_CLASS_NAME = Config.getString("driverClassName", "localhost");
	public static final String URL = Config.getString("url", "localhost");
	public static final String USERNAME = Config.getString("username", "root");
	public static final String PASSWORD = Config.getString("password", "root");
	
	
	//用户信息(头像，自定义文件路径,存储方式：base.fold + userId)
	public static final String USERMSG_FOLD = Config.getString("userMsg.upload.base.fold", "");
	public static final String USERMSG_FOLD_VIRTUALPATH = Config.getString("userMsg.upload.base.fold.virtualPath", "");
	
	//用户角色(普通用户，司机)
	public static final Integer USER_ROLE_ID = Config.getInt("user.role.id", "");
	public static final Integer DRIVER_ROLE_ID = Config.getInt("driver.role.id", "");
}