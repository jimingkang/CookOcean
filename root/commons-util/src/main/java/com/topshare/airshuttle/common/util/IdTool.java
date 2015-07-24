package com.topshare.airshuttle.common.util;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.SimpleTimeZone;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

public class IdTool {

	private static final Logger logger = Logger.getLogger(IdTool.class);

	public IdTool() {

	}

	/**
	 * 
	 * 功能描述：判断目录是否在服务器上存在，如果不存在，创建该目录。
	 * 方法名:mkdirs 访问类:Tool
	 * 
	 * @param path
	 *            绝对路径
	 */
	public static void mkdirs(String path) {
		if (!(new File(path).isDirectory())) {
			try {
				new File(path).mkdirs();
			} catch (SecurityException e) {
				e.getStackTrace();
				logger.info("can not make security direcoty");
			}
		}
	}

	/**
	 * 
	 * 功能描述： 判断文件是否在服务器上存在，如果不存在，创建该文件。
	 * 方法名:mkfiles 访问类:Tool
	 * 
	 * @param path
	 *            绝对路径
	 * 
	 */
	public static void mkfiles(String path) {
		File file = new File(path);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				logger.info("can not make security file");
				e.printStackTrace();
			}
		}
	}

	/*
	 * 功能:判断文件目录是否存在,不存在则进行创建 参数说明: path:绝对路径
	 */
	public static void mkFiledirs(String filename) {
		String filepath = filename.replace('\\', '/');
		int length = filename.trim().length();
		if (length > 0) {
			int i = filepath.lastIndexOf("/");
			if (i >= 0) {
				filepath = filepath.substring(0, i + 1);

			}
		}
		if (!(new File(filepath).isDirectory())) {
			try {
				new File(filepath).mkdirs();
			} catch (SecurityException e) {
				logger.info("can not make security direcoty");
			}
		}
	}

	/**
	 * 
	 * 功能描述：将数据的NULL设为""  日期:下午02:33:43 方法名:setMapNull
	 * 访问类:IdTool
	 * 
	 * @param rsMap
	 * @return String[]
	 * 
	 */
	public static String[] setMapNull(String[] rsMap) {
		for (int i = 0; i < rsMap.length; i++) {
			rsMap[i] = IdTool.isNull(rsMap[i]) ? "" : rsMap[i];
		}
		return rsMap;
	}

	/**
	 * 
	 * 功能描述：返回该路径的文件名  日期:下午02:37:04 方法名:GetFileName
	 * 访问类:IdTool
	 * 
	 * @param filepath
	 *            绝对路径
	 * @return String
	 * 
	 */
	public static String GetFileName(String filepath) {
		String returnstr = "*.*";
		int length = filepath.trim().length();

		filepath = filepath.replace('\\', '/');
		if (length > 0) {
			int i = filepath.lastIndexOf("/");
			if (i >= 0) {
				filepath = filepath.substring(i + 1);
				returnstr = filepath;
			}
		}
		return returnstr;
	}

	/**
	 * 
	 * 功能描述：输出对象 参数说明 obj 想要输出的对象  日期:下午02:37:55 方法名:print
	 * 访问类:IdTool
	 * 
	 * @param obj
	 * 
	 */
	public static void print(Object obj) {
		logger.info(obj);
	}

	/**
	 * 
	 * 功能描述：输出对象 参数说明 obj 想要输出的对象，根据系统设置debugState的值，1输出 
	 * 日期:下午02:38:09 方法名:print 访问类:IdTool
	 * 
	 * @param obj
	 * @param debugState
	 * 
	 */
	public static void print(Object obj, String debugState) {
		if ("1".equalsIgnoreCase(debugState)) {
			logger.info(obj);
		}
	}

	/**
	 * 
	 * 功能描述：删除文件夹  日期:下午02:41:03 方法名:path_delete 访问类:IdTool
	 * 
	 * @param path
	 *            绝对路径
	 * 
	 */
	public static void path_delete(String path) {
		if ((new File(path).isDirectory())) {
			try {
				new File(path).delete();
			} catch (SecurityException e) {
				logger.info("can not delete security direcoty");
			}
		}
	}

	/**
	 * 
	 * 功能描述：删除文件的所有文件夹和文件  日期:下午02:41:59 方法名:DeleteFileByAll
	 * 
	 * 
	 * 访问类:IdTool
	 * 
	 * @param folderPath
	 * 
	 */
	public static void DeleteFileByAll(String folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 功能描述： 删除指定文件夹下所有文件  日期:2008-6-30 日期:上午10:45:04 方法名:delAllFile
	 * 访问类:IdTool
	 * 
	 * @param path
	 *            文件夹完整绝对路径
	 * @return boolean
	 * 
	 */
	public static boolean delAllFile(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
				DeleteFileByAll(path + "/" + tempList[i]);// 再删除空文件夹
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * 
	 * 功能描述：  日期:2008-6-30 日期:上午10:45:41 方法名:DeleteFileByAllTWO 访问类:IdTool
	 * 
	 * @param file
	 * @return boolean
	 * 
	 */
	public static boolean DeleteFileByAllTWO(File file) {
		boolean bool = true;
		try {
			if (file.exists())// 如果存在
			{
				if (file.isDirectory()) {
					File files[] = file.listFiles();
					if (files.length == 0) {
						file.delete();
					}
					for (int i = 0; i < files.length; i++) {
						File newfile = files[i];
						if (newfile.isDirectory()) {
							DeleteFileByAllTWO(newfile);
						} else {
							newfile.delete();
						}
					}
				} else {// 如果是文件直接删除
					file.delete();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			bool = false;
		}
		return bool;
	}

	/**
	 * 
	 * 功能描述：删除文件  日期:2008-6-30 日期:上午10:46:34 方法名:file_delete 访问类:IdTool
	 * 
	 * @param path
	 * 
	 */
	public static void file_delete(String path) {
		if ((new File(path).exists())) {
			try {
				new File(path).delete();
			} catch (SecurityException e) {
				logger.info("can not delete security direcoty");
			}
		}
	}

	/**
	 * 
	 * 功能描述：数组截取，返回一定数量的数组  日期:2008-6-30 日期:上午10:48:38 方法名:getNewSz
	 * 访问类:IdTool
	 * 
	 * @param txt
	 * @param number
	 * @return String[]
	 * 
	 */
	public static String[] getNewSz(String[] txt, int number) {
		String[] str = new String[number];
		for (int i = txt.length - number; i < txt.length; i++) {
			str[i - (txt.length - number)] = txt[i];
		}
		return str;
	}

	/**
	 * 
	 * 功能描述：数组截取，返回一定数量的数组,从开始下标到截一定的数量  日期:2008-6-30 日期:上午10:49:11
	 * 方法名:getNewSz 访问类:IdTool
	 * 
	 * @param txt
	 * @param start
	 * @param len
	 * @return String[]
	 * 
	 */
	public static String[] getNewSz(String[] txt, int start, int len) {
		String[] str = new String[len];
		int k = 0;
		for (int i = start; i < len; i++) {
			str[k] = txt[i];
			k++;
		}
		return str;

	}

	/**
	 * 
	 * 功能描述：将List转换成二维数组 返回一个二维数组  日期:2008-6-30 日期:上午10:49:54
	 * 方法名:listToArray 访问类:IdTool
	 * 
	 * @param datalist
	 * @param txt
	 * @return String[][]
	 * 
	 */
	public static String[][] listToArray(
			List<HashMap<String, String>> datalist, String[] txt) {
		String[][] data;
		data = new String[datalist.size()][txt.length];
		for (int i = 0; i < datalist.size(); i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			map = (HashMap<String, String>) datalist.get(i);
			for (int k = 0; k < txt.length; k++) {
				if (IdTool.isNull(map.get(txt[k]))) {
					data[i][k] = "";
				} else {
					data[i][k] = map.get(txt[k]).toString();
				}
			}
		}

		return data;
	}

	/**
	 * 
	 * 功能描述：将List转换成一维数组 返回一个一维数组  日期:2008-6-30 日期:上午10:50:04
	 * 方法名:listToArray 访问类:IdTool
	 * 
	 * @param datalist
	 * @param txt
	 * @return String[]
	 * 
	 */
	public static String[] listToArray(List<HashMap<String, String>> datalist,
			String txt) {
		if (datalist == null || datalist.size() == 0) {
			return null;
		}
		String[] data = null;
		data = new String[datalist.size()];
		for (int i = 0; i < datalist.size(); i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			map = (HashMap<String, String>) datalist.get(i);
			if (IdTool.isNull(map.get(txt))) {
				data[i] = "";
			} else {
				data[i] = map.get(txt).toString();
			}

		}
		return data;
	}

	/**
	 * 功能描述：返回一个唯一的ID号  日期:2008-6-30 日期:上午10:50:48 方法名:getId 访问类:IdTool
	 * 
	 * @return String
	 * 
	 */
	public static String getId() {
		return getRecordid();
	}
	
	/**
	 * <p>Description: 根据ip获取id</p>
	 * @param ip
	 * @return
	 *
	 * @since Nov 2, 2011 6:26:41 PM
	 * @author xuxinghua
	 */
//	public static String getIdByIp(String ip) {
//		if(ip==null || ip.trim().equals("")) return null;
//		return ip+getRecordid();
//	}

	/**
	 * 
	 * 功能描述：返回一个唯一的ID号 当前时间加上5位的随机数  日期:2008-6-30 日期:上午10:51:51
	 * 方法名:getRecordid 访问类:IdTool
	 * 
	 * @return String
	 * 
	 */
	public static String getRecordid() {
		String recordid = "";
		java.util.Date dt = new java.util.Date();
		long lg = dt.getTime();
		Long ld = new Long(lg);
		String rand = new Integer(new java.util.Random().nextInt(90000) + 10000)
				.toString();
		//String id
		recordid = ld.toString() + rand;
		return recordid;
	}

	/**
	 * 
	 * 功能描述：将字符串分割，返回 Vector  日期:2008-6-30 日期:上午10:53:39 方法名:parseCSV
	 * 访问类:IdTool
	 * 
	 * @param s
	 * @return Vector
	 * 
	 */
	public static Vector<String> parseCSV(String s) {
		Vector<String> v = new Vector<String>();
		StringTokenizer st = new StringTokenizer(s, ",");
		while (st.hasMoreTokens()) {
			v.add(st.nextToken());
		}
		return v;
	}

	/**
	 * 
	 * 功能描述：将一字符串中A字符串替换成B字符串  日期:2008-6-30 日期:上午10:56:02
	 * 方法名:replaceAWithB 访问类:IdTool
	 * 
	 * @param str
	 * @param A
	 * @param B
	 * @return String
	 * 
	 */
	public static String replaceAWithB(String str, String A, String B) {
		StringBuffer res = new StringBuffer();
		int p = 0;
		int q = 0;
		while ((q = str.indexOf(A, p)) > -1) {
			res.append(str.substring(p, q));
			if (B != null)
				res.append(B);
			p = q + A.length();
		}
		res.append(str.substring(p));
		return res.toString();
	}

	/**
	 * 
	 * 功能描述：得到当前服务器端时间  日期:2008-6-30 日期:上午10:57:24 方法名:getTime 访问类:IdTool
	 * 
	 * @return String
	 * 
	 */
	public static String getTime() {
		Calendar calendar = Calendar.getInstance();
		String hh = "";
		String ss = "";
		if (calendar.get(Calendar.HOUR_OF_DAY) < 10) {
			hh = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
			hh = "0" + hh;
		} else{
			hh = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
		}
		if (calendar.get(Calendar.MINUTE) < 10) {
			ss = String.valueOf(calendar.get(Calendar.MINUTE));
			ss = "0" + ss;
		} else{
			ss = String.valueOf(calendar.get(Calendar.MINUTE));
		}
		
		String times = hh + ":" + ss;
		return times;
	}

	/**
	 * 
	 * 功能描述：根据客户端IP地址，返回客户端MAC地址 因此方法执行时间较长，最好少用  日期:2008-6-30
	 * 日期:上午10:58:17 方法名:getMacAddressIP 访问类:IdTool
	 * 
	 * @param remotePcIP
	 * @return String
	 * 
	 */
	public static String getMacAddressIP(String remotePcIP) {
		String str = "";
		String macAddress = "";
		try {
			Process pp = Runtime.getRuntime().exec("nbtstat -A " + remotePcIP);
			InputStreamReader ir = new InputStreamReader(pp.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			for (int i = 1; i < 100; i++) {
				str = input.readLine();
				if (str != null) {
					if (str.indexOf("MAC Address") > 1) {
						macAddress = str.substring(
								str.indexOf("MAC Address") + 14, str.length());
					}
				}
			}
		} catch (IOException ex) {

		} finally {

		}
		return macAddress;
	}

	/**
	 * 
	 * 功能描述：得到当前时间  日期:2008-6-30 日期:上午11:00:53 方法名:getCurrentTime
	 * 访问类:IdTool
	 * 
	 * @return String
	 * 
	 */
	public static String getCurrentTime() {
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, Locale.CHINA);
		return df.format(new Date());
	}

	/**
	 * 
	 * 功能描述： 作者:韩震宇; 日期:Sep 2, 2008 时间:3:22:42 PM 方法名:getCurrentTime1 访问类:IdTool
	 * 返回类型:String
	 * 
	 * @return String
	 */
	public static String getCurrentTime1() {
		Date dt = new java.util.Date();
		SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:MM:ss");
		return sdf.format(dt);
	}

	/**
	 * 
	 * 功能描述：得到当前时间 ，返回指定格式 "HH:MM:ss"  日期:2008-6-30 日期:上午11:02:08
	 * 方法名:getCurrentTime 访问类:IdTool
	 * 
	 * @param format
	 * @return String
	 * 
	 */
	public static String getCurrentTime(String format) {
		Date dt = new java.util.Date();
		SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
		return sdf.format(dt);
	}

	public static Timestamp getSqlTime(Date date) {
		return new Timestamp(date.getTime());
	}

	public static Timestamp getSystemTime() {
		return getSqlTime(new Date());
	}

	public static Timestamp getSqlTime1(String dateStr) {
		if (isNull(dateStr))
			return null;
		return getSqlTime(getStringTime1(dateStr));
	}

	public static Timestamp getSqlTime2(String dateStr) {
		return getSqlTime(getStringTime2(dateStr));
	}

	public static Timestamp getSqlTime3(String dateStr) {
		if (isNull(dateStr))
			return null;
		return getSqlTime(getStringTime3(dateStr));
	}
	
	
	/**
	 * 获得标准GMT时间,遵循RFC822标准
	 */
	public static String getGmtStringTime(Date date){
		SimpleDateFormat  mdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z",Locale.US);
		SimpleTimeZone aZone = new SimpleTimeZone(8,"GMT");
		mdf.setTimeZone(aZone);       
		return mdf.format(date);
	}
	
	public static String getGmtStringTime(String dateStr){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SimpleDateFormat  mdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z",Locale.US);
		SimpleTimeZone aZone = new SimpleTimeZone(8,"GMT");
		mdf.setTimeZone(aZone);       
		return mdf.format(date);
	}
	
	public static Date getStringTime3(String dateStr) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 
	 * 功能描述：判断字符串p是否为空  日期:2008-6-30 日期:上午11:04:13 方法名:isNull 访问类:IdTool
	 * 
	 * @param p
	 * @return boolean
	 * 
	 */
	public static boolean isNull(String p) {
		if (p == null || p.equalsIgnoreCase("")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * 功能描述：判断数字p是否为0  日期:2008-6-30 日期:上午11:04:27 方法名:isNull 访问类:IdTool
	 * 
	 * @param p
	 * @return boolean
	 * 
	 */

	public static boolean isNull(int p) {
		int i = 0;
		return p != i;
	}

	/**
	 * 
	 * 功能描述： 判断数字p是否为0  日期:2008-6-30 日期:上午11:06:23 方法名:isNull 访问类:IdTool
	 * 
	 * @param p
	 * @return boolean
	 * 
	 */
	public static boolean isNull(long p) {
		long i = 0;
		return p != i;
	}

	/**
	 * 
	 * 功能描述：将文件流写入指定的文件  日期:2008-6-30 日期:上午11:08:01 方法名:write 访问类:IdTool
	 * 
	 * @param path
	 * @param add_Str
	 * @param accpet
	 * 
	 */
	public static void write(String path, String add_Str, boolean accpet) {
		BufferedWriter bw = null;
		File f = null;
		FileWriter fw = null;

		f = new File(path.substring(0, path.lastIndexOf("\\")));
		if (!f.exists())
			f.mkdirs();
		f = new File(path);
		try {
			if (!f.exists()) {
				f.createNewFile();
				f = new File(path);
			}
			fw = new FileWriter(f, accpet);
			bw = new BufferedWriter(fw);
			bw.write(add_Str);
			bw.flush();
		} catch (IOException e) {
			logger.info("写文件失败:" + e.getMessage());
		} finally {
			try {
				if (bw != null) {
					bw.close();
					bw = null;
				}
				if (fw != null) {
					fw.close();
					fw = null;
				}
			} catch (IOException e1) {
				logger.info("写入文件失败，关闭文件流失败：" + e1.getMessage());
			}
		}
	}

	/**
	 * 
	 * 功能描述：得到长度为length的随机字符串  日期:2008-6-30 日期:上午11:08:44 方法名:random
	 * 访问类:IdTool
	 * 
	 * @param length
	 * @return String
	 * 
	 */
	public static String random(int length) {
		int range = 10;
		String ret = "";
		Random rand = new Random();
		for (int i = 0; i < length; i++) {
			int temp = rand.nextInt(range);
			ret = ret + temp;
		}
		return ret;
	}

	/**
	 * 
	 * 功能描述：功能:在0-range范围内,给到count个随机数  日期:2008-6-30 日期:上午11:09:13
	 * 方法名:random 访问类:IdTool
	 * 
	 * @param range
	 * @param count
	 * @return String[]
	 * 
	 */
	public static String[] random(int range, int count) {
		if (count > range) {
			return null;
		}
		String[] randstr = new String[count];
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < range; i++) {
			list.add(String.valueOf(i));
		}
		Random rand = new Random();
		int n = 0;
		for (int i = 0; i < count; i++) {
			int j = rand.nextInt(list.size());
			randstr[n] = (String) list.get(j);
			list.remove(list.get(j));
			n++;
		}

		return randstr;
	}

	/**
	 * 
	 * 功能描述： 得到指定图片的尺寸大小  日期:2008-6-30 日期:上午11:11:18 方法名:getImageSize
	 * 访问类:IdTool
	 * 
	 * @param file
	 * @return int[]
	 * 
	 */
	final public static int[] getImageSize(File file) {

		Image src = null;
		try {
			src = ImageIO.read(file);
			int w = src.getWidth(null);// 得到源图宽
			int h = src.getHeight(null);// 得到源图高
			int[] s = { w, h };
			return s;
		} catch (Exception e) {

			return null;
		}
	}

	/**
	 * 
	 * 功能描述：得到指定图片的尺寸大小  日期:2008-6-30 日期:上午11:11:59 方法名:getImageSize
	 * 访问类:IdTool
	 * 
	 * @param inputStream
	 * @return int[]
	 * 
	 */
	final public static int[] getImageSize(InputStream inputStream) {
		Image src = null;
		try {
			src = ImageIO.read(inputStream);
			int w = src.getWidth(null);// 得到源图宽
			int h = src.getHeight(null);// 得到源图高
			int[] s = { w, h };
			return s;
		} catch (Exception e) {

			return null;
		}
	}

	/**
	 * 
	 * 功能描述：得到指定图片的尺寸大小  日期:2008-6-30 日期:上午11:12:08 方法名:getImageSize
	 * 访问类:IdTool
	 * 
	 * @param filePath
	 * @return int[]
	 * 
	 */
	final public static int[] getImageSize(String filePath) {
		return getImageSize(new File(filePath));
	}

	/**
	 * 
	 * 功能描述：图片按比例压缩  日期:2008-6-30 日期:上午11:12:42 方法名:getImageSize 访问类:IdTool
	 * 
	 * @param sw
	 * @param sh
	 * @param w
	 * @param h
	 * @return int[]
	 * 
	 */
	final public static int[] getImageSize(int sw, int sh, int w, int h) {
		float f_h = h;
		float f_w = w;
		float f_sh = sh;
		float f_sw = sw;

		if ((f_sh / f_sw) * f_w > f_h) {
			f_w = (f_sw / f_sh) * f_h;
		} else {
			f_h = (f_sh / f_sw) * f_w;
		}
		String _tmp = f_w + "";
		int i = _tmp.indexOf(".");
		int ii_w = Integer.parseInt(_tmp.substring(0, i));
		_tmp = f_h + "";
		i = _tmp.indexOf(".");
		int ii_h = Integer.parseInt(_tmp.substring(0, i));

		int[] s = { ii_w, ii_h };
		if (sw < w && sh < h) {
			s[0] = sw;
			s[1] = sh;
		}
		return s;
	}

	/**
	 * 
	 * 功能描述：字符串转换行数  日期:2008-6-30 日期:上午11:13:01 方法名:replaceAll 访问类:IdTool
	 * 
	 * @param srcStr
	 * @param s1
	 * @param s2
	 * @return String
	 * 
	 */
	public static String replaceAll(String srcStr, String s1, String s2) {
		StringReader reader = new StringReader(srcStr);
		StringBuffer _buffer = new StringBuffer();
		StringBuffer buffer = new StringBuffer();

		char[] c = new char[1];
		try {
			while (reader.read(c) >= 0) {

				_buffer.append(c[0]);
				if (s1.startsWith(_buffer.toString())) {
					if (s1.equalsIgnoreCase(_buffer.toString())) {
						_buffer = new StringBuffer();
						buffer.append(s2);

					}
				} else {
					buffer.append(_buffer.toString());
					_buffer = new StringBuffer();
				}

			}

		} catch (IOException e) {

			return null;
		}
		return buffer.append(_buffer).toString();
	}

	/**
	 * 
	 * 功能描述：将str的第一个字母大写  日期:2008-6-30 日期:上午11:14:46
	 * 方法名:toUpcaseFirstChar 访问类:IdTool
	 * 
	 * @param str
	 * @return String
	 * 
	 */
	final public static String toUpcaseFirstChar(String str) {
		if (str == null || str.length() < 1)
			return str;
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	/**
	 * 
	 * 功能描述：得到当前时间字符串，  日期:2008-6-30 日期:上午11:15:12 方法名:getTimeString1
	 * 访问类:IdTool
	 * 
	 * @param date
	 * @return String
	 * 
	 */
	public static String getTimeString1(Date date) {
		if (date == null)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	public static String getTimeByFormat(Date date, String format) {
		if (date == null)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 
	 * 功能描述：得到当前时间Date，  日期:2008-6-30 日期:上午11:15:39 方法名:getStringTime1
	 * 访问类:IdTool
	 * 
	 * @param dateStr
	 * @return Date
	 * 
	 */
	public static Date getStringTime1(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 
	 * 功能描述：得到当前时间 yyyy-MM-dd HH:mm  日期:2008-6-30 日期:上午11:16:48
	 * 方法名:getTimeString2 访问类:IdTool
	 * 
	 * @param date
	 * @return String
	 * 
	 */
	public static String getTimeString2(Date date) {
		if (date == null)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sdf.format(date);
	}

	/**
	 * 
	 * 功能描述：得到当前时间 yyyy-MM-dd HH:mm  日期:2008-6-30 日期:上午11:17:20
	 * 方法名:getStringTime2 访问类:IdTool
	 * 
	 * @param dateStr
	 * @return Date
	 * 
	 */
	public static Date getStringTime2(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 功能描述：当前日期 2007-7-7 作者:黄国龙; 日期:2008-2-14 日期:下午05:07:57 方法名:getTime
	 * 访问类:IdTool 返回类型:String
	 * 
	 * @return String
	 */
	public static String getNowDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String yemp = simpleDateFormat.format(new java.util.Date());
		return yemp;
	}

	/**
	 * 功能描述：当前日期时间 2007-7-7 05:07:57 作者:黄国龙; 日期:2008-2-14 日期:下午05:07:57
	 * 方法名:getTime 访问类:IdTool 返回类型:String
	 * 
	 * @return String
	 */
	public static String getNowTime() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String yemp = simpleDateFormat.format(new java.util.Date());
		return yemp;
	}

	/**
	 * 功能描述：生产如order by to_date(ZJSJ,'yyyy-MM-dd/HH24:MI:ss') desc 一样的排序语句
	 * 作者:黄国龙; 日期:2008-2-14 日期:下午05:12:20 方法名:getOrderByDate 访问类:IdTool
	 * 返回类型:String
	 * 
	 * @param row
	 * @param st
	 * @return String
	 */
	public static String getOrderByDate(String row, String st) {
		return " order by to_date(" + row + ",'yyyy-MM-dd/HH24:MI:ss') " + st
				+ " ";
	}

	public static String getTimeString(Date date) {
		if (date == null)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");
		return sdf.format(date);
	}

	public static String getTimeString3(Date date) {
		if (date == null)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	/**
	 * 
	 * 功能描述：在list页面中截取前面几个字符  日期:2008-6-30 日期:上午11:18:52
	 * 方法名:getIndexString 访问类:IdTool
	 * 
	 * @param str
	 * @param len
	 * @return String
	 * 
	 */
	public static String getIndexString(String str, int len) {
		if (str == null)
			return "";
		String indexString = str;
		byte[] b = str.getBytes();

		if (b.length > len) {
			int i = len / 2;
			while ((str.substring(0, i) + "...").getBytes().length < len) {
				i++;
			}
			indexString = str.substring(0, i - 1) + "...";
		}
		return indexString;
	}

	/**
	 * 
	 * 功能描述：字符串截取  日期:2008-6-30 日期:上午11:19:16 方法名:getsubString 访问类:IdTool
	 * 
	 * @param str
	 * @param len
	 * @return String
	 * 
	 */
	public static String getsubString(String str, int len) {
		String indexString = str;
		if (indexString == null)
			indexString = "";
		if (indexString.length() > len) {
			indexString = indexString.substring(0, len);
		}
		return indexString;
	}

	/**
	 * 
	 * 功能描述：将数组组成字符串，用","隔开  日期:2008-6-30 日期:上午11:20:07 方法名:arrayToString
	 * 访问类:IdTool
	 * 
	 * @param strs
	 * @param split
	 * @return String
	 * 
	 */
	public static String arrayToString(String[] strs, String split) {
		if (strs == null)
			return "";
		String tmp = "";
		for (int i = 0; i < strs.length; i++) {
			tmp += strs[i] + ",";
		}
		if (tmp.endsWith(","))
			tmp = tmp.substring(0, tmp.length() - 1);
		return tmp;
	}

	public static String toUtf8String(String s) {
		StringBuffer stringbuffer = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= '\377') {
				stringbuffer.append(c);
			} else {
				byte abyte0[];
				try {
					abyte0 = String.valueOf(c).getBytes("utf-8");
				} catch (Exception exception) {
					abyte0 = new byte[0];
				}
				for (int j = 0; j < abyte0.length; j++) {
					int k = abyte0[j];
					if (k < 0) {
						k += 256;
					}
					stringbuffer.append("%"
							+ Integer.toHexString(k).toUpperCase());
				}

			}
		}

		return stringbuffer.toString();
	}

	/**
	 * 
	 * 功能描述：将字符串NULL设为""  日期:2008-6-30 日期:上午11:23:19 方法名:getShowString
	 * 访问类:IdTool
	 * 
	 * @param str
	 * @return String
	 * 
	 */
	public static String getShowString(String str) {
		return str == null ? "" : str;

	}

	/**
	 * 
	 * 功能描述：文件复制  日期:2008-6-30 日期:上午11:24:36 方法名:fileCopy 访问类:IdTool
	 * 
	 * @param srcFileName
	 * @param tarFileName
	 * @throws IOException
	 * 
	 */
	public static void fileCopy(String srcFileName, String tarFileName)
			throws IOException {
		File srcFile = new File(srcFileName);
		File tarFile = new File(tarFileName);
		InputStream inputStream = new FileInputStream(srcFile);
		OutputStream outputStream = new FileOutputStream(tarFile);
		byte[] b = new byte[1024];
		int i = -1;
		while ((i = inputStream.read(b)) > 0) {
			outputStream.write(b, 0, i);
		}
		outputStream.flush();
		outputStream.close();
		inputStream.close();
	}

	/**
	 * 功能描述：得到一个文件的内容  日期:2008-5-4 日期:下午04:06:23 方法名:getFileContent
	 * 访问类:IdTool 返回类型:String
	 * 
	 * @param absoluteAddress
	 *            绝对路径
	 * @return String
	 * @throws FileNotFoundException
	 * @throws IOException
	 * 
	 */
	public static String getFileContent(String absoluteAddress)
			throws FileNotFoundException, IOException {
		String fileContent = "";
		FileInputStream fileinputstream = new FileInputStream(absoluteAddress);// 读取模块文件
		int lenght = fileinputstream.available();
		byte bytes[] = new byte[lenght];
		fileinputstream.read(bytes);
		fileinputstream.close();
		fileContent = new String(bytes);
		return fileContent;
	}

	/**
	 * 
	 * 功能描述：获得当前时间 作者:韩震宇; 日期:Jul 15, 2008 时间:3:26:29 PM 方法名:getDtime 访问类:IdTool
	 * 返回类型:String
	 * 
	 * @return String
	 */
	public static String getDtime() {
		GregorianCalendar hzy = new GregorianCalendar();
		int Year = hzy.get(Calendar.YEAR);
		int Month = hzy.get(Calendar.MONTH) + 1;
		int Day = hzy.get(Calendar.DATE);
		String Dtime = "";
		String Dyear = "";
		String Dmonth = "";
		String Dday = "";
		Dyear = Year < 10 ? "0" + new Integer(Year).toString() : new Integer(
				Year).toString();
		Dmonth = Month < 10 ? "0" + new Integer(Month).toString()
				: new Integer(Month).toString();
		Dday = Day < 10 ? "0" + new Integer(Day).toString() : new Integer(Day)
				.toString();
		Dtime = Dyear + "-" + Dmonth + "-" + Dday;
		return Dtime;
	}

	/**
	 * 
	 * 功能描述：将一个List转换为字符串，中间以分隔符分开,空字符以空格代替 作者:韩震宇; 日期:Jul 18, 2008 时间:10:33:41
	 * AM 方法名:listToString 访问类:IdTool 返回类型:String
	 * 
	 * @param list
	 * @param str
	 * @param splitStr
	 * @return String
	 */
	public static String listToString(List<HashMap<String, String>> list,
			String str, String splitStr) {
		String res = " ";
		HashMap<String, String> map = new HashMap<String, String>();
		int i = 0;
		String resSon = " ";
		if (list != null) {
			for (i = 0; i < list.size(); i++) {
				map = (HashMap<String, String>) list.get(i);
				if (map.get(str) != null) {
					resSon = map.get(str).toString();
				} else {
					resSon = " ";
				}
				if (i == 0) {
					res = resSon;
				} else {
					res += splitStr + resSon;
				}
			}
		}
		return res;
	}

	/**
	 * 
	 * 功能描述：将InputStream流转换为byte[]  日期:2008-7-18 日期:下午05:11:46
	 * 方法名:getBytes 访问类:IdTool
	 * 
	 * @param is
	 * @return
	 * @throws Exception
	 * 
	 */
	public static byte[] getBytes(InputStream is) throws Exception {
		byte[] data = null;

		Collection<byte[]> chunks = new ArrayList<byte[]>();
		byte[] buffer = new byte[1024 * 1000];
		int read = -1;
		int size = 0;

		while ((read = is.read(buffer)) != -1) {
			if (read > 0) {
				byte[] chunk = new byte[read];
				System.arraycopy(buffer, 0, chunk, 0, read);
				chunks.add(chunk);
				size += chunk.length;
			}
		}

		if (size > 0) {
			ByteArrayOutputStream bos = null;
			try {
				bos = new ByteArrayOutputStream(size);
				for (Iterator<?> itr = chunks.iterator(); itr.hasNext();) {
					byte[] chunk = (byte[]) itr.next();
					bos.write(chunk);
				}
				data = bos.toByteArray();
			} finally {
				if (bos != null) {
					bos.close();
				}
			}
		}
		return data;
	}

	public static StringBuffer getTreeString(String id, String name,
			int childSum, int gradeInt, String clickFun, String spanClick,
			String checkClick, String icon, boolean isCheckBox) {
		StringBuffer buf = new StringBuffer();
		buf.append("<li style=\"word-break:keep-all;\" id=\"li_" + id
				+ "\"><a href=\"#\" onfocus=\"this.blur()\" >");
		for (int j = 0; j < gradeInt + 1; j++) {
			buf.append("<img src=\"images/icon/empty.gif\" border=\"0\">\r\n");
		}
		if (childSum > 0) {
			buf.append("<img id=\"img_" + id
					+ "\" src=\"images/icon/plus1.gif\"" + " onclick=\""
					+ clickFun + "\" border=\"0\"/>\r\n");
			buf.append("<img onclick=\"" + spanClick + "\" ondblclick=\""
					+ clickFun + "\" src=\"images/icon/" + icon
					+ ".gif\" border=\"0\">\r\n");
			buf.append("<span id=\"span_" + id + "\" onclick=\"" + spanClick
					+ "\" ondblclick=\"" + clickFun + "\">");
		} else {
			buf.append("<img id=\"img_" + id
					+ "\" src=\"images/icon/empty.gif\" border=\"0\"/>\r\n");
			buf.append("<img src=\"images/icon/" + icon + ".gif\" onclick=\""
					+ spanClick + "\"  border=\"0\">\r\n");
			buf.append("<span id=\"span_" + id + "\" onclick=\"" + spanClick
					+ "\">");
		}
		if (isCheckBox) {
			buf.append("<input type=\"checkbox\" id=\"checkbox_" + id
					+ "\" onclick=\"" + checkClick + "\" />\r\n");
		}
		buf.append(IdTool.isNull(name) ? "" : name);
		buf.append("</span>\r\n");
		buf.append("</a>\r\n");
		buf.append("</li>\r\n");
		buf.append("<ul id=\"ul_" + id
				+ "\"  style=\"display:none\">Loading...</ul>\r\n");
		return buf;
	}

	/**
	 * 功能描述：动态判断网址是否有效。  日期:2009-4-24 日期:下午14:02:20
	 * 
	 * @param URLName
	 *            url名称 如：http://rss.xinhuanet.com/rss/world.xml
	 * @return
	 */
	public static boolean urlExists(String URLName) {
		boolean res=false;
		HttpURLConnection con =null;
		try {
			HttpURLConnection.setFollowRedirects(false);
			con = (HttpURLConnection) new URL(URLName)
					.openConnection();
			con.setConnectTimeout(1000);
			con.setReadTimeout(1000);
			con.setRequestMethod("HEAD");
			if(con.getResponseCode()==HttpURLConnection.HTTP_OK){
				res=true;
			}
		} catch (java.net.UnknownHostException e1) {
			IdTool.print("----" + URLName + "路径名称错误！");
			if(con!=null){
				con.disconnect();
			}
			res=false;
		} catch (Exception e) {
			IdTool.print("----" + URLName + "路径名称错误！");
			if(con!=null){
				con.disconnect();
			}
			res=false;
		}finally{
			if(con!=null){
				con.disconnect();
			}
		}
		return res;
	}

	
	public static boolean urlExists(String URLName,int connecttime,int readtime) {
		try {
			HttpURLConnection.setFollowRedirects(false);
			HttpURLConnection con = (HttpURLConnection) new URL(URLName)
			.openConnection();
			con.setConnectTimeout(connecttime*1000);
			con.setReadTimeout(readtime*1000);
			
			con.setRequestMethod("HEAD");
			//con.connect();
			//return true;
			return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
		} catch (java.net.UnknownHostException e1) {
			IdTool.print("----" + URLName + "路径名称错误！");
			//e1.printStackTrace();
			return false;
		} catch (Exception e) {
			IdTool.print("----" + URLName + "路径名称错误！");
			//e.printStackTrace();
			return false;
		}
	}
	public static StringBuffer getTreeHtml(String id, String name,
			int childSum, int gradeInt, String spandbclick, String imgclick,
			String spanClick, String checkClick, String icon, boolean isCheckBox) {
		StringBuffer buf = new StringBuffer();
		buf.append("<li style=\"word-break:keep-all;\" id=\"li_" + id
				+ "\"><a href=\"#\" onfocus=\"this.blur()\" >");
		for (int j = 0; j < gradeInt + 1; j++) {
			buf.append("<img src=\"images/icon/empty.gif\" border=\"0\">\r\n");
		}
		if (childSum > 0) {
			buf.append("<img id=\"img_" + id
					+ "\" src=\"images/icon/plus1.gif\"" + " onclick=\""
					+ imgclick + "\" border=\"0\"/>\r\n");
			buf.append("<img onclick=\"" + spanClick + "\" ondblclick=\""
					+ spandbclick + "\" src=\"images/icon/" + icon
					+ ".gif\" border=\"0\">\r\n");
			buf.append("<span id=\"span_" + id + "\" onclick=\"" + spanClick
					+ "\" ondblclick=\"" + spandbclick + "\">");
		} else {
			buf.append("<img id=\"img_" + id
					+ "\" src=\"images/icon/empty.gif\" border=\"0\"/>\r\n");
			buf.append("<img src=\"images/icon/" + icon + ".gif\" onclick=\""
					+ spanClick + "\"  border=\"0\">\r\n");
			buf.append("<span id=\"span_" + id + "\" onclick=\"" + spanClick
					+ "\">");
		}
		if (isCheckBox) {
			if (icon.equals("plusbottom1")) {
				buf.append("<input type=\"checkbox\" id=\"checkbox_" + id
						+ "\" name=\"leaf\" value=\"" + id + "\" onclick=\""
						+ checkClick + "\" />\r\n");
			} else {
				buf.append("<input type=\"checkbox\" id=\"checkbox_" + id
						+ "\" name=\"" + gradeInt + "\" value=\"" + id
						+ "\" onclick=\"" + checkClick + "\" />\r\n");
			}
		}
		// buf.append(IdTool.isNull(name) ? "" : name);
		buf.append(IdTool.isNull(name) ? "" : name);
		buf.append("</span>\r\n");
		buf.append("</a>\r\n");
		buf.append("</li>\r\n");
		buf.append("<ul id=\"ul_" + id
				+ "\"  style=\"display:none\">Loading...</ul>\r\n");
		return buf;
	}

	public static StringBuffer getTreeHtml(String depname, String id,
			String name, int childSum, int gradeInt, String spandbclick,
			String imgclick, String spanClick, String checkClick, String icon,
			boolean isCheckBox) {
		StringBuffer buf = new StringBuffer();
		buf.append("<li style=\"word-break:keep-all;\" id=\"li_" + id
				+ "\"><a href=\"#\" onfocus=\"this.blur()\" >");
		for (int j = 0; j < gradeInt + 1; j++) {
			buf.append("<img src=\"images/icon/empty.gif\" border=\"0\">\r\n");
		}
		if (childSum > 0) {
			buf.append("<img id=\"img_" + id
					+ "\" src=\"images/icon/plus1.gif\"" + " onclick=\""
					+ imgclick + "\" border=\"0\"/>\r\n");
			buf.append("<img onclick=\"" + spanClick + "\" ondblclick=\""
					+ spandbclick + "\" src=\"images/icon/" + icon
					+ ".gif\" border=\"0\">\r\n");
			buf.append("<span id=\"span_" + id + "\" onclick=\"" + spanClick
					+ "\" ondblclick=\"" + spandbclick + "\">");
		} else {
			buf.append("<img id=\"img_" + id
					+ "\" src=\"images/icon/empty.gif\" border=\"0\"/>\r\n");
			buf.append("<img src=\"images/icon/" + icon + ".gif\" onclick=\""
					+ spanClick + "\"  border=\"0\">\r\n");
			buf.append("<span id=\"span_" + id + "\" onclick=\"" + spanClick
					+ "\">");
		}
		if (isCheckBox) {
			if (icon.equals("plusbottom1")) {
				buf.append("<input type=\"checkbox\" id=\"checkbox_" + id
						+ "\" name=\"leaf\" value=\"" + id + "\" onclick=\""
						+ checkClick + "\" />\r\n");
			} else {
				buf.append("<input type=\"checkbox\" id=\"checkbox_" + id
						+ "\" name=\"" + gradeInt + "\" value=\"" + id
						+ "\" onclick=\"" + checkClick + "\" />\r\n");
			}
		}
		// buf.append(IdTool.isNull(name) ? "" : name);
		buf.append(IdTool.isNull(name) ? "" : name);
		if (depname == null)
			buf.append("</span>\r\n");
		else
			buf.append("(" + depname + ")</span>\r\n");
		buf.append("</a>\r\n");
		buf.append("</li>\r\n");
		buf.append("<ul id=\"ul_" + id
				+ "\"  style=\"display:none\">Loading...</ul>\r\n");
		return buf;
	}

	public static String getStringByLengthCN(String inputStr, int subLength) {
		int cutLength = 0;
		if(inputStr.length()<subLength){
			return inputStr;
		}
		int byteNum = subLength;
		byte bt[] = inputStr.getBytes();
		if (subLength > 1) {
			for (int i = 0; i < byteNum; i++) {
				if (bt[i] < 0) {
					cutLength++;

				}
			}

			if (cutLength % 2 == 0) {
				cutLength /= 2;
			} else {
				cutLength = 0;
			}
		}
		int result = cutLength + --byteNum;
		if (result > subLength) {
			result = subLength;
		}
		if (subLength == 1) {
			if (bt[0] < 0) {
				result += 2;

			} else {
				result += 1;
			}
		}
		String substrx = new String(bt, 0, result);
		return substrx;
	}
	
	/**
	 * 得到当前操作系统名称
	 * @return
	 */
	public static String getOsName(){
		String os = System.getProperty("os.name").toLowerCase();
		return os;
	}
	
	/**
	 * 获取url的文本内容
	 * @param url
	 * @return
	 */
	public String getPageContent(String url){
		StringBuffer buffer=new StringBuffer();
		BufferedReader rd;
		try{
		    URL ul=new URL(url);
		    URLConnection conn=ul.openConnection();
		    
		    rd=new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    String ends=rd.readLine();
		    while (null!=ends)
		    {      
		    	buffer.append(ends);
		    	ends=rd.readLine();
		    }
		    return buffer.toString();
		}
		catch(MalformedURLException e){
			e.printStackTrace();
			return "";
		}
		catch(IOException e){
			e.printStackTrace();
			return "";
		}finally{
			buffer=null;
			rd=null;
		}
	}
	
	/**
	 * 去掉html的标签
	 * @param pageContent
	 * @return
	 */
	public static String KillHtml(String pageContent){
		pageContent=pageContent.toLowerCase();
		String reScript="<script.*</script>";
		String reStyle="<style.*</style>";
		String reHtml="<\\/*[^<>]*>";
		String nbspStr="&nbsp;";
		pageContent=pageContent.replaceAll(reScript, "");
		pageContent=pageContent.replaceAll(reStyle, "");
		pageContent=pageContent.replaceAll(reHtml, "");
		pageContent=pageContent.replaceAll(nbspStr, "");
		return pageContent;	
	}
}
