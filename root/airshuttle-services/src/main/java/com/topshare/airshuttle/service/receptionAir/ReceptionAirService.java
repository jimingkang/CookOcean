package com.topshare.airshuttle.service.receptionAir;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topshare.airshuttle.common.util.Page;
import com.topshare.airshuttle.dao.receptionAir.ReceptionAirDAO;
import com.topshare.airshuttle.model.receptionAir.TAirshuttleReceptionAir;

@Service
public class ReceptionAirService {

	@Autowired
	private ReceptionAirDAO receptionAirDAO;
	
	public void insert(TAirshuttleReceptionAir ta){
		
		receptionAirDAO.insert(ta);
	}
	
	public void updateByParam(TAirshuttleReceptionAir ta){
		
		receptionAirDAO.updateByParam(ta);
	}
	
	/***
	 * 分页查询
	 * @param tAirshuttleDriver
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public Page<TAirshuttleReceptionAir> getPageByParam(TAirshuttleReceptionAir ta, int pageNumber, int pageSize){
		
		Integer totalCount = this.receptionAirDAO.getCountByParam(ta);
    	
    	List<TAirshuttleReceptionAir> list = null;
    	
    	int offset = (pageNumber - 1) * pageSize; // 起始下标
    	offset = offset > 0 ? offset : 0;
		offset = offset < totalCount ? offset : totalCount;
		
    	if(totalCount > 0){
    		list =  this.receptionAirDAO.getByParam(ta, offset, pageSize);
    	}
    	
    	return new Page<TAirshuttleReceptionAir>(list, totalCount, pageSize, pageNumber);
	}
	
	public void deleteByIds(Set<Integer> ids){
		
		this.receptionAirDAO.deleteByIds(ids);
	}

	public Page<TAirshuttleReceptionAir> getPageBycity(
			TAirshuttleReceptionAir tAirshuttleReceptionAir,
			Integer pageNumber, Integer pageSize) {
Integer totalCount = this.receptionAirDAO.getCountByCity(tAirshuttleReceptionAir);
    	
    	List<TAirshuttleReceptionAir> list = null;
    	if(pageSize==null)
    		pageSize=5;
    	if (pageNumber==null)
    		pageNumber=1;
    	
    	int offset = (pageNumber - 1) * pageSize; // 起始下标
    	offset = offset > 0 ? offset : 0;
		offset = offset < totalCount ? offset : totalCount;
		
    	if(totalCount > 0){
    		list =  this.receptionAirDAO.getByCity(tAirshuttleReceptionAir, offset, pageSize);
    	}
    	
    	return new Page<TAirshuttleReceptionAir>(list, totalCount, pageSize, pageNumber);
	}
	public Page<TAirshuttleReceptionAir> getPageBySchool(
			TAirshuttleReceptionAir tAirshuttleReceptionAir,
			Integer pageNumber, Integer pageSize) {
Integer totalCount = this.receptionAirDAO.getCountBySchool(tAirshuttleReceptionAir);
    	
    	List<TAirshuttleReceptionAir> list = null;
    	
    	int offset = (pageNumber - 1) * pageSize; // 起始下标
    	offset = offset > 0 ? offset : 0;
		offset = offset < totalCount ? offset : totalCount;
		
    	if(totalCount > 0){
    		list =  this.receptionAirDAO.getBySchool(tAirshuttleReceptionAir, offset, pageSize);
    	}
    	
    	return new Page<TAirshuttleReceptionAir>(list, totalCount, pageSize, pageNumber);
	}
}
