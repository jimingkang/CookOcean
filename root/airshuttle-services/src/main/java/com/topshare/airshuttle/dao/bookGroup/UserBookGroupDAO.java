package com.topshare.airshuttle.dao.bookGroup;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import com.topshare.airshuttle.model.bookGroup.TAirshuttleUserBookGroup;

@DAO
public interface UserBookGroupDAO {

	/***
	 * 申请报名
	 * @param t
	 * @return
	 */
	@ReturnGeneratedKeys
	@SQL("insert into t_airshuttle_user_book_group (book_time,type, user_id, ref_id)"
		+ "values (now(),:c.type,:c.userId,:c.refId)")
	public Integer insert(@SQLParam("c") TAirshuttleUserBookGroup t);
	
	/***
	 * 走审核流程
	 * @param t
	 */
	@SQL("update t_airshuttle_user_book_group set MODIFY_TIME = :c.modifyTime"
			+ " #if(:c.status != null){,status=:c.status} "
			+ " #if(:c.statusMsg != null){,status_msg=:c.statusMsg} "
			+ "  where id = :c.id")
	public void updateByParam(@SQLParam("c") TAirshuttleUserBookGroup t);
	
	
	@SQL("delete from t_airshuttle_user_book_group where id = :id")
	public void deleteById(@SQLParam("id") Integer id);
}
