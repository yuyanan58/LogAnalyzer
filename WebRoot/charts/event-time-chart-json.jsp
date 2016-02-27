<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="xyz.charts.event_time.EventTimeChart" %>
<%
	String path = "L:/codesoft/Tomcat/apache-tomcat-7.0.68/webapps/dreaming/logFiles/a.log";
	EventTimeChart eventTimeChart = new EventTimeChart(path) ;
	out.print(eventTimeChart.getEventTimeStr());
%>