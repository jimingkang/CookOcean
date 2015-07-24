package com.topshare.airshuttle.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * 
 * 有关日期方面的操作类
 * 
 */
public class DateUtils {

	protected static final Logger logger = Logger.getLogger(DateUtils.class);

	/**
	 * day的format形式，格式为为：2011-12-14
	 */
	public static String FORMAT_DAY = "yyyy-MM-dd";

	/**
	 * day的format形式，格式为为：2011-12-14 05:15:31
	 */
	public static String FORMAT_DAY_TIME = "yyyy-MM-dd HH:mm:ss";

	/**
	 * day的format形式，格式为为：2011年12月14日
	 */
	public static String FORMAT_CHINA_DAY = "yyyy年MM月dd日";

	/**
	 * day的format形式，格式为为：2011年12月14日 05时15分31秒
	 */
	public static String FORMAT_CHINA_DAY_TIME = "yyyy年MM月dd日 HH时mm分ss秒";

	/**
	 * 判断targetDate是否在sourceDate之前。某一个为空都返回false
	 * 
	 * @param sourceDate
	 * @param targetDate
	 * @return boolean
	 * @author tongtong.pang@renren-inc.com
	 */
	public static boolean before(Date sourceDate, Date targetDate) {
		if (sourceDate == null || targetDate == null)
			return false;
		return targetDate.before(sourceDate);
	}

	/**
	 * 格式化日期，格式为：yyyy-MM-dd
	 * 
	 * @param date
	 * @return String
	 */
	public static String formatDate(Date date) {
		return formatDate(date, null);
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @param formate
	 *            默认格式为：yyyy-MM-dd
	 * @return String
	 */
	public static String formatDate(Date date, String format) {
		if (date == null)
			date = new Date(System.currentTimeMillis());
		if (StringUtils.isBlank(format))
			format = FORMAT_DAY;

		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	/**
	 * 解析日期
	 * 
	 * @param value
	 * @param format
	 *            默认值为"yyyy-MM-dd HH:mm:ss"
	 * @return Date
	 */
	public static Date parseDate(String value, String format) {
		if (StringUtils.isBlank(value))
			return null;
		if (StringUtils.isBlank(format))
			format = FORMAT_DAY_TIME;

		DateFormat dateFormate = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = dateFormate.parse(value);
		} catch (ParseException e) {
			logger.error(e.getMessage() + ":" + value);
		}
		return date;
	}

	/**
	 * 
	 * 获取当前时间
	 * 
	 * @return Date
	 * @author tongtong.pang@renren-inc.com
	 */
	public static Date getNowTime() {
		return new Date(System.currentTimeMillis());
	}

	/**
	 * 获取指日期的星期几日期
	 * 
	 * @param date
	 *            如果date==null则默认为当前时间
	 * @param day
	 *            1：周一 2：周二 3：周三 4：周四 5：周五 6：周六 7：周日
	 * @return Date
	 * @author tongtong.pang@renren-inc.com
	 */
	public static Date getWeekDay(Date date, int day) {
		if (day < 1 || day > 7) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		if (date != null) {
			cal.setTime(date);
		}
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.set(Calendar.DAY_OF_WEEK, (day + 1) % 7);
		return cal.getTime();
	}

	/**
	 * 
	 * 获取本周星期几的日期
	 * 
	 * @param day
	 *            1：周一 2：周二 3：周三 4：周四 5：周五 6：周六 7：周日
	 * @return Date
	 * @author tongtong.pang@renren-inc.com
	 */
	public static Date getThisWeekDay(int day) {
		return getWeekDay(null, day);
	}

	/**
	 * 
	 * 获取下周星期几的日期
	 * 
	 * @param day
	 *            1：周一 2：周二 3：周三 4：周四 5：周五 6：周六 7：周日
	 * @return Date
	 * @author tongtong.pang@renren-inc.com
	 */
	public static Date getNextWeekDay(int day) {
		if (day < 1 || day > 7) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.add(Calendar.WEEK_OF_YEAR, 1);
		cal.set(Calendar.DAY_OF_WEEK, (day + 1) % 7);
		return cal.getTime();
	}

	/**
	 * 
	 * 获取上周星期几的日期
	 * 
	 * @param day
	 *            1：周一 2：周二 3：周三 4：周四 5：周五 6：周六 7：周日
	 * @return Date
	 * @author tongtong.pang@renren-inc.com
	 */
	public static Date getLastWeekDay(int day) {
		if (day < 1 || day > 7) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.add(Calendar.WEEK_OF_YEAR, -1);
		cal.set(Calendar.DAY_OF_WEEK, (day + 1) % 7);
		return cal.getTime();
	}

	/**
	 * 取得某月的第一天
	 * 
	 * @param date
	 *            如果date==null则默认为当前时间
	 * @return Date
	 * @author tongtong.pang@renren-inc.com
	 */
	public static Date getMonthFirstDate(Date date) {
		Calendar cal = Calendar.getInstance();
		if (date != null) {
			cal.setTime(date);
		}
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}

	/**
	 * 取得某月的最后一天
	 * 
	 * @param date
	 * @return Date
	 * @author tongtong.pang@renren-inc.com
	 */
	public static Date getMonthEndDate(Date date) {
		Calendar cal = Calendar.getInstance();
		if (date != null) {
			cal.setTime(date);
		}
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.DAY_OF_YEAR, -1);
		return cal.getTime();
	}

