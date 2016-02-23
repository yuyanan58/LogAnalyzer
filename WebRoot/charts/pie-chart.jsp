<%@ page language="java" import="java.util.*"  contentType="text/html; charset=utf-8"%>

<div id="pieChart" style="width: 100%; height: 100%"></div>
<script type="text/javascript">
	var dom = document.getElementById("pieChart");
	var myChart = echarts.init(dom);
	var app = {};
    $.getJSON("/dreaming/charts/pie-chart-json.jsp", function(option) {
        if (option && typeof option === "object") {
	        var startTime = +new Date();
	        myChart.setOption(option, true);
	        var endTime = +new Date();
	        var updateTime = endTime - startTime;
	        console.log("Pie Chart Time used:", updateTime);
    	}else{
    		console.log("Pie Chart JSON get is fail");
    	}
    });
</script>