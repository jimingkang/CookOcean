package com.topshare.airshuttle.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.var.Model;

import org.springframework.beans.factory.annotation.Autowired;

import com.topshare.airshuttle.common.util.Page;
import com.topshare.airshuttle.common.util.ResponseObject;
import com.topshare.airshuttle.model.driver.TAirshuttleDriver;
import com.topshare.airshuttle.model.receptionAir.TAirshuttleReceptionAir;
import com.topshare.airshuttle.model.userBookDriver.TAirshuttleUserBookDriver;
import com.topshare.airshuttle.service.driver.DriverService;
import com.topshare.airshuttle.service.receptionAir.ReceptionAirService;
import com.topshare.airshuttle.service.userBookDriver.UserBookDriverService;

@Path("/bookdriver")
public class BookDriverController extends BaseController {

	@Autowired
	private UserBookDriverService userBookDriverService;

	@Autowired
	private DriverService driverService;
	@Autowired
	ReceptionAirService receptionAirService;

	@Get("/finddriver")
	public String findDriver(Invocation inv,
			TAirshuttleDriver tAirshuttleDriver,
			@Param("pageSize") final Integer pageSize,
			@Param("pageNumber") final Integer pageNumber) throws Exception{
		// int
		// pageNumber=Integer.parseInt(inv.getRequest().getParameter("pageNumber"));
		// int
		// pageSize=Integer.parseInt(inv.getRequest().getParameter("pageSize"));
		// userBookDriverService.getByParamCity(tAirshuttletAirshuttleDriver,
		// pageNumber, pageSize);
		ResponseObject ro = new ResponseObject();
		// TAirshuttleUser user = new TAirshuttleUser();

		Page<TAirshuttleDriver> page = driverService.getPageBycity(
				tAirshuttleDriver, pageNumber, pageSize);

		inv.getRequest().setAttribute("rows",
				page.getItems() == null ? "" : page.getItems());
		inv.getRequest().setAttribute("total", page.getTotalCount());
		inv.getRequest()
				.getRequestDispatcher("/views/bookdriver/driversinfo.jsp")
				.forward(inv.getRequest(), inv.getResponse());
		return "";
	}

	@Get("/findReceptionAir")
	public String findReceptionAir(Invocation inv,
			@Param("receptionSchool") String receptionSchool,
			@Param("pageSize") final Integer pageSize,
			@Param("pageNumber") final Integer pageNumber) throws Exception{
		System.out.println("-------------jimmy test: " + receptionSchool);
		ResponseObject ro = new ResponseObject();
		TAirshuttleReceptionAir tAirshuttleReceptionAir = new TAirshuttleReceptionAir();
		tAirshuttleReceptionAir.setReceptionSchool(receptionSchool);

		Page<TAirshuttleReceptionAir> page = receptionAirService
				.getPageBySchool(tAirshuttleReceptionAir, pageNumber,
						pageSize);

		inv.getRequest().setAttribute("rows",page.getItems() == null ? "" : page.getItems());
		inv.getRequest().setAttribute("total", page.getTotalCount());
		inv.getRequest().getRequestDispatcher("/views/bookdriver/receptionairinfo.jsp")
				.forward(inv.getRequest(), inv.getResponse());
		return "";
	}

	@Get("/updateuserbookdriver")
	public String updateUserBookDriver(Invocation inv, Model model,
			TAirshuttleUserBookDriver tAirshuttleUserBookDriver,
			@Param("pageSize") final Integer pageSize,
			@Param("pageNumber") final Integer pageNumber) throws Exception{

		ResponseObject ro = new ResponseObject();
		// TAirshuttleUserBookDriver tAirshuttleUserBookDriver = new
		// TAirshuttleUserBookDriver();

		HttpSession session = inv.getRequest().getSession();

		// SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
		// sp.parse(expirationDate);
		Date curDate = new Date();

		// sp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		//
		tAirshuttleUserBookDriver.setModifyTime(curDate);
		userBookDriverService
				.updateUserBookDriver(tAirshuttleUserBookDriver);
		Page<TAirshuttleUserBookDriver> page = userBookDriverService
				.getByParam(tAirshuttleUserBookDriver, pageNumber, pageSize);
		model.add("rows", page.getItems() == null ? "" : page.getItems());
		model.add("total", page.getTotalCount());

		return "bookdriver/userbookdriverinfo";
	}

	@Get("/insertuserbookdriver")
	public String insertUserBookDriver(Model model, Invocation inv,
			TAirshuttleUserBookDriver tAirshuttleUserBookDriver,
			@Param("pageSize") final Integer pageSize,
			@Param("pageNumber") final Integer pageNumber) throws Exception{

		// TAirshuttleUserBookDriver tAirshuttleUserBookDriver = new
		// TAirshuttleUserBookDriver();

		HttpSession session = inv.getRequest().getSession();

		SimpleDateFormat sp = sp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// sp.parse(expirationDate);
		Date curDate = new Date();

		tAirshuttleUserBookDriver.setCreateTime(curDate);
		// tAirshuttleUserBookDriver.setPickUpTime(pickUpTime);

		Integer id = userBookDriverService
				.insert(tAirshuttleUserBookDriver);

		tAirshuttleUserBookDriver.setId(id);
		Page<TAirshuttleUserBookDriver> page = userBookDriverService
				.getByParam(tAirshuttleUserBookDriver, pageNumber, pageSize);
		model.add("rows", page.getItems() == null ? "" : page.getItems());
		model.add("total", page.getTotalCount());
		return "bookdriver/userbookdriverinfo";
	}

	@Get("/finduserbookdriver")
	public String findUserBookDriver(Invocation inv, Model model,
			TAirshuttleUserBookDriver tAirshuttleUserBookDriver,
			@Param("pageSize") final Integer pageSize,
			@Param("pageNumber") final Integer pageNumber) throws Exception{

		ResponseObject ro = new ResponseObject();

		// System.out.println("jimmy  userId:"+userId);

		HttpSession session = inv.getRequest().getSession();

		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");

		Date curDate = new Date();

		Page<TAirshuttleUserBookDriver> page = userBookDriverService
				.getByParam(tAirshuttleUserBookDriver, pageNumber, pageSize);
		model.add("rows", page.getItems() == null ? "" : page.getItems());
		model.add("total", page.getTotalCount());

		return "bookdriver/userbookdriverinfo";
	}

}
