package com.chen.dao.test;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import com.chen.model.Test;

@DAO
public interface TestDAO {

	@SQL("select id,msg from test limit 1")
	public Test getTest();

	@ReturnGeneratedKeys
	@SQL("insert into test (id,msg) values (:t.id,:t.msg)")
	public int insertTest(@SQLParam("t") Test test);
	
	
	@SQL("select count(*) from test #if(:t.msg != null){ where msg =:t.msg }")
	public Integer getCountByParam(@SQLParam("t") Test test);
	
	@SQL("select id,msg from test #if(:t.msg != null){ where msg =:t.msg } limit :pageNumber,:pageSize")
	public List<Test> getByParam(@SQLParam("t") Test test,@SQLParam("pageNumber") int pageNumber,@SQLParam("pageSize")  int pageSize);
}
