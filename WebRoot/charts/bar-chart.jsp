<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<div id="barChart" style="width: 100%; height: 100%"></div>
<script type="text/javascript">
	var barChartDom = document.getElementById("barChart");
	var barChartMyChart = echarts.init(barChartDom);
	var app = {};
    $.getJSON("/dreaming/charts/bar-chart-json.jsp", function(option) {
        if (option && typeof option === "object") {
	        var startTime = +new Date();
	        barChartMyChart.setOption(option, true);
	        var endTime = +new Date();
	        var updateTime = endTime - startTime;
	        console.log("Bar Chart Time used:", updateTime);
    	}else{
    		console.log("Bar Chart JSON get is fail");
    	}
    });
</script>