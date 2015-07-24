/***
  selectDate(a,b,c) 
  第一个参数是输入控件     
  第三个参数是输出控件
  第三个参数是时间类型(目前定义了0、1、2、3)：
      0：yyyy-mm-dd
      1:yyyy-mm-dd hh24:mi
      2:yyyy-mm-dd hh24
      3:mm-dd hh24:mi
*/

//参数设定部分
var bMoveable=true;                //设置日历是否可以拖动 
var _VersionInfo=""     //版本信息 
var datelx=0;    //时间类型 0：yyyy-mm-dd  1:yyyy-mm-dd hh24:mi

//WEB 页面显示部分
var strFrame;                //存放日历层的HTML代码 
document.writeln('<iframe name=meizzDateLayer Author=wayx frameborder=0 style="position: absolute; width: 144; height:211; z-index: 9998; visibility:hidden"></iframe>'); 
strFrame='<style>'; 
strFrame+='INPUT.button{BORDER-RIGHT: #E7EEF5 1px solid;BORDER-TOP: #E7EEF5 1px solid;BORDER-LEFT: #E7EEF5 1px solid;'; 
strFrame+='BORDER-BOTTOM: #E7EEF5 1px solid;BACKGROUND-COLOR: #fff8ec;font-family:宋体;}'; 
strFrame+='TD{FONT-SIZE: 9pt;font-family:宋体;}'; 
strFrame+='A{text-decoration:none;font-weight:bold;color:black}'; 
strFrame+='</style>'; 
strFrame+='<scr' + 'ipt>'; 
strFrame+='var datelayerx,datelayery;        /*存放日历控件的鼠标位置*/'; 
strFrame+='var bDrag;        /*标记是否开始拖动*/'; 
strFrame+='function document_onmousemove(e){/*在鼠标移动事件中，如果开始拖动<u><b><font color="#FF0000">日历</font></b></u>，则移动<u><b><font color="#FF0000">日历</font></b></u>*/'; 
strFrame+='if(bDrag){'; 
strFrame+='        var DateLayer=parent.document.getElementsByName("meizzDateLayer")[0].style;'; 
strFrame+='                DateLayer.left = parseInt(DateLayer.left)+ e.clientX-datelayerx; /*由于每次移动以后鼠标位置都恢复为初始的位置，因此写法与div中不同*/'; 
strFrame+='if(DateLayer.top=="")DateLayer.top=0;'; 
strFrame+='                DateLayer.top = parseInt(DateLayer.top)+ e.clientY-datelayery;}}'; 
strFrame+='function DragStart(e){                /*开始日历拖动*/'; 
strFrame+="if ((document.all?e.button:e.which)!=1) return;\n"; 
strFrame+='var DateLayer=parent.document.getElementsByName("meizzDateLayer")[0].style;'; 
strFrame+='        datelayerx=e.clientX;'; 
strFrame+='        datelayery=e.clientY;'; 
strFrame+='        bDrag=true;}'; 
strFrame+='function DragEnd(){                /*结束日历拖动*/'; 
strFrame+='        bDrag=false;}'; 
strFrame+='</scr' + 'ipt>'; 
strFrame+='<body onmousemove="document_onmousemove(event)" scroll="no" width="auto" height="auto">'; 
strFrame+='<div style="z-index:9999;position: absolute; left:0; top:0;" onselectstart="return false"><span id=tmpSelectYearLayer Author=wayx style="z-index: 9999;position: absolute;top: 3; left: 19;visibility: hidden"></span>'; 
strFrame+='<span id=tmpSelectMonthLayer Author=wayx style="z-index: 9999;position: absolute;top: 3; left: 78;visibility: hidden"></span>'; 
strFrame+='<table border=1 cellspacing=0 cellpadding=0 width=142 height=160 bordercolor=#9CAED6 bgcolor=#9CAED6 Author="wayx">'; 
strFrame+='  <tr Author="wayx"><td width=142 height=23 Author="wayx" bgcolor=#FFFFFF><table border=0 cellspacing=1 cellpadding=0 width=140 Author="wayx" height=23>'; 
strFrame+='  <tr align=center Author="wayx"><td width=16 align=center bgcolor=#9CAED6'; 
strFrame+=' onclick="parent.meizzPrevM()" title="向前翻 1 月" Author=meizz><a href="javascript:;" style="font-size:12px;color: #ffffff" Author=meizz><</a>'; 
strFrame+='        </td><td width=60 align=center style="font-size:12px;cursor:default" Author=meizz '; 
strFrame+='onmouseover="style.backgroundColor=\'#FFD700\'" onmouseout="style.backgroundColor=\'white\'" '; 
strFrame+='onclick="parent.tmpSelectYearInnerHTML(innerHTML.match(/\\d{4}/).toString());" title="点击这里选择年份"><span Author=meizz id=meizzYearHead></span></td>'; 
strFrame+='<td width=48 align=center style="font-size:12px;cursor:default" Author=meizz onmouseover="style.backgroundColor=\'#FFD700\'" '; 
strFrame+=' onmouseout="style.backgroundColor=\'white\'" onclick="parent.tmpSelectMonthInnerHTML(innerHTML.match(/\\d\\d?/).toString())"'; 
strFrame+='        title="点击这里选择月份"><span id=meizzMonthHead Author=meizz></span></td>'; 
strFrame+='        <td width=16 bgcolor=#9CAED6 align=center style="font-size:12px;cursor: hand;color: #ffffff" '; 
strFrame+=' onclick="parent.meizzNextM()" title="向后翻 1 月" Author=meizz><a href="javascript:;" style="font-size:12px;color: #ffffff;font:bold" Author=meizz>></a></td></tr>'; 
strFrame+='    </table></td></tr>'; 
strFrame+='  <tr Author="wayx"><td width=142 height=18 Author="wayx">'; 
strFrame+='<table border=1 cellspacing=0 cellpadding=0 bgcolor=#9CAED6 ' + (bMoveable? 'onmousedown="DragStart(event)" onmouseup="DragEnd()"':''); 
strFrame+=' BORDERCOLORLIGHT=#E7EEF5 BORDERCOLORDARK=#FFFFFF width=140 height=20 Author="wayx" style="cursor:' + (bMoveable ? 'move':'default') + '">'; 
strFrame+='<tr Author="wayx" align=center valign=bottom><td style="font-size:12px;color:#FFFFFF" Author=meizz>日</td>'; 
strFrame+='<td style="font-size:12px;color:#FFFFFF" Author=meizz>一</td><td style="font-size:12px;color:#FFFFFF" Author=meizz>二</td>'; 
strFrame+='<td style="font-size:12px;color:#FFFFFF" Author=meizz>三</td><td style="font-size:12px;color:#FFFFFF" Author=meizz>四</td>'; 
strFrame+='<td style="font-size:12px;color:#FFFFFF" Author=meizz>五</td><td style="font-size:12px;color:#FFFFFF" Author=meizz>六</td></tr>'; 
strFrame+='</table></td></tr><!-- Author:F.R.Huang(meizz) http://www.meizz.com/ mail: meizz@hzcnc.com 2002-10-8 -->'; 
strFrame+='  <tr Author="wayx"><td width=142 height=120 Author="wayx">'; 
strFrame+='    <table border=1 cellspacing=2 cellpadding=0 BORDERCOLORLIGHT=#E7EEF5 BORDERCOLORDARK=#FFFFFF bgcolor=#f6f6f6 width=140 height=120 Author="wayx">'; 
var n=0; for (j=0;j<5;j++){ strFrame+= ' <tr align=center Author="wayx">'; for (i=0;i<7;i++){ 
strFrame+='<td width=20 height=20 id=meizzDay'+n+' style="font-size:12px" Author=meizz onclick=parent.meizzDayClick(this.innerHTML.match(/\\d+/).toString(),0)></td>';n++;} 
strFrame+='</tr>';} 
strFrame+='      <tr align=center Author="wayx">'; 
for (i=35;i<39;i++)strFrame+='<td width=20 height=20 id=meizzDay'+i+' style="font-size:12px" Author=wayx onclick="parent.meizzDayClick(this.innerHTML.match(/\\d+/).toString(),0)"></td>'; 
strFrame+='        <td colspan=3 align=right Author=meizz><a href="javascript:;" onclick=parent.closeLayer() style="font-size:12px;text-decoration:underline;font-weight:300;"'; 
strFrame+='         Author=meizz title="' + _VersionInfo + '">关闭</a> </td></tr> '; 
//============add (wuwei)=============
strFrame+='<tr Author="wayx">        <table border=0 cellspacing=1 cellpadding=0 width=100% Author="wayx" bgcolor=#FFFFFF><tr Author="wayx"><td Author=meizz align=left>小时<select name=xs  style="font-size: 10px"><option value="00" selected>0</option><option value="01">1</option><option value="02">2</option><option value="03">3</option><option value="04">4</option><option value="05">5</option><option value="06">6</option><option value="07">7</option><option value="08">8</option><option value="09">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option><option value="16">16</option><option value="17">17</option><option value="18">18</option><option value="19">19</option><option value="20">20</option><option value="21">21</option><option value="22">22</option><option value="23">23</option><option value="24">24</option></select></TD><td Author=meizz align=left>分<select name=f style="font-size: 10px"><option value="00">0</option><option value="01">1</option><option value="02">2</option><option value="03">3</option><option value="04">4</option><option value="05">5</option><option value="06">6</option><option value="07">7</option><option value="08">8</option><option value="09">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option><option value="16">16</option><option value="17">17</option><option value="18">18</option><option value="19">19</option><option value="20">20</option><option value="21">21</option><option value="22">22</option><option value="23">23</option><option value="24">24</option><option value="25">25</option><option value="26">26</option><option value="27">27</option><option value="28">28</option><option value="29">29</option><option value="30">30</option><option value="31">31</option><option value="32">32</option><option value="33">33</option><option value="34">34</option><option value="35">35</option><option value="36">36</option><option value="37">37</option><option value="38">38</option><option value="39">39</option><option value="40">40</option><option value="41">41</option><option value="42">42</option><option value="43">43</option><option value="44">44</option><option value="45">45</option><option value="46">46</option><option value="47">47</option><option value="48">48</option><option value="49">49</option><option value="50">50</option><option value="51">51</option><option value="52">52</option><option value="53">53</option><option value="54">54</option><option value="55">55</option><option value="56">56</option><option value="57">57</option><option value="58">58</option><option value="59">59</option></select>';
strFrame+='   </td></table></tr>';
//============over (wuwei)===============

