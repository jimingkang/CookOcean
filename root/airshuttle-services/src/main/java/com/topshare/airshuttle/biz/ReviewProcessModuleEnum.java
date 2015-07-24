package com.topshare.airshuttle.biz;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/***
 * 流程模块编号
 * @author root
 *
 */
public enum ReviewProcessModuleEnum {

	BOOK_DRIVER(0, "预约司机"),
	
	ORDER_PROCESS(1,"订单");
	
	private Integer value;

	private String title;

	ReviewProcessModuleEnum(Integer value, String title) {
		this.value = value;
		this.title = title;
	}

	public Integer getValue() {
		return this.value;
	}

	public String getTitle() {
		return this.title;
	}

	private static Map<Integer, ReviewProcessModuleEnum> cache = new HashMap<Integer, ReviewProcessModuleEnum>();

	static {
		for (ReviewProcessModuleEnum level : ReviewProcessModuleEnum.values()) {
			cache.put(level.getValue(), level);
		}
		Collections.unmodifiableMap(cache);
	}

	public static ReviewProcessModuleEnum getReviewProcessModule(Integer value) {
		return cache.get(value);
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
