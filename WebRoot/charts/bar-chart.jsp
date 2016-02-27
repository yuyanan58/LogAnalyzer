<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>

<div id="barChart" style="width: 100%; height: 100%"></div>
<script type="text/javascript">
	var barChartDom = document.getElementById("barChart");
	var barChartMyChart = echarts.init(barChartDom);
	var app = {};
    $.getJSON("/dreaming/charts/bar-chart-json.jsp", function(dataALL) {
    	var barChartXdata = dataALL.X_data;
    	var barChartSeries = dataALL.ALL_data;
    	var barChartName = dataALL.NAME_data;
    	var barChartMAX = dataALL.MAX_data;
    	
    	barChartoption = {
    		    "tooltip" : {
    		        "trigger": "axis"
    		    },
    		    "toolbox": {
    		        "show" : true,
    		        "feature" : {
    		            "mark" : {"show": "true"},
    		            "dataView": {"show": "true", "readOnly": "false"},
    		            "magicType": {"show": "true", "type": ["line", "bar"]},
    		            "restore" : {"show": "true"},
    		            "saveAsImage" : {"show": "true"}
    		        }
    		    },
    		    "calculable" : "true",
    		    "legend": {
    		        "data":barChartName
    		    },
    		    "xAxis" : [
    		        {
    		            "type" : "category",
    		            "data" : barChartXdata
    		        }
    		    ],
    		    "yAxis" : [
    		        {
    		            "type" : "value",
    		            "name" : "事件发生的次数",
    		            "min": 0,
    		            "max": barChartMAX,
    		            "interval": 30,
    		            "axisLabel" : {
    		                "formatter": "{value} 次"
    		            }
    		        }
    		    ],
    		    "series" : barChartSeries
    		};

        if (barChartoption && typeof barChartoption === "object") {
	        var startTime = +new Date();
	        barChartMyChart.hideLoading();
	        barChartMyChart.setOption(barChartoption, true);
	        var endTime = +new Date();
	        var updateTime = endTime - startTime;
	        console.log("Bar Chart Time used:", updateTime);
    	}else{
    		console.log("Bar Chart JSON get is fail");
    	}
    });
</script>