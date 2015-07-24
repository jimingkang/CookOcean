package com.topshare.airshuttle.common.util;

import java.io.ByteArrayOutputStream;
import java.util.Properties;

import javax.crypto.Cipher;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DBEncrypt {

	private Properties properties;

	public Object getObject() throws Exception {
		return getProperties();
	}

	@SuppressWarnings("rawtypes")
	public Class getObjectType() {
		return java.util.Properties.class;
	}

	public boolean isSingleton() {
		return true;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties inProperties) {
		this.properties = inProperties;
		String originalUsername = properties.getProperty("user");
		String originalPassword = properties.getProperty("password");
		if (originalUsername != null) {
			String newUsername = deEncryptUsername(originalUsername);
			properties.put("user", newUsername);
		}
		if (originalPassword != null) {
			String newPassword = deEncryptPassword(originalPassword);
			properties.put("password", newPassword);
		}
	}

	private String deEncryptUsername(String originalUsername) {
		return dCode(originalUsername.getBytes());
	}

	private String deEncryptPassword(String originalPassword) {
		return dCode(originalPassword.getBytes());
	}

	public String eCode(String needEncrypt){
		byte result[] = null;
		try {
			Cipher enCipher = Cipher.getInstance("DES");
			javax.crypto.SecretKey key = Key.loadKey();
			enCipher.init(1, key);
			result = enCipher.doFinal(needEncrypt.getBytes());
			BASE64Encoder b = new BASE64Encoder();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			b.encode(result, bos);
			result = bos.toByteArray();
		} catch (Exception e) {
			throw new IllegalStateException("System doesn't support DES algorithm.");
		}
		return new String(result);
	}

	public String dCode(byte result[]){
		String s = null;
		try {
			Cipher deCipher = Cipher.getInstance("DES");
			deCipher.init(2, Key.loadKey());
			BASE64Decoder d = new BASE64Decoder();
			result = d.decodeBuffer(new String(result));
			byte strByte[] = deCipher.doFinal(result);
			s = new String(strByte);
		} catch (Exception e) {
			throw new IllegalStateException("System doesn't support DES algorithm.");
		}
		return s;
	}

	public static void main(String[] args){
    	//String s = "jdbc:oracle:thin:zsxxpt_sns/zfsoft_sns@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=10.71.19.193)(PORT=1521))(FAILOVER=on)(LOAD_BALANCE=on))(CONNECT_DATA= (SERVICE_NAME=orcl)))";
//    	String s = "Kbs2u6NELkMD+i6RnR+aSYG1C367ZWx8vbQZM/AvzNGXIrc3lg7ezA==";
		//String s = "Kbs2u6NELkMD+i6RnR+aSQQSJDG9EpkVybSPYvEHgMyQdxKHcfeUto8e/AWXOsgj";
		String s = "yEb225G47Aa+dWY3kny6iiM3vZkjbWAa";
		//String s = "N5yFmmzznHW54tX4vCwEyoSaUOFQ/J4g";
		//String s = "jdbc:oracle:thin:@10.10.3.151:1521:cuteinfo";
//		String s = "jdbc:oracle:thin:@127.0.0.1:1521:orcl"; //Kbs2u6NELkMD+i6RnR+aSdT76UUiSKIQWme1vaP9axmXIrc3lg7ezA==
//		String s = "zfsoft_chat";
		/*s = "zsxxpt_sns";
    	s = "zfsoft_sns";*/
		
		//String url = "jdbc:oracle:thin:@192.168.30.11:1521:yfbdb2";

		//String url = "logink_ex1_monitor";
		String url = "cuteinfo_monitor_2";

		//String url = "logink_ex11_monitor";

		DBEncrypt p = new DBEncrypt();
    	String afterE = p.eCode(url);
    	System.out.println(afterE);
    	System.out.println(p.dCode(s.getBytes()));
    	
    	System.out.println(p.dCode("Kbs2u6NELkMD+i6RnR+aSQQSJDG9EpkVybSPYvEHgMyQdxKHcfeUto8e/AWXOsgj".getBytes()));
    	
    	//System.out.println(p.dCode("Kbs2u6NELkMD+i6RnR+aSdx/LrVdLfHXKhMsKnUppzcJrln4NBQnfEoSKuWC1Yii4l7SOAz8uVZSYAANwOkPU/t1pHrklu8y3y2wErDzbRaPI7RroGkiyFjjF6NrRUMkCa5Z+DQUJ3xKEirlgtWIouJe0jgM/LlWUmAADcDpD1P7daR65JbvMt8tsBKw820WjnUUw3K9ICpY4xeja0VDJLjXWON1ItXfiFtCq9qdoMhFEziukljqpaGE+98JVKedm2ASVoSRpjiayZwqu1uV2gjJV11e2VcCwwlyURc2FWQTEtc4Prkx2tKxLKULxhjJQa+3P5/pkT4=".getBytes()));
    	
    	System.out.println(p.dCode("yEb225G47Aa+dWY3kny6iiM3vZkjbWAa".getBytes()));
    	System.out.println(p.dCode("Kbs2u6NELkMD+i6RnR+aSdx/LrVdLfHXKhMsKnUppzcJrln4NBQnfEoSKuWC1Yii4l7SOAz8uVZSYAANwOkPU/t1pHrklu8y3y2wErDzbRaPI7RroGkiyFjjF6NrRUMkCa5Z+DQUJ3xKEirlgtWIouJe0jgM/LlWUmAADcDpD1P7daR65JbvMt8tsBKw820WjnUUw3K9ICpY4xeja0VDJLjXWON1ItXfiFtCq9qdoMhFEziukljqpaGE+98JVKedm2ASVoSRpjiayZwqu1uV2gjJV11e2VcCwwlyURc2FWQTEtc4Prkx2tKxLKULxhjJQa+3P5/pkT4=".getBytes()));
    }
}