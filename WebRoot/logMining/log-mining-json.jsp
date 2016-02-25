<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="logming.LogMining" %>
<%
	String logPath = "L:/codesoft/Tomcat/apache-tomcat-7.0.68/webapps/dreaming/logFiles/a.log";
	LogMining logMining = new LogMining(logPath) ;
	out.print(logMining.getLogMinJson());
%>