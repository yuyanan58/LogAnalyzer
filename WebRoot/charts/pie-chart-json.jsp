<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="xyz.charts.pie.PieChart" %>
<%
	String path = "L:/codesoft/Tomcat/apache-tomcat-7.0.68/webapps/dreaming/logFiles/a.log";
	PieChart pieChart = new PieChart(path);  
	out.print(pieChart.getPieStr());
%>