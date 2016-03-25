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
	
	
	@SQL("select  id, order_id, review_process_id, process_result_desc, create_time, MODIFY_TIME from t_airshuttle_order_process "
			+ "where order_id = :orderId order by MODIFY_TIME desc LIMIT 1")
	public TAirshuttleOrderProcess getByOrderId( @SQLParam("orderId") Integer orderId);

	@SQL("select  op.id, op.order_id, op.review_process_id, op.process_result_desc, op.MODIFY_TIME from t_airshuttle_order_process op "
			+ " inner join t_airshuttle_order ao  on(ao.id=op.order_id )  "
			+ "where ao.designation_number = .d:designationNumber order by op.MODIFY_TIME desc LIMIT 1")
	public TAirshuttleOrderProcess getByOrderDesignationNumber(@SQLParam("d")  TAirshuttleOrder tAirshuttleOrder);
	
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
	
	
	@ReturnGeneratedKeys
	@SQL("insert into t_airshuttle_order_process (order_id, review_process_id,"
			+ "process_result_desc, MODIFY_TIME)"
			+ "values(:d.id,:d.reviewProcessId,:d.processResultDesc,:d.modifyTime)")
	public void updateOrderProcess(TAirshuttleOrder tAirshuttleOrder);
}
