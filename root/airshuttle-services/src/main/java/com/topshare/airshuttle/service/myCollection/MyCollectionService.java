package com.topshare.airshuttle.service.myCollection;

import org.springframework.beans.factory.annotation.Autowired;

import com.topshare.airshuttle.dao.myCollection.MyCollectionDAO;
import com.topshare.airshuttle.model.myCollection.TAirshuttleMyCollection;

/***
 * 我的收藏
 * @author root
 *
 */
public class MyCollectionService {

	@Autowired
	private MyCollectionDAO myCollectionDAO;
	
	
	public Integer insert(TAirshuttleMyCollection tAirshuttleMyCollection){
		
		return myCollectionDAO.insert(tAirshuttleMyCollection);
	}
	
	public void deleteById(){
		
		myCollectionDAO.deleteById(1);
	}
}
