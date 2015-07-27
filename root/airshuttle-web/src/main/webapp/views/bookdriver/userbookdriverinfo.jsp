<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>Grouping Info - fly the Ocean</title>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    
		
		<link rel="stylesheet" type="text/css" href="http://cdn2.editmysite.com/css/sites.css?buildTime=1234" />
<link rel="stylesheet" type="text/css" href="http://cdn1.editmysite.com/editor/libraries/fancybox/fancybox.css?1234" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/files/main_style.css?1436453283" title="wsite-theme-css" />
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700&subset=latin,latin-ext' rel='stylesheet' type='text/css' />
<link href='http://fonts.googleapis.com/css?family=Montserrat+Alternates:400,700&subset=latin,latin-ext' rel='stylesheet' type='text/css' />

<style type='text/css'>
.wsite-elements.wsite-not-footer div.paragraph, .wsite-elements.wsite-not-footer p, .wsite-elements.wsite-not-footer .product-block .product-title, .wsite-elements.wsite-not-footer .product-description, .wsite-elements.wsite-not-footer .wsite-form-field label, .wsite-elements.wsite-not-footer .wsite-form-field label, #wsite-content div.paragraph, #wsite-content p, #wsite-content .product-block .product-title, #wsite-content .product-description, #wsite-content .wsite-form-field label, #wsite-content .wsite-form-field label, .blog-sidebar div.paragraph, .blog-sidebar p, .blog-sidebar .wsite-form-field label, .blog-sidebar .wsite-form-field label {}
#wsite-content div.paragraph, #wsite-content p, #wsite-content .product-block .product-title, #wsite-content .product-description, #wsite-content .wsite-form-field label, #wsite-content .wsite-form-field label, .blog-sidebar div.paragraph, .blog-sidebar p, .blog-sidebar .wsite-form-field label, .blog-sidebar .wsite-form-field label {}
.wsite-elements.wsite-footer div.paragraph, .wsite-elements.wsite-footer p, .wsite-elements.wsite-footer .product-block .product-title, .wsite-elements.wsite-footer .product-description, .wsite-elements.wsite-footer .wsite-form-field label, .wsite-elements.wsite-footer .wsite-form-field label{}
.wsite-elements.wsite-not-footer h2, .wsite-elements.wsite-not-footer .product-long .product-title, .wsite-elements.wsite-not-footer .product-large .product-title, .wsite-elements.wsite-not-footer .product-small .product-title, #wsite-content h2, #wsite-content .product-long .product-title, #wsite-content .product-large .product-title, #wsite-content .product-small .product-title, .blog-sidebar h2 {}
#wsite-content h2, #wsite-content .product-long .product-title, #wsite-content .product-large .product-title, #wsite-content .product-small .product-title, .blog-sidebar h2 {}
.wsite-elements.wsite-footer h2, .wsite-elements.wsite-footer .product-long .product-title, .wsite-elements.wsite-footer .product-large .product-title, .wsite-elements.wsite-footer .product-small .product-title{}
#wsite-title {}
.wsite-menu-default a {}
.wsite-menu a {}
.wsite-image div, .wsite-caption {}
.galleryCaptionInnerText {}
.fancybox-title {}
.wslide-caption-text {}
.wsite-phone {}
.wsite-headline {}
.wsite-headline-paragraph {}
.wsite-button-inner {}
.wsite-not-footer blockquote {}
.wsite-footer blockquote {}
.blog-header h2 a {}
#wsite-content h2.wsite-product-title {}
.wsite-product .wsite-product-price a {}
</style>

		<script><!--
var STATIC_BASE = '//cdn1.editmysite.com/';
var STYLE_PREFIX = 'wsite';
//-->
</script>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js'></script>
<script type="text/javascript">
function check(formid,val)
{
	var form=document.getElementById(formid);
	var status=document.getElementById('status-'+formid);
	status.value=val;
alert(form);
form.submit();

}
function order(formid,val)
{
	var form=document.getElementById(formid);
	var status=document.getElementById('status-'+formid);
	status.value=val;

form.submit();

}

