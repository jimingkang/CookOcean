package com.topshare.airshuttle.service;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;



/***
 * 事物支持service
 * 
 * @author root
 *
 */
public class BaseTransService {
	public static Map<String, DataSource> instances = new HashMap<String, DataSource>();
	private final String DATASOURCE_KEY = "jade.dataSource.com.topshare.airshuttle.datasource";

	public DataSource getDataSource() {
		DataSource instance = instances.get(DATASOURCE_KEY);
		if (instance == null) {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("import com.topshare.airshuttle.model.userManager.User;");
			dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/jade?useUnicode=true&amp;characterEncoding=utf-8");
			dataSource.setUsername("root");
			dataSource.setPassword("123456");
			instance = dataSource;
			instances.put(DATASOURCE_KEY, instance);
		}
		return instance;
	}
	
}
