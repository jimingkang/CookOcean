package com.topshare.airshuttle.dao.myCollection;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import com.topshare.airshuttle.model.myCollection.TAirshuttleMyCollection;

@DAO
public interface MyCollectionDAO {
	
	@ReturnGeneratedKeys
	@SQL("insert into t_airshuttle_my_collection (ref_id, type, user_id, CREATE_TIME)"
			+ "values (:d.refId,:d.type,:d.userId,now())")
	public Integer insert(@SQLParam("d") TAirshuttleMyCollection tAirshuttleMyCollection);
	
	@SQL("delete from t_airshuttle_my_collection where id = :id")
	public void deleteById(@SQLParam("id") Integer id);
	
	@SQL("delete from t_airshuttle_my_collection where ref_id = :d.refId and type = :d.type")
	public void deleteByParam(@SQLParam("d") TAirshuttleMyCollection tAirshuttleMyCollection);
}
