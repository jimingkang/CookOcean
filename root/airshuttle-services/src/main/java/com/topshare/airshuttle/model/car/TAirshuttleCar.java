package com.topshare.airshuttle.model.car;

import java.util.Date;
import java.util.Set;

/***
 * 车辆表
 * @author root
 *
 */
public class TAirshuttleCar {

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_airshuttle_driver.CREATE_PERSON
     *
     * @mbggenerated Wed Jul 08 10:27:42 CST 2015
     */
    private Integer createPerson;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_airshuttle_driver.CREATE_TIME
     *
     * @mbggenerated Wed Jul 08 10:27:42 CST 2015
     */
    private Date createTime;

    private Set<Integer> statusSet;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_airshuttle_driver.MODIFY_PERSON
     *
     * @mbggenerated Wed Jul 08 10:27:42 CST 2015
     */
    private Integer modifyPerson;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_airshuttle_driver.MODIFY_TIME
     *
     * @mbggenerated Wed Jul 08 10:27:42 CST 2015
     */
    private Date modifyTime;
    
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_airshuttle_car.id
	 * @mbggenerated  Wed Jul 08 10:33:46 CST 2015
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_airshuttle_car.car_number
	 * @mbggenerated  Wed Jul 08 10:33:46 CST 2015
	 */
	private String carNumber;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_airshuttle_car.car_brand
	 * @mbggenerated  Wed Jul 08 10:33:46 CST 2015
	 */
	private String carBrand;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_airshuttle_car.car_Model
	 * @mbggenerated  Wed Jul 08 10:33:46 CST 2015
	 */
	private String carModel;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_airshuttle_car.car_colour
	 * @mbggenerated  Wed Jul 08 10:33:46 CST 2015
	 */
	private String carColour;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_airshuttle_car.car_seatNum
	 * @mbggenerated  Wed Jul 08 10:33:46 CST 2015
	 */
	private Integer carSeatnum;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_airshuttle_car.car_picture_url
	 * @mbggenerated  Wed Jul 08 10:33:46 CST 2015
	 */
	private String carPictureUrl;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_airshuttle_car.status
	 * @mbggenerated  Wed Jul 08 10:33:46 CST 2015
	 */
	private Integer status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_airshuttle_car.status_msg
	 * @mbggenerated  Wed Jul 08 10:33:46 CST 2015
	 */
	private String statusMsg;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_airshuttle_car.id
	 * @return  the value of t_airshuttle_car.id
	 * @mbggenerated  Wed Jul 08 10:33:46 CST 2015
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_airshuttle_car.id
	 * @param id  the value for t_airshuttle_car.id
	 * @mbggenerated  Wed Jul 08 10:33:46 CST 2015
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	

	public Set<Integer> getStatusSet() {
		return statusSet;
	}

	public void setStatusSet(Set<Integer> statusSet) {
		this.statusSet = statusSet;
	}

	public Integer getCreatePerson() {
		return createPerson;
	}

	public void setCreatePerson(Integer createPerson) {
		this.createPerson = createPerson;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getModifyPerson() {
		return modifyPerson;
	}

	public void setModifyPerson(Integer modifyPerson) {
		this.modifyPerson = modifyPerson;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_airshuttle_car.car_number
	 * @return  the value of t_airshuttle_car.car_number
	 * @mbggenerated  Wed Jul 08 10:33:46 CST 2015
	 */
	public String getCarNumber() {
		return carNumber;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_airshuttle_car.car_number
	 * @param carNumber  the value for t_airshuttle_car.car_number
	 * @mbggenerated  Wed Jul 08 10:33:46 CST 2015
	 */
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_airshuttle_car.car_brand
	 * @return  the value of t_airshuttle_car.car_brand
	 * @mbggenerated  Wed Jul 08 10:33:46 CST 2015
	 */
	public String getCarBrand() {
		return carBrand;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_airshuttle_car.car_brand
	 * @param carBrand  the value for t_airshuttle_car.car_brand
	 * @mbggenerated  Wed Jul 08 10:33:46 CST 2015
	 */
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_airshuttle_car.car_Model
	 * @return  the value of t_airshuttle_car.car_Model
	 * @mbggenerated  Wed Jul 08 10:33:46 CST 2015
	 */
	public String getCarModel() {
		return carModel;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_airshuttle_car.car_Model
	 * @param carModel  the value for t_airshuttle_car.car_Model
	 * @mbggenerated  Wed Jul 08 10:33:46 CST 2015
	 */
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_airshuttle_car.car_colour
	 * @return  the value of t_airshuttle_car.car_colour
	 * @mbggenerated  Wed Jul 08 10:33:46 CST 2015
	 */
	public String getCarColour() {
		return carColour;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_airshuttle_car.car_colour
	 * @param carColour  the value for t_airshuttle_car.car_colour
	 * @mbggenerated  Wed Jul 08 10:33:46 CST 2015
	 */
	public void setCarColour(String carColour) {
		this.carColour = carColour;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_airshuttle_car.car_seatNum
	 * @return  the value of t_airshuttle_car.car_seatNum
	 * @mbggenerated  Wed Jul 08 10:33:46 CST 2015
	 */
	public Integer getCarSeatnum() {
		return carSeatnum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_airshuttle_car.car_seatNum
	 * @param carSeatnum  the value for t_airshuttle_car.car_seatNum
	 * @mbggenerated  Wed Jul 08 10:33:46 CST 2015
	 */
	public void setCarSeatnum(Integer carSeatnum) {
		this.carSeatnum = carSeatnum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_airshuttle_car.car_picture_url
	 * @return  the value of t_airshuttle_car.car_picture_url
	 * @mbggenerated  Wed Jul 08 10:33:46 CST 2015
	 */
	public String getCarPictureUrl() {
		return carPictureUrl;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_airshuttle_car.car_picture_url
	 * @param carPictureUrl  the value for t_airshuttle_car.car_picture_url
	 * @mbggenerated  Wed Jul 08 10:33:46 CST 2015
	 */
	public void setCarPictureUrl(String carPictureUrl) {
		this.carPictureUrl = carPictureUrl;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_airshuttle_car.status
	 * @return  the value of t_airshuttle_car.status
	 * @mbggenerated  Wed Jul 08 10:33:46 CST 2015
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_airshuttle_car.status
	 * @param status  the value for t_airshuttle_car.status
	 * @mbggenerated  Wed Jul 08 10:33:46 CST 2015
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_airshuttle_car.status_msg
	 * @return  the value of t_airshuttle_car.status_msg
	 * @mbggenerated  Wed Jul 08 10:33:46 CST 2015
	 */
	public String getStatusMsg() {
		return statusMsg;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_airshuttle_car.status_msg
	 * @param statusMsg  the value for t_airshuttle_car.status_msg
	 * @mbggenerated  Wed Jul 08 10:33:46 CST 2015
	 */
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}
}