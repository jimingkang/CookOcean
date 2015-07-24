package com.topshare.airshuttle.common.util;

/**
 * 系统常量文件Constants.java
 * <p>
 * Description:系统有关产量的定义要求全部定义到本文件里来。
 */
public class Constants {
	public static String DRIVER_CLASS_NAME = Config.getString("driverClassName", "localhost");
	public static String URL = Config.getString("url", "localhost");
	public static String USERNAME = Config.getString("username", "root");
	public static String PASSWORD = Config.getString("password", "root");

}