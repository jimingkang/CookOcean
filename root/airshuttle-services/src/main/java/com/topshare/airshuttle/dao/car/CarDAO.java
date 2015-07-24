package com.topshare.airshuttle.dao.car;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import com.topshare.airshuttle.model.car.TAirshuttleCar;

@DAO
public interface CarDAO {

	@ReturnGeneratedKeys
	@SQL("insert into t_airshuttle_car (CREATE_PERSON, CREATE_TIME, MODIFY_PERSON,car_number, car_brand,"
			+ "car_Model, car_colour, car_seatNum, car_picture_url, status, status_msg)"
			+ "values(:c.createPerson,now(),:c.createPerson,:c.carNumber,:c.carBrand,:c.carModel,:c.carColour,"
			+ ":c.carSeatnum,:c.carPictureUrl,:c.status,:c.status_msg)")
	public Integer insert(@SQLParam("c") TAirshuttleCar tAirshuttleCar);
	
	
	@SQL("update t_airshuttle_car set MODIFY_PERSON = :c.modifyPerson "
			+ " #if(:c.carNumber != null){,car_number=:c.carNumber} "
			+ " #if(:c.carBrand != null){,car_brand=:c.carBrand}"
			+ " #if(:c.carModel != null){,car_Model=:c.carModel}"
			+ " #if(:c.carColour != null){,car_colour=:c.carColour}"
			+ " #if(:c.carSeatnum != null){,car_seatNum=:c.carSeatnum}"
			+ " #if(:c.carPictureUrl != null){,car_picture_url=:c.carPictureUrl}"
			+ " #if(:c.status != null){,status=:c.status}"
			+ " #if(:c.statusMsg != null){,status_msg=:c.statusMsg}  where id = :c.id")
	public void updateByParam(@SQLParam("c") TAirshuttleCar tAirshuttleCar);
	
	/***
	 * 通过状态等信息查询
	 * @param tAirshuttleDriver
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@SQL("select count(*) from t_airshuttle_car where #if(:c.statusSet != null){ status in(:c.statusSet) }"
			+ " #if(:c.carNumber != null){ and car_number LIKE :c.carNumber}")
	public Integer getCountByParam(@SQLParam("c") TAirshuttleCar tAirshuttleCar);
	
	
	@SQL("select id,CREATE_PERSON, CREATE_TIME, MODIFY_PERSON, car_number, car_brand, car_Model, car_colour, car_seatNum,"
			+ " car_picture_url, status, status_msg from t_airshuttle_car"
			+ " where #if(:c.statusSet != null){ status in(:c.statusSet) }"
			+ " #if(:c.carNumber != null){ and car_number LIKE :c.carNumber}"
			+ " limit :pageNumber,:pageSize")
	public List<TAirshuttleCar> getByParam(@SQLParam("c") TAirshuttleCar tAirshuttleCar,@SQLParam("pageNumber") int pageNumber,@SQLParam("pageSize")  int pageSize);

	@SQL("select id,CREATE_PERSON, CREATE_TIME, MODIFY_PERSON, car_number, car_brand, car_Model, car_colour, car_seatNum,"
			+ " car_picture_url, status, status_msg from t_airshuttle_car"
			+ " where   id = :id ")
	public TAirshuttleCar getById( @SQLParam("id") Integer id);
}
