package com.topshare.airshuttle.service.receptionAir;

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
import com.topshare.airshuttle.dao.receptionAir.ReceptionAirDAO;
import com.topshare.airshuttle.model.receptionAir.TAirshuttleReceptionAir;
import com.topshare.airshuttle.service.BaseTransServiceTest;

@Service
public class ReceptionAirServiceTest extends BaseTransServiceTest{

	private Logger logger = Logger.getLogger(this.getClass());
	
	private ReceptionAirDAO receptionAirDAO = null;
	
	@Before
	public void before(){
		
		DataSource dataSource = this.getDataSource();
		JadeFactory factory = new JadeFactory(dataSource);
		receptionAirDAO = factory.create(ReceptionAirDAO.class);
	}
	
	
	@Test
	public void insert(){
		
		for (int i = 0; i < 5; i++) {
			
			TAirshuttleReceptionAir ta = new TAirshuttleReceptionAir();
			ta.setCreatePerson(1);
			ta.setReceptionCity("NY");
			ta.setReceptionSchool("NYC");
			ta.setReceptionAirport("KEN");
			ta.setDriverId(2000+i);
			ta.setCarId(i);
			ta.setOpenTime("Mon-Fri 1:pm-8:pm");
			ta.setPrice("10");
			ta.setLoadSeatnum(4);
			
			receptionAirDAO.insert(ta);
		}
	}
	
	@Test
	public void updateByParamTest(){
	
		TAirshuttleReceptionAir ta = new TAirshuttleReceptionAir();
		ta.setModifyPerson(1);
		ta.setId(2);
		ta.setOpenTime("xxx");
		receptionAirDAO.updateByParam(ta);
	}
	
	/***
	 * 分页查询
	 */
	@Test
	public void getPageByParamTest(){
		
		TAirshuttleReceptionAir ta = new TAirshuttleReceptionAir();
		ta.setCreatePerson(1);
		
		Integer pageNumber = 1;
		Integer pageSize = 10;
		
		Integer totalCount = receptionAirDAO.getCountByParam(ta);
		
		List<TAirshuttleReceptionAir> list = null;
    	
    	int offset = (pageNumber - 1) * pageSize; // 起始下标
    	offset = offset > 0 ? offset : 0;
		offset = offset < totalCount ? offset : totalCount;
		
    	if(totalCount > 0){
    		list =  this.receptionAirDAO.getByParam(ta, offset, pageSize);
    	}
    	
    	if(list != null){
    		
    		for(TAirshuttleReceptionAir taEve : list){
        		
        		logger.info(taEve.getId());
        	}
    	}
    	
    	new Page<TAirshuttleReceptionAir>(list, totalCount, pageSize, pageNumber);
	}
	
	@Test
	public void deleteByIds(){
		Set<Integer> ids = new HashSet<Integer>();
		ids.add(1);
		
		this.receptionAirDAO.deleteByIds(ids);
	}
}
