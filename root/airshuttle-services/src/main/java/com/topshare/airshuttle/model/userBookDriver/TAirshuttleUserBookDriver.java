package com.topshare.airshuttle.model.userBookDriver;

import java.util.Date;

public class TAirshuttleUserBookDriver {
	
	//from process 
	private Integer reviewProcessId;  //status

  
    private String processResultDesc;

    private Date createTime;
    public Integer getBookDriverProcessId() {
		return bookDriverProcessId;
	}

	public void setBookDriverProcessId(Integer bookDriverProcessId) {
		this.bookDriverProcessId = bookDriverProcessId;
	}

	private Integer bookDriverProcessId;   //the primary key of bookDriverProcess 

	public Integer getReviewProcessId() {
		return reviewProcessId;
	}

	public void setReviewProcessId(Integer reviewProcessId) {
		this.reviewProcessId = reviewProcessId;
	}

	public String getProcessResultDesc() {
		return processResultDesc;
	}

	public void setProcessResultDesc(String processResultDesc) {
		this.processResultDesc = processResultDesc;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_airshuttle_user_book_driver.id
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_airshuttle_user_book_driver.book_time
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	private Date bookTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_airshuttle_user_book_driver.MODIFY_TIME
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	private Date modifyTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_airshuttle_user_book_driver.user_id
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	private Integer userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_airshuttle_user_book_driver.driver_id
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	private Integer driverId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_airshuttle_user_book_driver.book_price
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	private String bookPrice;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_airshuttle_user_book_driver.book_number_person
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	private Integer bookNumberPerson;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_airshuttle_user_book_driver.pick_up_time
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	private Date pickUpTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_airshuttle_user_book_driver.status
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	private Integer status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_airshuttle_user_book_driver.flygroup_id
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	private Integer flygroupId;
	private String receptionSchool;
	private String receptionCity;
	private String receptionAirPort;
	public String getReceptionSchool() {
		return receptionSchool;
	}

	public void setReceptionSchool(String receptionSchool) {
		this.receptionSchool = receptionSchool;
	}

	public String getReceptionCity() {
		return receptionCity;
	}

	public void setReceptionCity(String receptionCity) {
		this.receptionCity = receptionCity;
	}

	public String getReceptionAirPort() {
		return receptionAirPort;
	}

	public void setReceptionAirPort(String receptionAirPort) {
		this.receptionAirPort = receptionAirPort;
	}

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_airshuttle_user_book_driver.reception_air_id
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	private Integer receptionAirId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_airshuttle_user_book_driver.id
	 * @return  the value of t_airshuttle_user_book_driver.id
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_airshuttle_user_book_driver.id
	 * @param id  the value for t_airshuttle_user_book_driver.id
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_airshuttle_user_book_driver.book_time
	 * @return  the value of t_airshuttle_user_book_driver.book_time
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	public Date getBookTime() {
		return bookTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_airshuttle_user_book_driver.book_time
	 * @param bookTime  the value for t_airshuttle_user_book_driver.book_time
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	public void setBookTime(Date bookTime) {
		this.bookTime = bookTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_airshuttle_user_book_driver.MODIFY_TIME
	 * @return  the value of t_airshuttle_user_book_driver.MODIFY_TIME
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_airshuttle_user_book_driver.MODIFY_TIME
	 * @param modifyTime  the value for t_airshuttle_user_book_driver.MODIFY_TIME
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_airshuttle_user_book_driver.user_id
	 * @return  the value of t_airshuttle_user_book_driver.user_id
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_airshuttle_user_book_driver.user_id
	 * @param userId  the value for t_airshuttle_user_book_driver.user_id
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_airshuttle_user_book_driver.driver_id
	 * @return  the value of t_airshuttle_user_book_driver.driver_id
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	public Integer getDriverId() {
		return driverId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_airshuttle_user_book_driver.driver_id
	 * @param driverId  the value for t_airshuttle_user_book_driver.driver_id
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_airshuttle_user_book_driver.book_price
	 * @return  the value of t_airshuttle_user_book_driver.book_price
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	public String getBookPrice() {
		return bookPrice;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_airshuttle_user_book_driver.book_price
	 * @param bookPrice  the value for t_airshuttle_user_book_driver.book_price
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_airshuttle_user_book_driver.book_number_person
	 * @return  the value of t_airshuttle_user_book_driver.book_number_person
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	public Integer getBookNumberPerson() {
		return bookNumberPerson;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_airshuttle_user_book_driver.book_number_person
	 * @param bookNumberPerson  the value for t_airshuttle_user_book_driver.book_number_person
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	public void setBookNumberPerson(Integer bookNumberPerson) {
		this.bookNumberPerson = bookNumberPerson;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_airshuttle_user_book_driver.pick_up_time
	 * @return  the value of t_airshuttle_user_book_driver.pick_up_time
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	public Date getPickUpTime() {
		return pickUpTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_airshuttle_user_book_driver.pick_up_time
	 * @param pickUpTime  the value for t_airshuttle_user_book_driver.pick_up_time
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	public void setPickUpTime(Date pickUpTime) {
		this.pickUpTime = pickUpTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_airshuttle_user_book_driver.status
	 * @return  the value of t_airshuttle_user_book_driver.status
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_airshuttle_user_book_driver.status
	 * @param status  the value for t_airshuttle_user_book_driver.status
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_airshuttle_user_book_driver.flygroup_id
	 * @return  the value of t_airshuttle_user_book_driver.flygroup_id
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	public Integer getFlygroupId() {
		return flygroupId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_airshuttle_user_book_driver.flygroup_id
	 * @param flygroupId  the value for t_airshuttle_user_book_driver.flygroup_id
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	public void setFlygroupId(Integer flygroupId) {
		this.flygroupId = flygroupId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_airshuttle_user_book_driver.reception_air_id
	 * @return  the value of t_airshuttle_user_book_driver.reception_air_id
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	public Integer getReceptionAirId() {
		return receptionAirId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_airshuttle_user_book_driver.reception_air_id
	 * @param receptionAirId  the value for t_airshuttle_user_book_driver.reception_air_id
	 * @mbggenerated  Tue Jul 21 17:38:33 CST 2015
	 */
	public void setReceptionAirId(Integer receptionAirId) {
		this.receptionAirId = receptionAirId;
	}
}