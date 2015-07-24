package com.topshare.airshuttle.service.bookGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topshare.airshuttle.dao.bookGroup.UserBookGroupDAO;

@Service
public class UserBookGroupService {

	@Autowired
	private UserBookGroupDAO userBookGroupDAO;
	
	
}
