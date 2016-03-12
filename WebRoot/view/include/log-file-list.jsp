<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="xyz.tools.fileutils.FileUtils" import="java.io.File" %>
<%@ page import="xyz.config.logpath.LogPath" %>
<ul class="prettygallery clearfix">
<%
	String path = LogPath.LOGPATH_STRING ;
	String[] fileList = FileUtils.ListDirectory( new File(path) );
	String s1 = "<li><a href=\"/dreaming/logFiles/" ;
	String s2 = " \" rel=\"prettyPhoto[gallery2]\"title=\" " ;
	String s3 = " \"> <img src=\"/dreaming/lib/img/log-logo.jpg\" /><br/> <p> ";
	String s4 = "</p> </a> </li>" ;
	for(String str:fileList){
		out.print(s1) ;
		out.print(str) ;
		out.print(s2) ;
		out.print(str) ;
		out.print(s3) ;
		out.print(str) ;
		out.print(s4) ;
	}
%>
</ul>
