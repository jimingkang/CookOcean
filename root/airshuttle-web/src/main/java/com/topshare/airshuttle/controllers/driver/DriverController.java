package com.topshare.airshuttle.controllers.driver;

import java.util.Date;
import java.util.List;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.topshare.airshuttle.common.util.ResponseObject;
import com.topshare.airshuttle.controllers.BaseController;
import com.topshare.airshuttle.dao.car.CarDAO;
import com.topshare.airshuttle.dao.driver.DriverDAO;
import com.topshare.airshuttle.model.car.TAirshuttleCar;
import com.topshare.airshuttle.model.driver.TAirshuttleDriver;
import com.topshare.airshuttle.service.driver.DriverService;

/***
 * 司机管理模块
 * @author root
 *
 */
@Path("/driver")
public class DriverController extends BaseController {

	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private CarDAO carDAO;
	
	@Autowired
	private DriverDAO driverDAO;
	
	@Autowired
	private DriverService driverService;
	
	/***
	 * 普通用户获取司机信息
	 * 普通用户和司机是一对一的关系
	 * @return
	 */
	public String getDriverMsg(Invocation inv){
		
		ResponseObject ro = new ResponseObject();
		
		try {
			
			Integer curUserId = this.getCurUserId(inv);
			
			//查询司机信息
			List<TAirshuttleDriver> driverList = driverDAO.getByCreatePerson(curUserId);
			
			if(driverList != null){
				
				TAirshuttleDriver driver = driverList.get(0);
				
				//查询司机对应的车辆信息
				List<TAirshuttleCar>  carList = carDAO.getByDriverId(driver.getId());
				driver.setCarList(carList);
				
				return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject(driver));
			}else{
				
				return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject(null));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			ro.setSuccess(false);
			ro.setErrorMessage("系统出现异常，请稍候再试");
			return "@"+this.returnObjectToJson(ro);
		}
	}
	
	/***
	 * 修改司机信息
	 * @return
	 */
	public String modifyDriverMsg(Invocation inv,TAirshuttleDriver driver){
		
		ResponseObject ro = new ResponseObject();
		
		try {
			
			Integer curUserId = this.getCurUserId(inv);
			
			driver.setModifyPerson(curUserId);
			
			for(TAirshuttleCar car : driver.getCarList()){
				
				car.setModifyPerson(curUserId);
			}
			
			driverService.modifyDriverMsg(driver);
			
			//TODO,应该删除司机历史附件信息
			return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject(null));
		} catch (Exception e) {
			e.printStackTrace();
			ro.setSuccess(false);
			ro.setErrorMessage("系统出现异常，请稍候再试");
			return "@"+this.returnObjectToJson(ro);
		}
	}
	
	/***
	 * 新增司机信息
	 * @return
	 */
	public String insertDriverMsg(Invocation inv,TAirshuttleDriver driver){
		
		ResponseObject ro = new ResponseObject();
		
		try {
			
			Integer curUserId = this.getCurUserId(inv);
			
			driver.setCreatePerson(curUserId);
			driver.setModifyPerson(curUserId);
			driver.setCreateTime(new Date());
			
			for(TAirshuttleCar car : driver.getCarList()){
				
				car.setCreatePerson(curUserId);
				car.setModifyPerson(curUserId);
				car.setCreateTime(new Date());
			}
			
			driverService.insertDriverMsg(driver);
			
			return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject(null));
		} catch (Exception e) {
			e.printStackTrace();
			ro.setSuccess(false);
			ro.setErrorMessage("系统出现异常，请稍候再试");
			return "@"+this.returnObjectToJson(ro);
		}
	}
}
