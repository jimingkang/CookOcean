package com.topshare.airshuttle.common.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * 
 * @author pangtt
 * 
 */
public class MailUtils {

	private static final String host = "mail.itcast.cn";

	private static final String sender = "system@itcast.cn";

	private static String password = "system";

	/**
	 * 用公共帐号发邮件
	 * 
	 * @param title
	 * @param content
	 * @param receiver
	 */
	public static void sendEmail(String title, String content, String receiver) {
		List<String> receivers = new ArrayList<String>();
		receivers.add(receiver);
		sendEmail(title, content, receivers, null);
	}

	/**
	 * 用公共帐号发邮件
	 * 
	 * @param title
	 * @param content
	 * @param receivers
	 *            接收者
	 * @param ccs
	 *            抄送
	 */
	public static void sendEmail(String title, String content,
			List<String> receivers, List<String> ccs) {
		try {
			sendEmail(title, content, receivers, ccs, host, sender,
					getPassword());
		} catch (RuntimeException e) {
			password = null;
			throw e;
		}
	}

	/**
	 * 用指定的email发邮件
	 * 
	 * @param title
	 * @param content
	 * @param receivers
	 *            接收
	 * @param ccs
	 *            抄送
	 * @param host
	 *            发邮件的服务器
	 * @param sender
	 *            发送者
	 * @param password
	 *            发送者的邮件密码
	 */
	public static void sendEmail(String title, String content,
			List<String> receivers, List<String> ccs, String host,
			final String sender, final String password) {
		try {
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.host", host); // smtp主机名。
			props.put("mail.smtp.user", sender); // 发送方邮件地址。
			props.put("mail.smtp.password", password); // 邮件密码。
			// 邮件安全认证。
			Authenticator pop = new Authenticator() {

				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(sender, password);
				}
			};
			Session session = Session.getInstance(props, pop);
			Message newMessage = new MimeMessage(session);
			newMessage.setFrom(new InternetAddress(sender));
			Address[] receiverList = parseAdds(receivers);
			newMessage.setRecipients(Message.RecipientType.TO, receiverList); // 接收方邮件地址
			newMessage.setSubject(title);
			newMessage.setSentDate(new Date());

			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(content, "text/html;charset=UTF-8");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			newMessage.setContent(multipart);
			// 添加抄送
			if (ccs != null && ccs.size() > 0) {
				Address[] adds = parseAdds(ccs);
				newMessage.setRecipients(Message.RecipientType.CC, adds);
			}
			// Transport transport = sendMailSession.getTransport("smtp");
			Transport.send(newMessage);
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage(), ex);
		}
	}

	private static String getPassword() {
		return password;
	}

	private static Address[] parseAdds(List<String> addList)
			throws AddressException {
		if (addList != null && addList.size() > 0) {
			Address[] adds = new Address[addList.size()];
			for (int i = 0; i < addList.size(); i++) {
				adds[i] = new InternetAddress(addList.get(i));
			}
			return adds;
		}
		return null;
	}
}
