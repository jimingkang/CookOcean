package com.topshare.airshuttle.service.userBookDriver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topshare.airshuttle.common.util.Page;
import com.topshare.airshuttle.dao.bookDriverProcess.BookDriverProcessDAO;
import com.topshare.airshuttle.dao.userBookDriver.UserBookDriverDAO;
import com.topshare.airshuttle.model.userBookDriver.TAirshuttleUserBookDriver;
@Service
public class UserBookDriverService {
	@Autowired
	private UserBookDriverDAO userBookDriverDAO;
	@Autowired
	BookDriverProcessDAO bookDriverProcessDAO;

	public Page<TAirshuttleUserBookDriver> getByParam(
			TAirshuttleUserBookDriver tAirshuttleUserBookDriver, Integer pageNumber,
			Integer pageSize) {
		Integer totalCount = userBookDriverDAO.getCountByParam(tAirshuttleUserBookDriver);
		
		List<TAirshuttleUserBookDriver> list = null;
    	if(pageSize==null)
    		pageSize=5;
    	if (pageNumber==null)
    		pageNumber=1;
    	int offset = (pageNumber - 1) * pageSize; // 起始下标
    	offset = offset > 0 ? offset : 0;
		offset = offset < totalCount ? offset : totalCount;
		
    	if(totalCount > 0){
    		list =  this.userBookDriverDAO.getByParam(tAirshuttleUserBookDriver, offset, pageSize);
    	}
    	
    	return new Page<TAirshuttleUserBookDriver>(list, totalCount, pageSize, pageNumber);
	}
	
	
    	
	public Integer insert(TAirshuttleUserBookDriver tAirshuttleUserBookDriver) {
		// TODO Auto-generated method stub
		
		//System.out.println("(userBookDriverDAO insert tAirshuttleUserBookDriver.getReceptionAirId( )"+tAirshuttleUserBookDriver.getReceptionAirId());
		
		 Integer id=userBookDriverDAO.insert(tAirshuttleUserBookDriver);
		 tAirshuttleUserBookDriver.setId(id);
		 bookDriverProcessDAO.insert(tAirshuttleUserBookDriver);
		 return id;
	}
	



	public TAirshuttleUserBookDriver getUserBookDriveById(
			TAirshuttleUserBookDriver tAirshuttleUserBookDriver) {
		// TODO Auto-generated method stub
		return userBookDriverDAO.getUserBookDriveById(tAirshuttleUserBookDriver);
	}



	public Integer updateUserBookDriver(
			TAirshuttleUserBookDriver tAirshuttleUserBookDriver) {
		
		bookDriverProcessDAO.updateBookProcess(tAirshuttleUserBookDriver);
		return userBookDriverDAO.updateUserBookDriveByBookPrice(tAirshuttleUserBookDriver);
	}
}
