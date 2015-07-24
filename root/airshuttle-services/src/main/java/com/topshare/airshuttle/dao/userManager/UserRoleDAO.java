package com.topshare.airshuttle.dao.userManager;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import com.topshare.airshuttle.model.userManager.TAirshuttleUserRole;

@DAO
public interface UserRoleDAO {

	@SQL("insert into t_airshuttle_user_role (USER_ID, ROLE_ID)"
			+ "values (:u.userId,:u.roleId)")
	public void batchInsertUserRole(@SQLParam("u") List<TAirshuttleUserRole> userRole);
	
	
	@SQL("select ROLE_ID from t_airshuttle_user_role #if(:u.userId != null){where USER_ID = :u.userId }")
	public List<Integer> getByParam(@SQLParam("u") TAirshuttleUserRole userRole);
	
	@SQL("delete from t_airshuttle_user_role where ROLE_ID in (:ids)")
	public void deleteByRoleIds(@SQLParam("ids") List<Integer> roleIds);
	
	@SQL("delete from t_airshuttle_user_role where USER_ID in (:ids)")
	public void deleteByUserIds(@SQLParam("ids") List<Integer> userIds);
}
