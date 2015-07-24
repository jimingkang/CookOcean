package com.topshare.airshuttle.service.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topshare.airshuttle.dao.car.CarDAO;

@Service
public class CarService {

	@Autowired
	private CarDAO carDAO;
	
	
}
