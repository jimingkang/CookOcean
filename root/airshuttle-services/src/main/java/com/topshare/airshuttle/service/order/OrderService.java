package com.topshare.airshuttle.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topshare.airshuttle.common.util.Page;
import com.topshare.airshuttle.dao.bookDriverProcess.BookDriverProcessDAO;
import com.topshare.airshuttle.dao.order.OrderDAO;
import com.topshare.airshuttle.dao.orderProcess.OrderProcessDAO;
import com.topshare.airshuttle.model.order.TAirshuttleOrder;
import com.topshare.airshuttle.model.userBookDriver.TAirshuttleUserBookDriver;

@Service
public class OrderService {
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	OrderProcessDAO orderProcessDAO;
	@Autowired
	BookDriverProcessDAO bookDriverProcessDAO;
	
	public Page<TAirshuttleOrder> getByUserId(
			TAirshuttleOrder tAirshuttleOrder, Integer pageNumber,
			Integer pageSize) {
		Integer totalCount = orderDAO.getCountByUserId(tAirshuttleOrder);
		
		List<TAirshuttleOrder> list = null;
    	if(pageSize==null)
    		pageSize=5;
    	if (pageNumber==null)
    		pageNumber=1;
    	int offset = (pageNumber - 1) * pageSize; // 起始下标
    	offset = offset > 0 ? offset : 0;
		offset = offset < totalCount ? offset : totalCount;
		
    	if(totalCount > 0){
    		list =  this.orderDAO.getOrderByUserId(tAirshuttleOrder);
    	}
    	
    	return new Page<TAirshuttleOrder>(list, totalCount, pageSize, pageNumber);
	}
	
	
    	
	public Integer insert(TAirshuttleOrder tAirshuttleOrder) {
		// TODO Auto-generated method stub
		
		//System.out.println("(orderDAO insert tAirshuttleOrder.getReceptionAirId( )"+tAirshuttleOrder.getReceptionAirId());
		
		 Integer id=orderDAO.insert(tAirshuttleOrder);
		 
		 tAirshuttleOrder.setReviewProcessId(Integer.valueOf(0));  //0 waiting for pay
		 tAirshuttleOrder.setId(id);
		 orderProcessDAO.insert(tAirshuttleOrder);
		 return id;
	}
	
	public Integer alipayfeedback(TAirshuttleOrder tAirshuttleOrder) {
	

		
		 TAirshuttleUserBookDriver  tAirshuttleUserBookDriver=new TAirshuttleUserBookDriver();
		 tAirshuttleUserBookDriver.setId(tAirshuttleOrder.getBookId());
		 
		 System.out.println("tAirshuttleUserBookDriver jimmy :" + tAirshuttleUserBookDriver.getId());
		 tAirshuttleUserBookDriver.setReviewProcessId(3);          //3 mean  alipay   pay successfully
		// bookDriverProcessDAO.insert(tAirshuttleUserBookDriver);  //用tAirshuttleUserBookDriver 去插入bookDriverProcess
		 tAirshuttleOrder.setReviewProcessId(Integer.valueOf(3));  //3  prepay successfully waiting for xieyun commit
		return orderProcessDAO.insertAfterailpayFeedBack(tAirshuttleOrder);
		
	}
	



	

	



	public Page<TAirshuttleOrder> updateOrder(TAirshuttleOrder tAirshuttleOrder) {
		orderProcessDAO.updateOrderProcess(tAirshuttleOrder);
		return orderDAO.updateOrder(tAirshuttleOrder);
	}



	public TAirshuttleOrder getOrderByDesignNumber(String trade_no) {
		// TODO Auto-generated method stub
		return orderDAO.getOrderByDesignNumber(trade_no);
	}




}
