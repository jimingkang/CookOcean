package com.topshare.airshuttle.service.myCollection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topshare.airshuttle.common.util.Page;
import com.topshare.airshuttle.dao.myCollection.MyCollectionDAO;
import com.topshare.airshuttle.model.myCollection.TAirshuttleMyCollection;

/***
 * 我的收藏
 * @author root
 *
 */
@Service
public class MyCollectionService {

	@Autowired
	private MyCollectionDAO myCollectionDAO;
	
	
	/***
	 * 分页查询
	 * @param tAirshuttleDriver
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public Page<TAirshuttleMyCollection> getPageByParam(TAirshuttleMyCollection tAirshuttleMyCollection, int pageNumber, int pageSize){
		
		Integer totalCount = this.myCollectionDAO.getCountByParam(tAirshuttleMyCollection);
    	
    	List<TAirshuttleMyCollection> list = null;
    	
    	int offset = (pageNumber - 1) * pageSize; // 起始下标
    	offset = offset > 0 ? offset : 0;
		offset = offset < totalCount ? offset : totalCount;
		
    	if(totalCount > 0){
    		list =  this.myCollectionDAO.getByParam(tAirshuttleMyCollection, offset, pageSize);
    	}
    	
    	return new Page<TAirshuttleMyCollection>(list, totalCount, pageSize, pageNumber);
	}
	
}