</script>
<script src="http://cdn2.editmysite.com/js/site/main.js?buildTime=1234"></script><script type="text/javascript">_W.configDomain = "www.weebly.com";</script><script type="text/javascript" src="http://cdn2.editmysite.com/js/lang/zh/ftl.js?buildTime=1234"></script><script>_W.relinquish && _W.relinquish()</script>
<script type="text/javascript"><!--
	var IS_ARCHIVE = 1;
	
	(function(jQuery){
		function initFlyouts(){
			initPublishedFlyoutMenus(
				[{"id":"349214849247426131","title":"AirShuttle","url":"index.jsp","target":""},{"id":"398593238625168252","title":"HouseRent","url":"houserent.jsp","target":""},{"id":"517303773409184253","title":"Contact","url":"contact.jsp","target":""},{"id":"217308836783333756","title":"About","url":"about.jsp","target":""}],
				"842982506626757635",
				"<li class=\"wsite-menu-item-wrap\"><a href=\"#\" data-membership-required=\"\" class=\"wsite-menu-item\">{{title}}<\/a><\/li>",
				'{{id}}',
				false,
				{"menu\/submenu-main":"<div class=\"wsite-menu-wrap\" style=\"display:none\">{{! Designer note: \"wsite-menu-wrap\" required on submenu wrapper }}\n\t<ul class=\"wsite-menu\">{{! Designer note: \"wsite-menu\" required on submenu element }}\n\t\t{{#children}}{{> menu\/submenu-item}}{{\/children}}\n\t<\/ul>\n<\/div>\n","menu\/submenu-item":"<li{{#id}} id=\"{{id}}\"{{\/id}} class=\"wsite-menu-subitem-wrap{{#current_page}} wsite-nav-current{{\/current_page}}\">{{! Designer note: id required & \"wsite-menu-subitem-wrap\" required on the item wrap }}\n\t<a href=\"{{itemlink}}\"{{#target}} target=\"{{target}}\"{{\/target}} class=\"wsite-menu-subitem\">{{! Designer note: \"wsite-menu-subitem\" required on the item link }}\n\t\t<span class=\"wsite-menu-title\">\n\t\t\t{{{itemtitle}}}\n\t\t<\/span>{{#has_children}}<span class=\"wsite-menu-arrow\">&gt;<\/span>{{\/has_children}}\n\t<\/a>\n\t{{#has_children}}{{> menu\/submenu-main}}{{\/has_children}}\n<\/li>\n","menu\/main":"<ul class=\"wsite-menu-default\">{{> menu\/main-without-wrap}}<\/ul>{{! Designer note: \"wsite-menu-default\" required on menu element }}\n","menu\/main-without-wrap":"{{#links}}{{!\n}}{{#current_page}}{{> menu\/item-current}}{{\/current_page}}{{!\n}}{{^current_page}}{{> menu\/item}}{{\/current_page}}{{!\n}}{{\/links}}\n","menu\/item-current":"<li{{#id}} id=\"{{id}}\"{{\/id}} class=\"wsite-menu-item-wrap\">{{! Designer note: id required & \"wsite-menu-item-wrap\" required on the item wrapper }}\n\t<a href=\"{{itemlink}}\"{{#target}} target=\"{{target}}\"{{\/target}} class=\"wsite-menu-item\">{{! Designer note: \"wsite-menu-item\" required on the item link }}\n\t\t{{{itemtitle}}}\n\t<\/a>\n\t{{#has_children}}{{> menu\/submenu-main}}{{\/has_children}}\n<\/li>\n","menu\/item":"<li{{#id}} id=\"{{id}}\"{{\/id}} class=\"wsite-menu-item-wrap\">{{! Designer note: id required & \"wsite-menu-item-wrap\" required on the item wrapper }}\n\t<a href=\"{{itemlink}}\" data-membership-required=\"{{membership-required}}\"{{#target}} target=\"{{target}}\"{{\/target}} class=\"wsite-menu-item\">{{! Designer note: \"wsite-menu-item\" required on the item link }}\n\t\t{{{itemtitle}}}\n\t<\/a>\n\t{{#has_children}}{{> menu\/submenu-main}}{{\/has_children}}\n<\/li>\n"}
			)
		}
		if (jQuery) {
			jQuery(document).ready(function() { jQuery(initFlyouts); });
		}else{
			if (Prototype.Browser.IE) window.onload = initFlyouts;
			else document.observe('dom:loaded', initFlyouts);
		}
	})(window._W && _W.jQuery)
//-->
</script>
		
	</head>
	<body class="no-header-page  wsite-theme-light  wsite-page-grouping-info"><div id="header-wrap">
        <div class="container">
			<div id="logo"><span class="wsite-logo">

	<a href="">
	
	<span id="wsite-title">fly the Ocean</span>
	
	</a>

</span></div>
			<div id="nav"><ul class="wsite-menu-default"><li id="active" class="wsite-menu-item-wrap">
	<a href="${pageContext.request.contextPath}/views/index.jsp" class="wsite-menu-item">
		接机
	</a>
	