/**
strFrame+='   <tr Author="wayx"><td Author="wayx">'; 
strFrame+='        <table border=0 cellspacing=1 cellpadding=0 width=100% Author="wayx" bgcolor=#FFFFFF>'; 
strFrame+='          <tr Author="wayx"><td Author=meizz align=left><input Author=meizz type=button class=button value="<<" title="向前翻 1 年" onclick="parent.meizzPrevY()" '; 
strFrame+='             onfocus="this.blur()" style="font-size: 12px; height: 20px"><input Author=meizz class=button title="向前翻 1 月" type=button '; 
strFrame+='             value="< " onclick="parent.meizzPrevM()" onfocus="this.blur()" style="font-size: 12px; height: 20px"></td><td '; 
strFrame+='             Author=meizz align=center><input Author=meizz type=button class=button value=今日 onclick="parent.meizzToday()" '; 
strFrame+='             onfocus="this.blur()" title="当前日期" style="font-size: 12px; height: 20px; cursor:hand"></td><td '; 
strFrame+='             Author=meizz align=right><input Author=meizz type=button class=button value=" >" onclick="parent.meizzNextM()" '; 
strFrame+='             onfocus="this.blur()" title="向后翻 1 月" class=button style="font-size: 12px; height: 20px"><input '; 
strFrame+='             Author=meizz type=button class=button value=">>" title="向后翻 1 年" onclick="parent.meizzNextY()"'; 
strFrame+='             onfocus="this.blur()" style="font-size: 12px; height: 20px"></td>'; 
strFrame+='</tr></table></td></tr>';
**/
strFrame+='</table>';

