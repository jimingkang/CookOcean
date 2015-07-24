package com.chen.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.dao.test.TestDAO;
import com.chen.model.Test;
import com.topshare.airshuttle.common.util.Page;

@Service
public class TestService{

    @Autowired
    private TestDAO testDAO;

    public Test getTest() {
        return testDAO.getTest();
    }
    
    
    public Page<Test> getPageByParam(Test searchTest, int pageNumber, int pageSize){
    	
    	Integer totalCount = testDAO.getCountByParam(searchTest);
    	
    	List<Test> list = null;
    	
    	int offset = (pageNumber - 1) * pageSize; // 起始下标
    	offset = offset > 0 ? offset : 0;
		offset = offset < totalCount ? offset : totalCount;
		
    	if(totalCount > 0){
    		list =  testDAO.getByParam(searchTest, offset, pageSize);
    	}
    	
    	return new Page<Test>(list, totalCount, pageSize, pageNumber);
    }
    
    public int insertTest(Test test){
    	
    	return testDAO.insertTest(test);
    }
}