<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="xyz.charts.barChart.BarChart" %>
<%
	String bar = BarChart.getBarChartJSON("a");  
	out.print(bar);
%>