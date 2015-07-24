package com.topshare.airshuttle.service.userManager;

import java.util.List;

import javax.sql.DataSource;

import net.paoding.rose.jade.context.application.JadeFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.topshare.airshuttle.common.util.Page;
import com.topshare.airshuttle.dao.userManager.RoleDAO;
import com.topshare.airshuttle.dao.userManager.RoleRescDAO;
import com.topshare.airshuttle.dao.userManager.UserRoleDAO;
import com.topshare.airshuttle.model.userManager.TAirshuttleRole;
import com.topshare.airshuttle.service.BaseTransService;

@Service
public class RoleService  extends BaseTransService{

	@Autowired
	private RoleDAO roleDAO;
	
	public Page<TAirshuttleRole> getPageByParam(TAirshuttleRole role,Integer pageNumber, Integer pageSize){
		
		Integer totalCount = roleDAO.getCountByParam(role);
		
		List<TAirshuttleRole> list = null;
    	
    	int offset = (pageNumber - 1) * pageSize; // 起始下标
    	offset = offset > 0 ? offset : 0;
		offset = offset < totalCount ? offset : totalCount;
		
    	if(totalCount > 0){
    		
    		list =  this.roleDAO.getByParam(role,offset, pageSize);
    	}
    	
    	return new Page<TAirshuttleRole>(list, totalCount, pageSize, pageNumber);
	}
	
	/***
	 * 删除角色方法<br>
	 * 需要删除角色，角色用户关联，角色资源关联
	 * 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void deleteRole(final List<Integer> roleIds){
		
		final DataSource dataSource = this.getDataSource();
		DataSourceTransactionManager dstm = new DataSourceTransactionManager();
		dstm.setDataSource(dataSource);
		TransactionTemplate tt = new TransactionTemplate(dstm);
		tt.execute(new TransactionCallback() {
			public Object doInTransaction(TransactionStatus status) {
				
				JadeFactory factory = new JadeFactory(dataSource);
				RoleDAO roleDAO = factory.create(RoleDAO.class);
				RoleRescDAO roleRescDAO = factory.create(RoleRescDAO.class);
				UserRoleDAO userRoleDAO = factory.create(UserRoleDAO.class);
				
				roleDAO.deleteByIds(roleIds);
				roleRescDAO.deleteByRoleIds(roleIds);
				userRoleDAO.deleteByRoleIds(roleIds);
				
				return null;
			}
		});
	}
}
