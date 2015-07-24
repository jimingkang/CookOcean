package com.topshare.airshuttle.service.flyGroup;

import java.util.List;


import javax.sql.DataSource;

import net.paoding.rose.jade.context.application.JadeFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.topshare.airshuttle.biz.UserRoleEnum;
import com.topshare.airshuttle.common.util.Page;
import com.topshare.airshuttle.dao.flyGroup.FlyGroupDAO;
import com.topshare.airshuttle.dao.myCollection.MyCollectionDAO;
import com.topshare.airshuttle.model.flyGroup.TAirshuttleFlyGroup;
import com.topshare.airshuttle.model.myCollection.TAirshuttleMyCollection;
import com.topshare.airshuttle.service.BaseTransService;
@Service
public class FlyGroupService extends BaseTransService{

	@Autowired
	private FlyGroupDAO flyGroupDAO;
	
	public Integer insert(TAirshuttleFlyGroup tAirshuttleFlyGroup){
		
		return flyGroupDAO.insert(tAirshuttleFlyGroup);
	}
	
	public void updateByParam(TAirshuttleFlyGroup flyGroup){
		
		flyGroupDAO.updateByParam(flyGroup);
	}
	
	/***
	 * 分页查询
	 */
public Page<TAirshuttleFlyGroup> getByParamAdmissionSchool(TAirshuttleFlyGroup flyGroup, int pageNumber, int pageSize){
		
		Integer totalCount = flyGroupDAO.getCountByParam(flyGroup);
		
		List<TAirshuttleFlyGroup> list = null;
    	
    	int offset = (pageNumber - 1) * pageSize; // 起始下标
    	offset = offset > 0 ? offset : 0;
		offset = offset < totalCount ? offset : totalCount;
		
    	if(totalCount > 0){
    		list =  this.flyGroupDAO.getByParamAdmissionSchool(flyGroup, offset, pageSize);
    	}
    	
    	return new Page<TAirshuttleFlyGroup>(list, totalCount, pageSize, pageNumber);
	} 

	public Page<TAirshuttleFlyGroup> getPageByParam(TAirshuttleFlyGroup flyGroup, int pageNumber, int pageSize){
		
		Integer totalCount = flyGroupDAO.getCountByParam(flyGroup);
		
		List<TAirshuttleFlyGroup> list = null;
    	
    	int offset = (pageNumber - 1) * pageSize; // 起始下标
    	offset = offset > 0 ? offset : 0;
		offset = offset < totalCount ? offset : totalCount;
		
    	if(totalCount > 0){
    		list =  this.flyGroupDAO.getByParam(flyGroup, offset, pageSize);
    	}
    	
    	return new Page<TAirshuttleFlyGroup>(list, totalCount, pageSize, pageNumber);
	}
	
	/***
	 * 删除飞友团，同时删除我的收藏
	 * @param id
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void deleteFlyGroup(final Integer id){
		
		final DataSource dataSource = this.getDataSource();
		DataSourceTransactionManager dstm = new DataSourceTransactionManager();
		dstm.setDataSource(dataSource);
		TransactionTemplate tt = new TransactionTemplate(dstm);
		tt.execute(new TransactionCallback() {
			public Object doInTransaction(TransactionStatus status) {
				
				JadeFactory factory = new JadeFactory(dataSource);
				FlyGroupDAO flyGroupDAO = factory.create(FlyGroupDAO.class);
				MyCollectionDAO myCollectionDAO = factory.create(MyCollectionDAO.class);
				
				flyGroupDAO.deleteById(id);
				
				TAirshuttleMyCollection t = new TAirshuttleMyCollection();
				t.setRefId(id);
				t.setType(UserRoleEnum.FLY_GROUP.getValue());
				myCollectionDAO.deleteByParam(t);
				
				return null;
			}
		});
		
	}
	
}
