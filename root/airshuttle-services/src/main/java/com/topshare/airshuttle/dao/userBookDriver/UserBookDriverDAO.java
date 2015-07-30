package com.topshare.airshuttle.dao.userBookDriver;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import com.topshare.airshuttle.model.flyGroup.TAirshuttleFlyGroup;
import com.topshare.airshuttle.model.userBookDriver.TAirshuttleUserBookDriver;

@DAO
public interface UserBookDriverDAO {

	@ReturnGeneratedKeys
	@SQL("insert into t_airshuttle_user_book_driver "
		+ "(book_time,user_id, driver_id, book_price,book_number_person, pick_up_time, status,reception_air_id)"
		+ "values(now(),:d.userId,:d.driverId,:d.bookPrice,:d.bookNumberPerson,:d.pickUpTime,:d.status,:d.receptionAirId)")
	public Integer insert(@SQLParam("d") TAirshuttleUserBookDriver t);

	@SQL("select count(*) from t_airshuttle_user_book_driver  #if(:d.userId != null){where user_id=:d.userId} ")
	public Integer getCountByParam(
			@SQLParam("d") TAirshuttleUserBookDriver tAirshuttleUserBookDriver);

	@SQL("select ar.reception_city, ar.reception_school, ap.id bookDriverProcessId , ap.review_process_id, ap.process_result_desc, ap.MODIFY_TIME, au.id, au.book_time, au.user_id, au.driver_id, au.book_price,au.book_number_person, au.pick_up_time, au.status,au.reception_air_id "
			+ " from t_airshuttle_reception_air ar  "
			+ " inner join t_airshuttle_user_book_driver au on(ar.id=au.reception_air_id )  "
			+ " inner join  t_airshuttle_book_driver_process ap on(au.id=ap.book_driver_id)"
			+ " #if(:d.userId != null){where au.user_id=:d.userId} "
			+ " and (ap.book_driver_id, ap.review_process_id) "
			+" in (select  app.book_driver_id, max(app.review_process_id)  from t_airshuttle_book_driver_process app"
			+ " group by app.book_driver_id) "
			+ " limit :pageNumber,:pageSize")
	public List<TAirshuttleUserBookDriver> getByParam(@SQLParam("d") TAirshuttleUserBookDriver tAirshuttleUserBookDriver,@SQLParam("pageNumber") int pageNumber,@SQLParam("pageSize")  int pageSize);


	
	@SQL("select ar.reception_city, ar.reception_school, ap.id bookDriverProcessId , ap.review_process_id, ap.process_result_desc, ap.MODIFY_TIME, au.id, au.book_time, au.user_id, au.driver_id, au.book_price,au.book_number_person, au.pick_up_time, au.status,au.reception_air_id "
			+ " from t_airshuttle_reception_air ar  "
			+ " inner join t_airshuttle_user_book_driver au on(ar.id=au.reception_air_id )  "
			+ " inner join  t_airshuttle_book_driver_process ap on(au.id=ap.book_driver_id)"
			+ " #if(:d.id != null){where au.id=:d.id } "
			+ " and (ap.book_driver_id, ap.review_process_id) "
			+" in (select  app.book_driver_id, max(app.review_process_id)  from t_airshuttle_book_driver_process app"
			+ " group by app.book_driver_id) "
			+ " limit :pageNumber,:pageSize")
	public List<TAirshuttleUserBookDriver> getBybookid(@SQLParam("d") TAirshuttleUserBookDriver tAirshuttleUserBookDriver,@SQLParam("pageNumber") int pageNumber,@SQLParam("pageSize")  int pageSize);

	@SQL("select ar.reception_city, ar.reception_school, ap.id bookDriverProcessId , ap.review_process_id, ap.process_result_desc, ap.MODIFY_TIME, au.id, au.book_time, au.user_id, au.driver_id, au.book_price,au.book_number_person, au.pick_up_time, au.status"
			+ " from t_airshuttle_reception_air ar  "
			+ " inner join t_airshuttle_user_book_driver au on(ar.id=au.reception_air_id )  "
			+ " inner join  t_airshuttle_book_driver_process ap on(au.id=ap.book_driver_id)"
			+ " where au.id = :d.id")
	public TAirshuttleUserBookDriver getUserBookDriveById(TAirshuttleUserBookDriver tAirshuttleUserBookDriver);
	
	@SQL(" update t_airshuttle_user_book_driver set book_price = :d.bookPrice,"
			+ " MODIFY_TIME =:d.modifyTime "
			+ " where id = :d.id")
			public Integer updateUserBookDriveByBookPrice(
					@SQLParam("d") TAirshuttleUserBookDriver tAirshuttleUserBookDriver);   
	   
}
