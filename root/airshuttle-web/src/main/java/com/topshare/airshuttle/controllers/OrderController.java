package com.topshare.airshuttle.controllers;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.paoding.rose.web.var.Model;

import org.springframework.beans.factory.annotation.Autowired;

import com.alipay.config.AlipayConfig;
import com.alipay.util.AlipaySubmit;
import com.topshare.airshuttle.common.util.Page;
import com.topshare.airshuttle.common.util.ResponseObject;
import com.topshare.airshuttle.model.order.TAirshuttleOrder;
import com.topshare.airshuttle.service.order.OrderService;
import com.topshare.airshuttle.service.orderProcess.OrderProcessService;


@Path("/order")  
public class OrderController extends BaseController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderProcessService orderProcessService;

	@Get("/findorder")
	public String findOrder(Invocation inv,TAirshuttleOrder tAirshuttleOrder,@Param("pageSize") final Integer pageSize,@Param("pageNumber") final Integer pageNumber
			){
		//int pageNumber=Integer.parseInt(inv.getRequest().getParameter("pageNumber"));
		//int pageSize=Integer.parseInt(inv.getRequest().getParameter("pageSize"));
		//orderService.getByParamCity(tAirshuttletAirshuttleOrder, pageNumber,  pageSize);
		ResponseObject ro = new ResponseObject();
		//TAirshuttleUser user = new TAirshuttleUser();
		
		try {


			
			Page<TAirshuttleOrder> page = orderService.getByUserId(tAirshuttleOrder, pageNumber, pageSize);

	
			inv.getRequest().setAttribute("rows", page.getItems() == null ? "" : page.getItems());
			inv.getRequest().setAttribute("total", page.getTotalCount());	
			inv.getRequest().getRequestDispatcher("/views/order/orderinfo.jsp").forward(inv.getRequest(),inv.getResponse());
			return "";
			
		} catch (Exception e) {
			e.printStackTrace();
			ro.setSuccess(false);
			ro.setErrorMessage("系统出现异常，请稍候再试");
			return "@"+this.returnObjectToJson(ro);
		}
		
		
	}
	
	
	@Get("/updateorder")
	public String updateOrder(Invocation inv,Model model,TAirshuttleOrder tAirshuttleOrder,

@Param("pageSize") final Integer pageSize,@Param("pageNumber") final Integer pageNumber
		
			) {
		
		ResponseObject ro = new ResponseObject();
		//TAirshuttleOrder tAirshuttleOrder = new TAirshuttleOrder();
		try {
			
			HttpSession session = inv.getRequest().getSession();
			

			
			//SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
			//sp.parse(expirationDate);
			Date curDate = new Date();

			// sp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//			
			tAirshuttleOrder.setModifyTime(curDate);
			orderService.updateOrder(tAirshuttleOrder);
			 Page<TAirshuttleOrder> page= orderService.updateOrder(tAirshuttleOrder);
			 model.add("rows", page.getItems() == null ? "" : page.getItems());
			 model.add("total", page.getTotalCount());
		
			
		
			return "order/orderinfo";
		} catch (Exception e) {
			e.printStackTrace();
			ro.setSuccess(false);
			ro.setErrorMessage("系统出现异常，请稍候再试");
			return "@"+this.returnObjectToJson(ro);
		}
		
		
	}
	@Post("/alipayapi")
	public void alipalyapi(Invocation inv){
		//支付类型
		HttpServletRequest request=inv.getRequest();
		inv.getResponse().setContentType("text/html;charset=UTF-8"); 

		String payment_type = "1";
		//必填，不能修改
		//服务器异步通知页面路径
		String notify_url = "http://sinoustravel.com/notify_url.jsp";
		//需http://格式的完整路径，不能加?id=123这类自定义参数

		//页面跳转同步通知页面路径
		String return_url = "http://sinoustravel.com/return_url.jsp";
		//需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/

		//商户订单号
		
		try {
			String out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
			//商户网站订单系统中唯一订单号，必填

			//订单名称
			String subject = new String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"),"UTF-8");
			//必填

			//付款金额
			String price = new String(request.getParameter("WIDprice").getBytes("ISO-8859-1"),"UTF-8");
			//必填

			//商品数量
			String quantity = "1";
			//必填，建议默认为1，不改变值，把一次交易看成是一次下订单而非购买一件商品
			//物流费用
			String logistics_fee = "0.00";
			//必填，即运费
			//物流类型
			String logistics_type = "EXPRESS";
			//必填，三个值可选：EXPRESS（快递）、POST（平邮）、EMS（EMS）
			//物流支付方式
			String logistics_payment = "SELLER_PAY";
			//必填，两个值可选：SELLER_PAY（卖家承担运费）、BUYER_PAY（买家承担运费）
			//订单描述

			String body = new String(request.getParameter("WIDbody").getBytes("ISO-8859-1"),"UTF-8");
			
			//商品展示地址
			String show_url = new String(request.getParameter("WIDshow_url").getBytes("ISO-8859-1"),"UTF-8");
			//需以http://开头的完整路径，如：http://www.商户网站.com/myorder.html
	/*
			//收货人姓名
			String receive_name = new String(request.getParameter("WIDreceive_name").getBytes("ISO-8859-1"),"UTF-8");
			//如：张三

			//收货人地址
			String receive_address = new String(request.getParameter("WIDreceive_address").getBytes("ISO-8859-1"),"UTF-8");
			//如：XX省XXX市XXX区XXX路XXX小区XXX栋XXX单元XXX号

			//收货人邮编
			String receive_zip = new String(request.getParameter("WIDreceive_zip").getBytes("ISO-8859-1"),"UTF-8");
			//如：123456

			//收货人电话号码
			String receive_phone = new String(request.getParameter("WIDreceive_phone").getBytes("ISO-8859-1"),"UTF-8");
			//如：0571-88158090

			//收货人手机号码
			String receive_mobile = new String(request.getParameter("WIDreceive_mobile").getBytes("ISO-8859-1"),"UTF-8");
			//如：13312341234
		*/	
			
			//////////////////////////////////////////////////////////////////////////////////
			
			//把请求参数打包成数组
			Map<String, String> sParaTemp = new HashMap<String, String>();
			sParaTemp.put("service", "create_partner_trade_by_buyer");
	        sParaTemp.put("partner", AlipayConfig.partner);
	        sParaTemp.put("seller_email", AlipayConfig.seller_email);
	        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
			sParaTemp.put("payment_type", payment_type);
			sParaTemp.put("notify_url", notify_url);
			sParaTemp.put("return_url", return_url);
			sParaTemp.put("out_trade_no", out_trade_no);
			sParaTemp.put("subject", subject);
			sParaTemp.put("price", price);
			sParaTemp.put("quantity", quantity);
			sParaTemp.put("logistics_fee", logistics_fee);
			sParaTemp.put("logistics_type", logistics_type);
			sParaTemp.put("logistics_payment", logistics_payment);
			sParaTemp.put("body", body);
			sParaTemp.put("show_url", show_url);
			//sParaTemp.put("receive_name", receive_name);
			//sParaTemp.put("receive_address", receive_address);
			//sParaTemp.put("receive_zip", receive_zip);
			//sParaTemp.put("receive_phone", receive_phone);
			//sParaTemp.put("receive_mobile", receive_mobile);
			
			//建立请求
			String sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"get","确认");
			inv.getResponse().getOutputStream().println(sHtmlText);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Get("/insertorder")
	public String insertUserBookDriver(Model model,Invocation inv,TAirshuttleOrder tAirshuttleOrder, @Param("pageSize") final Integer pageSize,@Param("pageNumber") final Integer pageNumber
		
			) {
		
		ResponseObject ro = new ResponseObject();
		//TAirshuttleOrder tAirshuttleOrder = new TAirshuttleOrder();
		try {
			
			HttpSession session = inv.getRequest().getSession();

			SimpleDateFormat  sp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			//sp.parse(expirationDate);
			Date curDate = new Date();

			tAirshuttleOrder.setCreateTime(curDate);
			tAirshuttleOrder.setDesignationNumber(Long.toString(System.currentTimeMillis()));
			
			Integer id = orderService.insert(tAirshuttleOrder);
			
			tAirshuttleOrder.setId(id);
			// Page<TAirshuttleOrder> page= orderService.getByUserId(tAirshuttleOrder, pageNumber, pageSize);
			// model.add("rows", page.getItems() == null ? "" : page.getItems());
			// model.add("total", page.getTotalCount());
			
			 model.add("designationNumber", tAirshuttleOrder.getDesignationNumber());
			 model.add("bookPrice", tAirshuttleOrder.getBookPrice());
			 return "alipay/alipay";
		} catch (Exception e) {
			e.printStackTrace();
			ro.setSuccess(false);
			ro.setErrorMessage("系统出现异常，请稍候再试");
			return "@"+this.returnObjectToJson(ro);
		}
		
		
	}




}
