<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.3.2.min-vsdoc.js" type="text/javascript"></script>
		<script type="text/javascript">
			function uploadImage() {
		        //判断是否有选择上传文件
	            var imgPath = $("#uploadFile").val();
	            if (imgPath == "") {
	                alert("请选择上传图片！");
	                return;
	            }
	            //判断上传文件的后缀名
	            var strExtension = imgPath.substr(imgPath.lastIndexOf('.') + 1);
	            if (strExtension != 'jpg' && strExtension != 'gif'
	            && strExtension != 'png' && strExtension != 'bmp') {
	                alert("请选择图片文件");
	                return;
	            }
	            $.ajax({
	                type: "POST",
	                url: "/upload/commonUploadFile/doUpload",
	                data: { file: $("#uploadFile").val() },
	                cache: false,
	                success: function(data) {
	                    alert("上传成功");
	                    $("#imgDiv").empty();
	                    $("#imgDiv").html(data);
	                    $("#imgDiv").show();
	                },
	                error: function(XMLHttpRequest, textStatus, errorThrown) {
	                    alert("上传失败，请检查网络后重试");
	                }
	            });
	        }
			
		</script>
	</head>
	<body>
		<form  enctype="multipart/form-data" method="post">
			<input type="file" id="uploadFile" runat="server" />
			<input type="button" id="btnUpload" value="确定" onclick="uploadImage()" />
			<div id="imgDiv"></div>
		</form>
	</body>
</html>