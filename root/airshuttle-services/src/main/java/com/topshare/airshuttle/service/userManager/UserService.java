package com.topshare.airshuttle.service.userManager;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import net.paoding.rose.jade.context.application.JadeFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.topshare.airshuttle.common.util.Constants;
import com.topshare.airshuttle.common.util.Page;
import com.topshare.airshuttle.dao.userManager.UserDAO;
import com.topshare.airshuttle.dao.userManager.UserRoleDAO;
import com.topshare.airshuttle.model.userManager.TAirshuttleUser;
import com.topshare.airshuttle.model.userManager.TAirshuttleUserRole;
import com.topshare.airshuttle.service.BaseTransService;

@Service
public class UserService extends BaseTransService{

	@Autowired
	private UserDAO userDAO;
	
	public Page<TAirshuttleUser> getPageByParam(TAirshuttleUser user, int pageNumber, int pageSize){
		
		Integer totalCount = userDAO.getCountByParam(user);
		
		List<TAirshuttleUser> list = null;
    	
    	int offset = (pageNumber - 1) * pageSize; // 起始下标
    	offset = offset > 0 ? offset : 0;
		offset = offset < totalCount ? offset : totalCount;
		
    	if(totalCount > 0){
    		
    		list =  this.userDAO.getByParam(user, offset, pageSize);
    	}
    	
    	return new Page<TAirshuttleUser>(list, totalCount, pageSize, pageNumber);
	}
	
	/***
	 * 删除角色方法<br>
	 * 需要删除角色，角色用户关联，角色资源关联
	 * 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void deleteByIds(final List<Integer> userIds){
		
		final DataSource dataSource = this.getDataSource();
		DataSourceTransactionManager dstm = new DataSourceTransactionManager();
		dstm.setDataSource(dataSource);
		TransactionTemplate tt = new TransactionTemplate(dstm);
		tt.execute(new TransactionCallback() {
			public Object doInTransaction(TransactionStatus status) {
				
				JadeFactory factory = new JadeFactory(dataSource);
				UserDAO userDAO = factory.create(UserDAO.class);
				UserRoleDAO userRoleDAO = factory.create(UserRoleDAO.class);
				
				userDAO.deleteByIds(userIds);
				userRoleDAO.deleteByUserIds(userIds);
				
				return null;
			}
		});
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void registerUser(final TAirshuttleUser user){
		
		final DataSource dataSource = this.getDataSource();
		DataSourceTransactionManager dstm = new DataSourceTransactionManager();
		dstm.setDataSource(dataSource);
		TransactionTemplate tt = new TransactionTemplate(dstm);
		tt.execute(new TransactionCallback() {
			public Object doInTransaction(TransactionStatus status) {
				
				JadeFactory factory = new JadeFactory(dataSource);
				UserDAO userDAO = factory.create(UserDAO.class);
				UserRoleDAO userRoleDAO = factory.create(UserRoleDAO.class);
				
				//插入用户
				Integer userId = userDAO.insert(user);
				
				List<TAirshuttleUserRole> userRoleList = new ArrayList<TAirshuttleUserRole>();
				TAirshuttleUserRole userRole = new TAirshuttleUserRole();
				userRole.setUserId(userId);
				userRole.setRoleId(Constants.USER_ROLE_ID);
				
				userRoleList.add(userRole);
				
				//插入用户角色
				userRoleDAO.batchInsertUserRole(userRoleList);
				
				return null;
			}
		});
	}
}
