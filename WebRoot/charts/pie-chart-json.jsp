<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%-- 正确的JSON 
{"series":[{"name":"I am name 哈哈","data":[{"name":"搜索引擎","value":"400"},{"name":"直接访问","value":"335"},{"name":"邮件营销","value":"310"},{"name":"联盟广告","value":"274"},{"name":"视频广告","value":"235"}],"radius":"55%","type":"pie"}]}
--%>
<%@ page import="xyz.charts.barChart.BarChart" %>
<%
	String bar = BarChart.getBarChartJSON("a");  
	out.print(bar);
%>