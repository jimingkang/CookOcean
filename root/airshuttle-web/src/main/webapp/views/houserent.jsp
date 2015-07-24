<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>HouseRent - fly the Ocean</title>


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
				"398593238625168252",
				"<li class=\"wsite-menu-item-wrap\"><a href=\"#\" data-membership-required=\"\" class=\"wsite-menu-item\">{{title}}<\/a><\/li>",
				'active',
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
	<body class="no-header-page  wsite-theme-light  wsite-page-houserent"><div id="header-wrap">
        <div class="container">
			<div id="logo"><span class="wsite-logo">

	<a href="">
	
	<span id="wsite-title">fly the Ocean</span>
	
	</a>

</span></div>
					<div id="nav"><ul class="wsite-menu-default"><li  class="wsite-menu-item-wrap">
	<a href="${pageContext.request.contextPath}/views/index.jsp" class="wsite-menu-item">
		接机
	</a>
	
</li>
<li id="active"class="wsite-menu-item-wrap">
	<a href="${pageContext.request.contextPath}/views/houserent.jsp" data-membership-required="0" class="wsite-menu-item">
		租房
	</a>
	
</li>
<li  class="wsite-menu-item-wrap">
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
<div><div class="wsite-multicol"><div class="wsite-multicol-table-wrap" style="margin:0 -20px;">
	<table class="wsite-multicol-table">
		<tbody class="wsite-multicol-tbody">
			<tr class="wsite-multicol-tr">
				<td class="wsite-multicol-col" style="width:50%; padding:0 20px;">
					
						

<div class="wsite-spacer" style="height:20px;"></div>

<h2 class="wsite-content-title" style="text-align:left;"><font size="6">Event Headline</font></h2>

<div class="paragraph" style="text-align:left;">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi.</div>

<div style="text-align:left;"><div style="height: 10px; overflow: hidden;"></div>
<a class="wsite-button wsite-button-small wsite-button-normal" href="javascript:;" >
<span class="wsite-button-inner">Register Now</span>
</a>
<div style="height: 10px; overflow: hidden;"></div></div>


					
				</td>				<td class="wsite-multicol-col" style="width:50%; padding:0 20px;">
					
						

<div><div class="wsite-image wsite-image-border-none " style="padding-top:0;padding-bottom:10px;margin-left:0;margin-right:0;text-align:center">
<a>
<img src="${pageContext.request.contextPath}/uploads/4/6/6/6/46660685/page-layouts-8023776_orig.jpeg" alt="Picture" style="width:auto;max-width:100%" />
</a>
<div style="display:block;font-size:90%"></div>
</div></div>


					
				</td>			</tr>
		</tbody>
	</table>
</div></div></div>

<div><div style="height: 40px; overflow: hidden; width: 100%;"></div>
<hr class="styled-hr" style="width:100%;"></hr>
<div style="height: 40px; overflow: hidden; width: 100%;"></div></div>

<div><div class="wsite-multicol"><div class="wsite-multicol-table-wrap" style="margin:0 -20px;">
	<table class="wsite-multicol-table">
		<tbody class="wsite-multicol-tbody">
			<tr class="wsite-multicol-tr">
				<td class="wsite-multicol-col" style="width:50%; padding:0 20px;">
					
						

<div class="wsite-map"><iframe allowtransparency="true" frameborder="0" scrolling="no" style="width: 100%; height: 250px; margin-top: 10px; margin-bottom: 15px;" src="http://www.weebly.com/weebly/apps/generateMap.php?map=google&elementid=652438282898532613&ineditor=0&control=3&width=auto&height=250px&overviewmap=0&scalecontrol=0&typecontrol=0&zoom=15&long=-122.418333&lat=37.775&domain=www&point=1&align=1&reseller=false"></iframe></div>


					
				</td>				<td class="wsite-multicol-col" style="width:50%; padding:0 20px;">
					
						

