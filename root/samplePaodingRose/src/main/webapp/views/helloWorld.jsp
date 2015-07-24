<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="http://localhost:8080/rose-example1/js/test.js" type="text/javascript"></script>
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script src="http://localhost:8080/rose-example1/js/jquery.pagination.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/rose-example1/css/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css" href="http://localhost:8080/rose-example1/css/bootstrap-theme.min.css" />
<link rel="stylesheet" type="text/css" href="http://localhost:8080/rose-example1/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="http://localhost:8080/rose-example1/css/bootstrap.min.css" />
<script type="text/javascript">
	function loadData() {
		$.ajax({
			async : false,
			url : "/test",
			data : '',
			success : function(data) {
				$("#showDiv").html(data);
			}
		});
	}
	 $(function() {
		 $('pageDiv').pagination(20, 5, {
		        'current_page': 1-1,
		        callback: function(page, component) {  // 点击页码的事件
		            getData(renderNews) // 获取数据并渲染到表格
		        }
			});
	 });
	 
	 
</script>
<head></head>
<body>
	#msg("hello"), it's $date.format("yy-MM-dd HH:mm:ss", $now)3223
	<br />
	<input type="button" value="test" onclick="test();" />
	<input type="button" value="showDiv" onclick="loadData();" />
	<div id="showDiv"></div>
	<div id="pageDiv"></div>
</body>
</html>