package com.topshare.airshuttle.dao.userManager;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import com.topshare.airshuttle.model.userManager.TAirshuttleUser;


@DAO
public interface UserDAO {

	@SQL("select ID, USERNAME, PASSWORD,SEX, ENABLED, CREATE_PERSON,"
			+ "CREATE_TIME, MODIFY_PERSON, MODIFY_TIME,DESCRIPTION, EMAIL, photot_url,"
			+ "desc_myself, lable, telephone,customer_picUrl "
			+ "from t_airshuttle_user where username = :u.username and password = :u.password limit 1")
	public TAirshuttleUser getUserByLogin(@SQLParam("u") TAirshuttleUser user);
	
	@SQL("select ID, USERNAME, PASSWORD,SEX, ENABLED, CREATE_PERSON,"
			+ "CREATE_TIME, MODIFY_PERSON, MODIFY_TIME,DESCRIPTION, EMAIL, photot_url,"
			+ "desc_myself, lable, telephone,customer_picUrl "
			+ "from t_airshuttle_user where id = :id limit 1")
	public TAirshuttleUser getUserById(@SQLParam("id") Integer id);
	
	
	@ReturnGeneratedKeys
	@SQL("INSERT INTO t_airshuttle_user(USERNAME, PASSWORD,SEX, ENABLED, CREATE_PERSON,"
			+ "CREATE_TIME, MODIFY_PERSON,DESCRIPTION, EMAIL, photot_url,"
			+ "desc_myself, lable, telephone,customer_picUrl) "
			+ "VALUES (:u.username,:u.password,:u.sex,:u.enabled,:u.createPerson,NOW(),:u.modifyPerson,"
			+ ":u.description,:u.email,:u.phototUrl,:u.descMyself,:u.lable,:u.telephone,:u.customerPicurl)")
	public Integer insert(@SQLParam("u") TAirshuttleUser user);
	
	
	
	@SQL("update T_AIRSHUTTLE_USER set MODIFY_PERSON = :c.modifyPerson "
			+ " #if(:c.username != null){,username=:c.username}"
			+ " #if(:c.password != null){,password=:c.password}"
			+ " #if(:c.sex != null){,sex=:c.sex}"
			+ " #if(:c.enabled != null){,enabled=:c.enabled}"
			+ " #if(:c.description != null){,description=:c.description}"
			+ " #if(:c.email != null){,email=:c.email}"
			+ " #if(:c.phototUrl != null){,photot_url=:c.phototUrl}"
			+ " #if(:c.descMyself != null){,desc_myself=:c.descMyself}"
			+ " #if(:c.lable != null){,lable=:c.lable}"
			+ " #if(:c.telephone != null){,telephone=:c.telephone}"
			+ " #if(:c.customerPicurl != null){,customer_picUrl=:c.customerPicurl}"
			+ " where   id = :c.id ")
	public void updateByParam(@SQLParam("c") TAirshuttleUser user);
	
	/***
	 * 校验用户名是否存在
	 * @param user
	 * @return
	 */
	@SQL("select count(ID) from T_AIRSHUTTLE_USER where  USERNAME = :u.username #if(:u.id != null){and id !=:u.id}")
	public Integer vertifyExistsUserName(@SQLParam("u") TAirshuttleUser user); 
	
	
	@SQL("select count(ID) from T_AIRSHUTTLE_USER #if(:u.username != null){where username like :u.username }")
	public Integer getCountByParam(@SQLParam("u") TAirshuttleUser user);
	
	
	@SQL("select ID, USERNAME, PASSWORD,SEX, ENABLED, CREATE_PERSON,"
			+ "CREATE_TIME, MODIFY_PERSON, MODIFY_TIME,DESCRIPTION, EMAIL, photot_url,"
			+ "desc_myself, lable, telephone,customer_picUrl "
			+ "from t_airshuttle_user #if(:u.username != null){where username like :u.username }"
			+ " limit :pageNumber,:pageSize")
	public List<TAirshuttleUser> getByParam(@SQLParam("u") TAirshuttleUser user,@SQLParam("pageNumber") int pageNumber,
			@SQLParam("pageSize")  int pageSize);

	@SQL("delete from T_AIRSHUTTLE_USER where id in (:ids)")
	public void deleteByIds(@SQLParam("ids") List<Integer> ids);
	
}
