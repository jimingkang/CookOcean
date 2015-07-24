<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>交通物流运行监测系统:首页</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Cache-Control" content="no-store">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/menuPages.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/formalize.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pages.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/imgs.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
    <script type="text/jscript" src="${pageContext.request.contextPath}/js/html5.js"></script>
</head>
<body screen_capture_injected="true">
    <div id="header" class="clearfix">
         <!--     <div class="logo">
	       <h4>危险货运</h4>
	        </div> -->
        <div class="fr">
            <ul class="op clearfix">
                <a href="http://localhost:8090/monitor-web/systemManage/menu">
                    <li class="sys">系统管理</li></a> <a href="http://localhost:8090/monitor-web/j_spring_security_logout">
                        <li class="logout">注销登录</li></a>
            </ul>
        </div>
        <div class="fr user">
            <dl>
                <dt><b>浙江省道路运输管理局</b></dt>
                <dd>
                    <b>许灵，</b>欢迎登录</dd>
            </dl>
        </div>
    </div>
    <div id="menu">
        <ul class="clearfix">
            <li id="homePage" class="selected"><a href="${pageContext.request.contextPath}/css/交通物流运行监测系统 首页.htm"><span>首页</span></a></li>
            <li id="staticDateManage"><a href="http://localhost:8090/monitor-web/remind/menu"><span>
                静态数据监测</span></a></li>
            <li id="dynamicDateManage"><a href="http://localhost:8090/monitor-web/eroadBill/menu">
                <span>动态数据监测</span></a></li>
            <li id="inspectionManage"><a href="http://localhost:8090/monitor-web/regulation/menu">
                <span>监管信息处置</span></a></li>
            <li id="notice"><a href="http://localhost:8090/monitor-web/notice/menu"><span>通知公告</span></a></li>
            <li id="reportManage"><a href="http://localhost:8090/monitor-web/rptEnterprise/menu">
                <span>报表管理</span></a></li>
            <li id="accountBook"><a href="http://localhost:8090/monitor-web/accountbookrecord/menu">
                <span>台帐管理</span></a></li>
        </ul>
    </div>
    <div id="mainwrap" class="clearfix">
        <div class="clearfix mw1024">
            <div class="fl m10 main-panel" style="width: 1029px;">
                <div class="panel mb10" style="height: 210px;">
                    <div class="clearfix">
                        <h5 class="lite">
                            全省通知公告<a href="http://localhost:8090/monitor-web/notice/menu?flag=true" class="more fr"
                                style="color: white; text-decoration: underline;">更多</a></h5>
                    </div>
                    <ul class="list m8">
                        <li class="clearfix"><a href="http://localhost:8090/monitor-web/home/menu#" class="area mr8">
                            [<label class="fixWidth60">
                                浙江省
                            </label>
                            ]</a><a href="javascript:viewReport('254f7e95-38b0-4490-b967-965e6d8a059e','1')"
                                class="w70p"> <b>
                                    <nobr>超市</nobr>
                                </b></a><span class="date fr">2014-06-27</span> </li>
                        <li class="clearfix"><a href="http://localhost:8090/monitor-web/home/menu#" class="area mr8">
                            [<label class="fixWidth60">
                                西湖区
                            </label>
                            ]</a><a href="javascript:viewReport('73317a31-4842-47b9-8072-324fb0bf7633','1')"
                                class="w70p">
                                <nobr>4444444444444444444444444444444444444444444444444444444</nobr>
                            </a><span class="date fr">2014-06-27</span> </li>
                        <li class="clearfix"><a href="http://localhost:8090/monitor-web/home/menu#" class="area mr8">
                            [<label class="fixWidth60">
                                西湖区
                            </label>
                            ]</a><a href="javascript:viewReport('0aeacb3a-8dac-4836-9436-cdb0bd44ab3b','1')"
                                class="w70p">
                                <nobr>1231232</nobr>
                            </a><span class="date fr">2014-06-27</span> </li>
                        <li class="clearfix"><a href="http://localhost:8090/monitor-web/home/menu#" class="area mr8">
                            [<label class="fixWidth60">
                                西湖区
                            </label>
                            ]</a><a href="javascript:viewReport('27355f3f-9b1c-4489-8cc5-b4bb40207bd0','1')"
                                class="w70p">
                                <nobr>11</nobr>
                            </a><span class="date fr">2014-06-27</span> </li>
                        <li class="clearfix"><a href="http://localhost:8090/monitor-web/home/menu#" class="area mr8">
                            [<label class="fixWidth60">
                                西湖区
                            </label>
                            ]</a><a href="javascript:viewReport('2397e523-0c0c-4238-84cc-66992a52c03c','1')"
                                class="w70p">
                                <nobr>阿斯蒂芬</nobr>
                            </a><span class="date fr">2014-06-27</span> </li>
                    </ul>
                </div>
                <div class="panel ">
                    <h5 class="deep">
                        静态数据监测情况</h5>
                    <div>
                        <table class="table_01">
                            <!--                 		<tr> -->
                            <!--                         </tr> -->
                            <tbody>
                                <tr>
                                    <td colspan="6">
                                        有已到期信息的危运企业共&nbsp;&nbsp;<a href="javascript:viewExp('yidaoqi');" style="text-decoration: underline;
                                            color: red">632</a>&nbsp;家，人车配比可能不足危运企业共&nbsp;&nbsp;<a href="javascript:viewExp('renchebi');"
                                                style="text-decoration: underline; color: red">674</a>&nbsp;家
                                    </td>
                                </tr>
                                <tr style="background: rgb(243, 243, 243);">
                                    <td>
                                        &nbsp;
                                    </td>
                                    <td>
                                        监测项目
                                    </td>
                                    <td>
                                        30天内将到期
                                    </td>
                                    <td>
                                        15天内将到期
                                    </td>
                                    <td>
                                        5天内将到期
                                    </td>
                                    <td>
                                        已到期
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="qiye">
                                            &nbsp;</div>
                                    </td>
                                    <td style="text-align: center">
                                        <b>经营许可证有效期</b>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('经营许可证到期企业列表','0','30');">20&nbsp;家</a>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('经营许可证到期企业列表','0','15');">8&nbsp;家</a>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('经营许可证到期企业列表','0','5');">5&nbsp;家</a>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('经营许可证到期企业列表','0','0');">22&nbsp;家</a>
                                    </td>
                                </tr>
                                <tr style="background: rgb(243, 243, 243);">
                                    <td rowspan="6">
                                        <div class="car">
                                            &nbsp;</div>
                                    </td>
                                    <td>
                                        <b>道路运输证有效期</b>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('道路运输证到期企业列表','1','30');">289&nbsp;辆</a>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('道路运输证到期企业列表','1','15');">202&nbsp;辆</a>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('道路运输证到期企业列表','1','5');">78&nbsp;辆</a>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('道路运输证到期企业列表','1','0');">587&nbsp;辆</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <b>道路运输证年审</b>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('道路运输证年审到期企业列表','2','30');">1291&nbsp;辆</a>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('道路运输证年审到期企业列表','2','15');">645&nbsp;辆</a>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('道路运输证年审到期企业列表','2','5');">253&nbsp;辆</a>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('道路运输证年审到期企业列表','2','0');">1929&nbsp;辆</a>
                                    </td>
                                </tr>
                                <tr style="background: rgb(243, 243, 243);">
                                    <td>
                                        <b>承运人责任险</b>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('承运人责任险到期企业列表','6','30');">609&nbsp;辆</a>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('承运人责任险到期企业列表','6','15');">316&nbsp;辆</a>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('承运人责任险到期企业列表','6','5');">94&nbsp;辆</a>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('承运人责任险到期企业列表','6','0');">4312&nbsp;辆</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <b>技术等级评定</b>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('技术等级评定到期企业列表','3','30');">1301&nbsp;辆</a>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('技术等级评定到期企业列表','3','15');">647&nbsp;辆</a>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('技术等级评定到期企业列表','3','5');">216&nbsp;辆</a>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('技术等级评定到期企业列表','3','0');">5621&nbsp;辆</a>
                                    </td>
                                </tr>
                                <tr style="background: rgb(243, 243, 243);">
                                    <td>
                                        <b>二级维护</b>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('二级维护到期企业列表','4','30');">0&nbsp;辆</a>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('二级维护到期企业列表','4','15');">0&nbsp;辆</a>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('二级维护到期企业列表','4','5');">0&nbsp;辆</a>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('二级维护到期企业列表','4','0');">6637&nbsp;辆</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <b>罐体检测</b>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('罐体检测到期企业列表','5','30');">668&nbsp;辆</a>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('罐体检测到期企业列表','5','15');">272&nbsp;辆</a>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('罐体检测到期企业列表','5','5');">118&nbsp;辆</a>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('罐体检测到期企业列表','5','0');">3540&nbsp;辆</a>
                                    </td>
                                </tr>
                                <tr style="background: rgb(243, 243, 243);">
                                    <td>
                                        <div class="people">
                                            &nbsp;</div>
                                    </td>
                                    <td>
                                        <b>从业资格证有效期</b>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('从业资格证到期企业列表','7','30');">442&nbsp;人</a>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('从业资格证到期企业列表','7','15');">207&nbsp;人</a>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('从业资格证到期企业列表','7','5');">86&nbsp;人</a>
                                    </td>
                                    <td>
                                        <a href="javascript:viewDetail('从业资格证到期企业列表','7','0');">334&nbsp;人</a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="fl w280 mt10">
                <div class="panel">
                    <h4 class="lite sta" style="height: 38px;">
                        动态数据监测情况</h4>
                    <div class="gray_1 p5">
                        <!--                 	<ul> -->
                        <!--                     </ul> 