strFrame+='</div></body>';
var odatelayer; 
var outObject; 
var outButton;                //点击的按钮 
var outDate="";                //存放对象的日期 
function init(){ 
        window.frames.meizzDateLayer.document.writeln(strFrame); 
        window.frames.meizzDateLayer.document.close();                //解决ie进度条不结束的问题 
        odatelayer=window.frames.meizzDateLayer.document;                //存放日历对象 
} 
//==================================================== WEB 页面显示部分 ====================================================== 
function selectDateTime(obj){
	selectDate(obj,obj,1)
}
function selectDate(tt,obj,dlx) //主调函数 
{ 
      if (!isNaN(dlx)){
		 datelx=dlx; 
	  }
  //    alert(datelx);

        if (arguments.length >  3){alert("对不起！传入本控件的参数太多！");return;} 
        if (arguments.length == 0){alert("对不起！您没有传回本控件任何参数！");return;} 
        var dads  = document.getElementsByName("meizzDateLayer")[0].style; 
        var th = tt; 
        var ttop  = tt.offsetTop;     //TT控件的定位点高 
        var thei  = tt.offsetHeight;  //TT控件本身的高 
        var tleft = tt.offsetLeft;    //TT控件的定位点宽 
        var ttyp  = tt.type;          //TT控件的类型 
        while (tt = tt.offsetParent){ttop+=tt.offsetTop; tleft+=tt.offsetLeft;} 
        dads.top  = ttop+thei ; 
        dads.left = tleft; 
        outObject = (arguments.length == 1) ? th : obj; 
        outButton = (arguments.length == 1) ? null : th;        //设定外部点击的按钮 
        //根据当前输入框的日期显示日历的年月 
        var reg = /^(\d+)-(\d{1,2})-(\d{1,2})$/; 
        var r = outObject.value.match(reg); 
        if(r!=null){ 
                r[2]=r[2]-1; 
                var d= new Date(r[1], r[2],r[3]); 
                if(d.getFullYear()==r[1] && d.getMonth()==r[2] && d.getDate()==r[3]){ 
                        outDate=d;                //保存外部传入的日期 
                } 
                else outDate=""; 
                        meizzSetDay(r[1],r[2]+1); 
        } 
        else{ 
                outDate=""; 
                meizzSetDay(new Date().getFullYear(), new Date().getMonth() + 1); 
        } 
        dads.visibility="visible"; 
        document.getElementsByName("meizzDateLayer")[0].focus(); 
        event.returnValue=false; 
} 

