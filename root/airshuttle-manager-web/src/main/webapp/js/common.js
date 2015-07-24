
//定义日期
var _today = new Date();
var TODAY = new Date(_today.getFullYear(),_today.getMonth(), _today.getDate());
var YESTERDAY = new Date(_today.getFullYear(),_today.getMonth(), _today.getDate());
YESTERDAY.setDate(TODAY.getDate()-1);
var THIS_WEEK = new Date(_today.getFullYear(),_today.getMonth(), _today.getDate());
THIS_WEEK.setDate(TODAY.getDate()-TODAY.getDay());
var THIS_MONTH = new Date(_today.getFullYear(),_today.getMonth(), 1);
var MONTH_STR = ((YESTERDAY.getMonth()+1)<10)?"0"+(YESTERDAY.getMonth()+1):(YESTERDAY.getMonth()+1);
var DAY_STR = (YESTERDAY.getDate()<10)?"0"+YESTERDAY.getDate():YESTERDAY.getDate();
var YESTERDAY_STR = YESTERDAY.getFullYear() + '-' + MONTH_STR + '-' + DAY_STR;
var THIS_WEEK_STR = THIS_WEEK.getFullYear() + '-' + (THIS_WEEK.getMonth()+1) + '-' + THIS_WEEK.getDate();
var THIS_MONTH_STR = THIS_MONTH.getFullYear() + '-' + (THIS_MONTH.getMonth()+1) + '-' + THIS_MONTH.getDate();
var TODAY_STR = TODAY.getFullYear() + '-' + (((TODAY.getMonth()+1)<10)?"0"+(TODAY.getMonth()+1):(TODAY.getMonth()+1)) + '-' + ((TODAY.getDate()<10)?"0"+TODAY.getDate():TODAY.getDate());
var GPS_SHOW_URL = 'http://172.16.16.84:8080/eroad/html/dm/dm.html';
                  //当前日期    

var nowMonth = _today.getMonth();           //当前月    
var nowYear = _today.getYear();             //当前年    
nowYear += (nowYear < 2000) ? 1900 : 0;  //   
 
var lastMonthDate = new Date();  //上月日期 
lastMonthDate.setDate(1); 
lastMonthDate.setMonth(lastMonthDate.getMonth()-1); 
var lastYear = lastMonthDate.getYear(); 
var lastMonth = lastMonthDate.getMonth();  

function gotoMenu(obj,title,url){
	if($(obj).attr("class")!="selected"){
		switchSubMenu(obj);
	}
	addCurTab(title,url);
}


var CITY = [{'id': '',
	         'name':'请选择'},
            {'id': '330100',
			'name':'杭州市'},
			{'id': '330200',
			'name':'宁波市'},
			{'id': '330300',
			 'name':'温州市'},
			{'id': '330400',
			 'name':'嘉兴市'},
			{'id': '330500',
			'name':'绍兴市'},
			{'id': '330600',
			'name':'温州市'},
			{'id': '330700',
			'name':'金华市'},
			{'id': '330800',
			'name':'衢州市'},
			{'id': '330900',
			'name':'舟山市'},
			{'id': '331000',
			'name':'台州市'},
			{'id': '331100',
			'name':'丽水市'}
			];

function initMain() {
	$(".left").height($(document).height()-120);	
	$(".right").height($(document).height()-120);
	var righWidth=$(document).width()-$(".left").width()-25;
	$(".right").width(righWidth<760? 760:righWidth);
}

function resizeMain() {
	initMain();
	
	$('#tabs').tabs('resize');
}

//改变表格宽高
function resizeForm(){
    $('#tableContent').datagrid('resize',{  
          height:$(window).height()-$("#queryForm").height()-10,
          width:$(window).width()
    });
}

function switchSubMenu(obj){
	closeAllTabs(); 
	$("#nav ul li ul li.selected ").attr("class","");
	$(obj).attr("class","selected");
}


