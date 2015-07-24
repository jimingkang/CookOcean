package com.topshare.airshuttle.service.driver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import net.paoding.rose.jade.context.application.JadeFactory;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Service;

import com.topshare.airshuttle.common.util.Page;
import com.topshare.airshuttle.dao.driver.DriverCarDAO;
import com.topshare.airshuttle.dao.driver.DriverDAO;
import com.topshare.airshuttle.model.driver.TAirshuttleDriver;
import com.topshare.airshuttle.model.driver.TAirshuttleDriverCar;
import com.topshare.airshuttle.service.BaseTransServiceTest;

@Service
public class DriverServiceTest extends BaseTransServiceTest{
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	private DriverDAO driverDAO = null;
	
	private DriverCarDAO driverCarDAO = null;
	
	@Before
	public void before(){
		
		DataSource dataSource = this.getDataSource();
		JadeFactory factory = new JadeFactory(dataSource);
		driverDAO = factory.create(DriverDAO.class);
		driverCarDAO = factory.create(DriverCarDAO.class);
	}
	
	
	/***
	 * 保存
	 * @param tAirshuttleDriver
	 */
	@Test
	public void insertTest(){
		
		for (int i = 0; i < 500; i++) {
			
			TAirshuttleDriver tAirshuttleDriver = new TAirshuttleDriver();
			tAirshuttleDriver.setCreatePerson(1);
			tAirshuttleDriver.setModifyPerson(1);
			tAirshuttleDriver.setRealname("谢云"+i);
			tAirshuttleDriver.setIdcard("511602198604171914");
			tAirshuttleDriver.setTelephone("15928687165");
			tAirshuttleDriver.setDrivingLicenseUrl("http://maimode.iteye.com/blog/DrivingLicenseUrl");
			tAirshuttleDriver.setDriversLicenseUrl("http://maimode.iteye.com/blog/DriversLicenseUrl");
			tAirshuttleDriver.setOfficialPhototUrl("http://maimode.iteye.com/blog/OfficialPhototUrl");
			
			if(i % 5 == 0){
				
				tAirshuttleDriver.setStatus(1);
			}else if(i % 3 == 0){
				
				tAirshuttleDriver.setStatus(2);
			}else{
				tAirshuttleDriver.setStatus(0);
			}
			
			driverDAO.insert(tAirshuttleDriver);
		}
	}
	
	/***
	 * 修改
	 */
	@Test
	public void updateByParamTest(){
		
		TAirshuttleDriver tAirshuttleDriver = new TAirshuttleDriver();
		tAirshuttleDriver.setId(1);
		tAirshuttleDriver.setCreatePerson(11);
		tAirshuttleDriver.setModifyPerson(11);
		tAirshuttleDriver.setRealname("谢云1");
		
		driverDAO.updateByParam(tAirshuttleDriver);
	}
	
	/***
	 * 修改司机状态
	 */
	@Test
	public void updateDriverStatusTest(){
		
		TAirshuttleDriver tAirshuttleDriver = new TAirshuttleDriver();
		tAirshuttleDriver.setId(1002);
		tAirshuttleDriver.setStatus(0);
		
		driverDAO.updateByParam(tAirshuttleDriver);
	}
	
	
	/***
	 * 分页查询
	 */
	@Test
	public void getPageByParamTest(){
		
		TAirshuttleDriver tAirshuttleDriver = new TAirshuttleDriver();
		
		Set<Integer> statusSet = new HashSet<Integer>();
		//statusSet.add(1);
		//tAirshuttleDriver.setStatusSet(statusSet);
		tAirshuttleDriver.setStatus(1);
		//模糊查询，需要将%号放到参数里面，不然会报错：'%'12'%' 
		tAirshuttleDriver.setRealname("%12%");
		Integer pageNumber = 1;
		Integer pageSize = 10;
		
		Integer totalCount = driverDAO.getCountByParam(tAirshuttleDriver);
		
		List<TAirshuttleDriver> list = null;
    	
    	int offset = (pageNumber - 1) * pageSize; // 起始下标
    	offset = offset > 0 ? offset : 0;
		offset = offset < totalCount ? offset : totalCount;
		
    	if(totalCount > 0){
    		list =  this.driverDAO.getByParam(tAirshuttleDriver, offset, pageSize);
    	}
    	
    	if(list != null){
    		
    		for(TAirshuttleDriver t : list){
        		
        		logger.info(t.getRealname());
        	}
    	}
    	
    	new Page<TAirshuttleDriver>(list, totalCount, pageSize, pageNumber);
	}
	
	@Test
	public void getByIdTest(){
		
		Integer id = 1002;
		
		TAirshuttleDriver t = this.driverDAO.getById(id);
		logger.info(t.getRealname());
	}
	
	
	@Test
	public void insertDriverCarTest(){
		
		TAirshuttleDriverCar tAirshuttleDriverCar = new TAirshuttleDriverCar();
		tAirshuttleDriverCar.setDriverId(1002);
		tAirshuttleDriverCar.setCarId(501);
		driverCarDAO.insert(tAirshuttleDriverCar);
	}
	
	@Test
	public void commonTest(){
		
		logger.info(3 % 3);
	}
}
