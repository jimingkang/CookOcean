package com.topshare.airshuttle.controllers.myCollection;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.topshare.airshuttle.common.util.Page;
import com.topshare.airshuttle.common.util.ResponseObject;
import com.topshare.airshuttle.controllers.BaseController;
import com.topshare.airshuttle.dao.myCollection.MyCollectionDAO;
import com.topshare.airshuttle.model.myCollection.TAirshuttleMyCollection;
import com.topshare.airshuttle.service.myCollection.MyCollectionService;

/***
 * 我的收藏
 * @author root
 *
 */
@Path("/myCollection")
public class MyCollectionController extends BaseController {

	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private MyCollectionService myCollectionService;
	
	@Autowired
	private MyCollectionDAO myCollectionDAO;
	
	/***
	 * 通过类型查询收藏
	 * @param inv
	 * @return
	 */
	public String listByType(Invocation inv,TAirshuttleMyCollection myCollection,
			@Param("pageSize") final Integer pageSize,@Param("pageNumber") final Integer pageNumber) throws Exception{
		
		Integer curUserId = this.getCurUserId(inv);
		myCollection.setUserId(curUserId);
		
		Page<TAirshuttleMyCollection>  myCollectionPage = myCollectionService.getPageByParam(myCollection , pageNumber, pageSize);
		
		return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject(myCollectionPage));
	}
	
	/***
	 * 新增我的收藏
	 * @return
	 */
	public String addMyCollection(Invocation inv,TAirshuttleMyCollection myCollection) throws Exception{
		
		Integer curUserId = this.getCurUserId(inv);
		myCollection.setUserId(curUserId);
		
		myCollectionDAO.insert(myCollection);
		
		return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject("添加成功"));
	}
	
	/***
	 * 删除我的收藏
	 * @return
	 */
	public String deleteByParam(Invocation inv,TAirshuttleMyCollection myCollection) throws Exception{
		
		Integer curUserId = this.getCurUserId(inv);
		myCollection.setUserId(curUserId);
		myCollectionDAO.deleteByParam(myCollection);
		
		return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject("添加成功"));
	}
}
