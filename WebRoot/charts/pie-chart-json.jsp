<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%-- <%@ page import="xyz.charts.barChart.BarChart" %>
<%
	String bar = BarChart.getBarChartJSON("a");  
	out.print(bar);
%> --%>
{
	"data1" : [ "直接访问", "邮件营销", "联盟广告", "视频广告", "搜索引擎" ],
	"data2" : [ 
		{
			"value" : 335,
			"name" : "直接访问"
		}, {
			"value" : 310,
			"name" : "邮件营销"
		}, {
			"value" : 234,
			"name" : "联盟广告"
		}, {
			"value" : 135,
			"name" : "视频广告"
		}, {
			"value" : 1548,
			"name" : "搜索引擎"
		} 
	]
}