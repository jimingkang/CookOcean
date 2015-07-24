package com.topshare.airshuttle.service.userBookDriver;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import net.paoding.rose.jade.context.application.JadeFactory;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.topshare.airshuttle.biz.bookDriverProcess.UserBookDriverProcessEnum;
import com.topshare.airshuttle.common.util.Page;
import com.topshare.airshuttle.dao.bookDriverProcess.BookDriverProcessDAO;
import com.topshare.airshuttle.dao.flyGroup.FlyGroupDAO;
import com.topshare.airshuttle.dao.userBookDriver.UserBookDriverDAO;
import com.topshare.airshuttle.model.bookDriverProcess.TAirshuttleBookDriverProcess;
import com.topshare.airshuttle.model.receptionAir.TAirshuttleReceptionAir;
import com.topshare.airshuttle.model.userBookDriver.TAirshuttleUserBookDriver;
import com.topshare.airshuttle.service.BaseTransServiceTest;

public class UserBookDriverServiceTest  extends BaseTransServiceTest{

	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());
	
	private UserBookDriverDAO userBookDriverDAO;
	private BookDriverProcessDAO bookDriverProcessDAO;
	private DataSource dataSource;
	
	@Before
	public void before(){
		
		dataSource = this.getDataSource();
		JadeFactory factory = new JadeFactory(dataSource);
		userBookDriverDAO = factory.create(UserBookDriverDAO.class);
	}
	@Test
	public void getPageByParamTest(){
		
		TAirshuttleUserBookDriver ta = new TAirshuttleUserBookDriver();
		ta.setUserId(1);
		
		Integer pageNumber = 1;
		Integer pageSize = 10;
		
		Integer totalCount = userBookDriverDAO.getCountByParam(ta);
		
		List<TAirshuttleUserBookDriver> list = null;
    	
    	int offset = (pageNumber - 1) * pageSize; // 起始下标
    	offset = offset > 0 ? offset : 0;
		offset = offset < totalCount ? offset : totalCount;
		
    	if(totalCount > 0){
    		list =  this.userBookDriverDAO.getByParam(ta, offset, pageSize);
    	}
    	System.out.println("jimmy list size"+list.size());
    	
    	if(list != null){
    		
    		for(TAirshuttleUserBookDriver taEve : list){
    			System.out.println(taEve.getId());
        		logger.info(taEve.getId());
        	}
    	}
    	
    	new Page<TAirshuttleUserBookDriver>(list, totalCount, pageSize, pageNumber);
	}
	
	
	/***
	 * 需要同时插入状态
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void insertTest(){
		
		DataSourceTransactionManager dstm = new DataSourceTransactionManager();
		dstm.setDataSource(dataSource);
		TransactionTemplate tt = new TransactionTemplate(dstm);
		tt.execute(new TransactionCallback() {
			public Object doInTransaction(TransactionStatus status) {
				
				JadeFactory factory = new JadeFactory(dataSource);
				FlyGroupDAO flyGroupDAO = factory.create(FlyGroupDAO.class);
				userBookDriverDAO = factory.create(UserBookDriverDAO.class);
				bookDriverProcessDAO = factory.create(BookDriverProcessDAO.class);
				
				
				TAirshuttleUserBookDriver t = new TAirshuttleUserBookDriver();
				t.setUserId(1);
				t.setDriverId(1);
				t.setBookPrice("200");
				t.setBookNumberPerson(4);
				t.setPickUpTime(new Date());
				t.setReceptionAirId(1);
				
				Integer id = userBookDriverDAO.insert(t);
				
				//同时插入流程
				TAirshuttleBookDriverProcess tbp = new TAirshuttleBookDriverProcess();
				tbp.setBookDriverId(id);
				//tbp.setStatus(UserBookDriverProcessEnum.AUDIT_ING.getValue());
				tbp.setProcessResultDesc("test");
				tbp.setCreateTime(new Date());

				bookDriverProcessDAO.insert(tbp);
				
				return null;
			}
		});
		
	}
}
