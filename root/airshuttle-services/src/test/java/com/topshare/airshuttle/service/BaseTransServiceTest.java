package com.topshare.airshuttle.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.topshare.airshuttle.common.util.Constants;

/***
 * 事物支持service
 * 
 * @author root
 *
 */
public class BaseTransServiceTest {

	public static Map<String, DataSource> instances = new HashMap<String, DataSource>();
	private final String DATASOURCE_KEY = "jade.dataSource.com.topshare.airshuttle.datasource";

	public DataSource getDataSource() {
		DataSource instance = instances.get(DATASOURCE_KEY);
		if (instance == null) {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName(Constants.DRIVER_CLASS_NAME);
			dataSource.setUrl(Constants.URL);
			dataSource.setUsername(Constants.USERNAME);
			dataSource.setPassword(Constants.PASSWORD);
			instance = dataSource;
			instances.put(DATASOURCE_KEY, instance);
		}
		return instance;
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testDataSource() throws Exception{
		
		DataSource dataSource = this.getDataSource();
		Connection actualCon = dataSource.getConnection();  
	}
}
