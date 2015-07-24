package com.topshare.airshuttle.service.bookGroup;

import java.util.Date;

import javax.sql.DataSource;

import net.paoding.rose.jade.context.application.JadeFactory;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Service;

import com.topshare.airshuttle.biz.CommonStatusEnum;
import com.topshare.airshuttle.biz.UserRoleEnum;
import com.topshare.airshuttle.dao.bookGroup.UserBookGroupDAO;
import com.topshare.airshuttle.model.bookGroup.TAirshuttleUserBookGroup;
import com.topshare.airshuttle.service.BaseTransServiceTest;

@Service
public class UserBookGroupServiceTest  extends BaseTransServiceTest{

	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());
	
	private UserBookGroupDAO userBookGroupDAO;
	
	@Before
	public void before(){
		
		DataSource dataSource = this.getDataSource();
		JadeFactory factory = new JadeFactory(dataSource);
		userBookGroupDAO = factory.create(UserBookGroupDAO.class);
	}
	
	@Test
	public void insertTest(){
		
		TAirshuttleUserBookGroup t = new TAirshuttleUserBookGroup();
		t.setBookTime(new Date());
		t.setType(UserRoleEnum.FLY_GROUP.getValue());
		t.setUserId(1);
		t.setRefId(1);
		userBookGroupDAO.insert(t);
	}
	
	@Test
	public void updateByParam(){
		
		TAirshuttleUserBookGroup t = new TAirshuttleUserBookGroup();
		t.setId(2);
		t.setStatus(CommonStatusEnum.AUDIT_PASS.getValue());
		t.setStatusMsg("test");
		
		userBookGroupDAO.updateByParam(t);
	}
	
	@Test
	public void deleteByIdTest(){
		
		userBookGroupDAO.deleteById(2);
	}
}
