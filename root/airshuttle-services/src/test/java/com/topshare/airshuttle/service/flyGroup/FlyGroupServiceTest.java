package com.topshare.airshuttle.service.flyGroup;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import net.paoding.rose.jade.context.application.JadeFactory;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.topshare.airshuttle.common.util.DateUtils;
import com.topshare.airshuttle.common.util.Page;
import com.topshare.airshuttle.dao.flyGroup.FlyGroupDAO;
import com.topshare.airshuttle.model.flyGroup.TAirshuttleFlyGroup;
import com.topshare.airshuttle.service.BaseTransServiceTest;

/***
 * 飞友团service测试类
 * @author root
 *
 */
public class FlyGroupServiceTest  extends BaseTransServiceTest{

	private Logger logger = Logger.getLogger(this.getClass());
	
	private FlyGroupDAO flyGroupDAO = null;
	
	@Before
	public void before(){
		
		DataSource dataSource = this.getDataSource();
		JadeFactory factory = new JadeFactory(dataSource);
		flyGroupDAO = factory.create(FlyGroupDAO.class);
	}
	
	/***
	 * 保存
	 * @param tAirshuttleDriver
	 */
	@Test
	public void insertTest(){
		
		for (int i = 0; i < 500; i++) {
			
			TAirshuttleFlyGroup flyGroup = new TAirshuttleFlyGroup();
			flyGroup.setDesignationNumber(DateUtils.formatDate(new Date(), "yyyyMMddHHmmss"));
			flyGroup.setCreatePerson(1);
			flyGroup.setModifyPerson(1);
			flyGroup.setCreateTime(new Date());
			flyGroup.setAdmissionSchool("1");
			flyGroup.setGroupType(1);
			flyGroup.setOrigin("1");
			flyGroup.setDestination("1");
			flyGroup.setGroupName("1221");
			flyGroup.setMaxMember(1);
			flyGroup.setExpirationDate(new Date());
			flyGroup.setContactInformation("ContactInformation");
			flyGroup.setMemo("memo");
			
			flyGroup.setIsBookFlights(1);
			flyGroup.setDepartTime(new Date());
			flyGroup.setArriveTime(new Date());
			flyGroup.setAirlines("Airlines");
			flyGroup.setFlight("flight");
			flyGroup.setDepartAirport("setDepartAirport");
			flyGroup.setArriveAirport("xxxArriveAirport");
			
			flyGroup.setIsBookPickUpAirport(1);
			flyGroup.setBookCarNumber(1);
			flyGroup.setCarryNumberPerson(1);
			flyGroup.setDriverList("DriverList");
			
			flyGroupDAO.insert(flyGroup);
		}
	}
	
	@Test
	public void updateByParam(){
		
		TAirshuttleFlyGroup flyGroup = new TAirshuttleFlyGroup();
		flyGroup.setId(501);
		flyGroup.setModifyPerson(1);
		flyGroup.setDesignationNumber(DateUtils.formatDate(new Date(), "yyyyMMddHHmmss"));
		flyGroupDAO.updateByParam(flyGroup);
	}
	
	/***
	 * 分页查询
	 */
	@Test
	public void getPageByParamTest(){
		
		TAirshuttleFlyGroup flyGroup = new TAirshuttleFlyGroup();
		//flyGro;
		Integer pageNumber = 1;
		Integer pageSize = 10;
		
		Integer totalCount = flyGroupDAO.getCountByParam(flyGroup);
		
		List<TAirshuttleFlyGroup> list = null;
    	
    	int offset = (pageNumber - 1) * pageSize; // 起始下标
    	offset = offset > 0 ? offset : 0;
		offset = offset < totalCount ? offset : totalCount;
		
    	if(totalCount > 0){
    		list =  this.flyGroupDAO.getByParam(flyGroup, offset, pageSize);
    	}
    	
    	if(list != null){
    		
    		for(TAirshuttleFlyGroup t : list){
        		
        		logger.info(t.getId());
        	}
    	}
    	
    	new Page<TAirshuttleFlyGroup>(list, totalCount, pageSize, pageNumber);
	}
	
	
	@Test
	public void getByIdTest(){
		
		TAirshuttleFlyGroup flyGroup = this.flyGroupDAO.getById(501);
		if(flyGroup != null){
			
			logger.info(flyGroup.getAdmissionSchool());
		}
	}
}
