package com.topshare.airshuttle.service.userManager;

import javax.sql.DataSource;

import net.paoding.rose.jade.context.application.JadeFactory;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.topshare.airshuttle.common.util.DBEncrypt;
import com.topshare.airshuttle.dao.userManager.UserDAO;
import com.topshare.airshuttle.model.userManager.TAirshuttleUser;
import com.topshare.airshuttle.service.BaseTransServiceTest;

public class UserServiceTest extends BaseTransServiceTest{

	private Logger logger = Logger.getLogger(this.getClass());
	
	/***
	 * 测试添加用户
	 */
	@Test
	public void getUserByLoginTest(){
		
		TAirshuttleUser user =  new TAirshuttleUser();
		user.setUsername("admin");
		user.setPassword("123456");
		DBEncrypt dBEncrypt = new DBEncrypt();
		user.setPassword(dBEncrypt.eCode("123456"));
		logger.info(dBEncrypt.eCode("123456"));
		DataSource dataSource = this.getDataSource();
		JadeFactory factory = new JadeFactory(dataSource);
		UserDAO dao = factory.create(UserDAO.class);
		
		TAirshuttleUser searchUser = dao.getUserByLogin(user);
		logger.info(searchUser.getUsername());
	}
}
