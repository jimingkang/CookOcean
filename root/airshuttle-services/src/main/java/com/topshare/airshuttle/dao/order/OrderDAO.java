package com.topshare.airshuttle.dao.order;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import com.topshare.airshuttle.common.util.Page;
import com.topshare.airshuttle.model.order.TAirshuttleOrder;

@DAO
public interface OrderDAO {

	@ReturnGeneratedKeys
	@SQL(" insert into t_airshuttle_order (designation_number,create_time,user_id, book_id, driver_id, reception_air_id,"
			+ "book_number_person, pick_up_time, book_price)"
			+ "values(:d.designationNumber,now(),:d.userId,:d.bookId,:d.driverId,:d.receptionAirId,:d.bookNumberPerson,:d.pickUpTime,:d.bookPrice)")
	public Integer insert(@SQLParam("d") TAirshuttleOrder t);
	
	/***
	 * 查询用户查询发起的订单
	 * @param userId
	 * @return
	 */
	@SQL(" select  id,designation_number, create_time, MODIFY_TIME, user_id, driver_id, reception_air_id, book_number_person,pick_up_time, book_price"
			+ " from t_airshuttle_order where user_id = :userId")
	public List<TAirshuttleOrder> getOrderByUserId(@SQLParam("userId") Integer userId);
	
	@SQL(" select  id,designation_number, create_time, MODIFY_TIME, user_id, driver_id, reception_air_id, book_number_person,pick_up_time, book_price"
			+ " from t_airshuttle_order "
			+ "where designation_number = .d:designationNumber"
			)
	public List<TAirshuttleOrder> getByOrderDesignationNumber(@SQLParam("d") TAirshuttleOrder tAirshuttleOrder);
	
	@SQL(" select count(*)"
			+ " from t_airshuttle_order where user_id = :d.userId")
	public Integer getCountByUserId(@SQLParam("d") TAirshuttleOrder tAirshuttleOrder);
	/***
	 * 通过司机编号查询订单
	 * @param driverId
	 * @return
	 */
	@SQL(" select id, designation_number, create_time, MODIFY_TIME, user_id,book_id,  driver_id, reception_air_id, book_number_person,pick_up_time, book_price"
			+ " from t_airshuttle_order where driver_id = :driverId")
	public List<TAirshuttleOrder> getOrderByDriverId(@SQLParam("driverId") Integer driverId);



	@SQL(" select ao.id,ao.designation_number, ao.create_time, ao.MODIFY_TIME, ao.user_id, ao.book_id, ao.driver_id, ao.reception_air_id, ao.book_number_person,ao.pick_up_time,ao.book_price, review_process_id "
			+ " from t_airshuttle_order ao "
			+ " inner join t_airshuttle_order_process op  on(ao.id=op.order_id )  "
			
			+ " #if(:d.userId != null){where ao.user_id=:d.userId } "
			+ " and (op.order_id, op.review_process_id) "
			+" in (select  app.order_id, max(app.review_process_id)  from t_airshuttle_order_process app"
			+ " group by app.order_id) ")
	public List<TAirshuttleOrder> getOrderByUserId(
			@SQLParam("d") TAirshuttleOrder tAirshuttleOrder);

	@SQL(" select id,designation_number, create_time, MODIFY_TIME, user_id, book_id, driver_id, reception_air_id, book_number_person,pick_up_time, book_price"
			+ " from t_airshuttle_order where designation_number = :designationNumber")
	public TAirshuttleOrder getOrderByDesignNumber( @SQLParam("designationNumber") String designationNumber);

	

	
	


	

	
}
