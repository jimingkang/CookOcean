package com.topshare.airshuttle.service.userManager;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import net.paoding.rose.jade.context.application.JadeFactory;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.topshare.airshuttle.dao.userManager.UserRoleDAO;
import com.topshare.airshuttle.model.userManager.TAirshuttleUserRole;
import com.topshare.airshuttle.service.BaseTransService;

@Service
public class UserRoleService extends BaseTransService{

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void insertUserRole(final List<TAirshuttleUserRole> userRoleList,final Integer userId){
		
		final DataSource dataSource = this.getDataSource();
		DataSourceTransactionManager dstm = new DataSourceTransactionManager();
		dstm.setDataSource(dataSource);
		TransactionTemplate tt = new TransactionTemplate(dstm);
		tt.execute(new TransactionCallback() {
			public Object doInTransaction(TransactionStatus status) {
				
				List<Integer> userIds = new ArrayList<Integer>();
				userIds.add(userId);
				
				JadeFactory factory = new JadeFactory(dataSource);
				UserRoleDAO userRoleDAO = factory.create(UserRoleDAO.class);
				
				userRoleDAO.deleteByUserIds(userIds);
				userRoleDAO.batchInsertUserRole(userRoleList);
				
				return null;
			}
		});
		
	}
}