var MonHead = new Array(12);                       //定义阳历中每个月的最大天数 
    MonHead[0] = 31; MonHead[1] = 28; MonHead[2] = 31; MonHead[3] = 30; MonHead[4]  = 31; MonHead[5]  = 30; 
    MonHead[6] = 31; MonHead[7] = 31; MonHead[8] = 30; MonHead[9] = 31; MonHead[10] = 30; MonHead[11] = 31; 

var meizzTheYear=new Date().getFullYear(); //定义年的变量的初始值 
var meizzTheMonth=new Date().getMonth()+1; //定义月的变量的初始值 
var meizzWDay=new Array(39);               //定义写日期的数组 

function document_onclick(e) //任意点击时关闭该控件        //ie6的情况可以由下面的切换焦点处理代替 
{ 
		e = window.event;
        var elm = (document.all)?(e.srcElement):(e.target); 
        if ((elm.getAttribute("Author")==null || elm.getAttribute("Author")=="") && elm != outObject && elm != outButton) 
    closeLayer(); 
} 

function document_onkeyup(e)                //按Esc键关闭，切换焦点关闭 
  {
	  e = window.event;
    if (window.event.keyCode==27){ 
                if(outObject)outObject.blur(); 
                closeLayer(); 
        } 
        else if(document.activeElement) 
                if(document.activeElement.getAttribute("Author")==null && document.activeElement != outObject && document.activeElement != outButton) 
                { 
                        closeLayer(); 
                } 
  } 

function meizzWriteHead(yy,mm)  //往 head 中写入当前的年与月 
  { 
        odatelayer.getElementById("meizzYearHead").innerHTML  = yy + " 年"; 
    odatelayer.getElementById("meizzMonthHead").innerHTML = mm + " 月"; 
  } 

function tmpSelectYearInnerHTML(strYear) //年份的下拉框 
{ 
  if (strYear.match(/\D/)!=null){alert("年份输入参数不是数字！");return;} 
  var m = (strYear) ? strYear : new Date().getFullYear(); 
  if (m < 1000 || m > 9999) {alert("年份值不在 1000 到 9999 之间！");return;} 
  var n = m - 10; 
  if (n < 1000) n = 1000; 
  if (n + 26 > 9999) n = 9974; 
  var s = "<select Author=meizz name=tmpSelectYear style='font-size: 12px' " 
     s += "onblur='document.getElementById(\"tmpSelectYearLayer\").style.visibility=\"hidden\"' " 
     s += "onchange='blur();" 
     s += "parent.meizzTheYear = this.value; parent.meizzSetDay(parent.meizzTheYear,parent.meizzTheMonth)'>\r\n"; 
  var selectInnerHTML = s; 
  for (var i = n; i < n + 26; i++) 
  { 
    if (i == m) 
       {selectInnerHTML += "<option Author=wayx value='" + i + "' selected>" + i + "年" + "</option>\r\n";} 
    else {selectInnerHTML += "<option Author=wayx value='" + i + "'>" + i + "年" + "</option>\r\n";} 
  } 
  selectInnerHTML += "</select>"; 
  odatelayer.getElementById("tmpSelectYearLayer").innerHTML = selectInnerHTML; 
  odatelayer.getElementById("tmpSelectYearLayer").style.visibility="visible"; 
  odatelayer.getElementsByName("tmpSelectYear")[0].focus(); 

} 

