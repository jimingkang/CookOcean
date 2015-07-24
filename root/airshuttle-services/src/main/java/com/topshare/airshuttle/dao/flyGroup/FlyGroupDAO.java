package com.topshare.airshuttle.dao.flyGroup;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import com.topshare.airshuttle.model.flyGroup.TAirshuttleFlyGroup;

/***
 * 飞友团
 * @author root
 *
 */
@DAO
public interface FlyGroupDAO {

	@ReturnGeneratedKeys
	@SQL("insert into t_airshuttle_fly_group (Designation_number, CREATE_PERSON, "
			+ "CREATE_TIME, MODIFY_PERSON,Admission_school, group_type, origin,"
			+ "destination, group_name, max_member,expiration_date, contact_information, memo,"
			+ "is_Book_flights, depart_time, arrive_time,airlines, flight, depart_airport,"
			+ "arrive_airport,is_book_pick_up_airport, book_car_number, carry_number_person,"
			+ "driver_list)values (:c.designationNumber,:c.createPerson,now(),:c.createPerson,"
			+ ":c.admissionSchool,:c.groupType,:c.origin,:c.destination,"
			+ ":c.groupName,:c.maxMember,:c.expirationDate,:c.contactInformation,:c.memo,"
			+ ":c.isBookFlights,:c.departTime,:c.arriveTime,:c.airlines,:c.flight,:c.departAirport,"
			+ ":c.arriveAirport,:c.isBookPickUpAirport,"
			+ ":c.bookCarNumber,:c.carryNumberPerson,:c.driverList)")
	public Integer insert(@SQLParam("c") TAirshuttleFlyGroup tAirshuttleFlyGroup);
	
	/***
	 * 删除是修改状态
	 * @param tAirshuttleFlyGroup
	 */
	@SQL("update t_airshuttle_fly_group set MODIFY_PERSON = :c.modifyPerson "
			+ " #if(:c.designationNumber != null){,Designation_number=:c.designationNumber} "
			+ " #if(:c.admissionSchool != null){,Admission_school=:c.admissionSchool} "
			+ " #if(:c.groupType != null){,group_type=:c.groupType} "
			+ " #if(:c.origin != null){,origin=:c.origin} "
			+ " #if(:c.destination != null){,destination=:c.destination} "
			+ " #if(:c.groupName != null){,group_name=:c.groupName} "
			+ " #if(:c.maxMember != null){,max_member=:c.maxMember} "
			+ " #if(:c.expirationDate != null){,expiration_date=:c.expirationDate} "
			+ " #if(:c.contactInformation != null){,contact_information=:c.contactInformation} "
			+ " #if(:c.memo != null){,memo=:c.memo} "
			+ " #if(:c.isBookFlights != null){,is_Book_flights=:c.isBookFlights} "
			+ " #if(:c.departTime != null){,depart_time=:c.departTime} "
			+ " #if(:c.arriveTime != null){,arrive_time=:c.arriveTime} "
			+ " #if(:c.airlines != null){,airlines=:c.airlines} "
			+ " #if(:c.flight != null){,flight=:c.flight} "
			+ " #if(:c.departAirport != null){,depart_airport=:c.departAirport} "
			+ " #if(:c.arriveAirport != null){,arrive_airport=:c.arriveAirport} "
			+ " #if(:c.isBookPickUpAirport != null){,is_book_pick_up_airport=:c.isBookPickUpAirport} "
			+ " #if(:c.bookCarNumber != null){,book_car_number=:c.bookCarNumber} "
			+ " #if(:c.carryNumberPerson != null){,carry_number_person=:c.carryNumberPerson} "
			+ " #if(:c.driverList != null){,driver_list=:c.driverList}"
			+ " #if(:c.status != null){,status=:c.status}"
			+ "  where id = :c.id")
	public void updateByParam(@SQLParam("c") TAirshuttleFlyGroup tAirshuttleFlyGroup);
	
	
	/***
	 * 通过状态等信息查询
	 * @param tAirshuttleDriver
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	
	@SQL("select count(*) from t_airshuttle_fly_group ")
	public Integer getCount(@SQLParam("c") TAirshuttleFlyGroup tAirshuttleFlyGroup);
	
	@SQL("select count(*) from t_airshuttle_fly_group where Admission_school like :c.admissionSchool")
	public Integer getCountByParam(@SQLParam("c") TAirshuttleFlyGroup tAirshuttleFlyGroup);
	
	@SQL("select id,Designation_number, CREATE_PERSON, "
			+ "CREATE_TIME, MODIFY_PERSON,Admission_school, group_type, origin,"
			+ "destination, group_name, max_member,expiration_date, contact_information, memo,"
			+ "is_Book_flights, depart_time, arrive_time,airlines, flight, depart_airport,"
			+ "arrive_airport,is_book_pick_up_airport, book_car_number, carry_number_person,"
			+ "driver_list from t_airshuttle_fly_group"
			+ " where status = :c.status "
			+ " order by MODIFY_TIME desc limit :pageNumber,:pageSize")
	public List<TAirshuttleFlyGroup> getByParam(@SQLParam("c") TAirshuttleFlyGroup tAirshuttleFlyGroup,
			@SQLParam("pageNumber") int pageNumber,@SQLParam("pageSize")  int pageSize);
	
	@SQL("select id,Designation_number, CREATE_PERSON, "
			+ "CREATE_TIME, MODIFY_PERSON,Admission_school, group_type, origin,"
			+ "destination, group_name, max_member,expiration_date, contact_information, memo,"
			+ "is_Book_flights, depart_time, arrive_time,airlines, flight, depart_airport,"
			+ "arrive_airport,is_book_pick_up_airport, book_car_number, carry_number_person,"
			+ "driver_list from t_airshuttle_fly_group"
			+ " where Admission_school like :c.admissionSchool "
			+ " order by MODIFY_TIME desc limit :pageNumber,:pageSize")
	public List<TAirshuttleFlyGroup> getByParamAdmissionSchool(@SQLParam("c") TAirshuttleFlyGroup tAirshuttleFlyGroup,
			@SQLParam("pageNumber") int pageNumber,@SQLParam("pageSize")  int pageSize);
	
	
	/***
	 * 通过编号获取
	 * @param id
	 * @return
	 */
	@SQL("select id,Designation_number, CREATE_PERSON, "
			+ "CREATE_TIME, MODIFY_PERSON,Admission_school, group_type, origin,"
			+ "destination, group_name, max_member,expiration_date, contact_information, memo,"
			+ "is_Book_flights, depart_time, arrive_time,airlines, flight, depart_airport,"
			+ "arrive_airport,is_book_pick_up_airport, book_car_number, carry_number_person,"
			+ "driver_list from t_airshuttle_fly_group"
			+ "  where id = :id ")
	public TAirshuttleFlyGroup getById( @SQLParam("id") Integer id);
	
	
	@SQL("delete from t_airshuttle_fly_group where id = :id")
	public void deleteById( @SQLParam("id") Integer id);
}