	/**
	 * 
	 * 获取本月第一天
	 * 
	 * @return Date
	 * @author tongtong.pang@renren-inc.com
	 */
	public static Date getThisMonthFirstDate() {
		return getMonthFirstDate(null);
	}

	/**
	 * 获取本月最后一天
	 * 
	 * @return Date
	 * @author tongtong.pang@renren-inc.com
	 */
	public static Date getThisMonthEndDate() {
		return getMonthEndDate(null);
	}

	/**
	 * 取下月的第一天
	 * 
	 * @return Date
	 * @author tongtong.pang@renren-inc.com
	 */
	public static Date getNextMonthFirstDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}

	/**
	 * 取下月的最后一天
	 * 
	 * @return Date
	 * @author tongtong.pang@renren-inc.com
	 * @throws
	 */
	public static Date getNextMonthEndDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 2);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.DAY_OF_YEAR, -1);
		return getMonthEndDate(cal.getTime());
	}

	/**
	 * 取上月的第一天
	 * 
	 * @return Date
	 * @author tongtong.pang@renren-inc.com
	 * @throws
	 */
	public static Date getLastMonthFirstDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}

	/**
	 * 去上月的最后天
	 * 
	 * @return Date
	 * @author tongtong.pang@renren-inc.com
	 * @throws
	 */
	public static Date getLastMonthEndDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.DAY_OF_YEAR, -1);
		return cal.getTime();
	}

	/**
	 * 取得日期是一年中的第几个月
	 * 
	 * @param date
	 *            如果date==null则默认为当前时间
	 * @return int
	 * @author tongtong.pang@renren-inc.com
	 */
	public static int getMonthOfThisYear(Date date) {
		Calendar cal = Calendar.getInstance();
		if (date != null) {
			cal.setTime(date);
		}
		return cal.get(Calendar.MONTH) + 1;

	}

	/**
	 * 取得该周是一年的第几周
	 * 
	 * @param date
	 *            如果date==null则默认为当前时间
	 * @return Integer
	 * @author tongtong.pang@renren-inc.com
	 */
	public static Integer getWeekOfThisYear(Date date) {
		Calendar cal = Calendar.getInstance();
		if (date != null) {
			cal.setTime(date);
		}
		return cal.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 取得n天后的某天
	 * 
	 * @param date
	 * @param n
	 *            正数为n天后，负数为n天前
	 * @return Date
	 * @author tongtong.pang@renren-inc.com
	 */
	public static Date getAfterDay(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		if (date != null) {
			cal.setTime(date);
		}

		cal.add(Calendar.DAY_OF_MONTH, n);
		return cal.getTime();
	}

	/**
	 * 取得n月后的某天
	 * 
	 * @param date
	 * @param n
	 * @return Date
	 * @author tongtong.pang@renren-inc.com
	 * @throws
	 */
	public static Date getAfterMonth(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		if (date != null) {
			cal.setTime(date);
		}

		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

	/**
	 * 返回从开始到结束的所有天
	 * 
	 * @param startDate
	 * @param endDate
	 * @return Set<String>
	 * @author tongtong.pang@renren-inc.com
	 */
	public static Set<String> getDates(Date startDate, Date endDate) {

		if (startDate == null || endDate == null || startDate.after(endDate)) {
			return null;
		}
		Set<String> result = new LinkedHashSet<String>();
		String _end = formatDate(endDate);
		String _start = null;
		do {
			_start = formatDate(startDate);
			result.add(_start);
			startDate = getAfterDay(startDate, 1);
		} while (!_start.equals(_end));

		return result;
	}

	/**
	 * 返回从开始时间到结束时间的所有月份
	 * 
	 * @param startDate
	 * @param endDate
	 * @return Set<String>
	 * @author tongtong.pang@renren-inc.com
	 */
	public static Set<String> getMonths(Date startDate, Date endDate) {

		if (startDate == null || endDate == null || startDate.after(endDate)) {
			return null;
		}
		Set<String> result = new LinkedHashSet<String>();
		String _end = formatDate(endDate, "yyyy-MM");
		String _start = null;
		do {
			_start = formatDate(startDate, "yyyy-MM");
			result.add(_start);
			startDate = getAfterMonth(startDate, 1);
		} while (!_start.equals(_end));

		return result;
	}

	/**
	 * 根据日期计算星座
	 * 
	 * @param month
	 * @param date
	 * @author tongtong.pang@renren-inc.com
	 */
	public static String getConstellation(Date date) {
		Calendar cal = Calendar.getInstance();
		if (date != null) {
			cal.setTime(date);
		}
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);

		return getConstellation(month, day);
	}

	/**
	 * 根据月份和日期计算星座
	 * 
	 * @param month
	 * @param day
	 * @return String
	 * @author tongtong.pang@renren-inc.com
	 */
	public static String getConstellation(int month, int day) {
		String s = "魔羯水瓶双鱼牡羊金牛双子巨蟹狮子处女天秤天蝎射手魔羯";
		int[] arr = { 20, 19, 21, 21, 21, 22, 23, 23, 23, 23, 22, 22 };
		int num = month * 2 - (day < arr[month - 1] ? 2 : 0);
		return s.substring(num, num + 2);
	}

	/**
	 * 
	 * 根据年份计算生肖
	 * 
	 * @param year
	 * @return String
	 * @author tongtong.pang@renren-inc.com
	 */
	public static String getZodiac(int year) {
		if (year < 1900)
			return null;
		String str = "鼠牛虎兔龙蛇马羊猴鸡狗猪";
		int num = (year - 1900) % 12;
		return str.substring(num, num + 1);
	}

	/**
	 * 
	 * 根据日期计算生肖
	 * 
	 * @param date
	 * @return String
	 * @author tongtong.pang@renren-inc.com
	 */
	public static String getZodiac(Date date) {
		Calendar cal = Calendar.getInstance();
		if (date != null) {
			cal.setTime(date);
		}
		int year = cal.get(Calendar.YEAR);

		return getZodiac(year);
	}

	/**
	 * 返回date1-dat2相差的秒数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int subSecond(Date date1, Date date2) {
		long d1 = date1.getTime();
		long d2 = date2.getTime();
		int sub = (int) ((d1 - d2) / 1000);
		return sub;
	}

	public static void main(String[] args) {
		Date d1 = parseDate("2012-12-24", "yyyy-MM-dd");
		Date d2 = parseDate("2012-12-25", "yyyy-MM-dd");
		System.out.println(subSecond(d1, d2));
	}
}
