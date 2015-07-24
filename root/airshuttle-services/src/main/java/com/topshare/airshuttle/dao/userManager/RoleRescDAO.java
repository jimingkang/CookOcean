package com.topshare.airshuttle.dao.userManager;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import com.topshare.airshuttle.model.userManager.TAirshuttleRoleResc;

/***
 * 角色资源
 * @author root
 *
 */
@DAO
public interface RoleRescDAO {

	@SQL("insert into t_airshuttle_role_resc ( RESC_ID, ROLE_ID)"
			+ "values (:u.rescId,:u.roleId)")
	public void batchInsertRoleResc(@SQLParam("u") List<TAirshuttleRoleResc> roleResc);
	
	@SQL("delete from t_airshuttle_role_resc where role_id in (:ids)")
	public void deleteByRoleIds(@SQLParam("ids") List<Integer> roleIds);
	
	@SQL("delete from t_airshuttle_role_resc where resc_id in (:ids)")
	public void deleteByRescIds(@SQLParam("ids") List<String> rescIds);
	
	@SQL("select resc_id from t_airshuttle_role_resc where role_id = :roleId")
	public List<String> getRescByRoleId(@SQLParam("roleId") Integer roleId);
	
	
}
