package com.topshare.airshuttle.controllers;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
import com.alipay.util.AlipayNotify;
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
			) throws Exception{
		//int pageNumber=Integer.parseInt(inv.getRequest().getParameter("pageNumber"));
		//int pageSize=Integer.parseInt(inv.getRequest().getParameter("pageSize"));
		//orderService.getByParamCity(tAirshuttletAirshuttleOrder, pageNumber,  pageSize);
		ResponseObject ro = new ResponseObject();
		//TAirshuttleUser user = new TAirshuttleUser();
			
		Page<TAirshuttleOrder> page = orderService.getByUserId(tAirshuttleOrder, pageNumber, pageSize);


		inv.getRequest().setAttribute("rows", page.getItems() == null ? "" : page.getItems());
		inv.getRequest().setAttribute("total", page.getTotalCount());	
		inv.getRequest().getRequestDispatcher("/views/order/orderinfo.jsp").forward(inv.getRequest(),inv.getResponse());
		return "";
	}
	
	
	@Get("/updateorder")
	public String updateOrder(Invocation inv,Model model,TAirshuttleOrder tAirshuttleOrder,

@Param("pageSize") final Integer pageSize,@Param("pageNumber") final Integer pageNumber
		
			) throws Exception{
		
			
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
	}
	@Post("/notify_url")
	public void alipaynotify_url(Invocation inv) throws Exception{
		//支付类型
		HttpServletRequest request=inv.getRequest();
		inv.getResponse().setContentType("text/html;charset=UTF-8"); 

		//获取支付宝POST过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(name, valueStr);
		}
		
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		//商户订单号
		String out_trade_no = null;
		
		//支付宝交易号

				String trade_no = null;
		//交易状态
				String trade_status = null;
	
			//商户订单号
			 out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
			//支付宝交易号

			 trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

			//交易状态
			 trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
		

		

		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//

		if(AlipayNotify.verify(params)){//验证成功
			//////////////////////////////////////////////////////////////////////////////////////////
			//请在这里加上商户的业务逻辑程序代码

			//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
			
			
			//review_process
			if(trade_status.equals("WAIT_BUYER_PAY")){
				//该判断表示买家已在支付宝交易管理中产生了交易记录，但没有付款
				
					//判断该笔订单是否在商户网站中已经做过处理
						//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
						//如果有做过处理，不执行商户的业务程序
					
					//inv.getResponse().getWriter().println("success");	//请不要修改或删除
				} else if(trade_status.equals("WAIT_SELLER_SEND_GOODS")){
				//该判断表示买家已在支付宝交易管理中产生了交易记录且付款成功，但卖家没有发货
				
					//判断该笔订单是否在商户网站中已经做过处理
						//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
						//如果有做过处理，不执行商户的业务程序
					
				//	inv.getResponse().getWriter().println("success");	//请不要修改或删除
				} else if(trade_status.equals("WAIT_BUYER_CONFIRM_GOODS")){
				//该判断表示卖家已经发了货，但买家还没有做确认收货的操作
				
					//判断该笔订单是否在商户网站中已经做过处理
						//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
						//如果有做过处理，不执行商户的业务程序
					
				//	inv.getResponse().getWriter().println("success");	//请不要修改或删除
				} else if(trade_status.equals("TRADE_FINISHED")){
				//该判断表示买家已经确认收货，这笔交易完成
				
					//判断该笔订单是否在商户网站中已经做过处理
						//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
						//如果有做过处理，不执行商户的业务程序
					
					//inv.getResponse().getWriter().println("success");	//请不要修改或删除
				}
				else {
					//inv.getResponse().getWriter().println("success");	//请不要修改或删除
				}

			//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

			//////////////////////////////////////////////////////////////////////////////////////////
		}else{//验证失败
			//inv.getResponse().getWriter().println("fail");
		}
	}
	@Post("/alipayapi")
	public void alipalyapi(Invocation inv) throws Exception{
		//支付类型
		HttpServletRequest request=inv.getRequest();
		inv.getResponse().setContentType("text/html;charset=UTF-8"); 

		String payment_type = "1";
		//必填，不能修改
		//服务器异步通知页面路径
		String notify_url = "http://sinoustravel.com/order/notify_url";
		//需http://格式的完整路径，不能加?id=123这类自定义参数

		//页面跳转同步通知页面路径
		String return_url = "http://sinoustravel.com/order/return_url";
		//需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/

		//商户订单号
		
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
		sParaTemp.put("receive_name", receive_name);
		sParaTemp.put("receive_address", receive_address);
		sParaTemp.put("receive_zip", receive_zip);
		sParaTemp.put("receive_phone", receive_phone);
		sParaTemp.put("receive_mobile", receive_mobile);
		
		//建立请求
		String sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"get","确认");
		inv.getResponse().getWriter().println(sHtmlText);
	}
	@Get("/insertorder")
	public String insertOrder(Model model,Invocation inv,TAirshuttleOrder tAirshuttleOrder, @Param("pageSize") final Integer pageSize,@Param("pageNumber") final Integer pageNumber
		
			) throws Exception{
		
			
		HttpSession session = inv.getRequest().getSession();

		SimpleDateFormat  sp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		//sp.parse(expirationDate);
		Date curDate = new Date();

		tAirshuttleOrder.setCreateTime(curDate);
		tAirshuttleOrder.setDesignationNumber("Order_"+Long.toString(System.currentTimeMillis()));
		
		Integer id = orderService.insert(tAirshuttleOrder);
		
		tAirshuttleOrder.setId(id);
		// Page<TAirshuttleOrder> page= orderService.getByUserId(tAirshuttleOrder, pageNumber, pageSize);
		// model.add("rows", page.getItems() == null ? "" : page.getItems());
		// model.add("total", page.getTotalCount());
		
		 model.add("designationNumber", tAirshuttleOrder.getDesignationNumber());
		 model.add("bookPrice", tAirshuttleOrder.getBookPrice());
		 return "alipay/alipay";
	}
	@Get("/return_url")
	public void alipayfeedback(Invocation inv) throws Exception{
		//支付类型
		HttpServletRequest request=inv.getRequest();
		inv.getResponse().setContentType("text/html;charset=UTF-8"); 

		//获取支付宝GET过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			try {
				valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			params.put(name, valueStr);
			System.out.println(name+":"+valueStr);
		}
		
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		//商户订单号
		String out_trade_no=null;
		try {
			out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//支付宝交易号
		
		String trade_no=null;
		try {
			 trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//交易状态
		String trade_status=null;
		try {
			trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
		
		//计算得出通知验证结果
		boolean verify_result = AlipayNotify.verify(params);
		
		if(verify_result){//验证成功
			//////////////////////////////////////////////////////////////////////////////////////////
			//请在这里加上商户的业务逻辑程序代码
			
			//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
			
			if(trade_status.equals("WAIT_SELLER_SEND_GOODS")){
				//判断该笔订单是否在商户网站中已经做过处理
					//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					//如果有做过处理，不执行商户的业务程序
			}
			
			//该页面可做页面美工编辑
			try {
				
			
				TAirshuttleOrder tAirshuttleOrder=orderService.getOrderByDesignNumber(out_trade_no);
				Date curDate = new Date();

				tAirshuttleOrder.setModifyTime(curDate);
				tAirshuttleOrder.setDesignationNumber(trade_no);
				Integer id = orderService.alipayfeedback(tAirshuttleOrder);
				inv.getResponse().getWriter().println("验证成功<br />");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

			//////////////////////////////////////////////////////////////////////////////////////////
		}else{
			//该页面可做页面美工编辑
			try {
				inv.getResponse().getWriter().println("验证失败");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}




}
