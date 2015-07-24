package com.topshare.airshuttle.service.order;

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

import com.topshare.airshuttle.biz.orderProcess.OrderProcessEnum;
import com.topshare.airshuttle.dao.order.OrderDAO;
import com.topshare.airshuttle.dao.orderProcess.OrderProcessDAO;
import com.topshare.airshuttle.model.order.TAirshuttleOrder;
import com.topshare.airshuttle.model.orderProcess.TAirshuttleOrderProcess;
import com.topshare.airshuttle.service.BaseTransServiceTest;

public class OrderServiceTest  extends BaseTransServiceTest{

	private Logger logger = Logger.getLogger(this.getClass());
	
	private OrderDAO orderDAO;
	private OrderProcessDAO orderProcessDAO;
	private DataSource dataSource;
	
	@Before
	public void before(){
		
		dataSource = this.getDataSource();
		JadeFactory factory = new JadeFactory(dataSource);
		orderDAO = factory.create(OrderDAO.class);
		orderProcessDAO = factory.create(OrderProcessDAO.class);
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
				
				TAirshuttleOrder t = new TAirshuttleOrder();
				t.setUserId(1);
				t.setDriverId(1);
				t.setBookPrice("200");
				t.setBookNumberPerson(4);
				t.setPickUpTime(new Date());
				t.setReceptionAirId(1);
				
				Integer orderId = orderDAO.insert(t);
				
				//同时插入流程
				TAirshuttleOrderProcess tp = new TAirshuttleOrderProcess();
				tp.setOrderId(orderId);
				//tp.setStatus(OrderProcessEnum.AUDIT_ING.getValue());
				tp.setProcessResultDesc("test");
				tp.setCreateTime(new Date());

				orderProcessDAO.insert(tp);
				
				return null;
			}
		});
		
	}
	
	@Test
	public void insertOrderProcessTest(){
		
		TAirshuttleOrderProcess tp = new TAirshuttleOrderProcess();
		tp.setOrderId(1);
		//tp.setStatus(OrderProcessEnum.COMPLETE_RECEPTION_AIR.getValue());
		tp.setProcessResultDesc("test");
		tp.setCreateTime(new Date());

		orderProcessDAO.insert(tp);
	}
	
	@Test
	public void getOrderByUserIdTest(){
		
		Integer userId = 1;
		List<TAirshuttleOrder> tList = orderDAO.getOrderByUserId(userId);
		
		for(TAirshuttleOrder t : tList){
			
			logger.info(t.getBookNumberPerson());
			TAirshuttleOrderProcess tp = orderProcessDAO.getByOrderId(t.getId());
			//logger.info(tp.getStatus());
		}
		
	}
	
	@Test
	public void getOrderByDriverIdTest(){
		
		Integer driverId = 1;
		List<TAirshuttleOrder> tList = orderDAO.getOrderByDriverId(driverId);
		
		for(TAirshuttleOrder t : tList){
			
			logger.info(t.getBookNumberPerson());
			TAirshuttleOrderProcess tp = orderProcessDAO.getByOrderId(t.getId());
		//	logger.info(tp.getStatus());
		}
	}
	
}
