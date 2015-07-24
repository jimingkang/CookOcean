package com.topshare.airshuttle.service.userManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import net.paoding.rose.jade.context.application.JadeFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.topshare.airshuttle.dao.userManager.RoleRescDAO;
import com.topshare.airshuttle.model.userManager.TAirshuttleRoleResc;
import com.topshare.airshuttle.service.BaseTransService;


@Service
public class RoleRescService extends BaseTransService{

	@Autowired
	private RoleRescDAO roleRescDAO;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void insertRoleResc(final Integer roleId,final List<String> rescIds){
		
		final DataSource dataSource = this.getDataSource();
		DataSourceTransactionManager dstm = new DataSourceTransactionManager();
		dstm.setDataSource(dataSource);
		TransactionTemplate tt = new TransactionTemplate(dstm);
		tt.execute(new TransactionCallback() {
			public Object doInTransaction(TransactionStatus status) {
				
				JadeFactory factory = new JadeFactory(dataSource);
				RoleRescDAO roleRescDAO = factory.create(RoleRescDAO.class);
				
				if(rescIds != null){

					List<Integer> roleIdList = new ArrayList<Integer>();
					roleIdList.add(Integer.valueOf(roleId));

					roleRescDAO.deleteByRoleIds(roleIdList);
					List<TAirshuttleRoleResc> roleRescList = new ArrayList<TAirshuttleRoleResc>();
					
					Set<String> rescIdSet = new HashSet<String>(rescIds);    
					
					for(String rescId : rescIdSet){
						
						TAirshuttleRoleResc roleResc = new TAirshuttleRoleResc();
						roleResc.setRoleId(roleId);
						roleResc.setRescId(rescId);
						roleRescList.add(roleResc);
					}
					
					roleRescDAO.batchInsertRoleResc(roleRescList);
				}
				
				return null;
			}
		});
		
	}
	
}
