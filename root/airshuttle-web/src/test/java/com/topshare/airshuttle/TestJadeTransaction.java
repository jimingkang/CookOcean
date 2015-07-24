package com.topshare.airshuttle;

import javax.sql.DataSource;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.context.application.JadeFactory;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class TestJadeTransaction {
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 创建一个新的、唯一的DataSource实例
	 * 
	 * @return
	 */
	public static DataSource createUniqueDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource
				.setUrl("jdbc:mysql://127.0.0.1:3306/airshuttle?useUnicode=true&amp;characterEncoding=utf-8");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");

		return dataSource;
	}

	/***
	 * 测试事物回滚
	 */
	@Test
	public void testTrans() {

		final DataSource dataSource = createUniqueDataSource();
		DataSourceTransactionManager dstm = new DataSourceTransactionManager();
		dstm.setDataSource(dataSource);
		TransactionTemplate tt = new TransactionTemplate(dstm);
		tt.execute(new TransactionCallback() {
			public Object doInTransaction(TransactionStatus status) {
				// JdbcTemplate jt = new JdbcTemplate(getDataSource());
				//jt.update("insert into userTrans (id, name) values(2, 'xxx');");
				// jt.update("insert into userTrans (id, name) values(3, 'xxx');");
				
				JadeFactory factory = new JadeFactory(dataSource);
				UserDAO dao = factory.create(UserDAO.class);
				dao.insert(3, "zhiliang3");
				dao.insert(4, "zhiliang4");
				
				int r = 4 / 0;
				return null;
			}
		});
	}

	@DAO
	interface UserDAO {

		@SQL("create table userXXX (id int, name varchar(200));")
		void createTable();

		@SQL("insert into userXXX (id, name) values(:1, :2);")
		void insert(int id, String name);

		@SQL("select name from userXXX where id=:1")
		String getName(int id);

		@SQL("select name from userXXX order by id asc")
		String[] findNames();
	}
}