function closeAllTabs(){
	var tabs = $("#tabs").tabs("tabs");
	var length = tabs.length;
	for(var i = 0; i < length; i++) {
	    var onetab = tabs[0];
	    var title = onetab.panel('options').tab.text();
	    $("#tabs").tabs("close", title);
	}   
}

function addCurTab(title, href) {
    var tt = $('#tabs');
    if (tt.tabs('exists', title)) {
        tt.tabs('select', title);
        tt.tabs('update',{
        	tab: tt.tabs('getSelected'),
        	options: {
        		content:"<iframe width='100%' height='100%'  frameborder='0' scrolling='auto'  src='"+href+"'></iframe>"
        	}
        	
        });
    } else {
        tt.tabs('add', {
            title: title,
            closable: true,
            content:"<iframe width='100%' height='100%'   frameborder='0' style='overflow-x:hidden'  src='"+href+"'></iframe>"
        });
    }
}


function addTab(title, href) {
    var tt = parent.$('#tabs');
    if (tt.tabs('exists', title)) {
        tt.tabs('select', title);
        tt.tabs('update',{
        	tab: tt.tabs('getSelected'),
        	options: {
        		content:"<iframe width='100%' height='100%' frameborder='0' scrolling='auto'  src='"+href+"'></iframe>"
        	}
        	
        });
    } else {
        tt.tabs('add', {
            title: title,
            closable: true,
            content:"<iframe width='100%' height='100%' frameborder='0' scrolling='auto'  src='"+href+"'></iframe>"
        });
    }
}

function closeTab(title){
	var tab = parent.$('#tabs').tabs('getSelected');
	var index = parent.$('#tabs').tabs('getTabIndex',tab);
    parent.$('#tabs').tabs('close',index);
}

function closeTabByTitle(title){
    parent.$('#tabs').tabs('close',title);
}

function createFormAndSubmitAbnormal(columns,params,href){
	var colspanString="";
	var titleString = "";
	var fieldString = "";
	var columnsLength = columns.columns.length;
	for(var m=0;m<columnsLength;m++){
		var num = columns.columns[m].length;
		var col = columns.columns[m];
		
		for(var i=0;i<col.length;i++){
			if(col[i].title=="操作"||col[i].title=="选择"){
				num = num-1;
			}else{
				if(col[i].hidden==true){
				}else{
					if(i!=num-1){
						titleString+=col[i].title+",";
						if(col[i].colspan!=""&&col[i].colspan!=undefined){
							colspanString+=col[i].colspan+",";	
						}
						fieldString+=col[i].field+",";	
					}else{
						titleString+=col[i].title;
						if(col[i].colspan!=""&&col[i].colspan!=undefined){
							colspanString+=col[i].colspan;
						}
			            fieldString+=col[i].field;	
					}
				}
			}
		 } 
		if(m!=columnsLength-1){
			titleString+="-";
			colspanString+="-";	
            fieldString+="-";			
		}
		
	}
	
    var form = $('<form></form>');
    form.attr('action', href);
    form.attr('method', 'post');
    $('body').append(form);
    for(var prop in params){
        var formInput = $('<input type="text"/>');
        formInput.attr('name', prop);
        formInput.attr('value',params[prop]);
        form.append(formInput);
    }
    
    var formInputField = $('<input type="text"/>');
    formInputField.attr('name', "fieldString");
    formInputField.attr('value',fieldString);
    form.append(formInputField);
    
    var formInputTitle = $('<input type="text"/>');
    formInputTitle.attr('name', "titleString");
    formInputTitle.attr('value',titleString);
    form.append(formInputTitle);
    
    var formInputTitle = $('<input type="text"/>');
    formInputTitle.attr('name', "colspanString");
    formInputTitle.attr('value',colspanString);
    form.append(formInputTitle);
    // 提交表单
    form.submit();
    form.remove();
}

