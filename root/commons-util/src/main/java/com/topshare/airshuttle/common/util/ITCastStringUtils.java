/**
 * 
 */
package com.topshare.airshuttle.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 */
public final class ITCastStringUtils {

	public static List<Integer> arrayToList(String[] strs) {
		if (strs == null) {
			return null;
		}
		List<Integer> list = new ArrayList<Integer>();
		for (String str : strs) {
			if (str != null && str.trim().length() > 0) {
				list.add(Integer.parseInt(str.trim()));
			}
		}
		return list;
	}

	/**
	 * 逗号分割的字符串转成long数组
	 * 
	 * @param str
	 * @return
	 */
	public static List<Long> toLongArray(String str) {
		if (str == null || str.trim().length() > 0) {
			return null;
		}
		List<Long> list = new ArrayList<Long>();
		String[] strs = str.split(",");
		for (String string : strs) {
			if (string != null && string.trim().length() > 0) {
				list.add(Long.parseLong(string.trim()));
			}
		}
		return list;
	}

	public static List<Integer> toIntegerList(String str) {
		if (str == null || str.trim().length() > 0) {
			return null;
		}
		List<Integer> list = new ArrayList<Integer>();
		String[] strs = str.split(",");
		for (String string : strs) {
			if (string != null && string.trim().length() > 0) {
				list.add(Integer.parseInt(string.trim()));
			}
		}
		return list;
	}
}
