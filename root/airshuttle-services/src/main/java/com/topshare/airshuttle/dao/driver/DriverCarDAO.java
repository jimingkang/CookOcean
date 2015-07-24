package com.topshare.airshuttle.dao.driver;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import com.topshare.airshuttle.model.driver.TAirshuttleDriverCar;

/***
 * 司机和车辆关联表
 * @author root
 *
 */
@DAO
public interface DriverCarDAO {

	@SQL(" insert into t_airshuttle_driver_car (driver_id, car_id)"
			+ "values (:c.driverId,:c.carId)")
	public void insert(@SQLParam("c") TAirshuttleDriverCar tAirshuttleDriverCar);
	
}