function tmpSelectMonthInnerHTML(strMonth) //月份的下拉框 
{ 
  if (strMonth.match(/\D/)!=null){alert("月份输入参数不是数字！");return;} 
  var m = (strMonth) ? strMonth : new Date().getMonth() + 1; 
  var s = "<select Author=meizz name=tmpSelectMonth style='font-size: 12px' " 
     s += "onblur='document.getElementById(\"tmpSelectMonthLayer\").style.visibility=\"hidden\"' " 
     s += "onchange='blur();" 
     s += "parent.meizzTheMonth = this.value; parent.meizzSetDay(parent.meizzTheYear,parent.meizzTheMonth)'>\r\n"; 
  var selectInnerHTML = s; 
  for (var i = 1; i < 13; i++) 
  { 
    if (i == m) 
       {selectInnerHTML += "<option Author=wayx value='"+i+"' selected>"+i+"月"+"</option>\r\n";} 
    else {selectInnerHTML += "<option Author=wayx value='"+i+"'>"+i+"月"+"</option>\r\n";} 
  } 
  selectInnerHTML += "</select>"; 
  odatelayer.getElementById("tmpSelectMonthLayer").style.visibility="visible"; 
  odatelayer.getElementById("tmpSelectMonthLayer").innerHTML = selectInnerHTML; 
  odatelayer.getElementsByName("tmpSelectMonth")[0].focus(); 
} 

function closeLayer()               //这个层的关闭 
  { 
    document.getElementsByName("meizzDateLayer")[0].style.visibility="hidden"; 
  } 

function IsPinYear(year)            //判断是否闰平年 
  { 
    if (0==year%4&&((year%100!=0)||(year%400==0))) return true;else return false; 
  } 

function GetMonthCount(year,month)  //闰年二月为29天 
  { 
    var c=MonHead[month-1];if((month==2)&&IsPinYear(year)) c++;return c; 
  } 
function GetDOW(day,month,year)     //求某天的星期几 
  { 
    var dt=new Date(year,month-1,day).getDay()/7; return dt; 
  } 

function meizzPrevY()  //往前翻 Year 
  { 
    if(meizzTheYear > 999 && meizzTheYear <10000){meizzTheYear--;} 
    else{alert("年份超出范围（1000-9999）！");} 
    meizzSetDay(meizzTheYear,meizzTheMonth); 
  } 
function meizzNextY()  //往后翻 Year 
  { 
    if(meizzTheYear > 999 && meizzTheYear <10000){meizzTheYear++;} 
    else{alert("年份超出范围（1000-9999）！");} 
    meizzSetDay(meizzTheYear,meizzTheMonth); 
  } 
function meizzToday()  //Today Button 
  { 
        var today; 
    meizzTheYear = new Date().getFullYear(); 
    meizzTheMonth = new Date().getMonth()+1; 
    today=new Date().getDate(); 
    //meizzSetDay(meizzTheYear,meizzTheMonth); 
    if(outObject){ 
                outObject.value=meizzTheYear + "-" + meizzTheMonth + "-" + today; 
    } 
    closeLayer(); 
  } 
function meizzPrevM()  //往前翻月份 
  { 
    if(meizzTheMonth>1){meizzTheMonth--}else{meizzTheYear--;meizzTheMonth=12;} 
    meizzSetDay(meizzTheYear,meizzTheMonth); 
  } 
function meizzNextM()  //往后翻月份 
  { 
    if(meizzTheMonth==12){meizzTheYear++;meizzTheMonth=1}else{meizzTheMonth++} 
    meizzSetDay(meizzTheYear,meizzTheMonth); 
  } 

