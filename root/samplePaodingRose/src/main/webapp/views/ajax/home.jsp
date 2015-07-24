<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
	<script type="text/javascript">
		//ajax json test
		function loadAjaxData() {
			$.ajax({
				async : false,
				url : "/rose-example1/ajax/json",
				dataType: "json",
				data : '',
				success : function(data) {
					$("#showDiv").html(data.show);
				}
			});
		}
		
		//ajax text test
		function loadTextData() {
			$.ajax({
				async : false,
				url : "/rose-example1/ajax/text",
				data : '',
				success : function(data) {
					$("#showDiv").html(data);
				}
			});
		}
	</script>
</head>
<body>
	<input type="button" value="loadAjaxData" onclick="loadAjaxData();" />
	<input type="button" value="loadTextData" onclick="loadTextData();" />
	<div id="showDiv"></div>
</body>
</html>