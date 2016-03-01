<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="logming.LogMining" %>
<%@ page import="xyz.config.logpath.LogPath" %>
<!-- BEGIN: LONMINING TABLE-->
<table class="data display datatable" id="example">
	<thead>
		<tr>
			<th>摘要描述</th>
		</tr>
	</thead>
	<tbody class="logminingtable">    
        <tr><td>蛤蛤蛤，以上就是LogMining输出的结果。 </td></tr>
        <%
	        String logPath = LogPath.LOGPATH_STRING + "a.log";
        	LogMining logMining = new LogMining(logPath);
        	String[] t = logMining.getLogMiningString() ;
        	for(int i = 0 ; i < t.length ; i ++){
        		if(i % 2 == 0){
        			out.print("<tr class=\"odd gradeA\"><td>");
        		}else{
        			out.print("<tr class=\"even gradeA\"><td>");        			
        		}
        		out.println( t[i]  + "</td></tr>");
        	}
        %>        
	</tbody>
</table>
<!-- BEGIN: LONMINING TABLE-->
