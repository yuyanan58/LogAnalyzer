<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>

<div id="eventTimeChart" style="width: 100%; height: 100%"></div>
<script type="text/javascript">
	var eventTimeChartDom = document.getElementById("eventTimeChart");
	var eventTimeChartDomMyChart = echarts.init(eventTimeChartDom);
	var app = {};
	$.getJSON("/dreaming/charts/event-time-chart-json.jsp", function(dataALL) {
		
		var eventTimeChartdate = dataALL.date;
		var eventTimeChartdata = dataALL.data;
		var eventTimeChartmax = dataALL.max;
		
		eventTimeChartoption = {
		    title: {
		        x: 'center',
		        text: '事件发生在时间轴上的分布',
		    },
		    legend: {
		        top: 'bottom',
		        data:['事件数/个']
		    },
		    toolbox: {
		        show: true,
		        feature: {
		            mark: {show: true},
		            dataView: {show: true, readOnly: false},
		            magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
		            restore: {show: true},
		            saveAsImage: {show: true}
		        }
		    },
		    xAxis: [
		        {
		            type: 'category',
		            boundaryGap: false,
		            data: eventTimeChartdate
		        }
		    ],
		    yAxis: [
		        {
		            type: 'value',
		            max: eventTimeChartmax,
		            interval: 20,
		        }
		    ],
		    dataZoom: {
		        type: 'inside',
		        start: 60,
		        end: 80
		    },
		    series: [
		        {
		            name:'成交',
		            type:'line',
		            smooth:true,
		            symbol: 'none',
		            stack: 'a',
		            areaStyle: {
		                normal: {}
		            },
		            data: eventTimeChartdata
		        }
		    ]
		};

		if (eventTimeChartoption && typeof eventTimeChartoption === "object") {
			var startTime = +new Date();
			eventTimeChartDomMyChart.hideLoading();
			eventTimeChartDomMyChart.setOption(eventTimeChartoption, true);
			var endTime = +new Date();
			var updateTime = endTime - startTime;
			console.log("eventTimeChartoption Time used:", updateTime);
		} else {
			console.log("eventTimeChartoption JSON get is fail");
		}
	});
</script>