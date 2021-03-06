<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>交通物流运行监测系统:系统管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-store">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/menuPages.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/formalize.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pages.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/imgs.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/jscript" src="${pageContext.request.contextPath}/js/html5.js"></script>
</head>
<body screen_capture_injected="true">
	<div id="header" class="clearfix">
		<div class="logo">
			<h4>危险货运</h4>
		</div>
		<div class="fr">
			<ul class="op clearfix">
				<a href="./交通物流运行监测系统 系统管理_files/交通物流运行监测系统 系统管理.htm">
					<li class="sys">系统管理</li>
				</a>
				<a href="http://localhost:8090/monitor-web/j_spring_security_logout">
					<li class="logout">注销登录</li>
				</a>
			</ul>
		</div>
		<div class="fr user">
			<dl>
				<dt>
					<b>浙江省道路运输管理局</b>
				</dt>
				<dd>
					<b>许灵，</b>欢迎登录
				</dd>
			</dl>
		</div>
	</div>
	<div id="menu">
		<ul class="clearfix">
			<li id="homePage"><a
				href="http://localhost:8090/monitor-web/home/menu"><span>首页</span></a></li>
			<li id="staticDateManage"><a
				href="http://localhost:8090/monitor-web/remind/menu"><span>
						静态数据监测</span></a></li>
			<li id="dynamicDateManage"><a
				href="http://localhost:8090/monitor-web/eroadBill/menu"> <span>动态数据监测</span></a></li>
			<li id="inspectionManage"><a
				href="http://localhost:8090/monitor-web/regulation/menu"> <span>监管信息处置</span></a></li>
			<li id="notice"><a
				href="http://localhost:8090/monitor-web/notice/menu"><span>通知公告</span></a></li>
			<li id="reportManage"><a
				href="http://localhost:8090/monitor-web/rptEnterprise/menu"> <span>报表管理</span></a></li>
			<li id="accountBook"><a
				href="http://localhost:8090/monitor-web/accountbookrecord/menu">
					<span>台帐管理</span>
			</a></li>
		</ul>
	</div>
	<div id="mainwrap" class="clearfix">
		<div class="main clearfix">
			<div class="left clearfix" style="height: 477px;">
				<div id="nav">
					<ul>
						<li class="selected clearfix">
							<!-- <a href="#"><span>系统管理</span><i></i></a> -->
							<ul>
								<li id="userManage" class="selected"
									onclick="gotoMenu('/monitor-web/security/userList')">
									<a href="http://localhost:8090/monitor-web/systemManage/menu#"><span>用户管理</span></a>
								</li>
								<li id="roleRemind"><a
									href="http://localhost:8090/monitor-web/systemManage/menu#"><span>
											角色管理</span></a></li>
								<li id="orgManage"><a
									href="http://localhost:8090/monitor-web/systemManage/menu#"><span>
											组织机构管理</span></a></li>
								<!-- <li id="permissionManage"><a href="#"><span>权限管理</span></a></li> -->
								<!-- 	                    <li id="expireInfoMange"><a href="#"><span>路单校验规则管理</span></a></li> -->
								<li id="verifyEroadBillInfo"><a
									href="http://localhost:8090/monitor-web/systemManage/menu#">
										<span>路单校验规则设置</span>
								</a></li>
								<li id="verifyMessageSetting"><a
									href="http://localhost:8090/monitor-web/systemManage/menu#">
										<span>到期提醒短信设置</span>
								</a></li>
								<li id="verifyExpireCertification"><a
									href="http://localhost:8090/monitor-web/systemManage/menu#">
										<span>到期提醒校验设置</span>
								</a></li>
								<!-- 	                    <li id="exceptionLevelManage"><a href="#"><span>路单异常等级管理</span></a></li> -->
								<li id="noticeClassifyMange"><a
									href="http://localhost:8090/monitor-web/systemManage/menu#">
										<span>公告类别设置</span>
								</a></li>
								<!-- 	                    <li id="messageSendManage"><a href="#"><span>短信发送设置</span></a></li> -->
								<!-- 	                    <li id="expireInfoMange"><a href="#"><span>到期提醒设置</span></a></li> -->
								<!-- 	                   	 <li id="problemTypeMange"><a href="#"><span>问题类别设置</span></a></li> -->
								<li id="eventType"><a
									href="http://localhost:8090/monitor-web/systemManage/menu#"><span>
											事件类型管理</span></a></li>
								<li id="resource"><a
									href="http://localhost:8090/monitor-web/systemManage/menu#"><span>
											系统资源</span></a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
			<div id="content" class="right clearfix panel-noscroll"
				style="height: 477px; width: 1141px;">
				<div id="tabs" class="clearfix tabs-container"
					style="width: 1141px; height: 477px;">
					<div class="tabs-header tabs-header-noborder"
						style="width: 1141px;">
						<div class="tabs-scroller-left" style="display: none;"></div>
						<div class="tabs-scroller-right" style="display: none;"></div>
						<div class="tabs-wrap"
							style="margin-left: 0px; margin-right: 0px; width: 1141px;">
							<ul class="tabs" style="height: 26px;">
								<li class="tabs-selected"><a href="javascript:void(0)"
									class="tabs-inner" style="height: 25px; line-height: 25px;"><span
										class="tabs-title tabs-closable">用户管理</span><span
										class="tabs-icon"></span></a><a href="javascript:void(0)"
									class="tabs-close"></a></li>
							</ul>
						</div>
					</div>
					<div class="tabs-panels tabs-panels-noborder"
						style="height: 448px; width: 1141px;">
						<div class="panel" style="display: block; width: 1141px;">
							<div title=""
								class="panel-body panel-body-noheader panel-body-noborder"
								style="width: 1141px; height: 448px;">
								<iframe width="100%" height="100%" frameborder="0"
									scrolling="auto" src="./交通物流运行监测系统 系统管理_files/userList.htm">
								</iframe>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
            $(document).ready(function () {
                initMain();
                $('#tabs').tabs({
                    border: false,
                    fit: true
                });

                $('#nav ul li ul li').first().click();
            });

            $("#userManage").click(function () {
                if ($("#userManage").attr("class") != "selected") {
                    switchSubMenu(this);
                }
                addCurTab('用户管理', '/monitor/view/userstate/activeUserData.jsp');
            });

            $("#orgManage").click(function () {
                if ($("#orgManage").attr("class") != "selected") {
                    switchSubMenu(this);
                }
                addCurTab('组织机构管理', '/monitor-web/organization/orgManageList');
            });

            /* $("#permissionManage").click(function(){
            if($("#permissionManage").attr("class")!="selected"){
            switchSubMenu(this);
            }
            addCurTab('权限管理','/monitor-web/systemManage/permissionManage');
            });  */

            $("#expireInfoMange").click(function () {
                if ($("#expireInfoMange").attr("class") != "selected") {
                    switchSubMenu(this);
                }
                addCurTab('路单校验规则管理', '/monitor-web/systemManage/expireInfoMange');
            });

            $("#verifyEroadBillInfo").click(function () {
                if ($("#verifyEroadBillInfo").attr("class") != "selected") {
                    switchSubMenu(this);
                }
                addCurTab('路单校验规则设置', '/monitor-web/systemManage/verifyEroadBillInfo');
            });

            $("#verifyMessageSetting").click(function () {
                if ($("#verifyMessageSetting").attr("class") != "selected") {
                    switchSubMenu(this);
                }
                addCurTab('到期提醒短信设置', '/monitor-web/systemManage/verifyMessageSetting');
            });

            $("#verifyExpireCertification").click(function () {
                if ($("#verifyExpireCertification").attr("class") != "selected") {
                    switchSubMenu(this);
                }
                addCurTab('到期提醒校验设置', '/monitor-web/systemManage/verifyExpireCertification');
            });

            $("#problemTypeMange").click(function () {
                if ($("#problemTypeMange").attr("class") != "selected") {
                    switchSubMenu(this);
                }
                addCurTab('问题类别设置', '/monitor-web/systemManage/problemTypeMange');
            });

            $("#noticeClassifyMange").click(function () {
                if ($("#noticeClassifyMange").attr("class") != "selected") {
                    switchSubMenu(this);
                }
                addCurTab('公告类别设置', '/monitor-web/notice/noticeClassifyMange');
            });

            $("#eventType").click(function () {
                if ($(this).attr("class") != "selected") {
                    switchSubMenu(this);
                }
                addCurTab('事件类型管理', "/monitor-web/emergency/eventsType/showList");
            });
            $("#resource").click(function () {
                if ($(this).attr("class") != 'selected') {
                    switchSubMenu(this);
                }
                addCurTab('系统资源', "/monitor-web/security/resource/showList");
            });
            $("#roleRemind").click(function () {
                if ($(this).attr("class") != 'selected') {
                    switchSubMenu(this);
                }
                addCurTab('角色管理', "/monitor-web/security/roleRemind/showList");
            });

            //监听窗口大小变化
            $(window).resize(function () {
                resizeMain();
            });
           	
</script>
	</div>
	<div id="footer">
		<a href="javascript:viewPerson('enterprise')">业户查询</a> | <a
			href="javascript:viewPerson('vehicle')"> 车辆查询</a> | <a
			href="javascript:viewPerson('person')">人员查询</a>
	</div>
	<script>

        function viewPerson(perm) {
            window.location.href = '/monitor-web/remind/menu?fl=' + perm;
        }
   </script>
	<script type="text/javascript">

        $("#systemManage").attr("class", "selected");
</script>
</body>
</html>