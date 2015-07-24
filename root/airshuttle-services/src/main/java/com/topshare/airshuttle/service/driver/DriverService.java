package com.topshare.airshuttle.service.driver;

import java.util.List;

import net.paoding.rose.jade.annotation.SQLParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topshare.airshuttle.common.util.Page;
import com.topshare.airshuttle.dao.driver.DriverCarDAO;
import com.topshare.airshuttle.dao.driver.DriverDAO;
import com.topshare.airshuttle.model.driver.TAirshuttleDriver;
import com.topshare.airshuttle.model.driver.TAirshuttleDriverCar;
import com.topshare.airshuttle.model.userBookDriver.TAirshuttleUserBookDriver;

@Service
public class DriverService {
	
	@Autowired
	private DriverDAO driverDAO;
	
	@Autowired
	private DriverCarDAO driverCarDAO;
	
	/***
	 * 保存
	 * @param tAirshuttleDriver
	 */
	public Integer insert(TAirshuttleDriver tAirshuttleDriver){
		
		return this.driverDAO.insert(tAirshuttleDriver);
	}
	
	/***
	 * 更新，删除也是改变status属性
	 * @param tAirshuttleDriver
	 */
	public void updateByParam(TAirshuttleDriver tAirshuttleDriver){
		
		this.driverDAO.updateByParam(tAirshuttleDriver);
	}
	
	/***
	 * 分页查询
	 * @param tAirshuttleDriver
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public Page<TAirshuttleDriver> getPageByParam(TAirshuttleDriver tAirshuttleDriver, int pageNumber, int pageSize){
		
		Integer totalCount = this.driverDAO.getCountByParam(tAirshuttleDriver);
    	
    	List<TAirshuttleDriver> list = null;
    	
    	int offset = (pageNumber - 1) * pageSize; // 起始下标
    	offset = offset > 0 ? offset : 0;
		offset = offset < totalCount ? offset : totalCount;
		
    	if(totalCount > 0){
    		list =  this.driverDAO.getByParam(tAirshuttleDriver, offset, pageSize);
    	}
    	
    	return new Page<TAirshuttleDriver>(list, totalCount, pageSize, pageNumber);
	}
	public Page<TAirshuttleDriver> getPageBycity(TAirshuttleDriver tAirshuttleDriver, int pageNumber, int pageSize){
		
		Integer totalCount = this.driverDAO.getCountByCity(tAirshuttleDriver);
    	
    	List<TAirshuttleDriver> list = null;
    	
    	int offset = (pageNumber - 1) * pageSize; // 起始下标
    	offset = offset > 0 ? offset : 0;
		offset = offset < totalCount ? offset : totalCount;
		
    	if(totalCount > 0){
    		list =  this.driverDAO.getByParamCity(tAirshuttleDriver, offset, pageSize);
    	}
    	
    	return new Page<TAirshuttleDriver>(list, totalCount, pageSize, pageNumber);
	}
	
	/***
	 * 查询一条记录
	 * @param id
	 * @return
	 */
	public TAirshuttleDriver getById( @SQLParam("id") Integer id){
		
		return this.driverDAO.getById(id);
	}
	
	/***
	 * 插入司机和车辆关联表信息
	 */
	public void insertDriverCar(TAirshuttleDriverCar tAirshuttleDriverCar){
		
		this.driverCarDAO.insert(tAirshuttleDriverCar);
	}

	
}
