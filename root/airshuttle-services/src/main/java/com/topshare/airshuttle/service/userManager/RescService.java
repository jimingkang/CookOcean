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

import com.topshare.airshuttle.dao.userManager.RescDAO;
import com.topshare.airshuttle.dao.userManager.RoleRescDAO;
import com.topshare.airshuttle.service.BaseTransService;

@Service
public class RescService  extends BaseTransService{

	@Autowired
	private RescDAO rescDAO;
	
	@Autowired
	private RoleRescDAO roleRescDAO;
	/***
	 * 删除资源方法<br>
	 * 需要删除资源，资源角色关联
	 * 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void deleteResc(final List<String> rescIds){
		
		final DataSource dataSource = this.getDataSource();
		DataSourceTransactionManager dstm = new DataSourceTransactionManager();
		dstm.setDataSource(dataSource);
		TransactionTemplate tt = new TransactionTemplate(dstm);
		tt.execute(new TransactionCallback() {
			public Object doInTransaction(TransactionStatus status) {
				
				JadeFactory factory = new JadeFactory(dataSource);
				RoleRescDAO roleRescDAO = factory.create(RoleRescDAO.class);
				RescDAO rescDAO = factory.create(RescDAO.class);
				
				rescDAO.deleteByIds(rescIds);
				roleRescDAO.deleteByRescIds(rescIds);
				
				return null;
			}
		});
	}
}
