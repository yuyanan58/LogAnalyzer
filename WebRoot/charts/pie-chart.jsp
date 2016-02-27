<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>

<div id="pieChart" style="width: 100%; height: 100%"></div>
<script type="text/javascript">
	var pieChartDom = document.getElementById("pieChart");
	var pieChartDomMyChart = echarts.init(pieChartDom);
	var app = {};
	$.getJSON("/dreaming/charts/pie-chart-json.jsp", function(dataALL) {
		
		var data1 = dataALL.data1 ;
		var data2 = dataALL.data2 ;
		
		pieChartOption = {
			title : {
				text : '日志事件统计',
				subtext : '全部事件',
				x : 'center'
			},
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			legend : {
				orient : 'vertical',
				left : 'left',
				data : data1 
			},
			series : [ {
				name : '访问来源',
				type : 'pie',
				radius : '55%',
				center : [ '50%', '60%' ],
				data : data2,
				itemStyle : {
					emphasis : {
						shadowBlur : 10,
						shadowOffsetX : 0,
						shadowColor : 'rgba(0, 0, 0, 0.5)'
					}
				}
			} ]
		};

		if (pieChartOption && typeof pieChartOption === "object") {
			var startTime = +new Date();
			pieChartDomMyChart.hideLoading();
			pieChartDomMyChart.setOption(pieChartOption, true);
			var endTime = +new Date();
			var updateTime = endTime - startTime;
			console.log("Pie Chart Time used:", updateTime);
		} else {
			console.log("Pie Chart JSON get is fail");
		}
	});
</script>