</li>
<li id="pg398593238625168252" class="wsite-menu-item-wrap">
	<a href="${pageContext.request.contextPath}/views/houserent.jsp" data-membership-required="0" class="wsite-menu-item">
		租房
	</a>
	
</li>
<li id="active" class="wsite-menu-item-wrap">
	<a href="${pageContext.request.contextPath}/views/contact.jsp" class="wsite-menu-item">
		联系我们
	</a>
	
</li>

<li id="pg217308836783333756" class="wsite-menu-item-wrap">
	<a href="${pageContext.request.contextPath}/views/flygroup/initgroup.jsp" data-membership-required="0" class="wsite-menu-item">
		发起组团
	</a>
	
</li>


</ul>
</div>
        </div><!-- end container -->
    </div><!-- end header-wrap -->  

    <div id="main-wrap">
        <div class="container">
   			<div id='wsite-content' class='wsite-elements wsite-not-footer'>
<div>
	<div class="wsite-multicol">
		<div class="wsite-multicol-table-wrap" style="margin:0 -20px;">
	
			<table class="wsite-multicol-table" border=1>
				<tbody class="wsite-multicol-tbody">
				<tr class="wsite-multicol-tr">
		
								
							<td >

							
							<font size="5">司机姓名</font>
							</td>
							
							<td>
							<font style="font-weight: normal;" size="4">目的城市</font>
							</td>
							<td>
							<font style="font-weight: normal;" size="4">目的学校</font>
							</td>
							
							<td>
							<font style="font-weight: normal;" size="4">报价</font>
							</td>
							<td width=25%>
							<font style="font-weight: normal;" size="4" >状态</font>
							</td>
							<td>
							<font style="font-weight: normal;" size="4">操作</font>
							</td>
			
					</tr>
				<c:forEach var="item" items="${rows}" varStatus="status"> 
				
					<tr class="wsite-multicol-tr">
							
								
							<td>


							<font size="5">${item.driverId}</font>
							</td>
							
							<td>
							<font style="font-weight: normal;" size="4">${item.receptionCity}</font>
							</td>
							<td>
							<font style="font-weight: normal;" size="4">${item.receptionSchool}</font>
							</td>
							
							<td>
							<c:if test="${item.reviewProcessId eq 0}">
							${item.bookPrice}
							</c:if>
							<c:if test="${item.reviewProcessId eq 1}">
							${item.bookPrice}
							</c:if>
							<c:if test="${item.reviewProcessId eq 2}">
							<font style="font-weight: normal;" size="4"><input type="text" name="bookPrice" id="bookPrice-${item.id}" size="4" value="${item.bookPrice}"/>  </font>
							</c:if>
							<c:if test="${item.reviewProcessId eq 3}">
							${item.bookPrice}
							</c:if>
							<c:if test="${item.reviewProcessId eq 4}">
							${item.bookPrice}
							</c:if>
							<c:if test="${item.reviewProcessId eq 5}">
							${item.bookPrice}
							</c:if>
							
				
					
							</td>
							<td>
							<c:if test="${item.reviewProcessId eq 0}">
							等待对方回应
							</c:if>
							<c:if test="${item.reviewProcessId eq 1}">
							对方同意报价
							</c:if>
							<c:if test="${item.reviewProcessId eq 2}">
							对方否决报价
							</c:if>
							<c:if test="${item.reviewProcessId eq 3}">
							支付成功
							</c:if>
							<c:if test="${item.reviewProcessId eq 4}">
							等待接机
							</c:if>
							<c:if test="${item.reviewProcessId eq 5}">
							接机成功
							</c:if>
							
  
					
							</td>	
							<td>
						<c:if test="${item.reviewProcessId eq 0}">
							
							</c:if>
							<c:if test="${item.reviewProcessId eq 1}">
							<form action="${pageContext.request.contextPath}/order/insertorder" method="GET" id="${item.id}">	
							<input type="hidden" name="status" id="status-${item.id}"/>	
							
				            <input type="hidden" name="receptionAirId" id="receptionAirId-${item.id}" value="${item.receptionAirId}"/>
				            <input type="hidden" name="bookPrice" id="bookPrice-${item.id}" value="${item.bookPrice}"/> 
				            <input type="hidden" name="driverId" id="driverId-${item.id}" value="${item.driverId}"/> 
				            <input type="hidden" name="bookId" id="bookId-${item.id}" value="${item.id}"/> 
				             <input type="hidden" name="userId" id="userId-${item.id}" value="${item.userId}"/> 
				             <input type="hidden" name="pickUpTime" id="pickUpTime-${item.id}" value="${item.pickUpTime}"/> 
							<font style="font-weight: small;" size="4"><a class='wsite-button' onclick="order(${item.id})"><span class='wsite-button-inner'>立即支付</span></a></font>
							</form>
							</c:if>
							<c:if test="${item.reviewProcessId eq 2}">
							<form action="${pageContext.request.contextPath}/bookdriver/updateuserbookdriver" method="GET" id="${item.id}">	
							<input type="hidden" name="status" id="status-${item.id}"/>	
							
				            <input type="hidden" name="reviewProcessId" id="reviewProcessId-${item.id}" value="${item.reviewProcessId}"/>
				            <input type="hidden" name="id" value="${item.id}"/> 
							<font style="font-weight: small;" size="4"><a class='wsite-button' onclick="check(${item.id},'-1')" ><span class='wsite-button-inner'>取消预约</span></a></font>
							<font style="font-weight: small;" size="4"><a class='wsite-button' onclick="check(${item.id},'1')"><span class='wsite-button-inner'>重新报价</span></a></font>
							</form>
							</c:if>
							<c:if test="${item.reviewProcessId eq 3}">
							<form action="${pageContext.request.contextPath}/bookdriver/updateuserbookdriver" method="GET" id="${item.id}">	
							<input type="hidden" name="status" id="status-${item.id}"/>		
				            <input type="hidden" name="reviewProcessId" id="reviewProcessId-${item.id}" value="${item.reviewProcessId}"/>
				            <input type="hidden" name="id" value="${item.id}"/> 
							<font style="font-weight: small;" size="4"><a class='wsite-button' onclick="check(${item.id},'4')" ><span class='wsite-button-inner'>等待接机</span></a></font>