<h2 class="wsite-content-title" style="text-align:left;"><span style="font-weight: normal;"><font size="5">Location</font></span></h2>

<div class="paragraph" style="text-align:left;">Location Name<br /><span style="">1345 Main St</span><br /><span style="">San Francisco, CA</span><br /><span style=""><br /></span>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi.<span style=""><br /></span></div>


					
				</td>			</tr>
		</tbody>
	</table>
</div></div></div>

<div><div style="height: 40px; overflow: hidden; width: 100%;"></div>
<hr class="styled-hr" style="width:100%;"></hr>
<div style="height: 40px; overflow: hidden; width: 100%;"></div></div>

<h2 class="wsite-content-title" style="text-align:left;"><span style="font-weight: normal;">Gallery</span></h2>

<div><div style="height: 20px; overflow: hidden;"></div>
				<div id='240261691802475265-gallery' class='imageGallery' style='line-height: 0px; padding: 0; margin: 0'>
<div id='240261691802475265-imageContainer0' style='float:left;width:24.95%;margin:0;'>
<div id='240261691802475265-insideImageContainer0' style='position:relative;margin:5px;'>
<div class='galleryImageHolder' style='position:relative; width:100%; padding:0 0 75%;overflow:hidden;'>
<div class='galleryInnerImageHolder'><a href='${pageContext.request.contextPath}/uploads/4/6/6/6/46660685/page-layouts-6896209_orig.jpeg' rel='lightbox[gallery240261691802475265]' onclick='if (!window.lightboxLoaded) return false'><img src='${pageContext.request.contextPath}/uploads/4/6/6/6/46660685/page-layouts-6896209.jpeg' class='galleryImage' _width='400' _height='266' style='position:absolute;border:0;width:112.78%;top:0%;left:-6.39%' /></a></div></div></div></div><div id='240261691802475265-imageContainer1' style='float:left;width:24.95%;margin:0;'><div id='240261691802475265-insideImageContainer1' style='position:relative;margin:5px;'><div class='galleryImageHolder' style='position:relative; width:100%; padding:0 0 75%;overflow:hidden;'><div class='galleryInnerImageHolder'><a href='${pageContext.request.contextPath}/uploads/4/6/6/6/46660685/page-layouts-6983713_orig.jpeg' rel='lightbox[gallery240261691802475265]' onclick='if (!window.lightboxLoaded) return false'><img src='${pageContext.request.contextPath}/uploads/4/6/6/6/46660685/page-layouts-6983713.jpeg' class='galleryImage' _width='400' _height='266' style='position:absolute;border:0;width:112.78%;top:0%;left:-6.39%' /></a></div></div></div></div><div id='240261691802475265-imageContainer2' style='float:left;width:24.95%;margin:0;'><div id='240261691802475265-insideImageContainer2' style='position:relative;margin:5px;'><div class='galleryImageHolder' style='position:relative; width:100%; padding:0 0 75%;overflow:hidden;'><div class='galleryInnerImageHolder'><a href='${pageContext.request.contextPath}/uploads/4/6/6/6/46660685/page-layouts-2107450_orig.jpeg' rel='lightbox[gallery240261691802475265]' onclick='if (!window.lightboxLoaded) return false'><img src='${pageContext.request.contextPath}/uploads/4/6/6/6/46660685/page-layouts-2107450.jpeg' class='galleryImage' _width='400' _height='266' style='position:absolute;border:0;width:112.78%;top:0%;left:-6.39%' /></a></div></div></div></div><div id='240261691802475265-imageContainer3' style='float:left;width:24.95%;margin:0;'><div id='240261691802475265-insideImageContainer3' style='position:relative;margin:5px;'><div class='galleryImageHolder' style='position:relative; width:100%; padding:0 0 75%;overflow:hidden;'><div class='galleryInnerImageHolder'><a href='${pageContext.request.contextPath}/uploads/4/6/6/6/46660685/page-layouts-2577492_orig.jpeg' rel='lightbox[gallery240261691802475265]' onclick='if (!window.lightboxLoaded) return false'><img src='${pageContext.request.contextPath}/uploads/4/6/6/6/46660685/page-layouts-2577492.jpeg' class='galleryImage' _width='400' _height='266' style='position:absolute;border:0;width:112.78%;top:0%;left:-6.39%' /></a></div></div></div></div><div id='240261691802475265-imageContainer4' style='float:left;width:24.95%;margin:0;'><div id='240261691802475265-insideImageContainer4' style='position:relative;margin:5px;'><div class='galleryImageHolder' style='position:relative; width:100%; padding:0 0 75%;overflow:hidden;'><div class='galleryInnerImageHolder'><a href='uploads/4/6/6/6/46660685/page-layouts-4544965_orig.jpeg' rel='lightbox[gallery240261691802475265]' onclick='if (!window.lightboxLoaded) return false'>
<img src='${pageContext.request.contextPath}/uploads/4/6/6/6/46660685/page-layouts-4544965.jpeg' class='galleryImage' _width='400' _height='266' style='position:absolute;border:0;width:112.78%;top:0%;left:-6.39%' /></a></div></div></div></div><div id='240261691802475265-imageContainer5' style='float:left;width:24.95%;margin:0;'><div id='240261691802475265-insideImageContainer5' style='position:relative;margin:5px;'><div class='galleryImageHolder' style='position:relative; width:100%; padding:0 0 75%;overflow:hidden;'><div class='galleryInnerImageHolder'><a href='${pageContext.request.contextPath}/uploads/4/6/6/6/46660685/page-layouts-1240611_orig.jpeg' rel='lightbox[gallery240261691802475265]' onclick='if (!window.lightboxLoaded) return false'>
<img src='${pageContext.request.contextPath}/uploads/4/6/6/6/46660685/page-layouts-1240611.jpeg' class='galleryImage' _width='400' _height='266' style='position:absolute;border:0;width:112.78%;top:0%;left:-6.39%' /></a></div></div></div></div><div id='240261691802475265-imageContainer6' style='float:left;width:24.95%;margin:0;'><div id='240261691802475265-insideImageContainer6' style='position:relative;margin:5px;'><div class='galleryImageHolder' style='position:relative; width:100%; padding:0 0 75%;overflow:hidden;'><div class='galleryInnerImageHolder'><a href='${pageContext.request.contextPath}/uploads/4/6/6/6/46660685/page-layouts-6655981_orig.jpeg' rel='lightbox[gallery240261691802475265]' onclick='if (!window.lightboxLoaded) return false'><img src='${pageContext.request.contextPath}/uploads/4/6/6/6/46660685/page-layouts-6655981.jpeg' class='galleryImage' _width='400' _height='266' style='position:absolute;border:0;width:112.78%;top:0%;left:-6.39%' /></a></div></div></div></div><div id='240261691802475265-imageContainer7' style='float:left;width:24.95%;margin:0;'><div id='240261691802475265-insideImageContainer7' style='position:relative;margin:5px;'><div class='galleryImageHolder' style='position:relative; width:100%; padding:0 0 75%;overflow:hidden;'><div class='galleryInnerImageHolder'><a href='${pageContext.request.contextPath}/uploads/4/6/6/6/46660685/page-layouts-7659662_orig.jpeg' rel='lightbox[gallery240261691802475265]' onclick='if (!window.lightboxLoaded) return false'>
<img src='${pageContext.request.contextPath}/uploads/4/6/6/6/46660685/page-layouts-7659662.jpeg' class='galleryImage' _width='400' _height='266' style='position:absolute;border:0;width:112.78%;top:0%;left:-6.39%' /></a></div></div></div></div><span style='display: block; clear: both; height: 0px; overflow: hidden;'></span>
</div>

				<div style="height: 20px; overflow: hidden;"></div></div>

