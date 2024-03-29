﻿<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>Charts | BlueWhale Admin</title>
    
    <jsp:include page="../view/include/head-include.jsp" />
	<jsp:include page="../view/include/my-head-include-file.jsp"/>
	
    <script type="text/javascript">
        $(document).ready(function () {
            setupLeftMenu();
			setSidebarHeight();
        });
    </script>
</head>
<body>
    <div class="container_12">
    
        <div class="grid_12 header-repeat">
			<jsp:include page="../view/include/header.jsp"/>
        </div>
        <div class="clear">
        </div>
        <div class="grid_12">
			<jsp:include page="../view/include/nav.jsp" />
        </div>
        
        <div class="clear">
        </div>
        <div class="grid_2">
            <div class="box sidemenu">
                <div class="block" id="section-menu">
                    <ul class="section menu">
                        <li><a class="menuitem">Menu 1</a>
                            <ul class="submenu">
                                <li><a>Submenu 1</a> </li>
                                <li><a>Submenu 2</a> </li>
                                <li><a class="active">Submenu 3</a> </li>
                                <li><a>Submenu 4</a> </li>
                                <li><a>Submenu 5</a> </li>
                            </ul>
                        </li>
                        <li><a class="menuitem">Menu 2</a>
                            <ul class="submenu">
                                <li><a>Submenu 1</a> </li>
                                <li><a>Submenu 2</a> </li>
                                <li><a>Submenu 3</a> </li>
                                <li><a>Submenu 4</a> </li>
                                <li><a>Submenu 5</a> </li>
                            </ul>
                        </li>
                        <li><a class="menuitem">Menu 3</a>
                            <ul class="submenu">
                                <li><a>Submenu 1</a> </li>
                                <li><a>Submenu 2</a> </li>
                                <li><a>Submenu 3</a> </li>
                                <li><a>Submenu 4</a> </li>
                                <li><a>Submenu 5</a> </li>
                            </ul>
                        </li>
                        <li><a class="menuitem">Menu 4</a>
                            <ul class="submenu">
                                <li><a>Submenu 1</a> </li>
                                <li><a>Submenu 2</a> </li>
                                <li><a>Submenu 3</a> </li>
                                <li><a>Submenu 4</a> </li>
                                <li><a>Submenu 5</a> </li>
                            </ul>
                        </li>
                    </ul>
                    
                    
                </div>
            </div>
        </div>
                
        <div class="grid_10">
            <div class="box round">
                <h2>Pie-Chart</h2>
        		 <div class="ec-pie-chart">
        		 	<jsp:include page="/charts/pie-chart.jsp" />
				 </div>                
            </div>
        </div>
        
        <div class="grid_10">
            <div class="box round">
                <h2>事件发生的时间分布</h2>
        		 <div class="ec-event-time-chart">
        		 	<jsp:include page="/charts/event-time-chart.jsp" />
				 </div>                
            </div>
        </div>
        
        <div class="grid_10">
        	<div class="box round first">
        		 <h2>Bar-Chart</h2>
        		 <div class="ec-bar-chart">
        		 	<jsp:include page="/charts/bar-chart.jsp" />
				 </div>

            </div>     
        </div>
        
        <div class="grid_10">
            <div class="box round">
                <h2>Cmp-Chart</h2>
        		 <div class="ec-cmp-chart">
        		 	<jsp:include page="/charts/cmp-chart.jsp" />
				 </div>                
            </div>
        </div>
                       
<!--    暂时用不到这样的图。     
		<div class="grid_5">
        	<div class="box round">
        		 <h2> Charts</h2>
                 <div id="donuts-chart">
                    </div>
            </div>     
        </div>
        <div class="grid_5">
        	<div class="box round">
        		 <h2> Charts</h2>
                  <div id="bubble-chart">
                    </div>
            </div>     
        </div> 
-->
        
        <div class="clear">
        </div>
    </div>
    <div class="clear">
    </div>
    <div id="site_info">
		<jsp:include page="../view/include/site-info.jsp"/>
    </div>
</body>
</html>
