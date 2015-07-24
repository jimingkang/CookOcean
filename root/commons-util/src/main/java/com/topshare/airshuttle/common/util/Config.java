package com.topshare.airshuttle.common.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;


/**
 * 读取配置文件信息类
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 */
public class Config {
	private static final String DEFAULT_CONF_FILE = "/base.properties";

	private static Properties config = null;

	static {
		InputStream in = null;
		try {
			String absolutePath = Config.class.getResource(getConfigFile())
					.getFile();
			config = new Properties();
			in = new BufferedInputStream(new FileInputStream(absolutePath));
			config.load(in);
		} catch (Exception e) {
			throw new ConfigException(e);
		}finally{
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}

	}
	
	
	protected static String getConfigFile(){
		return DEFAULT_CONF_FILE;
	}

	public static String getString(String key, String defaultValue) {
		return config.getProperty(key, defaultValue);
	}

	public static String getString(String key) {
		return config.getProperty(key, null);
	}
	public static String getString(String key, String defaultValue,String code) {
		try {
			return new String(config.getProperty(key, defaultValue).getBytes("ISO8859_1"),code);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		return null;
		}
	}

	public static int getInt(String key, String defaultValue) {
		return Integer.valueOf(config.getProperty(key, defaultValue));
	}

	public static int getInt(String key) {
		return Integer.valueOf(config.getProperty(key));
	}


	public static boolean getBoolean(String key, String defaultValue) {
		return Boolean.valueOf(config.getProperty(key, defaultValue));
	}

	public static boolean getBoolean(String key) {
		return Boolean.valueOf(config.getProperty(key,"false"));
	}

	public static float getFloat(String key, String defaultValue) {
		return Float.valueOf(config.getProperty(key, defaultValue));
	}

	public static float getFloat(String key) {
		return Float.valueOf(config.getProperty(key, "0"));
	}
}
