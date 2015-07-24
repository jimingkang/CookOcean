<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<a href="${pageContext.request.contextPath}/views/about.jsp" data-membership-required="0" class="wsite-menu-item">
		关于
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
<center>
<form action="${pageContext.request.contextPath}/flygroup/insertFlyGroup" method="POST" id="form-670088469665913026">
<div id="670088469665913026-form-parent" class="wsite-form-container" style="margin-top:10px;">
  <ul class="formlist" id="670088469665913026-form-list">
    <h2 class="wsite-content-title" style="text-align:center;">我要组团.</h2>



<div><div class="wsite-form-field" style="margin:5px 0px 5px 0px;">
				<label class="wsite-form-label" for="input-231513899216011631">团名 <span class="form-required">*</span></label>
				<div class="wsite-form-input-container">
					<input id="groupName" class="wsite-form-input wsite-input wsite-input-width-370px" type="text" name="groupName" />
				</div>
				<div id="instructions-231513899216011631" class="wsite-form-instructions" style="display:none;"></div>
			</div></div>

<div><div class="wsite-form-field" style="margin:5px 0px 5px 0px;">
				<label class="wsite-form-label" for="input-231513899216011631">录取学校 <span class="form-required">*</span></label>
				<div class="wsite-form-input-container">
					<input id="admissionSchool" class="wsite-form-input wsite-input wsite-input-width-370px" type="text" name="admissionSchool" />
				</div>
				<div id="instructions-231513899216011631" class="wsite-form-instructions" style="display:none;"></div>
			</div></div>
<div><div class="wsite-form-field" style="margin:5px 0px 5px 0px;">
				<label class="wsite-form-label" for="input-958708571261610907">联系方式（电子邮件，QQ） <span class="form-required">*</span></label>
				<div class="wsite-form-input-container">
					<input id="contactInformation" class="wsite-form-input wsite-input wsite-input-width-370px" type="text" name="contactInformation" />
				</div>
				<div id="instructions-958708571261610907" class="wsite-form-instructions" style="display:none;"></div>
			</div></div>

<div><div class="wsite-form-field" style="margin:5px 0px 5px 0px;">
				<label class="wsite-form-label" for="input-992233898609486851">报名截止日期(2015-07-28)<span class="form-required">*</span></label>
				<div class="wsite-form-input-container">
					<input id="expirationDate" class="wsite-form-input wsite-input wsite-input-width-370px" type="text" name="expirationDate" />
				</div>
				<div id="instructions-992233898609486851" class="wsite-form-instructions" style="display:none;"></div>
			</div></div>

			<div><div class="wsite-form-field" style="margin:5px 0px 5px 0px;">
				<label class="wsite-form-label" for="input-665279579287057622">航班号 <span class="form-required">*</span></label>
				<div class="wsite-form-input-container">
					<input id="flight" class="wsite-form-input wsite-input wsite-input-width-370px" name="flight" ></input>
				</div>
				<div id="instructions-665279579287057622" class="wsite-form-instructions" style="display:none;"></div>
			</div>
			</div>
			<div><div class="wsite-form-field" style="margin:5px 0px 5px 0px;">
				<label class="wsite-form-label" for="input-665279579287057622">出发机场 <span class="form-required">*</span></label>
				<div class="wsite-form-input-container">
					<input id="departAirport" class="wsite-form-input wsite-input wsite-input-width-370px" name="departAirport" ></input>
				</div>
				<div id="instructions-665279579287057622" class="wsite-form-instructions" style="display:none;"></div>
			</div>
			</div>
			<div><div class="wsite-form-field" style="margin:5px 0px 5px 0px;">
				<label class="wsite-form-label" for="input-665279579287057622">出发时间(格式2015-07-28 15:45:50)<span class="form-required">*</span></label>
				<div class="wsite-form-input-container">
					<input id="departTime" class="wsite-form-input wsite-input wsite-input-width-370px" name="departTime" value='2015-07-28 15:45:50'></input>
				</div>
				<div id="instructions-665279579287057622" class="wsite-form-instructions" style="display:none;"></div>
			</div>
			</div>
			
			<div><div class="wsite-form-field" style="margin:5px 0px 5px 0px;">
				<label class="wsite-form-label" for="input-665279579287057622">到达机场 <span class="form-required">*</span></label>
				<div class="wsite-form-input-container">
					<input id="arriveAirport" class="wsite-form-input wsite-input wsite-input-width-370px" name="arriveAirport" ></input>
				</div>
				<div id="instructions-665279579287057622" class="wsite-form-instructions" style="display:none;"></div>
			</div>
			</div>
			<div><div class="wsite-form-field" style="margin:5px 0px 5px 0px;">
				<label class="wsite-form-label" for="input-665279579287057622">预计到达时间 (当地时间，格式2015-07-28 15:45:50)<span class="form-required">*</span></label>
				<div class="wsite-form-input-container">
					<input id="arriveTime" class="wsite-form-input wsite-input wsite-input-width-370px" name="arriveTime" value='2015-07-28 15:45:50' ></input>
				</div>
				<div id="instructions-665279579287057622" class="wsite-form-instructions" style="display:none;"></div>
			</div>
			</div>
  </ul>
</div>
<div style="display:none; visibility:hidden;">
  <input type="text" name="wsite_subject" />
</div>
<div style="text-align:center; margin-top:10px; margin-bottom:10px;">
  <input type="hidden" name="form_version" value="2" />
  <input type="hidden" name="wsite_approved" id="wsite-approved" value="approved" />
  <input type="hidden" name="ucfid" value="670088469665913026" />
  <input type='submit' style='position:absolute;top:0;left:-9999px;width:1px;height:1px' /><a class='wsite-button' onclick="document.getElementById('form-670088469665913026').submit()"><span class='wsite-button-inner'>提交</span></a>
</div>
</form>
</center>

</div></div>

	       </div><!-- end container -->
	    </div><!-- end main-wrap -->

</body>
</html>