<h3 style="text-align: left;"></h3>
-->
                        <div style="text-align: left; font-size: 14px;">
                            今日上报路单总数<a href="javascript:viewEroadBill('all');" style="text-decoration: underline;
                                font-size: 16px; color: red"></a>条，正常路单数<a href="javascript:viewEroadBill('zhengchang');"
                                    style="text-decoration: underline; font-size: 16px; color: red">0</a>条，异常路单数<a href="javascript:viewEroadBill('yichang');"
                                        style="text-decoration: underline; font-size: 16px; color: red">0</a>条，共有异常<label
                                            style="font-size: 16px; color: red;">0</label>个，共有<label style="font-size: 16px;
                                                color: red;">0</label>家企业上报的路单有异常。<br>
                            连续5天未上报路单企业有<a href="javascript:viewUnupload();" style="text-decoration: underline;
                                font-size: 16px; color: red">1</a>家。
                        </div>
                    </div>
                    <div class="p_r">
                        <div class="arrow">
                            <!--这个div是那个装饰性的灰色小三角。不要删除！-->
                        </div>
                        <div id="chart1-div" style="width: 280px; height: 232px;">
                        </div>
                        <div class="gray_2" style="padding: 2px;">
                            <table class="table_01">
                                <tbody>
                                    <tr>
                                        <td>
                                            色块
                                        </td>
                                        <td>
                                            异常名称
                                        </td>
                                        <td>
                                            个数
                                        </td>
                                        <td>
                                            所占比例
                                        </td>
                                    </tr>
                                    <tr style="background: rgb(243, 243, 243);">
                                        <td>
                                            <em style="width: 30px; height: 20px; display: block; background-color: #2f7ed8">
                                            </em>
                                        </td>
                                        <td>
                                            车辆异常
                                        </td>
                                        <td>
                                            0
                                        </td>
                                        <td>
                                            0.0 %
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <em style="width: 30px; height: 20px; display: block; background-color: #0d233a">
                                            </em>
                                        </td>
                                        <td>
                                            人员异常
                                        </td>
                                        <td>
                                            0
                                        </td>
                                        <td>
                                            0.0 %
                                        </td>
                                    </tr>
                                    <tr style="background: rgb(243, 243, 243);">
                                        <td>
                                            <em style="width: 30px; height: 20px; display: block; background-color: #8bbc21">
                                            </em>
                                        </td>
                                        <td>
                                            货物异常
                                        </td>
                                        <td>
                                            0
                                        </td>
                                        <td>
                                            0.0 %
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <em style="width: 30px; height: 20px; display: block; background-color: #910000">
                                            </em>
                                        </td>
                                        <td>
                                            GPS异常
                                        </td>
                                        <td>
                                            0
                                        </td>
                                        <td>
                                            0.0 %
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            <!--                         <ul class="p8 gray_01"> -->
                            <!--                         </ul> -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
   
   function viewEroadBill(perm){
		window.location.href='/monitor-web/eroadBill/menu?fl='+perm;
	}
   function viewUnupload(){
		window.location.href='/monitor-web/eroadBill/menu?fl=unupload';
	}
   
   function viewExp(perm){
		window.location.href='/monitor-web/remind/menu?fl='+perm;
	}
   
   function viewReport(lid,noticeStatus){
		window.location.href='/monitor-web/notice/menu?lid='+lid+'&&noticeStatus='+noticeStatus;
	}
   
   function viewDetail(title,certificationType,expireDays) {
	    window.location.href='/monitor-web/remind/menu?certificationType='+certificationType+'&&expireDays='+expireDays;
		//addTab(title, '/monitor-web/remind/expireInfoDetail?title='+title+'&&certificationType='+certificationType+'&&expireDays='+expireDays);
	}
   
   $(function(){
   	
	$(".main-panel").width($(window).width()-320);
var $tblAlterRow = $(".table_01 tbody tr:odd");
if ($tblAlterRow.length > 0)
    $tblAlterRow.css("background","#f3f3f3");           
	   
	   $('#tableCheck').datagrid({
           onLoadSuccess: function (data) {
               if (data.rows.length > 0) {
                   mergeCellsByField("tableCheck", "code");
               }
           }
       });
	   
	   $.ajax({
			url : '/monitor-web/eroadBill/display/t',
			method : 'post',
			success : function(data) {
				drawTable(data.dataReal);
			}

		});
   });
   
   $(window).resize(function() {
		$(".main-panel").width($(window).width()-320);
   });
   
   function mergeCellsByField(tableID, colList) {
	    var ColArray = colList.split(",");
	    var tTable = $("#" + tableID);
	    var TableRowCnts = tTable.datagrid("getRows").length;
	    var tmpA;
	    var tmpB;
	    var PerTxt = "";
	    var CurTxt = "";
	    for (var j = ColArray.length - 1; j >= 0; j--) {
	        PerTxt = "";
	        tmpA = 1;
	        tmpB = 0;

	        for (var i = 0; i <= TableRowCnts; i++) {
	            if (i == TableRowCnts) {
	                CurTxt = "";
	            }
	            else {
	                CurTxt = tTable.datagrid("getRows")[i][ColArray[j]];
	            }
	            if (PerTxt == CurTxt) {
	                tmpA += 1;
	            }
	            else {
	                tmpB += tmpA;

	                tTable.datagrid("mergeCells", { 
	                    index: tmpB - tmpA -1,
	                    field: ColArray[j],
	                    rowspan: tmpA,
	                    colspan: null
	                });
	              
	                tmpA = 1;
	            }
	            PerTxt = CurTxt;
	        }
	    }
	}
   
   function goToReportCheck() {
   	
   	parent.switchMenu(parent.$("#reportCheck"),'/monitor-web/report/reportCheck');
   	
   }
   
   function goToRemindEnterprise(){
	   parent.switchMenu(parent.$("#remind"),'/monitor-web/goverment/remind/remindMenu');
   	
   }; 
   
   
   function drawTable(realData) {
		var proData = [];
		proData.push([ '车辆异常', realData[0].vehicleProblems ]);
		proData.push([ '人员异常', realData[0].personProblems ]);
		proData.push([ '货物异常', realData[0].goodsProblems ]);
		proData.push([ 'GPS异常', realData[0].gpsProblems ]);
        
		
		$('#chart1-div').highcharts({
			chart : {
				plotBackgroundColor : null,
				plotBorderWidth : null,
				plotShadow : true
			},
			credits : {
				enabled : false
			},
			title : {
				text : '辖区今日路单异常情况分析'
			},
			tooltip : {
				pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
			},
			
			plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: false
                    },
                   // showInLegend: true
                }
            },
//            
// 			plotOptions : {
// 				pie : {
// 					allowPointSelect : true,
// 					cursor : 'pointer',
// 					dataLabels : {
// 						enabled : true,
// 						color : '#000000',
// 						connectorColor : '#000000',
// 						format : '<b>{point.name}</b>: {point.percentage:.1f} %'
// 					}
// 				}
// 			},
			series : [ {
				type : 'pie',
				name : '路单异常',
				data : proData
			} ]
		});
	}
   </script>
    </div>
    <div id="footer">
        <a href="javascript:viewPerson('enterprise')">业户查询</a> | <a href="javascript:viewPerson('vehicle')">
            车辆查询</a> | <a href="javascript:viewPerson('person')">人员查询</a></div>
    <script>

        function viewPerson(perm) {
            window.location.href = '/monitor-web/remind/menu?fl=' + perm;
        }
   </script>
    <script type="text/javascript">

        $("#homePage").attr("class", "selected");
</script>
</body>
</html>