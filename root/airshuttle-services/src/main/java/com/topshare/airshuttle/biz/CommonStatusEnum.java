package com.topshare.airshuttle.biz;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/***
 * 车辆审核状态
 * @author root
 *
 */
public enum CommonStatusEnum {

	/***
	 * 正在审核
	 */
	AUDIT_ING(0, "初始化"),

	/**
	 * 审核通过
	 */
	AUDIT_PASS(1, "审核通过"),

	/**
	 * 审核未通过
	 */
	AUDIT_NOT_PASS(2, "审核未通过"),
	/**
	 * 已经删除
	 */
	AUDIT_DELETE(3, "已经删除");

	private Integer value;

	private String title;

	CommonStatusEnum(Integer value, String title) {
		this.value = value;
		this.title = title;
	}

	public Integer getValue() {
		return this.value;
	}

	public String getTitle() {
		return this.title;
	}

	private static Map<Integer, CommonStatusEnum> cache = new HashMap<Integer, CommonStatusEnum>();

	static {
		for (CommonStatusEnum level : CommonStatusEnum.values()) {
			cache.put(level.getValue(), level);
		}
		Collections.unmodifiableMap(cache);
	}

	public static CommonStatusEnum getCommonStatus(Integer value) {
		return cache.get(value);
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
