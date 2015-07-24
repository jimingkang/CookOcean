<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>交换监控</title>
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/images/logink.ico"
	type="image/x-icon">

<link href="${pageContext.request.contextPath}/css/default.css" type="text/css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bg.css" type="text/css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/main.css" type="text/css"
	rel="stylesheet">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>

<body screen_capture_injected="true">
	<div style="margin: 150px auto 0 auto; auto; width: 800px;">
		<div id="logBox" style="position: relative;">
		<div id="lbNameLeft" style="position:absolute; left: 104px;top:148px;height:26px;width:185px;font-family:微软雅黑;font-size:18px;color:#575958;text-align: center;">1号浙江交换服务器</div>
		<div id="lbNameRight" style="position:absolute; left: 437px;top:55px;height:45px;width:316px;font-family:微软雅黑;font-size:28px;color:#575958;text-align: center;">登录数据交换监控平台</div>
			<form
				action="${pageContext.request.contextPath}/user/login"
				method="POST" style="display: block; margin: 120px 0 20px 340px;">
				<dl>
					<dd style="position:absolute; left:455px;top:95px;">
						<label>
							<font color="red">${ERROR_MSG}</font>
						</label>
						<label style="margin-bottom:20px;font-size: 17px;">用户名:
						<!-- <input type="text" id="username" name="username"
							onmouseout="this.style.borderColor=&#39;#c4c7c8&#39;"
							onmouseover="this.style.borderColor=&#39;#7dbde2&#39;"
							style="border-color: rgb(196, 199, 200);margin-left: 8px;">-->
							<input type="text" name="username" id="username" onmouseout="this.style.borderColor=&#39;#c4c7c8&#39;"
							onmouseover="this.style.borderColor=&#39;#7dbde2&#39;" style="width:205px;height:25px;margin-right:5px; margin-left:10px; color:#0f0f0f;background-color:#F9FFED;">
							
						</label>
						<label class="marg" style="font-size: 17px;">密&nbsp;&nbsp;&nbsp;码:
						<input type="password"
							id="password" name="password"
							onmouseout="this.style.borderColor=&#39;#c4c7c8&#39;"
							onmouseover="this.style.borderColor=&#39;#7dbde2&#39;"
							style="width:205px;height:25px;margin-right:5px;margin-left:10px; color:#0f0f0f;background-color:#F9FFED;"">
						</label>
					<label  style="margin-top: 25px; border-style:none; ">
							<input name="button" type="submit" style="margin-right:43px; " class="btnLog" id="button" value="">
							<input name="button" type="reset"  style="margin-right:4px; "  class="btnReset" id="button" value="">
					</label>
				</dl>
			</form>
		</div>
		<div id="loginContent">
		<p style="zoom: 1; ">
				<b>运维商：万达信息股份有限公司&nbsp;&nbsp;联系电话：0571-87850256</b>
				09:00-17:00&nbsp;&nbsp;
			</p>
			</div>
	</div>
</body>
</html>