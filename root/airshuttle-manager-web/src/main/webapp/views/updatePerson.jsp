<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		
		<link href="../js/jquery-easyui-1.3.6/themes/default/easyui.css" rel="stylesheet" />
	    <link href="../js/jquery-easyui-1.3.6/themes/icon.css" rel="stylesheet" />
	    <style>
	    ul{
	    	margin:20px;
	    	margin-left:0;
	    }
	    ul li{
	    list-style:none;
	    margin-bottom:15px;
	    }
	    ul li lable{
	    	width: 60px;
display: inline-block;
	    }
	    .easyui-linkbutton{
	    padding:5px;
	    }
	    </style>
	    <script src="../js/jquery-1.11.1.js"></script>
	    <script src="../js/jquery-easyui-1.3.6/jquery.easyui.min.js"></script>
	    <script src="../js/jquery-easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			$(function(){$("#btn_update").click(function(){//修改个人信息
				$.getJSON("../manager/updatePersonalMsg.action", //原有数据无 ID 则为新增
		            {
		                userId: $("#userId").val(),
		                username: $("#userName").val(),
		                password: $("#password").val(),
		                sex: $("#sex").combobox("getValue")
		            }, function (data) {
		            	 if (data.result) {
		                     $.messager.alert('错误', data.result);
		                     return;
		                 }else{
		                	 $.messager.alert('执行结果', '修改成功');
		                 }
		            }).fail(function () {
		                $.messager.alert('异常', '请检查网络后重试。');
		            });
				});
			});
		</script>
	</head>
	<body>
	<form>
		<ul>
		<li><lable>用户名</lable><input type="text" class="easyui-textbox" id="userName" name="userName" data-option="required:true" value="${sessionScope.SESSION_USER_ATTRIBUTE_KEY.username}"/> </li>
		<li><lable>密    码</lable><input type="password" class="easyui-textbox" id="password" name="password" data-option="required:true"/></li>
		<!-- 
		<li><lable>性    别</lable><select id="sex" name="sex" class="easyui-combobox">
					<option value="1"
							<c:if test="${sessionScope.SESSION_USER_ATTRIBUTE_KEY.sex == 1}">
						selected="selected"
					</c:if>>男</option>
						<option value="0" <c:if test="${sessionScope.SESSION_USER_ATTRIBUTE_KEY.sex == 0}">
						selected="selected"
					</c:if>>女</option>	
				 </select></li> -->
		<li><input type="text" name="sex" value="1" hidden="true"/></li>		 
				 <li>	<input id="btn_update" type="button" value=" 修  改  " class="easyui-linkbutton"/></li>
		</ul>
	
		<input type="hidden" id="userId" name="userId" value="${sessionScope.SESSION_USER_ATTRIBUTE_KEY.id}"/>
		</form>
	</body>
</html>