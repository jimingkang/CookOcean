package com.topshare.airshuttle.dao.userManager;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import com.topshare.airshuttle.model.userManager.TAirshuttleResc;

@DAO
public interface RescDAO {

	@SQL("select count(ID) from t_airshuttle_resc where #if(:u.name != null){ name = :u.name } #if(:u.id != null){and id != :u.id }")
	public Integer vertifyExistsRescName(@SQLParam("u") TAirshuttleResc resc);
	
	
	@SQL("select ID, DESCRIPTION, NAME, PARENT_ID, NODE_ORDER, CREATE_PERSON, CREATE_TIME, MODIFY_PERSON,"
			+ " MODIFY_TIME, URI,URICUSTOMER,BELONG  from T_AIRSHUTTLE_RESC "
			+ " where belong = :belong #if(:parentId != null){and PARENT_ID = :parentId }"
			+ "  ORDER BY NODE_ORDER")
	public List<TAirshuttleResc> selectchildLevelRes(@SQLParam("parentId") String parentId,@SQLParam("belong") Integer belong);
	
	@SQL("select ID, DESCRIPTION, NAME, PARENT_ID, NODE_ORDER, CREATE_PERSON, CREATE_TIME, MODIFY_PERSON,"
			+ " MODIFY_TIME, URI,URICUSTOMER,BELONG  from T_AIRSHUTTLE_RESC "
			+ " where belong = :belong #if(:parentId != null){and PARENT_ID = :parentId }#else{ and PARENT_ID is null} "
			+ "  ORDER BY NODE_ORDER")
	public List<TAirshuttleResc> selectResByParentId(@SQLParam("parentId") String parentId,@SQLParam("belong") Integer belong);
	
	@SQL("select resc.ID, resc.DESCRIPTION, resc.NAME, resc.PARENT_ID,"
			+ " resc.NODE_ORDER, resc.CREATE_PERSON, resc.CREATE_TIME, resc.MODIFY_PERSON,"
			+ " resc.MODIFY_TIME, resc.URI,resc.URICUSTOMER,resc.BELONG "
			+ " from T_AIRSHUTTLE_RESC resc where resc.PARENT_ID = :parentId  and resc.belong = :belong "
			+ " and resc.id in(select rrole.resc_id from t_airshuttle_role_resc rrole"
			+ " where  rrole.role_id in(select urole.role_id from t_airshuttle_user_role urole "
			+ " where urole.user_id = :userId)) ORDER BY resc.NODE_ORDER")
	public List<TAirshuttleResc> selectchildLevelResByUserId(@SQLParam("parentId") String parentId,
			@SQLParam("userId") Integer userId,@SQLParam("belong") Integer belong);
	
	@SQL("INSERT INTO T_AIRSHUTTLE_RESC(ID,DESCRIPTION, NAME, PARENT_ID, NODE_ORDER, CREATE_PERSON, CREATE_TIME, MODIFY_PERSON,"
			+ "URI,URICUSTOMER,BELONG) "
			+ " VALUES (:u.id,:u.description,:u.name,:u.parentId,:u.nodeOrder,:u.createPerson,NOW(),:u.createPerson,"
			+ " :u.uri,:u.uriCustomer,:u.belong)")
	public void insert(@SQLParam("u") TAirshuttleResc resc);
	
	@SQL("update T_AIRSHUTTLE_RESC set MODIFY_PERSON = :c.modifyPerson "
			+ " #if(:c.description != null){,DESCRIPTION=:c.description}"
			+ " #if(:c.name != null){,NAME=:c.name}"
			+ " #if(:c.parentId != null){,PARENT_ID=:c.parentId}"
			+ " #if(:c.nodeOrder != null){,NODE_ORDER=:c.nodeOrder}"
			+ " #if(:c.uri != null){,URI=:c.uri}"
			+ " #if(:c.uriCustomer != null){,URICUSTOMER=:c.uriCustomer}"
			+ " where id = :c.id ")
	public void updateByParam(@SQLParam("c") TAirshuttleResc resc);
	
	
	@SQL("delete from T_AIRSHUTTLE_RESC where id in (:ids)")
	public void deleteByIds(@SQLParam("ids") List<String> ids);
}
