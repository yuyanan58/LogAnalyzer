<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="logming.LogMining" %>
<%@ page import="xyz.config.logpath.LogPath" %>
<%
	String path = LogPath.LOGPATH_STRING + "a.log";
	LogMining logMining = new LogMining(path) ;
	out.print(logMining.getLogMinJson());
%>