function createFormAndSubmit(columns,params,href){
	
	var titleString = "";
	var fieldString = "";
	var num = columns.length;
	for(var i=0;i<columns.length;i++){
		if(columns[i].title=="操作"||columns[i].title=="选择"){
			num = num-1;
		}else{
			if(columns[i].hidden==true){
			}else{
				if(i!=num-1){
					titleString+=columns[i].title+",";
		            fieldString+=columns[i].field+",";			
				}else{
					titleString+=columns[i].title;
		            fieldString+=columns[i].field;	
				}
			}
		}
	} 
    var form = $('<form></form>');
    form.attr('action', href);
    form.attr('method', 'post');
    $('body').append(form);
    for(var prop in params){
        var formInput = $('<input type="text"/>');
        formInput.attr('name', prop);
        formInput.attr('value',params[prop]);
        form.append(formInput);
    }
    
    var formInputField = $('<input type="text"/>');
    formInputField.attr('name', "fieldString");
    formInputField.attr('value',fieldString);
    form.append(formInputField);
    
    var formInputTitle = $('<input type="text"/>');
    formInputTitle.attr('name', "titleString");
    formInputTitle.attr('value',titleString);
    form.append(formInputTitle);
    // 提交表单
    form.submit();
    form.remove();
}

//判断输入的日期是否正确
function CheckDate(INDate){ 
	if (INDate==""){
		return true;
	}
	if(INDate.indexOf('-',0)!=-1)
	{
		separate="-";
    }
	else{	
	    return true;		
	}
	area=INDate.indexOf(separate,0);
	//获取年份
	subYY=INDate.substr(0,area);
	if(isNaN(subYY) || subYY<=0){
		return true;
	}		
	//转换月份
	subMM=INDate.substr(area+1,INDate.indexOf(separate,area+1)-(area+1));
	if(isNaN(subMM) || subMM<=0){
		return true;
	}
	if(subMM.length<2){
		subMM="0"+subMM;
	}
	//转换日
	area=INDate.lastIndexOf(separate);
	subDD=INDate.substr(area+1,INDate.length-area-1);
	if(isNaN(subDD) || subDD<=0){
		return true;
	}
	if(eval(subDD)<10){
		subDD="0"+eval(subDD);
	}
	NewDate=subYY+"-"+subMM+"-"+subDD;
	if(NewDate.length!=10){
		return true;
	}
    if(NewDate.substr(4,1)!="-"){
    	return true;
    }
    if(NewDate.substr(7,1)!="-"){
    	return true;
    }
	var MM=NewDate.substr(5,2);
	var DD=NewDate.substr(8,2);
	if((subYY%4==0 && subYY%100!=0)||subYY%400==0){ //判断是否为闰年
		if(parseInt(MM)==2){
			if(DD>29){
				return true;
			}
		}
	}else{
		if(parseInt(MM)==2){
			if(DD>28){
				return true;
			}
		}	
	}
	var mm=new Array(1,3,5,7,8,10,12); //判断每月中的最大天数
	for(var i=0;i< mm.length;i++){
		if (parseInt(MM) == mm[i]){
			if(parseInt(DD)>31){
				return true;
			}else{
				return false;
			}
		}
	}
   if(parseInt(DD)>30){
	   return true;
   }
   if(parseInt(MM)>12){
	   return true;
   }
   return false;
} 

//判断datagrid中是否有选项被选中
//tableId datagrid table的id  
function checkSelectOrNot(tableId){
	//判断是否有异常被选中
	var selRows = $("#"+tableId).datagrid("getSelections");
	var selLen = selRows.length;
	if(selLen<1){
		return false;
	}else{
		return true;
	}
}

