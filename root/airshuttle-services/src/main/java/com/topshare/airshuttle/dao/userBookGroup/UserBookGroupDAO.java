package com.topshare.airshuttle.dao.userBookGroup;

import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import com.topshare.airshuttle.model.userBookGroup.TAirshuttleUserBookGroup;

/***
 * 飞友团，室友团报名
 * @author root
 *
 */
public interface UserBookGroupDAO {

	
	@ReturnGeneratedKeys
	@SQL("insert into t_airshuttle_user_book_group (book_time,type, user_id, ref_id,status, status_msg)"
		+ "")
	public Integer insert(@SQLParam("c") TAirshuttleUserBookGroup userBookGroup);
}
