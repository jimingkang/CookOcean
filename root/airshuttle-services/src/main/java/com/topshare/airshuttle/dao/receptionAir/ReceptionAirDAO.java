package com.topshare.airshuttle.dao.receptionAir;

import java.util.List;
import java.util.Set;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import com.topshare.airshuttle.model.receptionAir.TAirshuttleReceptionAir;

/***
 * 接机
 * @author root
 *
 */
@DAO
public interface ReceptionAirDAO {

	@ReturnGeneratedKeys
	@SQL("insert into t_airshuttle_reception_air (CREATE_PERSON, CREATE_TIME,MODIFY_PERSON, reception_city,"
			+ "reception_school, reception_airport, driver_id,car_id, open_time, price,load_seatNum)"
			+ "values(:c.createPerson,now(),:c.createPerson,:c.receptionCity,:c.receptionSchool,:c.receptionAirport,"
			+ ":c.driverId,:c.carId,:c.openTime,:c.price,:c.loadSeatnum)")
	public Integer insert(@SQLParam("c") TAirshuttleReceptionAir ta);
	
	@SQL("update t_airshuttle_reception_air set MODIFY_PERSON = :c.modifyPerson "
			+ " #if(:c.receptionCity != null){,reception_city=:c.receptionCity} "
			+ " #if(:c.receptionSchool != null){,reception_school=:c.receptionSchool}"
			+ " #if(:c.receptionAirport != null){,reception_airport=:c.receptionAirport}"
			+ " #if(:c.driverId != null){,driver_id=:c.driverId}"
			+ " #if(:c.carId != null){,car_id=:c.carId}"
			+ " #if(:c.openTime != null){,open_time=:c.openTime}"
			+ " #if(:c.price != null){,price=:c.price}"
			+ " #if(:c.loadSeatnum != null){,load_seatNum=:c.loadSeatnum}  where id = :c.id")
	public void updateByParam(@SQLParam("c") TAirshuttleReceptionAir ta);
	
	
	@SQL("select count(*) from t_airshuttle_reception_air #if(:c.createPerson != null){where CREATE_PERSON=:c.createPerson}")
	public Integer getCountByParam(@SQLParam("c") TAirshuttleReceptionAir ta);
	
	@SQL("select count(*) from t_airshuttle_reception_air #if(:c.receptionCity != null){where reception_city=:c.receptionCity}")
	public Integer getCountByCity(@SQLParam("c") TAirshuttleReceptionAir ta);
	
	@SQL("select id,CREATE_PERSON, CREATE_TIME,MODIFY_PERSON, reception_city,"
			+ "reception_school, reception_airport, driver_id,car_id, open_time, price,load_seatNum "
			+ " from t_airshuttle_reception_air"
			+ " #if(:c.createPerson != null){where CREATE_PERSON=:c.createPerson}"
			+ " order by MODIFY_TIME desc limit :pageNumber,:pageSize")
	public List<TAirshuttleReceptionAir> getByParam(@SQLParam("c") TAirshuttleReceptionAir ta,@SQLParam("pageNumber") int pageNumber,@SQLParam("pageSize")  int pageSize);
	
	
	@SQL("select ar.id,ar.CREATE_PERSON, ar.CREATE_TIME,ar.MODIFY_PERSON, ar.reception_city,"
			+ "ar.reception_school, ar.reception_airport, ar.driver_id,car_id, ar.open_time, ar.price,ar.load_seatNum, ad.realName,ad.driving_license_url "
			+ " from t_airshuttle_reception_air ar inner join t_airshuttle_driver ad on (ar.driver_id=ad.id ) "
			+ " #if(:c.receptionCity != null){where ar.reception_city=:c.receptionCity}"
			+ " order by ar.MODIFY_TIME desc limit :pageNumber,:pageSize")
	public List<TAirshuttleReceptionAir> getByCity(@SQLParam("c") TAirshuttleReceptionAir ta,@SQLParam("pageNumber") int pageNumber,@SQLParam("pageSize")  int pageSize);
	
	@SQL("delete from t_airshuttle_reception_air where id in (:ids)")
	public void deleteByIds(@SQLParam("ids") Set<Integer> ids);
	@SQL("select count(*) from t_airshuttle_reception_air #if(:c.receptionSchool != null){where reception_school=:c.receptionSchool}")
	public Integer getCountBySchool(
			@SQLParam("c") TAirshuttleReceptionAir tAirshuttleReceptionAir);
	@SQL("select ar.id,ar.CREATE_PERSON, ar.CREATE_TIME,ar.MODIFY_PERSON, ar.reception_city,"
			+ "ar.reception_school, ar.reception_airport, ar.driver_id,car_id, ar.open_time, ar.price,ar.load_seatNum, ad.realName,ad.driving_license_url "
			+ " from t_airshuttle_reception_air ar inner join t_airshuttle_driver ad on (ar.driver_id=ad.id ) "
			+ " #if(:c.receptionSchool != null){where ar.reception_school=:c.receptionSchool}"
			+ " order by ar.MODIFY_TIME desc limit :pageNumber,:pageSize")
	public List<TAirshuttleReceptionAir> getBySchool(
			@SQLParam("c") TAirshuttleReceptionAir tAirshuttleReceptionAir, @SQLParam("pageNumber") int pageNumber,@SQLParam("pageSize")  int pageSize);
}