function meizzSetDay(yy,mm)   //主要的写程序********** 
{ 
  meizzWriteHead(yy,mm); 
  //设置当前年月的公共变量为传入值 
  meizzTheYear=yy; 
  meizzTheMonth=mm; 
  for (var i = 0; i < 39; i++){meizzWDay[i]=""};  //将显示框的内容全部清空 
  var day1 = 1,day2=1,firstday = new Date(yy,mm-1,1).getDay();  //某月第一天的星期几 
  for (i=0;i<firstday;i++)meizzWDay[i]=GetMonthCount(mm==1?yy-1:yy,mm==1?12:mm-1)-firstday+i+1        //上个月的最后几天 
  for (i = firstday; day1 < GetMonthCount(yy,mm)+1; i++){meizzWDay[i]=day1;day1++;} 
  for (i=firstday+GetMonthCount(yy,mm);i<39;i++){meizzWDay[i]=day2;day2++} 
  for (i = 0; i < 39; i++) 
  { var da = odatelayer.getElementById("meizzDay"+i);     //书写新的一个月的日期星期排列 
    if (meizzWDay[i]!="") 
      { 
                //初始化边框 
                da.style.borderWidth="1px"; 
                da.style.borderStyle="solid"; 
                da.style.borderTopColor="#FFFFFF"; 
                da.style.borderRightColor="#808080"; 
                da.style.borderBottomColor="#808080"; 
                da.style.borderLeftColor="#FFFFFF"; 
                if(i<firstday)                //上个月的部分 
                { 
                        da.innerHTML="<a href='javascript:;'><font color=gray>" + meizzWDay[i] + "</font></a>"; 
                        da.title=(mm==1?12:mm-1) +"月" + meizzWDay[i] + "日"; 
                        da.onclick=Function("meizzDayClick(this.innerHTML.match(/\\d+/).toString(),-1)"); 
                        if(!outDate) 
                                da.style.backgroundColor = ((mm==1?yy-1:yy) == new Date().getFullYear() && 
                                        (mm==1?12:mm-1) == new Date().getMonth()+1 && meizzWDay[i] == new Date().getDate()) ? 
                                         "#FFD700":"#e0e0e0"; 
                        else 
                        { 
                                da.style.backgroundColor =((mm==1?yy-1:yy)==outDate.getFullYear() && (mm==1?12:mm-1)== outDate.getMonth() + 1 && 
                                meizzWDay[i]==outDate.getDate())? "#00ffff" : 
                                (((mm==1?yy-1:yy) == new Date().getFullYear() && (mm==1?12:mm-1) == new Date().getMonth()+1 && 
                                meizzWDay[i] == new Date().getDate()) ? "#FFD700":"#e0e0e0"); 
                                //将选中的日期显示为凹下去 
                                if((mm==1?yy-1:yy)==outDate.getFullYear() && (mm==1?12:mm-1)== outDate.getMonth() + 1 && 
                                meizzWDay[i]==outDate.getDate()) 
                                { 
                                        da.style.borderTopColor="#808080"; 
                                        da.style.borderRightColor="#FFFFFF"; 
                                        da.style.borderBottomColor="#FFFFFF"; 
                                        da.style.borderLeftColor="#808080"; 
                                } 
                        } 
                } 
                else if (i>=firstday+GetMonthCount(yy,mm))                //下个月的部分 
                { 
                        da.innerHTML="<a href='javascript:;'><font color=gray>" + meizzWDay[i] + "</font></a>"; 
                        da.title=(mm%12+1) +"月" + meizzWDay[i] + "日"; 
                        da.onclick=Function("meizzDayClick(this.innerHTML.match(/\\d+/).toString(),1)"); 
                        if(!outDate) 
                                da.style.backgroundColor = ((mm==12?yy+1:yy) == new Date().getFullYear() && 
                                        (mm==12?1:mm+1) == new Date().getMonth()+1 && meizzWDay[i] == new Date().getDate()) ? 
                                         "#FFD700":"#e0e0e0"; 
                        else 
                        { 
                                da.style.backgroundColor =((mm==12?yy+1:yy)==outDate.getFullYear() && (mm==12?1:mm+1)== outDate.getMonth() + 1 && 
                                meizzWDay[i]==outDate.getDate())? "#00ffff" : 
                                (((mm==12?yy+1:yy) == new Date().getFullYear() && (mm==12?1:mm+1) == new Date().getMonth()+1 && 
                                meizzWDay[i] == new Date().getDate()) ? "#FFD700":"#e0e0e0"); 
                                //将选中的日期显示为凹下去 
                                if((mm==12?yy+1:yy)==outDate.getFullYear() && (mm==12?1:mm+1)== outDate.getMonth() + 1 && 
                                meizzWDay[i]==outDate.getDate()) 
                                { 
                                        da.style.borderTopColor="#808080"; 
                                        da.style.borderRightColor="#FFFFFF"; 
                                        da.style.borderBottomColor="#FFFFFF"; 
                                        da.style.borderLeftColor="#808080"; 
                                } 
                        } 
                } 
                else                //本月的部分 
                { 
                        da.innerHTML="<a href='javascript:;'>" + meizzWDay[i] + "</a>"; 
                        da.title=mm +"月" + meizzWDay[i] + "日"; 
                        da.onclick=Function("meizzDayClick(this.innerHTML.match(/\\d+/).toString(),0)");                //给td赋予onclick事件的处理 
                        //如果是当前选择的日期，则显示亮蓝色的背景；如果是当前日期，则显示暗黄色背景 
                        if(!outDate) 
                                da.style.backgroundColor = (yy == new Date().getFullYear() && mm == new Date().getMonth()+1 && meizzWDay[i] == new Date().getDate())? 
                                        "#FFD700":"#e0e0e0"; 
                        else 
                        { 
                                da.style.backgroundColor =(yy==outDate.getFullYear() && mm== outDate.getMonth() + 1 && meizzWDay[i]==outDate.getDate())? 
                                        "#00ffff":((yy == new Date().getFullYear() && mm == new Date().getMonth()+1 && meizzWDay[i] == new Date().getDate())? 
                                        "#FFD700":"#e0e0e0"); 
                                //将选中的日期显示为凹下去 
                                if(yy==outDate.getFullYear() && mm== outDate.getMonth() + 1 && meizzWDay[i]==outDate.getDate()) 
                                { 
                                        da.style.borderTopColor="#808080"; 
                                        da.style.borderRightColor="#FFFFFF"; 
                                        da.style.borderBottomColor="#FFFFFF"; 
                                        da.style.borderLeftColor="#808080"; 
                                } 
                        } 
                } 
        da.style.cursor="hand" 
      } 
    else{da.innerHTML="";da.style.backgroundColor="";da.style.cursor="default"} 
  } 
} 

