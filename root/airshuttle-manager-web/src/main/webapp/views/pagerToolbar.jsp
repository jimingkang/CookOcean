<%@page language="java" contentType="text/html;charset=UTF-8"%>

<%@page import="com.topshare.airshuttle.common.QueryPager"%>
<%@page import="java.util.UUID"%>

<%String queryForm =request.getParameter("form");
 if(queryForm==null&&queryForm.trim().toString().equals("")){
 	out.print("初始化分页组件异常，参数form缺失!");
 }
 String pagerTextNum =UUID.randomUUID().toString();
 QueryPager pager = (QueryPager)request.getAttribute("pager");
 %>

<script type="text/javascript">
<!--
	var pager = {
		toPage:function(current,pformId){
			document.getElementById('pagerText_'+pformId).value = current;
			pager.doQuery(pformId);
		},
		nextPage:function(pformId){
			var pageText = document.getElementById('pagerText_'+pformId);
			pageText.value = parseInt(pageText.value) + 1;	
			pager.doQuery(pformId);
		},
		prePage:function(pformId){ 
			var pageText = document.getElementById('pagerText_'+pformId);
			pageText.value = parseInt(pageText.value) - 1;	
			pager.doQuery(pformId);
		},
		doQuery:function(pformId){
		    document.forms[pformId].submit();
		},
		checkInput:function(text,current,total){
			var exp = /^(\+|-)?(0|[1-9]\d*)(\.\d*[1-9])?$/;
			if(!exp.test(text.value)){
				text.value = current;
			}else if(parseInt(text.value)<1){
				text.value = current;
			}else if(parseInt(text.value)>total){
				text.value = current;
			}
		},
		keyEnter:function(e,pformId){
			e=e||event;
			if(e.keyCode==13){
				pager.doQuery(pformId);
			}
		}
	};
//--> 
</script>
<div class="page">
<%if(pager.hasPrePage()){%><a href="#" onclick="javascript:pager.prePage('<%=queryForm%>');"><span>上一页</span></a><% }else{out.print("<span class=\"disabled\">上一页</span>");}%>
&nbsp;&nbsp; 
<%
	Integer pageTotal = pager.getPageTotal();
	if(pageTotal!=null && pageTotal > 0 ){
		int total = pager.getPageTotal();
		int current = pager.getCurrent();
		
		if(total==1){
			out.print("<span class=\"current\">"+(1)+"</span>&nbsp;&nbsp;");
		}else{
		
			if(current!=1){
				out.print("<a href='#' onclick='javascript:pager.toPage(1,\""+queryForm+"\");'><span>1</span></a>");
			}else{
				out.print("<span class=\"current\">"+(1)+"</span>&nbsp;&nbsp;");
			}
			
			if(current-3<=1){
				int range = 6;
				if(total<=6){
					range = total;
				}
				if(total!=2){
					for(int i=2;i<=range;i++){  
						if(total != i){
							out.print("&nbsp;&nbsp;<a href='#' onclick='javascript:pager.toPage("+i+",\""+queryForm+"\");'>"+i+"</a>");
						}
					}
					out.print("...");
				}
				
			}else if(current+3>=total){
				out.print("..."); 
				for(int i=total-4;i<total;i++){
					if(i==current){
						out.print("<span class=\"current\">"+(i)+"</span>&nbsp;&nbsp;");
					}else{
						out.print("<a href='#' onclick='javascript:pager.toPage("+i+",\""+queryForm+"\");'><span>"+i+"</span></a>&nbsp;&nbsp;");
					}
				}
			}else{
				out.print("...");
				out.print("<a href='#' onclick='javascript:pager.toPage("+(current-2)+",\""+queryForm+"\");'><span>"+(current-2)+"</span></a>&nbsp;&nbsp;");
				out.print("<a href='#' onclick='javascript:pager.toPage("+(current-1)+",\""+queryForm+"\");'><span>"+(current-1)+"</span></a>&nbsp;&nbsp;");
				out.print("<span class=\"current\">"+(current)+"</span>&nbsp;&nbsp;");
				out.print("<a href='#' onclick='javascript:pager.toPage("+(current+1)+",\""+queryForm+"\");'><span>"+(current+1)+"</span></a>&nbsp;&nbsp;");
				out.print("<a href='#' onclick='javascript:pager.toPage("+(current+2)+",\""+queryForm+"\");'><span>"+(current+2)+"</span></a>&nbsp;&nbsp;");
				out.print("..."); 
			}
			
			if(current!=total){
				out.print("<a href='#' onclick='javascript:pager.toPage("+total+",\""+queryForm+"\");'><span>"+total+"</span></a>");
			}else{
				out.print("<span class=\"current\">"+(total)+"</span>&nbsp;&nbsp;");
			}
		}
	}
%>
<%if(pager.hasNextPage()){%><a href="#" onclick="javascript:pager.nextPage('<%=queryForm%>');"><span>下一页</span></a><% }else{out.print("<span class=\"disabled\">下一页</span>");}%>
&nbsp;&nbsp;
<span class="text">
转到
<input style="width: 38px; border: 1px solid ;" class="num" onkeyup="pager.checkInput(this,'<%=pager.getCurrent()%>','<%=pager.getPageTotal()%>');" onblur="pager.checkInput(this,'<%=pager.getCurrent()%>','<%=pager.getPageTotal()%>');" id="pagerText_<%=queryForm%>" name="pager.current" value="<%=pager.getCurrent()%>" onkeydown="pager.keyEnter(event,'<%=queryForm%>');" />
页
</span> 
<button onclick="pager.doQuery('<%=queryForm%>');">确定</button>
</div>
