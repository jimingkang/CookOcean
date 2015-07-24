package com.topshare.airshuttle.dao.driver;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import com.topshare.airshuttle.model.driver.TAirshuttleDriver;

@DAO
public interface DriverDAO {

	@ReturnGeneratedKeys
	@SQL("insert into t_airshuttle_driver ( CREATE_PERSON, CREATE_TIME, MODIFY_PERSON, realName,"
			+ "idCard, telephone, driving_license_url, Drivers_license_url, official_photot_url,status,statusMsg)"
			+ "values (:d.createPerson,now(),:d.createPerson,:d.realname,:d.idcard,:d.telephone,:d.drivingLicenseUrl,"
			+ ":d.driversLicenseUrl,:d.officialPhototUrl,:d.status,:d.statusMsg)")
	public Integer insert(@SQLParam("d") TAirshuttleDriver tAirshuttleDriver);
	
	
	@SQL("update t_airshuttle_driver set MODIFY_PERSON = :d.modifyPerson #if(:d.realname != null){,realName=:d.realname}"
			+ " #if(:d.idCard != null){,idCard=:d.idcard}"
			+ " #if(:d.telephone != null){,telephone=:d.telephone}"
			+ " #if(:d.drivingLicenseUrl != null){,driving_license_url=:d.drivingLicenseUrl}"
			+ " #if(:d.driversLicenseUrl != null){,Drivers_license_url=:d.driversLicenseUrl}"
			+ " #if(:d.officialPhototUrl != null){,official_photot_url=:d.officialPhototUrl}"
			+ " #if(:d.securityMoney != null){,security_money=:d.securityMoney}"
			+ " #if(:d.status != null){,status=:d.status}#if(:d.statusMsg != null){,statusMsg=:d.statusMsg} where id = :d.id")
	public void updateByParam(@SQLParam("d") TAirshuttleDriver tAirshuttleDriver);
	
	@SQL("select count(*) from t_airshuttle_driver where #if(:d.statusSet != null){ status in(:d.statusSet) }"
			+ " #if(:d.realname != null){ and realname LIKE :d.realname }")
	public Integer getCountByParam(@SQLParam("d") TAirshuttleDriver tAirshuttleDriver);
	
	
	@SQL("select count(*) from t_airshuttle_driver where city = :d.city")
	public Integer getCountByCity(@SQLParam("d") TAirshuttleDriver tAirshuttleDriver);
	
	/***
	 * 通过状态等信息查询
	 * @param tAirshuttleDriver
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@SQL("select id, CREATE_PERSON, CREATE_TIME, MODIFY_PERSON modifyPerson, MODIFY_TIME modifyTime, DESCRIPTION, realName,"
			+ " idCard, telephone, driving_license_url drivingLicenseUrl ,"
			+ " security_money securityMoney, official_photot_url officialPhototUrl, "
			+ " status, status_msg statusMsg from t_airshuttle_driver "
			+ " where #if(:d.statusSet != null){ status in(:d.statusSet) } #if(:d.realname != null){ and realname LIKE :d.realname }"
			+ " limit :pageNumber,:pageSize")
	public List<TAirshuttleDriver> getByParam(@SQLParam("d") TAirshuttleDriver tAirshuttleDriver,@SQLParam("pageNumber") int pageNumber,@SQLParam("pageSize")  int pageSize);
	
	/***
	 * 通过id查询
	 * @param id
	 * @return
	 */
	@SQL("select id, CREATE_PERSON, CREATE_TIME, MODIFY_PERSON modifyPerson, MODIFY_TIME modifyTime, DESCRIPTION, realName,"
			+ " idCard, telephone, driving_license_url drivingLicenseUrl , "
			+ " security_money securityMoney, official_photot_url officialPhototUrl, "
			+ " status, status_msg statusMsg from t_airshuttle_driver "
			+ " where  id = :id ")
	public TAirshuttleDriver getById( @SQLParam("id") Integer id);


	@SQL("select id, CREATE_PERSON, CREATE_TIME, MODIFY_PERSON modifyPerson, MODIFY_TIME modifyTime, DESCRIPTION, realName,"
			+ " idCard, telephone, driving_license_url drivingLicenseUrl ,"
			+ " security_money securityMoney, official_photot_url officialPhototUrl, "
			+ " status, status_msg statusMsg,city  from t_airshuttle_driver "
			+ " where #if(:d.city != null){  city LIKE :d.city } "
			
			+ " limit :pageNumber,:pageSize")
	public List<TAirshuttleDriver> getByParamCity(@SQLParam("d") TAirshuttleDriver tAirshuttleDriver,@SQLParam("pageNumber") int pageNumber,@SQLParam("pageSize")  int pageSize);
}