</form>
							</c:if>
							<c:if test="${item.reviewProcessId eq 4}">
							<form action="${pageContext.request.contextPath}/bookdriver/updateuserbookdriver" method="GET" id="${item.id}">	
							<input type="hidden" name="status" id="status-${item.id}"/>		
				            <input type="hidden" name="reviewProcessId" id="reviewProcessId-${item.id}" value="${item.reviewProcessId}"/>
				            <input type="hidden" name="id" value="${item.id}"/> 
							<font style="font-weight: small;" size="4"><a class='wsite-button' onclick="check(${item.id},'5')" ><span class='wsite-button-inner'>接机成功</span></a></font>
							</form>
							</c:if>
							<c:if test="${item.reviewProcessId eq 5}">
							<form action="${pageContext.request.contextPath}/bookdriver/updateuserbookdriver" method="GET" id="${item.id}">	
							<input type="hidden" name="status" id="status-${item.id}"/>		
				            <input type="hidden" name="reviewProcessId" id="reviewProcessId-${item.id}" value="${item.reviewProcessId}"/>
				            <input type="hidden" name="id" value="${item.id}"/> 
							<font style="font-weight: small;" size="4"><a class='wsite-button' onclick="check(${item.id},'6')" ><span class='wsite-button-inner'>评论交易</span></a></font>
							</form>
							</c:if>

					
				
							
							
							</td>
							
				
					</tr>
					
					
					</c:forEach>
					
					
		</tbody>
	</table>
	</div>
</div>

</div>

<div class="wsite-spacer" style="height:11px;"></div>

</div>

        </div><!-- end container -->
    </div><!-- end main-wrap -->

    <div id="footer-wrap">
        <div class="container">
       		Create a <a target="_top" href="http://www.weebly.com/">free web site</a> with <a target="_top" href="http://www.weebly.com/" title="free web site">Weebly</a>
        </div><!-- end container -->
    </div><!-- end footer-wrap -->
	<!-- JavaScript -->
<!--[if gt IE 8]><!-->
	<script type="text/javascript" src="../../files/theme/jquery.jqtransform.js" ></script>
	<!--<![endif]-->
		<script language="javascript">
		jQuery(function() {
			var $ = jQuery;
			$('#main-wrap .wsite-form-radio-container').jqTransform();
			var navPosition = $('#nav').offset().top - 15;
			$(window).scroll(function(e) {
				if ( $(window).scrollTop() > navPosition) {
					$('#main-wrap').css({'margin-top': $('#header-wrap').outerHeight() + 'px'});
					$('#header-wrap').css({'position': 'fixed', 'top': (-navPosition) + 'px', 'z-index': '1'});
				} else {
					$('#header-wrap').css({'position': 'static'});
					$('#main-wrap').css({'margin-top': '0px'});
				}
			});
		});
	</script>

		
	</body>
</html>
