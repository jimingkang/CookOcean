package com.topshare.airshuttle.biz.bookDriverProcess;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum UserBookDriverProcessEnum {

	/***
	 * 审核申请默认状态
	 */
	AUDIT_ING(0, "初始化"),

	/**
	 * 同意
	 */
	AUDIT_PASS(1, "同意"),

	/**
	 * 拒绝
	 */
	REFUSE(2, "拒绝"),
	
	/**
	 * 重新申请
	 */
	REAPPLY(3, "重新申请");
	
	private Integer value;

	private String title;

	UserBookDriverProcessEnum(Integer value, String title) {
		this.value = value;
		this.title = title;
	}

	public Integer getValue() {
		return this.value;
	}

	public String getTitle() {
		return this.title;
	}

	private static Map<Integer, UserBookDriverProcessEnum> cache = new HashMap<Integer, UserBookDriverProcessEnum>();

	static {
		for (UserBookDriverProcessEnum level : UserBookDriverProcessEnum.values()) {
			cache.put(level.getValue(), level);
		}
		Collections.unmodifiableMap(cache);
	}

	public static UserBookDriverProcessEnum getBookDriverProcessStatus(Integer value) {
		return cache.get(value);
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
