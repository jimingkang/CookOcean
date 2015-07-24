var target = "";

function skipTarget(){
	location = target;
}

function getRandom(){
	return Math.round(Math.random()*10000);
}


function ajax_post(the_url, the_param, succ_callback) {
	$.ajax({
		type : 'post',
		url : the_url,
		data : the_param,
		cache : false,
		success : succ_callback
	});
}

function ajax_get(the_url, the_param, succ_callback) {
	$.ajax({
		type : 'get',
		url : the_url,
		data : the_param,
		cache : false,
		success : succ_callback
	});
}


function stringToDate(dateStr){
	var d = new Date();
	var date = dateStr.substring(0,10).split('-');
	
	d.setYear(date[0]);
	d.setMonth(date[1]-1);
	d.setDate(date[2]);
	
	var time = dateStr.substring(11,19).split(':');
	if(time != ""){
		d.setHours(time[0]);
		d.setMinutes(time[1]);
		d.setSeconds(time[2]);
	}
	return d;
}

function trim(str){
	return str.replace(/(^\s*)|(\s*$)/g, "");
}

function substring(str,start,end){
	return str.substr(start,end);
}

function M(id){
	return document.getElementById(id);
}

function closer(id){
	$('#'+id).hide();
}

function getLocalDate(time){
	var date = new Date(time);
    var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
    var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
    var hh = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
    var mm = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
    return date.getFullYear() + "-" + month + "-" + currentDate+" "+hh + ":" + mm;
}

function addDays(date,days){ 
	var nd = new Date(date); 
	   nd = nd.valueOf(); 
	   nd = nd + days * 24 * 60 * 60 * 1000; 
	   nd = new Date(nd); 
	return nd.format("yyyy-MM-dd"); 
} 

function addTime(days){ 
	var d = new Date(); 
	d.setTime(d.getTime() + days * 24 * 60 * 60 * 1000);
	return d.format("yyyy-MM-dd"); 
} 

Date.prototype.format = function(format) {
	var o = {
		"M+" : this.getMonth() + 1, //month 
		"d+" : this.getDate(), //day 
		"h+" : this.getHours(), //hour 
		"m+" : this.getMinutes(), //minute 
		"s+" : this.getSeconds(), //second 
		"q+" : Math.floor((this.getMonth() + 3) / 3), //quarter 
		"S" : this.getMilliseconds()
	//millisecond 
	}

	if (/(y+)/.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	}

	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
					: ("00" + o[k]).substr(("" + o[k]).length));
		}
	}
	return format;
}

