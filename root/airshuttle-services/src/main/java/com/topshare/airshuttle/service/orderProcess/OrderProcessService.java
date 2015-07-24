package com.topshare.airshuttle.service.orderProcess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topshare.airshuttle.dao.orderProcess.OrderProcessDAO;
@Service
public class OrderProcessService {
	@Autowired
	OrderProcessDAO orderProcessDAO;
}
