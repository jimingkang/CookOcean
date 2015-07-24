package com.topshare.airshuttle.service.myCollection;

import javax.sql.DataSource;

import net.paoding.rose.jade.context.application.JadeFactory;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.topshare.airshuttle.biz.UserRoleEnum;
import com.topshare.airshuttle.dao.myCollection.MyCollectionDAO;
import com.topshare.airshuttle.model.myCollection.TAirshuttleMyCollection;
import com.topshare.airshuttle.service.BaseTransServiceTest;

/***
 * 我的收藏
 * @author root
 *
 */
public class MyCollectionServiceTest extends BaseTransServiceTest{

	@Autowired
	private MyCollectionDAO myCollectionDAO;
	
	@Before
	public void before(){
		
		DataSource dataSource = this.getDataSource();
		JadeFactory factory = new JadeFactory(dataSource);
		myCollectionDAO = factory.create(MyCollectionDAO.class);
	}
	
	/***
	 * 新增我的收藏
	 */
	@Test
	public void insertTest(){
		
		TAirshuttleMyCollection t = new TAirshuttleMyCollection();
		t.setRefId(1);
		t.setType(UserRoleEnum.FLY_GROUP.getValue());
		t.setUserId(1);
		
		myCollectionDAO.insert(t);
	}
	
	
	@Test
	public void deleteByIdTest(){
		
		myCollectionDAO.deleteById(1);
	}
	
	@Test
	public void deleteByParam(){
		
		TAirshuttleMyCollection t = new TAirshuttleMyCollection();
		t.setRefId(1);
		t.setType(UserRoleEnum.FLY_GROUP.getValue());
		myCollectionDAO.deleteByParam(t);
	}
}
