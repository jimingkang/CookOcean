package com.topshare.airshuttle.dao.bookDriverProcess;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import com.topshare.airshuttle.model.bookDriverProcess.TAirshuttleBookDriverProcess;
import com.topshare.airshuttle.model.userBookDriver.TAirshuttleUserBookDriver;

/***
 * 预定司机流程
 * @author root
 *
 */
@DAO
public interface BookDriverProcessDAO {
	
	@ReturnGeneratedKeys
	@SQL("insert into t_airshuttle_book_driver_process (book_driver_id, review_process_id,"
			+ "process_result_desc, create_time)"
			+ "values(:d.bookDriverId,:d.status,:d.processResultDesc,now())")
	public Integer insert(@SQLParam("d") TAirshuttleBookDriverProcess t);
	
	@ReturnGeneratedKeys
	@SQL("select  id, book_driver_id, review_process_id, process_result_desc, create_time, MODIFY_TIME from t_airshuttle_book_driver_process "
			+ "where book_driver_id = :bookDriverId order by MODIFY_TIME desc LIMIT 1")
	public TAirshuttleBookDriverProcess getByBookDriverId( @SQLParam("bookDriverId") Integer bookDriverId);
	
	@SQL("update t_airshuttle_book_driver_process set review_process_id=:d.reviewProcessId ,MODIFY_TIME=:d.modifyTime   "
			+ "where id = :d.bookDriverProcessId ")
	public Integer updateBookProcess(@SQLParam("d") TAirshuttleUserBookDriver tAirshuttleUserBookDriver);
	
	
	@ReturnGeneratedKeys
	@SQL("insert into t_airshuttle_book_driver_process (book_driver_id, review_process_id,"
			+ "process_result_desc, MODIFY_TIME)"
			+ "values(:d.id,:d.status,:d.processResultDesc,now())")
	public void insert(@SQLParam("d") TAirshuttleUserBookDriver tAirshuttleUserBookDriver);

	
}
