package com.topshare.airshuttle.service.bookDriverProcess;

import java.util.Date;

import javax.sql.DataSource;

import net.paoding.rose.jade.context.application.JadeFactory;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Service;

import com.topshare.airshuttle.dao.bookDriverProcess.BookDriverProcessDAO;
import com.topshare.airshuttle.model.bookDriverProcess.TAirshuttleBookDriverProcess;
import com.topshare.airshuttle.service.BaseTransServiceTest;

@Service
public class BookDriverProcessServiceTest extends BaseTransServiceTest{

	private Logger logger = Logger.getLogger(this.getClass());
	
	private BookDriverProcessDAO bookDriverProcessDAO;
	
	@Before
	public void before(){
		
		DataSource dataSource = this.getDataSource();
		JadeFactory factory = new JadeFactory(dataSource);
		bookDriverProcessDAO = factory.create(BookDriverProcessDAO.class);
	}
	
	@Test
	public void insertTest(){
		
		for (int i = 0; i < 10; i++) {
			TAirshuttleBookDriverProcess t = new TAirshuttleBookDriverProcess();
			t.setBookDriverId(1);
		//	t.setStatus(i);
			t.setProcessResultDesc("1221");
			t.setCreateTime(new Date());

			bookDriverProcessDAO.insert(t);
		}
	}
	
	@Test
	public void getByBookDriverId(){
		
		TAirshuttleBookDriverProcess t = bookDriverProcessDAO.getByBookDriverId(1);
		logger.info(t.getProcessResultDesc());
	}
}
