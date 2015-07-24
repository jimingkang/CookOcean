package com.topshare.airshuttle.service.car;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import net.paoding.rose.jade.context.application.JadeFactory;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Service;

import com.topshare.airshuttle.biz.CommonStatusEnum;
import com.topshare.airshuttle.common.util.Page;
import com.topshare.airshuttle.dao.car.CarDAO;
import com.topshare.airshuttle.model.car.TAirshuttleCar;
import com.topshare.airshuttle.service.BaseTransServiceTest;

@Service
public class CarServiceTest  extends BaseTransServiceTest{

	private Logger logger = Logger.getLogger(this.getClass());
	
	private CarDAO carDAO;
	
	@Before
	public void before(){
		
		DataSource dataSource = this.getDataSource();
		JadeFactory factory = new JadeFactory(dataSource);
		carDAO = factory.create(CarDAO.class);
	}
	
	@Test
	public void insertTest(){
		
		for (int i = 500; i < 501; i++) {
			
			TAirshuttleCar car = new TAirshuttleCar();
			car.setCreatePerson(1);
			car.setModifyPerson(1);
			car.setCarNumber("232323_"+i);
			car.setCarBrand("福特"+i);
			car.setCarModel("xxxxModel"+i);
			car.setCarColour("red"+i);
			car.setCarSeatnum(i);
			car.setCarPictureUrl("http://maimode.iteye.com/blog/carPictureUrl");
			
			if(i % 5 == 0){
				
				car.setStatus(CommonStatusEnum.AUDIT_DELETE.getValue());
			}else if(i % 3 == 0){
				
				car.setStatus(CommonStatusEnum.AUDIT_PASS.getValue());
			}else{
				car.setStatus(CommonStatusEnum.AUDIT_ING.getValue());
			}
			
			Integer id = carDAO.insert(car);
			logger.info(id);
		}
	}
	
	@Test
	public void updateByParam(){
		
		TAirshuttleCar car = new TAirshuttleCar();
		car.setId(502);
		car.setModifyPerson(3);
		car.setCarBrand("福特233232----34343");
		carDAO.updateByParam(car);
	}
	
	
	/***
	 * 分页查询
	 */
	@Test
	public void getPageByParamTest(){
		
		TAirshuttleCar car = new TAirshuttleCar();
		
		Set<Integer> statusSet = new HashSet<Integer>();
		statusSet.add(CommonStatusEnum.AUDIT_PASS.getValue());
		car.setStatusSet(statusSet);
		
		//模糊查询，需要将%号放到参数里面，不然会报错：'%'12'%' 
		car.setCarNumber("%1%");
		Integer pageNumber = 1;
		Integer pageSize = 10;
		
		Integer totalCount = carDAO.getCountByParam(car);
		
		List<TAirshuttleCar> list = null;
    	
    	int offset = (pageNumber - 1) * pageSize; // 起始下标
    	offset = offset > 0 ? offset : 0;
		offset = offset < totalCount ? offset : totalCount;
		
    	if(totalCount > 0){
    		list =  this.carDAO.getByParam(car, offset, pageSize);
    	}
    	
    	if(list != null){
    		
    		for(TAirshuttleCar carEve : list){
        		
        		logger.info(carEve.getCarNumber());
        	}
    	}
    	
    	new Page<TAirshuttleCar>(list, totalCount, pageSize, pageNumber);
	}
	
	@Test
	public void getByIdTest(){
		
		Integer id = 502;
		
		TAirshuttleCar car = this.carDAO.getById(id);
		logger.info(car.getCarNumber());
	}
	
}