//行政区划代码的控制
function renderSubdivision(ctx,orgaType,orgaDistrictCode,$city,$country) {
	//省级机构
	if(orgaDistrictCode.substr(2) == '0000'){
		$city.combobox({
			valueField : 'id',
			textField : 'name',
			editable:false,
			data : CITY,
			onSelect : function(rec) {
				var url = ctx+'/common/area/getCity?parentId='
				+ rec.id;
				$country.combobox('clear');
				$country.combobox('reload', url);
			}
		});
		$country.combobox({
			valueField : 'id',
			textField : 'name'
		});
	//市级机构
	}else if(orgaDistrictCode.substr(4) == '00'){
		$city.combobox({
			valueField : 'id',
			textField : 'name',
			editable:false,
			data : CITY,
			value : orgaDistrictCode,
			readonly : true
		});
		$country.combobox({
			valueField : 'id',
			textField : 'name',
			editable:false,
			url : ctx+'/common/area/getCity?parentId='+orgaDistrictCode
		});
	}else{
//	case '县级机构':
		var cityCode = orgaDistrictCode.substr(0, 4) + '00';
		$city.combobox({
			valueField : 'id',
			textField : 'name',
			editable:false,
			data : CITY,
			value : cityCode,
			readonly : true
		});
		$country.combobox({
			valueField : 'id',
			textField : 'name',
			editable:false,
			url : ctx+'/common/area/getCity?parentId=' + cityCode,
			value : orgaDistrictCode,
			readonly : true
		});
	}
}

//行政区划代码的控制
	function selectArea(ctx,orgaType,orgaDistrictCode,$city,$country) {
		//省级机构
		if(orgaDistrictCode.substr(2) == '0000'){
			$city.combobox({
				valueField : 'id',
				textField : 'name',
				editable:false,
				data : CITY,
				onSelect : function(rec) {
					var url = ctx+'/common/area/getCity?parentId='
					+ rec.id;
					$country.combobox('clear');
					$country.combobox('reload', url);
				}
			});
			$country.combobox({
				valueField : 'id',
				textField : 'name'
			});
		//市级机构
		}else if(orgaDistrictCode.substr(4) == '00'){
			$city.combobox({
				valueField : 'id',
				textField : 'name',
				editable:false,
				data : CITY,
				//value : orgaDistrictCode,
				onSelect : function(rec) {
					var url = ctx+'/common/area/getCity?parentId='
					+ rec.id;
					$country.combobox('clear');
					$country.combobox('reload', url);
				}
			});
			$country.combobox({
				valueField : 'id',
				textField : 'name',
				editable:false,
				url : ctx+'/common/area/getCity?parentId='+orgaDistrictCode
			});
		}else{
//		case '县级机构':
			var cityCode = orgaDistrictCode.substr(0, 4) + '00';
			$city.combobox({
				valueField : 'id',
				textField : 'name',
				editable:false,
				data : CITY,
				//value : cityCode,
					onSelect : function(rec) {
					var url = ctx+'/common/area/getCity?parentId='
					+ rec.id;
					$country.combobox('clear');
					$country.combobox('reload', url);
				}
			});
			$country.combobox({
				valueField : 'id',
				textField : 'name',
				editable:false,
				//value : orgaDistrictCode,
				url : ctx+'/common/area/getCity?parentId=' + cityCode
			});
		}
	}

/**
 * 参数说明：
 * orgaId 当前所在用户ID
 * departmentType 部门类型 1为核查部门 2 稽查部门
 * subdivisionCode 所选问题所在的行政区划代码
 * ifCC 是否是抄送部门 0  不是  1 是
 * */
