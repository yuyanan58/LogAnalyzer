<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="xyz.charts.bar.BarChart" %>
<%@ page import="xyz.config.logpath.LogPath" %>
<%
	String path = LogPath.LOGPATH_STRING + "a.log";
	BarChart bar = new BarChart(path);
	out.print(bar.getBarChartStr());
%>
         
         