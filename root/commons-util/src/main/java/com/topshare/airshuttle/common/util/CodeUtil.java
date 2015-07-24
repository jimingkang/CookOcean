package com.topshare.airshuttle.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * 字符编码的通用操作，包括加密解密、base64编码、MD5加密等
 * 
 * @author
 * 
 */
public class CodeUtil {

	protected static final Logger logger = Logger.getLogger(CodeUtil.class);

	/**
	 * 默认密钥
	 */
	private static String encryptKey = "ASDASDSAD432;K2L3K22JJJS88mltng.com";

	private static IvParameterSpec IvParameters = new IvParameterSpec(
			new byte[] { 54, 34, 62, 48, 70, 37, 24, 94 });

	private static Cipher cipherEncrypt = null;

	private static Cipher cipherDecrypt = null;

	private static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	/**
	 * @Title: init
	 * @Description: 初始化
	 */
	private static void _init() {
		synchronized (CodeUtil.class) {
			try {
				cipherEncrypt = Cipher.getInstance("DESede/CBC/PKCS5Padding");
				cipherDecrypt = Cipher.getInstance("DESede/CBC/PKCS5Padding");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @Title: getEnKey
	 * @Description:得到3-DES的密钥匙，根据根据需要，密钥匙为32个字节，
	 * @param spKey
	 *            原始的SPKEY
	 * @return byte[] 指定加密方式为md5后的byte[]
	 */
	private static byte[] _getEnKey(String spKey) {
		return encodeMd5(spKey).getBytes();
	}

	/**
	 * @Title: string2Hex
	 * @Description: 转为16进制字符串
	 * @param bytes
	 * @return String
	 */
	private static String _string2Hex(byte[] bytes) {
		String hex = "";
		String stmp = "";
		for (int i = 0; i < bytes.length; i++) {
			stmp = Integer.toHexString(bytes[i] & 0XFF);
			if (stmp.length() == 1)
				hex = hex + "0" + stmp;
			else
				hex = hex + stmp;
		}
		return hex.toUpperCase();
	}

	/**
	 * @Title: hex2String
	 * @Description: 16进制的字符串转为字节数组
	 * @param src
	 * @return byte[]
	 */
	private static byte[] _hex2String(String src) {
		byte[] bytes = new byte[src.length() / 2];
		String tmp = null;
		for (int i = 0; i < src.length() / 2; i++) {
			tmp = src.substring(i * 2, i * 2 + 2);
			bytes[i] = (byte) Integer.parseInt(tmp, 16);
		}
		return bytes;
	}

	/**
	 * @Title: encrypt
	 * @Description: 加密
	 * @param source
	 *            要进行加密的字符串
	 * @return String
	 */
	public static String encrypt(String source) {
		return encrypt(source, encryptKey);
	}

	/**
	 * @Title: encrypt
	 * @Description: 加密
	 * @param source
	 *            要进行加密的字符串
	 * @param spKey
	 *            密钥
	 * @return String
	 */
	public static String encrypt(String source, String spKey) {
		if (StringUtils.isBlank(source) || StringUtils.isBlank(spKey)) {
			return null;
		}
		byte[] codes = encrypt(source.getBytes(), spKey);
		return _string2Hex(codes);

	}

	/**
	 * @Title: encrypt
	 * @Description: 加密
	 * @param source
	 *            要进行加密的字符串
	 * @return byte[]
	 */
	public static byte[] encrypt(byte[] source) {
		return encrypt(source, encryptKey);
	}

	/**
	 * @Title: encrypt
	 * @Description:加密
	 * @param source
	 *            要进行加密的字节数组
	 * @param spKey
	 * @return byte[]
	 */
	public static byte[] encrypt(byte[] source, String spKey) {
		if (source == null || source.length == 0 || StringUtils.isBlank(spKey)) {
			return null;
		}

		byte[] encryptedData = null;
		try {
			DESedeKeySpec spec = new DESedeKeySpec(_getEnKey(spKey));
			SecretKeyFactory keyFactory = SecretKeyFactory
					.getInstance("DESede");
			SecretKey theKey = keyFactory.generateSecret(spec);

			if (cipherEncrypt == null) {
				_init();
			}

			cipherEncrypt.init(Cipher.ENCRYPT_MODE, theKey, IvParameters);
			encryptedData = cipherEncrypt.doFinal(source);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return encryptedData;
	}

	/**
	 * @Title: decrypt
	 * @Description: 解密（密钥匙等同于加密的密钥匙）。
	 * @param source
	 *            要进行解密的字符串
	 * @return String
	 */
	public static String decrypt(String source) {
		return decrypt(source, encryptKey);
	}

	/**
	 * @Title: decrypt
	 * @Description: 解密（密钥匙等同于加密的密钥匙）。
	 * @param source
	 *            要进行解密的字符串
	 * @param spKey
	 *            密钥
	 * @return String
	 */
	public static String decrypt(String source, String spKey) {
		if (StringUtils.isBlank(source) || StringUtils.isBlank(spKey)) {
			return null;
		}

		byte[] src = _hex2String(source);
		return new String(decrypt(src, spKey));
	}

	/**
	 * @Title: decrypt
	 * @Description: 解密（密钥匙等同于加密的密钥匙）。
	 * @param source
	 *            要进行解密的字符串
	 * @return byte[] 密钥
	 */
	public static byte[] decrypt(byte[] source) {
		return decrypt(source, encryptKey);
	}

	/**
	 * 
	 * 进行3-DES解密（密钥匙等同于加密的密钥匙）。
	 * 
	 * @param source
	 *            要进行3-DES解密byte[]
	 * @param String
	 *            spkey分配的SPKEY
	 * @return String 3-DES解密后的String
	 */
	public static byte[] decrypt(byte[] source, String spKey) {
		if (source == null || source.length == 0 || StringUtils.isBlank(spKey)) {
			return null;
		}

		byte[] decryptData = null;
		try {
			DESedeKeySpec spec = new DESedeKeySpec(_getEnKey(spKey));
			SecretKeyFactory keyFactory = SecretKeyFactory
					.getInstance("DESede");
			SecretKey theKey = keyFactory.generateSecret(spec);

			if (cipherDecrypt == null) {
				_init();
			}
			cipherDecrypt.init(Cipher.DECRYPT_MODE, theKey, IvParameters);
			decryptData = cipherDecrypt.doFinal(source);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return decryptData;
	}

	/**
	 * @Title: encode
	 * @Description: 对字符串进行加密，字符编码为UTF-8
	 * @param source
	 *            要加密的字符串
	 * @return String
	 */
	public static String encodeMd5(String source) {

		if (StringUtils.isBlank(source)) {
			return null;
		}
		String value = null;
		try {
			value = _getMd5(source.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage());
		}
		return value;
	}

	/**
	 * 对byte[] md5加密
	 * 
	 * @param data
	 * @return String
	 */
	public static String encodeMd5(byte[] data) {
		if (data == null || data.length == 0) {
			return null;
		}
		return _getMd5(data);
	}

	private static String _getMd5(byte[] source) {
		String s = null;

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(source);
			byte tmp[] = md.digest(); // MD5 的计算结果是一个 128 位的长整数，
			// 用字节表示就是 16 个字节
			char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
			// 所以表示成 16 进制需要 32 个字符
			int k = 0; // 表示转换结果中对应的字符位置
			for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节
				// 转换成 16 进制字符的转换
				byte byte0 = tmp[i]; // 取第 i 个字节
				str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
				// >>> 为逻辑右移，将符号位一起右移
				str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
			}
			s = new String(str); // 换后的结果转换为字符串

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * 产生一个不带'-'的UUID字符串
	 * @return
	 */
	public static String getRandomUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
