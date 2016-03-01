<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="xyz.charts.cmp.CmpChart" %>
<%@ page import="xyz.config.logpath.LogPath" %>
<%
	String path = LogPath.LOGPATH_STRING + "a.log";
	CmpChart chart = new CmpChart(path, 3, 1);
	out.print(chart.getCmpStr());
%>
