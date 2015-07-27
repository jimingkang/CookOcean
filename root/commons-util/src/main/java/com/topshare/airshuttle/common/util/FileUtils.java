package com.topshare.airshuttle.common.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;


/**
 * 文件操作相关类
 */
public class FileUtils {

	private static final int BUFFER_SIZE = 1024 * 10;

	private static AtomicInteger inc = new AtomicInteger();

	private static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd/HH");

	protected static final Logger logger = Logger.getLogger(FileUtils.class);

	/**
	 * 
	 * @Title: writeToFile
	 * @Description: 文件的写操作
	 * @param filePathName
	 * @param byteArray
	 *            void
	 */
	public static void writeToFile(String filePathName, byte[] byteArray) {
		OutputStream os = null;
		try {
			String path = extractPath(filePathName);
			mkdir(path);
			os = new BufferedOutputStream(new FileOutputStream(new File(
					filePathName)));
			os.write(byteArray);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
	}

	private static String extractPath(String filename) {
		int i = filename.lastIndexOf("/");
		if (i > -1) {
			return filename.substring(0, i);
		}
		return filename;
	}

	/**
	 * 
	 * @Title: writeToImageSize
	 * @Description: 文件的写操作
	 * @param filePathName
	 * @param content
	 * @param maxW
	 * @param maxH
	 * @param suffic
	 *            void
	 */
	public static void writeToImageSize(String filePathName, byte[] content,
			int maxW, int maxH, String suffic) {
		try {
			BufferedImage src = ImageIO.read(new ByteArrayInputStream(content)); // 读入文件
			int w = src.getWidth(); // 得到源图宽
			int h = src.getHeight(); // 得到源图长
			if (w > maxW || h > maxH) {
				int resizeW = w;
				int resizeH = h;
				double f = (double) w / (double) h;
				if (w > h) {
					resizeW = maxW;
					resizeH = (int) (maxW / f);
				} else {
					resizeH = maxH;
					resizeW = (int) (maxH * f);
				}
				Image image = src.getScaledInstance(resizeW, resizeH,
						Image.SCALE_DEFAULT);
				BufferedImage tag = new BufferedImage(resizeW, resizeH,
						BufferedImage.TYPE_INT_RGB);
				Graphics g = tag.getGraphics();
				g.drawImage(image, 0, 0, null); // 绘制缩小后的图
				g.dispose();
				ImageIO.write(tag, suffic, new File(filePathName));
			} else {
				writeToFile(filePathName, content);
			}
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * 
	 * @Title: getBytes
	 * @Description: 输入流转换byte数组
	 * @param is
	 * @return
	 * @throws IOException
	 *             byte[]
	 */
	public static byte[] readFromStream(InputStream is) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] b = new byte[BUFFER_SIZE];
		int len = 0;
		while ((len = is.read(b, 0, BUFFER_SIZE)) != -1) {
			baos.write(b, 0, len);
		}
		baos.flush();
		byte[] bytes = baos.toByteArray();
		return bytes;
	}

	public static String readTextFile(String file) {
		byte[] ret = readFromFile(file);
		return new String(ret);
	}

	public static byte[] readFromFile(String file) {
		File f = new File(file);
		return readFromFile(f);
	}

	/**
	 * 
	 * @Title: readFromFile
	 * @Description: 读取文件，转换为byte[]
	 * @param file
	 * @return byte[]
	 */
	public static byte[] readFromFile(File file) {
		InputStream is = null;
		byte[] ret = null;
		try {
			is = new BufferedInputStream(new FileInputStream(file));
			ret = readFromStream(is);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
		return ret;
	}

	/**
	 * 删除一个文件或空目录
	 * 
	 * @param absFilePath
	 * @return
	 */
	public static boolean deleteFile(String absFilePath) {
		File file = new File(absFilePath);
		boolean b = false;
		if (file.exists()) {
			b = file.delete();
		}
		return b;
	}

	/**
	 * 将文件写入rootPath下，并加入日期作为子目录；文件名改为时间戳加给定文件的扩展名
	 * 
	 * @param rootPath
	 * @param content
	 * @param fileName
	 *            文件扩展名
	 * @return
	 */
	public static String writeGenFileNameDatePath(String rootPath,
			byte[] content, String fileName) {
		String suffix = getExtName(fileName);
		String finalFileName = getTimestampFileName(suffix);
		return writeFileDatePath(rootPath, content, finalFileName);
	}

	/**
	 * 计算文件路径,文件名改为时间戳加给定文件的扩展名。rootPath/yyyy/MM/dd/HH/uuid.extFileName
	 * 
	 * @param rootPath
	 * @param fileName
	 * @return
	 */
	public static String calFileNameDateAbsPath(String rootPath, String fileName) {
		String suffix = getExtName(fileName);
		// String name = getTimestampFileName(suffix);
		String name = getUUIDFileName(suffix);
		String path = getYearMonthDayHourPath();
		String pathFile = path + "/" + name;
		if (!rootPath.endsWith("/")) {
			rootPath += "/";
		}
		String absPath = rootPath + pathFile;
		return absPath;
	}

	public static String getExtName(String fileName) {
		int s = fileName.lastIndexOf(".");
		if (s < 0) {
			return fileName;
		}
		return fileName.substring(s + 1);
	}

	/**
	 * 将文件写入rootPath下，并加入日期作为子目录
	 * 
	 * @param rootPath
	 * @param content
	 * @param fileName
	 * @return
	 */
	public static String writeFileDatePath(String rootPath, byte[] content,
			String fileName) {
		String path = getYearMonthDayHourPath();
		mkdir(rootPath + "/" + path);
		String pathFile = path + "/" + fileName;
		String absPath = rootPath + "/" + pathFile;
		writeToFile(absPath, content);
		return pathFile;
	}

	public static void mkdir(String path) {
		File f = new File(path);
		if (f.exists()) {
			return;
		} else {
			f.mkdirs();
		}
	}

	/**
	 * 生成年月日的路径结构yyyy/MM/dd/HH
	 * 
	 * @return String
	 */
	public static String getYearMonthDayHourPath() {
		return dateFormat.format(new Date());
	}

	/**
	 * 
	 * @param suffix
	 * @return UUID.suffix
	 */
	public static String getUUIDFileName(String suffix) {
		return CodeUtil.getRandomUUID() + "." + suffix;
	}

	static String getTimestampFileName(String suffix) {
		return System.currentTimeMillis() + "_" + inc.incrementAndGet() + "."
				+ suffix;
	}
}
