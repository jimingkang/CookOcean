package com.topshare.airshuttle.dao.myCollection;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import com.topshare.airshuttle.model.myCollection.TAirshuttleMyCollection;

@DAO
public interface MyCollectionDAO {
	
	@ReturnGeneratedKeys
	@SQL("insert into t_airshuttle_my_collection (ref_id, type, user_id, CREATE_TIME)"
			+ "values (:d.refId,:d.type,:d.userId,now())")
	public Integer insert(@SQLParam("d") TAirshuttleMyCollection tAirshuttleMyCollection);
	
	@SQL("delete from t_airshuttle_my_collection where id = :id")
	public void deleteById(@SQLParam("id") Integer id);
	
	@SQL("delete from t_airshuttle_my_collection where ref_id = :d.refId and type = :d.type")
	public void deleteByParam(@SQLParam("d") TAirshuttleMyCollection tAirshuttleMyCollection);
	
	@SQL("SELECT count(*) "
			+ " FROM t_airshuttle_fly_group flyGroup "
			+ " INNER JOIN  t_airshuttle_my_collection my"
			+ " ON my.ref_id = flyGroup.id "
			+ " WHERE my.type = :type and my.user_id = :d.userId")
	public Integer getCountByParam(@SQLParam("d") TAirshuttleMyCollection tAirshuttleMyCollection);
	
	@SQL("select id,Designation_number, CREATE_PERSON, "
			+ "CREATE_TIME, MODIFY_PERSON,Admission_school, group_type, origin,"
			+ "destination, group_name, max_member,expiration_date, contact_information, memo,"
			+ "is_Book_flights, depart_time, arrive_time,airlines, flight, depart_airport,"
			+ "arrive_airport,is_book_pick_up_airport, book_car_number, carry_number_person,"
			+ "driver_list from t_airshuttle_fly_group flyGroup "
			+ " INNER JOIN  t_airshuttle_my_collection my "
			+ " ON my.ref_id = flyGroup.id "
			+ " WHERE my.type = :d.type and my.user_id = :d.userId "
			+ " ORDER BY flyGroup.expiration_date DESC "
			+ " limit :pageNumber,:pageSize")
	public List<TAirshuttleMyCollection> getByParam(@SQLParam("d") TAirshuttleMyCollection tAirshuttleMyCollection,
			@SQLParam("pageNumber") int pageNumber,@SQLParam("pageSize")  int pageSize);
}
