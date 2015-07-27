package com.topshare.airshuttle.controllers;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import org.springframework.beans.factory.annotation.Autowired;

import com.topshare.airshuttle.common.util.Page;
import com.topshare.airshuttle.common.util.ResponseObject;
import com.topshare.airshuttle.model.flyGroup.TAirshuttleFlyGroup;
import com.topshare.airshuttle.model.userManager.TAirshuttleUser;
import com.topshare.airshuttle.service.flyGroup.FlyGroupService;


@Path("/flygroup")
public class FlyGroupController extends BaseController {

	@Autowired
	private FlyGroupService flyGroupService;
	
	@Get("/findFlyGroup")
	public String findFlyGroupByAdmissionSchool(Invocation inv,TAirshuttleFlyGroup tAirshuttleFlyGroup,@Param("pageSize") final Integer pageSize,@Param("pageNumber") final Integer pageNumber
			){
		//int pageNumber=Integer.parseInt(inv.getRequest().getParameter("pageNumber"));
		//int pageSize=Integer.parseInt(inv.getRequest().getParameter("pageSize"));
		flyGroupService.getByParamAdmissionSchool(tAirshuttleFlyGroup, pageNumber,  pageSize);
		ResponseObject ro = new ResponseObject();
		TAirshuttleUser user = new TAirshuttleUser();
		
		try {


			
			Page<TAirshuttleFlyGroup> page = flyGroupService.getByParamAdmissionSchool(tAirshuttleFlyGroup, pageNumber, pageSize);

		//	HashMap<String,Object> hashmap = new HashMap<String,Object>();
				
		//	hashmap.put("total", page.getTotalCount());								//总行数
		//	hashmap.put("rows", page.getItems() == null ? "" : page.getItems());
		//	return "@"+this.returnObjectToJson(hashmap);
			
			inv.getRequest().setAttribute("rows", page.getItems() == null ? "" : page.getItems());
			inv.getRequest().setAttribute("total", page.getTotalCount());	
			inv.getRequest().getRequestDispatcher("/views/flygroup/grouping-info.jsp").forward(inv.getRequest(),inv.getResponse());
			return "";
			
		} catch (Exception e) {
			e.printStackTrace();
			ro.setSuccess(false);
			ro.setErrorMessage("系统出现异常，请稍候再试");
			return "@"+this.returnObjectToJson(ro);
		}
		
		
	}
	
	@Post("/insertFlyGroup")
	public String insertFlyGroup(Invocation inv,@Param("groupName") String groupName,
			@Param("admissionSchool") String admissionSchool,
			@Param("departAirport") String departAirport,
			@Param("arriveAirport") String arriveAirport,
			@Param("departTime") String departTime,
			@Param("arriveTime") String arriveTime,
			@Param("expirationDate") String expirationDate,
			@Param("createPerson") Integer createPerson,
			@Param("destination") String destination,
			@Param("contactInformation") String contactInformation,
			@Param("flight") String flight
			) {
		
		ResponseObject ro = new ResponseObject();
		TAirshuttleFlyGroup FlyGroup = new TAirshuttleFlyGroup();
		try {
			
			HttpSession session = inv.getRequest().getSession();
			
			
			
			if(groupName == null || groupName.equals("") || admissionSchool == null){
				
				ro.setSuccess(false);
				ro.setErrorMessage("团名，学校名不能为空");
				return "@"+this.returnObjectToJson(ro);
			}

			

		
			
			SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
			//sp.parse(expirationDate);
			Date curDate = new Date();
			FlyGroup.setDesignationNumber(Long.toString(System.currentTimeMillis()));
			FlyGroup.setGroupName(groupName);
			FlyGroup.setAdmissionSchool(admissionSchool);;
			FlyGroup.setCreatePerson(createPerson);
			FlyGroup.setExpirationDate(sp.parse(expirationDate));
			 sp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			FlyGroup.setDepartTime(sp.parse(departTime));
			FlyGroup.setArriveTime(sp.parse(arriveTime));
			
			FlyGroup.setDepartAirport(departAirport);
			FlyGroup.setArriveAirport(arriveAirport);
			FlyGroup.setContactInformation(contactInformation);
			
			Integer FlyGroupId = flyGroupService.insert(FlyGroup);
			FlyGroup.setId(FlyGroupId);
			inv.getRequest().getRequestDispatcher("/views/index.jsp").forward(inv.getRequest(),inv.getResponse());
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			ro.setSuccess(false);
			ro.setErrorMessage("系统出现异常，请稍候再试");
			return "@"+this.returnObjectToJson(ro);
		}
		
		
	}

}