function generateDepartmentInfo($combotreeObject,ctx,orgaId,departmentType,subdivisionCode,ifCC){
	
	if(departmentType!=''){
		$combotreeObject.combotree({
			url:ctx+'/organization/showTree?id='+orgaId+'&departmentType='+departmentType+'&districtCode='+subdivisionCode+'&ifCC='+ifCC,
//			url:ctx+'/organization/showTree',
//			data:{id:orgaId,departmentType:departmentType,districtCode:subdivisionCode},
			required:true,
			onBeforeExpand:function(node,param){
				var ary=node.id.split(",");
				$combotreeObject.combotree("tree").tree('options').url =ctx+"/organization/showTree?id="+ary[0]+'&departmentType='+departmentType+'&districtCode='+subdivisionCode+'&ifCC='+ifCC;
			},
			onSelect:function(node){
				$combotreeObject.val(node.id);
			}
		});
	}
	
	if(departmentType==''){
		$combotreeObject.combotree({
			url:ctx+'/organization/showTreess?id='+orgaId,
			required:true,
			onBeforeExpand:function(node,param){
				var ary=node.id.split(",");
				$combotreeObject.combotree("tree").tree('options').url =ctx+"/organization/showTreess?id="+ary[0];
			},
			onSelect:function(node){
				$combotreeObject.val(node.id);
			}
		});
	}
}


function showdate(n){
	var uom = new Date(new Date()-0+n*86400000);
	var month = uom.getMonth()+1;
	var day = uom.getDate();
	if(month<10){
		month = "0"+month;
	}
	if(day<10){
		dd = "0"+uom.getDate();
	}
	//uom = uom.getFullYear() + "-" + (uom.getMonth()+1) + "-" + uom.getDate();
	uom = uom.getFullYear() + "-" + month + "-" + day;
	return uom;
} 

function getNextDay(date) {
	var year = date.split("-");
	var nextDay = new Date(year[0],year[1]-1, year[2]);
	nextDay.setDate(nextDay.getDate()+1);
	var month = nextDay.getMonth()+1;
	var day = nextDay.getDate();
	if(month<10){
		month = "0"+month;
	}
	if(day<10){
		day = "0"+day;
	}
	return nextDay.getFullYear() + '-' + month+ '-' + day;
}

function getPreviousDate(date){
	var year = date.split("-");
	var previousDay = new Date(year[0],year[1]-1, year[2]);
	previousDay.setDate(previousDay.getDate()-1);
	var month = previousDay.getMonth()+1;
	var day = previousDay.getDate();
	if(month<10){
		month = "0"+month;
	}
	if(day<10){
		day = "0"+day;
	}
	return previousDay.getFullYear() + '-' +month+ '-' + day;
}

function transforDateToYearMonthDay(date){
	var year = date.split("-");
	//var time = year[0]+"年"+year[1]+"月"+year[2]+"日";
	var time = year[0]+"-"+year[1]+"-"+year[2]+"";
	return time;
}

//将日期字符串转化为日期Date类型
function formatDate(time){ 
	var time1 = time.split("-");
	var date;
	if(time1.length==3){ 
		date=new Date(time1[0],(time1[1]-1),time1[2],0,0); 
	}else if(time1.length==2){ 
	    date =new Date(time1[0],(time1[1]-1),0,0,0); 
	}else{ 
		date =new Date(time1[0],0,0,0,0); 
	} 
	return date; 
} 

//将开始日期和结束日期设为可用
function ableDate(beginDate,endDate){
    $('#'+beginDate).datebox({
    	disabled:false
    });
    $('#'+endDate).datebox({
    	disabled:false
    });
}

//将开始日期和结束日期设为不可用
function disableDate(beginDate,endDate){
	$('#'+beginDate).datebox({
    	disabled:true
    });
	$('#'+beginDate).datebox('setValue', '');
    $('#'+endDate).datebox({
    	disabled:true
    });
    $('#'+endDate).datebox('setValue', '');
}
   
