<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="xyz.charts.event_time.EventTimeChart" %>
<%@ page import="xyz.config.logpath.LogPath" %>
<%
	String path = LogPath.LOGPATH_STRING + "a.log";
	EventTimeChart eventTimeChart = new EventTimeChart(path) ;
	out.print(eventTimeChart.getEventTimeStr());
%>