<div><div style="height: 40px; overflow: hidden; width: 100%;"></div>
<hr class="styled-hr" style="width:100%;"></hr>
<div style="height: 40px; overflow: hidden; width: 100%;"></div></div>

<div><div class="wsite-multicol"><div class="wsite-multicol-table-wrap" style="margin:0 -20px;">
	<table class="wsite-multicol-table">
		<tbody class="wsite-multicol-tbody">
			<tr class="wsite-multicol-tr">
				<td class="wsite-multicol-col" style="width:50%; padding:0 20px;">
					
						

<h2 class="wsite-content-title" style="text-align:left;"><span style="font-weight: normal;">Contact Us</span></h2>

<div style="text-align:left;"><div style="height:10px;overflow:hidden"></div>
<span class="wsite-social wsite-social-default"><a class='first-child wsite-social-item wsite-social-facebook' href='http://facebook.com' target='_blank'><span class='wsite-social-item-inner'></span></a><a class='wsite-social-item wsite-social-twitter' href='http://twitter.com' target='_blank'><span class='wsite-social-item-inner'></span></a><a class='wsite-social-item wsite-social-linkedin' href='http://linkedin.com' target='_blank'><span class='wsite-social-item-inner'></span></a><a class='last-child wsite-social-item wsite-social-mail' href='mailto:info@email.com' target='_blank'><span class='wsite-social-item-inner'></span></a></span>
<div style="height:10px;overflow:hidden"></div></div>

