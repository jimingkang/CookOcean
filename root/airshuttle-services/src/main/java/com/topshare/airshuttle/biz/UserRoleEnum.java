package com.topshare.airshuttle.biz;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum UserRoleEnum {

	/***
	 * 飞友团
	 */
	FLY_GROUP(0, "飞友团"),

	/**
	 * 室友团
	 */
	HOUSE_GROUP(1, "室友团"),

	/**
	 * 司机
	 */
	DRIVER(2, "司机");
	
	private Integer value;

	private String title;

	UserRoleEnum(Integer value, String title) {
		this.value = value;
		this.title = title;
	}

	public Integer getValue() {
		return this.value;
	}

	public String getTitle() {
		return this.title;
	}

	private static Map<Integer, UserRoleEnum> cache = new HashMap<Integer, UserRoleEnum>();

	static {
		for (UserRoleEnum level : UserRoleEnum.values()) {
			cache.put(level.getValue(), level);
		}
		Collections.unmodifiableMap(cache);
	}

	public static UserRoleEnum getUserRole(Integer value) {
		return cache.get(value);
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
