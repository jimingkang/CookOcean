package com.topshare.airshuttle.dao.orderProcess;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import com.topshare.airshuttle.model.order.TAirshuttleOrder;
import com.topshare.airshuttle.model.orderProcess.TAirshuttleOrderProcess;

@DAO
public interface OrderProcessDAO {

	@ReturnGeneratedKeys
	@SQL("insert into t_airshuttle_order_process (order_id, review_process_id,"
			+ "process_result_desc, create_time)"
			+ "values(:d.orderId,:d.reviewProcessId,:d.processResultDesc,now())")
	public Integer insert(@SQLParam("d") TAirshuttleOrderProcess t);
	
	@ReturnGeneratedKeys
	@SQL("select  id, order_id, review_process_id, process_result_desc, create_time, MODIFY_TIME from t_airshuttle_order_process "
			+ "where order_id = :orderId order by MODIFY_TIME desc LIMIT 1")
	public TAirshuttleOrderProcess getByOrderId( @SQLParam("orderId") Integer orderId);

	public void updateOrderProcess(TAirshuttleOrderProcess tAirshuttleOrderProcess);

	@ReturnGeneratedKeys
	@SQL("insert into t_airshuttle_order_process (order_id, review_process_id,"
			+ "process_result_desc, create_time)"
			+ "values(:d.id,:d.reviewProcessId,:d.processResultDesc,now())")
	public Integer insert(@SQLParam("d")  TAirshuttleOrder tAirshuttleOrder);
	
	@ReturnGeneratedKeys
	@SQL("insert into t_airshuttle_order_process (order_id, review_process_id,"
			+ "process_result_desc, MODIFY_TIME)"
			+ "values(:d.id,:d.reviewProcessId,:d.processResultDesc,:d.modifyTime)")
	public Integer insertAfterailpayFeedBack(@SQLParam("d")  TAirshuttleOrder tAirshuttleOrder);
	

	public void updateOrderProcess(TAirshuttleOrder tAirshuttleOrder);
}