<div class="paragraph" style="text-align:left;">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi.</div>


					
				</td>				<td class="wsite-multicol-col" style="width:50%; padding:0 20px;">
					
						

<h2 class="wsite-content-title" style="text-align:left;"><span style="font-weight: normal;">Subscribe</span></h2>

<div>
<form enctype="multipart/form-data" action="http://www.weebly.com/weebly/apps/formSubmit.php" method="POST" id="form-602451405829814072">
<div id="602451405829814072-form-parent" class="wsite-form-container" style="margin-top:0px;">
  <ul class="formlist" id="602451405829814072-form-list">
    <div><div class="wsite-form-field" style="margin:5px 0px 0px 0px;">
				<label class="wsite-form-label" for="input-721898690835689926">Email <span class="form-required">*</span></label>
				<div class="wsite-form-input-container">
					<input id="input-721898690835689926" class="wsite-form-input wsite-input wsite-input-width-370px" type="text" name="_u721898690835689926" />
				</div>
				<div id="instructions-721898690835689926" class="wsite-form-instructions" style="display:none;"></div>
			</div></div>
  </ul>
</div>
<div style="display:none; visibility:hidden;">
  <input type="text" name="wsite_subject" />
</div>
<div style="text-align:left; margin-top:10px; margin-bottom:0px;">
  <input type="hidden" name="form_version" value="2" />
  <input type="hidden" name="wsite_approved" id="wsite-approved" value="approved" />
  <input type="hidden" name="ucfid" value="602451405829814072" />
  <input type='submit' style='position:absolute;top:0;left:-9999px;width:1px;height:1px' /><a class='wsite-button' onclick="document.getElementById('form-602451405829814072').submit()"><span class='wsite-button-inner'>Submit</span></a>
</div>
</form>


</div>


					
				</td>			</tr>
		</tbody>
	</table>
</div></div></div></div>

        </div><!-- end container -->
    </div><!-- end main-wrap -->

    <div id="footer-wrap">
        <div class="container">
       		Create a <a target="_top" href="http://www.weebly.com/">free web site</a> with <a target="_top" href="http://www.weebly.com/" title="free web site">Weebly</a>
        </div><!-- end container -->
    </div><!-- end footer-wrap -->
	<!-- JavaScript -->
<!--[if gt IE 8]><!-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/files/theme/jquery.jqtransform.js" ></script>
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
