<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="xyz.charts.cmp.CmpChart" %>
<%
	String path = "L:/codesoft/Tomcat/apache-tomcat-7.0.68/webapps/dreaming/logFiles/a.log";
	CmpChart chart = new CmpChart(path, 1, 2);
	out.print(chart.getCmpStr());
%>