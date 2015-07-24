<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/> 
<!DOCTYPE html >
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>

<link rel="stylesheet" type="text/css" href="${ctx}/static/styles/formalize.css">
<link rel="stylesheet" type="text/css" href="${ctx}/static/styles/reset.css">
<link rel="stylesheet" type="text/css" href="${ctx}/static/styles/pages.css" >
<link rel="stylesheet" type="text/css" href="${ctx}/static/styles/default/imgs.css" >
<link rel="stylesheet" type="text/css" href="${ctx}/static/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/static/easyui/themes/icon.css" />
<script type="text/javascript" src="${ctx}/static/js/common.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${ctx}/static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/static/easyui/locale/easyui-lang-zh_CN.js"></script> 
<script type="text/javascript">
	function loadUser(){
		//ajax请求用户，分页显示，按照名称进行模糊查询
	}
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
<div class="p5 mb6">
<form id="queryForm">
<input type="hidden" id="organizationId" name="organizationId">
<div class="clearfix">
       <div class="fl w49p clearfix ">
             <label class="fl p5 w120 t_r" for="noticeType">用户名称:</label>
             <div class="fl p5 ">
             	<input type="text" id="realName" name="realName" style="width:220px;"></input>
             </div>
        </div>
     </div>
	<div class="t_c">
		<input type="button" value="&nbsp;&nbsp;查&nbsp;&nbsp;&nbsp;&nbsp;询&nbsp;&nbsp;" class="btn" onclick="doSearch()"  />&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="重置查询条件" class="btn" onclick="doCancel()"  />&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="新增用户" class="btn" onclick="saveEmpower()"  />
	</div>
</form>
 </div>
    	<table id="userContent"> </table> 

<script type="text/javascript"> 
            $(function(){  
                $('#userContent').datagrid({ 
                 	height:$(window).height()-$("#queryForm").height()-10,
                	url:'${ctx}/security/userList',
                	method:'post',
                	pagination:true,
                    rownumbers:true,
                    fitColumns:true,
                    singleSelect:true,
                    remoteSort:true,
                    sortOrder:'desc',
                    sortName:'id',
                    columns:[[  
						{field:'orga.text',title:'机构名称',halign:'center',width:13,
							formatter:function(value,row,index){
								return row.orga.text;
							}},
						{field:'realname',title:'用户名',halign:'center',width:13},	
						{field:'username',title:'登录名',halign:'center',width:13},
						{field:'sex',title:'性别',halign:'center',width:13},
						{field:'phone',title:'电话',halign:'center',width:13},
						{field:'fax',title:'传真',halign:'center',width:13},
                    ]]
                }); 
	            $('#orgaNameTree').combotree({
	        		url:'${ctx}/organization/showTrees?id=1',
	        		//editable:true,
	   				onBeforeExpand:function(node,param){
	   					$('#orgaNameTree').combotree("tree").tree('options').url ="${ctx}/organization/showTrees?id=" + node.id;
	   				},
// 	   				onSelect:function(node){
// 	   					$("#organizationId").val(node.id);
// 	   				}
	        	});
            });
            function doSearch(){
            	var orgaId=$("#orgaNameTree").combotree("getValue");
            	
            	$("#organizationId").val(orgaId);
                 $('#userContent').datagrid({
                	url:'${ctx}/security/userList',
                 	method:'post',
                 	queryParams:{
                 		search_like_realname: $.trim($("input[name='realName']").val()),
                   	 	'search_eq_orga.id':orgaId
                 	},
                 	pagination:true,
                     rownumbers:true,
                     fitColumns:true,
                     singleSelect:true,
                     remoteSort:true,
                     sortOrder:'desc',
                     sortName:'id',
                     columns:[[  
 						{field:'orga.text',title:'机构名称',halign:'center',width:13,
 							formatter:function(value,row,index){
 								//$("#organizationId").val(row.orga.id);
 								return row.orga.text;
 							}},
 						{field:'realname',title:'用户名',halign:'center',width:13},	
 						{field:'username',title:'登录名',halign:'center',width:13},
 						{field:'sex',title:'性别',halign:'center',width:13},
 						{field:'phone',title:'电话',halign:'center',width:13},
 						{field:'fax',title:'传真',halign:'center',width:13},
                     ]],
                 	onLoadSuccess:function(data){
                 		if(data.rows.length==0){
                 			$("#organizationId").val("");
                 		}else{
							$("#organizationId").val(data.rows[0].orga.id);
                 		}
              		},
                 });
            }
          
            function showDialog(title){
        		$("#contentMain").css('display','block');
        		$('#contentMain').dialog({
        			draggable:false,
        			title: title,
        			width: 500,
        			height: 400,
        			closed: false,
        			cache: false,
        			modal: true
        			});
        	}
            
            function saveEmpower(){
            	var organizationId = $("#organizationId").val();
            	addTab("用户授权","${ctx}/security/empowerList?orgId="+organizationId);
            }
           
	        function doCancel(){
            	$("#queryForm").form('clear');
            	doSearch();
        	}
	        
	      //监听窗口大小变化
	    	$(window).resize(function() {
	    		$('#userContent').datagrid('resize',{  
	    	          height:$(window).height()-$("#queryForm").height()-10,
	    	          width:$(window).width()
	    	    });
	    	});
</script> 
</body>
</html>