package com.topshare.airshuttle.service.driver;

import java.util.List;

import javax.sql.DataSource;

import net.paoding.rose.jade.context.application.JadeFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.topshare.airshuttle.common.util.Page;
import com.topshare.airshuttle.dao.car.CarDAO;
import com.topshare.airshuttle.dao.driver.DriverCarDAO;
import com.topshare.airshuttle.dao.driver.DriverDAO;
import com.topshare.airshuttle.model.car.TAirshuttleCar;
import com.topshare.airshuttle.model.driver.TAirshuttleDriver;
import com.topshare.airshuttle.model.driver.TAirshuttleDriverCar;
import com.topshare.airshuttle.service.BaseTransService;

@Service
public class DriverService extends BaseTransService{
	
	@Autowired
	private DriverDAO driverDAO;
	
	@Autowired
	private DriverCarDAO driverCarDAO;
	
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void modifyDriverMsg(final TAirshuttleDriver driver){
		
		final DataSource dataSource = this.getDataSource();
		DataSourceTransactionManager dstm = new DataSourceTransactionManager();
		dstm.setDataSource(dataSource);
		TransactionTemplate tt = new TransactionTemplate(dstm);
		tt.execute(new TransactionCallback() {
			public Object doInTransaction(TransactionStatus status) {
				
				JadeFactory factory = new JadeFactory(dataSource);
				DriverDAO driverDAO = factory.create(DriverDAO.class);
				CarDAO carDAO = factory.create(CarDAO.class);
				
				driverDAO.updateByParam(driver);
				for(TAirshuttleCar car : driver.getCarList()){
					
					carDAO.updateByParam(car);
				}
				return null;
			}
		});
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void insertDriverMsg(final TAirshuttleDriver driver){
		
		final DataSource dataSource = this.getDataSource();
		DataSourceTransactionManager dstm = new DataSourceTransactionManager();
		dstm.setDataSource(dataSource);
		TransactionTemplate tt = new TransactionTemplate(dstm);
		tt.execute(new TransactionCallback() {
			public Object doInTransaction(TransactionStatus status) {
				
				JadeFactory factory = new JadeFactory(dataSource);
				DriverDAO driverDAO = factory.create(DriverDAO.class);
				CarDAO carDAO = factory.create(CarDAO.class);
				DriverCarDAO driverCarDAO = factory.create(DriverCarDAO.class);
				
				//插入司机
				Integer driverId = driverDAO.insert(driver);
				
				//插入车辆
				for(TAirshuttleCar car : driver.getCarList()){
					
					Integer carId = carDAO.insert(car);
					
					TAirshuttleDriverCar driverCar = new TAirshuttleDriverCar();
					driverCar.setCarId(carId);
					driverCar.setDriverId(driverId);
					
					driverCarDAO.insert(driverCar);
				}
				
				
				return null;
			}
		});
	}
}
