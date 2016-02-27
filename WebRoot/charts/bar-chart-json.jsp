<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="xyz.charts.bar.BarChart" %>
<%
	String path = "L:/codesoft/Tomcat/apache-tomcat-7.0.68/webapps/dreaming/logFiles/a.log";
	BarChart bar = new BarChart(path);
	out.print(bar.getBarChartStr());
%>
         
         