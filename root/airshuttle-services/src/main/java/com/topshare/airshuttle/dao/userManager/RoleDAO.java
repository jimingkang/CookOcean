package com.topshare.airshuttle.dao.userManager;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import com.topshare.airshuttle.model.userManager.TAirshuttleRole;

@DAO
public interface RoleDAO {
	
	
	@ReturnGeneratedKeys
	@SQL("insert into t_airshuttle_role (DESCRIPTION, NAME,CREATE_PERSON, CREATE_TIME, MODIFY_PERSON)"
		+ "values(:u.description,:u.name,:u.createPerson,now(),:u.createPerson)")
	public Integer insert(@SQLParam("u") TAirshuttleRole role);
	
	@SQL("select count(ID) from t_airshuttle_role #if(:u != null && :u.name != null){where name like :u.name }")
	public Integer getCountByParam(@SQLParam("u") TAirshuttleRole role);
	
	
	@SQL("select ID, DESCRIPTION, NAME, CREATE_PERSON, CREATE_TIME, MODIFY_PERSON, MODIFY_TIME "
			+ " from t_airshuttle_role #if(:u != null && :u.name != null){where name like :u.name } "
			+ " #if(:pageNumber != null){limit :pageNumber,:pageSize }")
	public List<TAirshuttleRole> getByParam(@SQLParam("u") TAirshuttleRole role,@SQLParam("pageNumber") Integer pageNumber, @SQLParam("pageSize")  Integer pageSize);
	
	@SQL("select count(ID) from t_airshuttle_role where #if(:u.name != null){ name = :u.name } #if(:u.id != null){and id != :u.id }")
	public Integer vertifyExistsRoleName(@SQLParam("u") TAirshuttleRole role);
	
	@SQL("select ID, DESCRIPTION, NAME, CREATE_PERSON, CREATE_TIME, MODIFY_PERSON, MODIFY_TIME "
			+ " from t_airshuttle_role where id = :id ")
	public TAirshuttleRole getRoleById(@SQLParam("id") Integer id);
	
	@SQL("update t_airshuttle_role set MODIFY_PERSON = :u.modifyPerson "
			+ " #if(:u.name != null){,name=:u.name}"
			+ " #if(:u.description != null){,description=:u.description}"
			+ " where id = :u.id ")
	public void updateByParam(@SQLParam("u") TAirshuttleRole role);
	
	@SQL("delete from t_airshuttle_role where id in (:roleIds)")
	public void deleteByIds(@SQLParam("roleIds") List<Integer> roleIds);
}
