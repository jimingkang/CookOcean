package com.topshare.airshuttle.biz.orderProcess;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum OrderProcessEnum {

	/***
	 * 审核申请默认状态
	 */
	AUDIT_ING(0, "初始化"),

	/**
	 * 完成接机
	 */
	COMPLETE_RECEPTION_AIR(1, "完成接机"),

	/**
	 * 支付成功
	 */
	PAY_SUCCESS(2, "支付成功"),
	
	/**
	 * 申请退款
	 */
	REQUEST_A_REFUND(3, "申请退款"),
	
	/**
	 * 申请退款成功
	 */
	REQUEST_A_REFUND_OK(4, "申请退款成功"),
	
	/**
	 * 申请退款失败
	 */
	REQUEST_A_REFUND_FAULT(5, "申请退款失败");
	
	private Integer value;

	private String title;

	OrderProcessEnum(Integer value, String title) {
		this.value = value;
		this.title = title;
	}

	public Integer getValue() {
		return this.value;
	}

	public String getTitle() {
		return this.title;
	}

	private static Map<Integer, OrderProcessEnum> cache = new HashMap<Integer, OrderProcessEnum>();

	static {
		for (OrderProcessEnum level : OrderProcessEnum.values()) {
			cache.put(level.getValue(), level);
		}
		Collections.unmodifiableMap(cache);
	}

	public static OrderProcessEnum getBookDriverProcessStatus(Integer value) {
		return cache.get(value);
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