function choiceDate(date){
	if(date=="昨天"){
   		 startDate =YESTERDAY_STR;
   		 endDate=TODAY_STR;
   	}else if(date=="最近7天"){
   		 startDate =showdate(-7);
   		 endDate=TODAY_STR;
   			 //TODAY_STR;
   	}else if(date=="最近30天"){
   		 startDate =showdate(-30);
   		 endDate=TODAY_STR;
   	}else if(date=="统计区间"){
   		 startDate=$("#beginDate").combobox("getValue");
   		 var endDateStr = $("#endDate").combobox("getValue");
   		 if(startDate==''||endDateStr==''){
   			 $.messager.alert("提示信息","请选择统计区间的起始时间");
   			 return;
   		 }
   		 endDate= getNextDay(endDateStr);
   	}else{
   		 startDate =YESTERDAY_STR;
   		 endDate=getNextDay(TODAY_STR);
   	}
	return startDate+"|"+endDate;
}


//格式化日期：yyyy-MM-dd    
function formatDateYYYYMMDD(date) {     
    var myyear = date.getFullYear();    
    var mymonth = date.getMonth()+1;    
    var myweekday = date.getDate();     
        
    if(mymonth < 10){    
        mymonth = "0" + mymonth;    
    }     
    if(myweekday < 10){    
        myweekday = "0" + myweekday;    
    }    
    return (myyear+"-"+mymonth + "-" + myweekday);     
}      

//获得某月的天数    
function getMonthDays(myMonth){    
    var monthStartDate = new Date(nowYear, myMonth, 1);     
    var monthEndDate = new Date(nowYear, myMonth + 1, 1);     
    var  days =(monthEndDate-monthStartDate)/(1000*60*60*24);     
    return   days;     
}     

//获得上月开始时间 
function getLastMonthStartDate(){ 
    var lastMonthStartDate = new Date(nowYear, lastMonth, 1); 
    return formatDateYYYYMMDD(lastMonthStartDate);   
} 
 
//获得上月结束时间 
function getLastMonthEndDate(){ 
    var lastMonthEndDate = new Date(nowYear, lastMonth, getMonthDays(lastMonth)); 
    return formatDateYYYYMMDD(lastMonthEndDate);   
}  

//开始时间大于结束时间
function compareDay(a,b){
	var d1=new Date(a);
	var d2=new Date(b);
	if(d1.getTime()-d2.getTime()>0){
		$.messager.alert("提示信息","开始时间不能大于结束时间，请重新选择");
		return -1;
	}
}

function reportCheckDay(startMonth,endMonth,startDay,endDay,$startDay,$endDay,startString,endString,judgeString){
	if(startDay==undefined||startDay==""||startDay<1||startDay>28){
		$.messager.alert("提示信息",startString,"info",function(){
			$startDay.focus();
		});
		return false;
	}
	else if(endDay==undefined||endDay==""||endDay<1||endDay>28){
		$.messager.alert("提示信息",endString,"info",function(){
			$endDay.focus();
		});
		return false;
	}
	if(startMonth==endMonth){
		if(startDay>endDay){
			$.messager.alert("提示信息",judgeString,"info",function(){
				$startDay.focus();
			});
			return false;
		}
	}
	return true;
}

function reportCheckMonth(biaoqianString,startMonth,endMonth,$startMonth,$endMonth,startString,endString,judgeString){
	var biaoqian=parseInt(biaoqianString);
	if(startMonth==undefined||startMonth==""||startMonth<1||startMonth>biaoqian){
		$.messager.alert("提示信息",startString,"info",function(){
			$startMonth.focus();
		});
		return false;
	}
	else if(endMonth==undefined||endMonth==""||endMonth<1||endMonth>biaoqian){
		$.messager.alert("提示信息",endString,"info",function(){
			$endMonth.focus();
		});
		return false;
	}
	else if(startMonth>endMonth){
		$.messager.alert("提示信息",judgeString,"info",function(){
			$startMonth.focus();
		});
		return false;
	}else{
		return true;
	}
}

/**
 * 不针对IE8 IE9
 * 获取文件大小，返回值单位： M
 * */
function getFileSize(fileId) { 
 	var target = document.getElementById(fileId);
    var fileSize = target.files[0].size;       
      
    var size = fileSize/1048576;    
       
    return size;  
 }


