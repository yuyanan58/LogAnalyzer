<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>Dashboard | BlueWhale Admin</title>
	<%@ include file="./include/head-include.jsp" %>
	<%@ include file="./include/my-head-include-file.jsp" %>	
	<script type="text/javascript">
        $(document).ready(function () {
            //setupDashboardChart('chart1');
            setupLeftMenu();
			setSidebarHeight();
        });
    </script>

<style type="text/css">
	p {font-size:16px;}
</style>
</head>

<body>
    <div class="container_12">
        <div class="grid_12 header-repeat">
            <jsp:include page="./include/header.jsp" />
        </div>
        <div class="clear"></div>
        <div class="grid_12">
            <%@ include file="./include/nav.jsp" %>
        </div>
        <div class="clear"></div>
        <div class="grid_2">
            <div class="box sidemenu">
                <div class="block" id="section-menu">
                    <ul class="section menu">
                        <li><a class="menuitem">Menu 1</a>
                            <ul class="submenu">
                                <li><a>Submenu 1</a> </li>
                                <li><a>Submenu 2</a> </li>
                              
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
                                <li><a>Submenu 6</a> </li>
                                <li><a>Submenu 7</a> </li>
                                <li><a>Submenu 8</a> </li>
                                <li><a>Submenu 9</a> </li>
                                <li><a>Submenu 10</a> </li>
                    
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="grid_10">
            <div class="box round first">
                <h2>网站介绍</h2>
               	<div class="block">
  					<p class="start">
  					<jsp:include page="./doc/introduction-p.jsp" />
  					</p>	
                </div>
            </div>
            <div class="box round">
                <h2>研究目标和方法</h2>
                <div class="block">
					<jsp:include page="./doc/aim-p.jsp" />
                    <div class="clear">
                    </div>
                </div>
            </div>
            <div class="box round">
                <h2>预计成果</h2>
                <div class="block">
					<jsp:include page="./doc/wangdachui-p.jsp" />
                    <div class="clear">
                    </div>
                </div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
    <div class="clear"></div>
    <div id="site_info">
       <%@ include file="./include/site-info.jsp" %>
    </div>
</body>
</html>
