<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>

<div id="cmpChart" style="width: 100%; height: 100%"></div>
<script type="text/javascript">
	var cmpChartOptionDom = document.getElementById("cmpChart");
	var cmpChartOptionMyChart = echarts.init(cmpChartOptionDom);
	var app = {};
	$.getJSON("/dreaming/charts/cmp-chart-json.jsp", function(dataALL) {
		var cmpChartTimeTamp_data = dataALL.time_data;
		var cmpChartData2_data = dataALL.data2_data;
		var cmpChartData1_data = dataALL.data1_data;
		var cmpChartNameStr0    = dataALL.name0;
		var cmpChartNameStr1    = dataALL.name1;
		
		cmpChartOption = {
			    title : {
			        text: '两中事件之间的关系',
			        subtext: '默认为发生次数最多的两种事件',
			        x: 'center',
			        align: 'right'
			    },
			    grid: {
			        bottom: 80
			    },
			    tooltip : {
			        trigger: 'axis',
			        formatter: function(params) {
			            return params[0].name + '<br/>'
			                   + params[0].seriesName + ' : ' + params[0].value + '<br/>'
			                   + params[1].seriesName + ' : ' + params[1].value + '';
			        },
			        axisPointer: {
			            animation: false
			        }
			    },
			    legend: {
			        data:[cmpChartNameStr0,cmpChartNameStr1],
			        x: 'left'
			    },
			    dataZoom: [
			        {
			            show: true,
			            realtime: true,
			            start: 60,
			            end: 80
			        },
			        {
			            type: 'inside',
			            realtime: true,
			            start: 60,
			            end: 180
			        }
			    ],
			    xAxis : [
			        {
			            type : 'category',
			            boundaryGap : false,
			            axisLine: {onZero: false},
			            data : cmpChartTimeTamp_data.map(function (str) {
			                return str.replace(' ', '\n')
			            })
			        }
			    ],
			    yAxis: [
			        {
			            name: 'event1<次>',
			            type: 'value',
			            max: 13
			        },
			        {
			            name: 'event2<次>',
			            nameLocation: 'start',
			            max: 13,
			            type: 'value',
			            inverse: true
			        }
			    ],
			    series: [
			        {
			            name:cmpChartNameStr0,
			            type:'line',
			            hoverAnimation: false,
			            areaStyle: {
			                normal: {}
			            },
			            lineStyle: {
			                normal: {
			                    width: 1
			                }
			            },
			            data:cmpChartData1_data
			        },
			        {
			            name:cmpChartNameStr1,
			            type:'line',
			            yAxisIndex:1,
			            hoverAnimation: false,
			            areaStyle: {
			                normal: {}
			            },
			            lineStyle: {
			                normal: {
			                    width: 1
			                }
			            },
			            data: cmpChartData2_data
			        }
			    ]
			};
		
		if (cmpChartOption && typeof cmpChartOption === "object") {
			var startTime = +new Date();
			cmpChartOptionMyChart.setOption(cmpChartOption, true);
			var endTime = +new Date();
			var updateTime = endTime - startTime;
			console.log("Pie Chart Time used:", updateTime);
		} else {
			console.log("Pie Chart JSON get is fail");
		}
	});
</script>