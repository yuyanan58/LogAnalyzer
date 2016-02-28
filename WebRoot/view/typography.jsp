<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>Typography | BlueWhale Admin</title>
    <jsp:include page="./include/head-include.jsp" />
  <script type="text/javascript">
        $(document).ready(function () {
            setupLeftMenu();
			setSidebarHeight();
        });
    </script>

<style type="text/css">
	.link{
		font-size:16px;
		color:#0000FF;
		text-decoration: underline;
	}
</style>
</head>
<body>
    <div class="container_12">
        <div class="grid_12 header-repeat">
            <jsp:include page="./include/header.jsp" />
        </div>
        <div class="clear"> </div>
        <div class="grid_12">
        	<jsp:include page="./include/nav.jsp" />
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
            <div class="box round first">
                <h2> 论文集</h2>
                <div class="block">
                    <!-- paragraphs -->
					<a href="/dreaming/paper/An Algorithmic Approach to Event Summarization.pdf"><p class="link">An Algorithmic Approach to Event Summarization</p></a>
                    <a href="/dreaming/paper/Constructing Comprehensive Summaries of Large Event.pdf"><p class="link">Constructing Comprehensive Summaries of Large Event </p></a>
                    <a href="/dreaming/paper/Incident Ticket Analytics for IT Application Management Services .pdf"><p class="link">Incident Ticket Analytics for IT Application Management Services  </p></a>
                    <a href="/dreaming/paper/TRAN-An Algorithmic Approach to Event Summarization.pdf"><p class="link">TRAN-An Algorithmic Approach to Event Summarization </p></a>
                    <a href="/dreaming/paper/TRAN-Constructing Comprehensive Summaries of Large Event.pdf.pdf"><p class="link">TRAN-Constructing Comprehensive Summaries of Large Event </p></a>
                    <a href="/dreaming/paper/TRAN-Incident Ticket Analytics for IT Application Management Services .pdf"><p class="link">TRAN-Incident Ticket Analytics for IT Application Management Services </p></a>
                    <a href="/dreaming/paper/Time Series Frequent Pattern Mining Algorithm.pdf"><p class="link"> 一种时间序列频繁模式挖掘算法及其在WSAN行为预测中的应用</p></a>
                </div>
            </div>
        </div>
        <div class="clear">
        </div>
    </div>
    <div class="clear">
    </div>
    <div id="site_info">
		<jsp:include page="./include/site-info.jsp"/>
    </div>
    
</body>
</html>
