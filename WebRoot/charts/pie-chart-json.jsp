<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="xyz.charts.pie.PieChart" %>
<%@ page import="xyz.config.logpath.LogPath" %>
<%
	String path = LogPath.LOGPATH_STRING + "a.log";
	PieChart pieChart = new PieChart(path);  
	out.print(pieChart.getPieStr());
%>