function meizzDayClick(n,ex)  //点击显示框选取日期，主输入函数************* 
{ 
  var yy=meizzTheYear; 
  var mm = parseInt(meizzTheMonth)+ex;        //ex表示偏移量，用于选择上个月份和下个月份的日期 
        //判断月份，并进行对应的处理 
        if(mm<1){ 
                yy--; 
                mm=12+mm; 
        } 
        else if(mm>12){ 
                yy++; 
                mm=mm-12; 
        } 
         
  if (mm < 10){mm = "0" + mm;} 
  if (outObject) 
  { 
    if (!n) {//outObject.value=""; 
      return;} 
    if ( n < 10){n = "0" + n;}
	var xs=window.frames.meizzDateLayer.document.all("xs").value;
	var f=window.frames.meizzDateLayer.document.all("f").value;
	if (datelx==0){
        outObject.value= yy + "-" + mm + "-" + n;
	}else if (datelx==1){
        outObject.value= yy + "-" + mm + "-" + n + " "+xs+":"+f;
	}else if (datelx==2){
        outObject.value= yy + "-" + mm + "-" + n + " "+xs;
	}else if (datelx==3){
        outObject.value= mm + "-" + n + " "+xs+":"+f;
	}
    
	//注：在这里你可以输出改成你想要的格式 
	
    closeLayer(); 
  } 
  else {closeLayer(); alert("您所要输出的控件对象并不存在！");} 
} 
init();
document.body.onclick = document_onclick;
document.body.onkeyup = document_onkeyup;

//######################################如果有两个日期输入框，进行先后顺序判断 
onBlurCheckTwoDate=function(){
	if (arguments.length!=3) return; 
	var s0=arguments[0];
	var s1=document.getElementById(arguments[1]).value;
	var s2=document.getElementById(arguments[2]).value; 
	if((s1==null || s1=="") || (s2==null || s2=="")){
		
	}else{
		if(s1>s2){
			alert('日期先后大小错误'); 
			s0.value="";
		} 
	}  
} 