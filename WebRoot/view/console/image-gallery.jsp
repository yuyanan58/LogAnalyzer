<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>Pretty Photo | BlueWhale Admin</title>
    <%@ include file="../include/head-include.jsp" %>
    <!-- <link rel="stylesheet" type="text/css" href="css/reset.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="css/text.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="css/grid.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="css/layout.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="css/nav.css" media="screen" />
    <link href="css/prettyPhoto.css" rel="stylesheet" type="text/css" />
    [if IE 6]><link rel="stylesheet" type="text/css" href="css/ie6.css" media="screen" /><![endif]
    [if IE 7]><link rel="stylesheet" type="text/css" href="css/ie.css" media="screen" /><![endif]
    BEGIN: load jquery
    <script src="js/jquery-1.6.4.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/jquery-ui/jquery.ui.core.min.js"></script>
    <script src="js/jquery-ui/jquery.ui.widget.min.js" type="text/javascript"></script>
    <script src="js/jquery-ui/jquery.ui.accordion.min.js" type="text/javascript"></script>
    <script src="js/jquery-ui/jquery.effects.core.min.js" type="text/javascript"></script>
    <script src="js/jquery-ui/jquery.effects.slide.min.js" type="text/javascript"></script>
    END: load jquery
    <script src="js/pretty-photo/jquery.prettyPhoto.js" type="text/javascript"></script>
    <script src="js/setup.js" type="text/javascript"></script> -->
    <script type="text/javascript">
        $(document).ready(function () {
            setupPrettyPhoto();
            setupLeftMenu();
			setSidebarHeight();
        });
    </script>
   
</head>
<body>
    <div class="container_12">
    	<div class="grid_12 header-repeat">
			<jsp:include page="../include/header.jsp"/>
        </div>
        <div class="clear">
        </div>
        <div class="grid_12">
			<jsp:include page="../include/nav.jsp" />
        </div>
        
        <div class="clear"> </div>
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
                    <h2>Gallery</h2>
                    <div class="block">
                    <ul class="prettygallery clearfix">
                        <li><a href="/dreaming/lib/img/pretty-photo/fullscreen/item1-full.jpg" rel="prettyPhoto[gallery2]"
                            title="">
                            <img src="/dreaming/lib/img/pretty-photo/thumbnails/item1.jpg" alt="This is a pretty long title" /></a></li>
                            
                        <li><a href="/dreaming/lib/img/pretty-photo/fullscreen/item2-full.jpg" rel="prettyPhoto[gallery2]"
                            title="Description on a single line.">
                            <img src="/dreaming/lib/img/pretty-photo/thumbnails/item2.jpg"  alt="" /></a></li>
                            
                        <li><a href="/dreaming/lib/img/pretty-photo/fullscreen/item3-full.png" rel="prettyPhoto[gallery2]">
                            <img src="/dreaming/lib/img/pretty-photo/thumbnails/item3.jpg"  alt="" /></a></li>
                            
                        <li><a href="/dreaming/lib/img/pretty-photo/fullscreen/item4-full.png" rel="prettyPhoto[gallery2]">
                            <img src="/dreaming/lib/img/pretty-photo/thumbnails/item4.jpg"  alt="" /></a></li>
                            
                        <li><a href="/dreaming/lib/img/pretty-photo/fullscreen/item5-full.png" rel="prettyPhoto[gallery2]">
                            <img src="/dreaming/lib/img/pretty-photo/thumbnails/item5.jpg"  alt="" /></a></li>
                            
                        <li><a href="/dreaming/lib/img/pretty-photo/fullscreen/item6-full.png" rel="prettyPhoto[gallery2]">
                            <img src="/dreaming/lib/img/pretty-photo/thumbnails/item6.jpg"  alt="" /></a></li>
                            
                        <li><a href="/dreaming/lib/img/pretty-photo/fullscreen/item7-full.png" rel="prettyPhoto[gallery2]">
                            <img src="/dreaming/lib/img/pretty-photo/thumbnails/item7.jpg"  alt="" /></a></li>
                            
                            
                        <li><a href="/dreaming/lib/img/pretty-photo/fullscreen/item8-full.png" rel="prettyPhoto[gallery2]">
                            <img src="/dreaming/lib/img/pretty-photo/thumbnails/item8.jpg"  alt="" /></a></li>
                            
                        <li><a href="/dreaming/lib/img/pretty-photo/fullscreen/item9-full.png" rel="prettyPhoto[gallery2]">
                            <img src="/dreaming/lib/img/pretty-photo/thumbnails/item9.jpg"  alt="" /></a></li>
                            
                        <li><a href="/dreaming/lib/img/pretty-photo/fullscreen/item10-full.png" rel="prettyPhoto[gallery2]">
                            <img src="/dreaming/lib/img/pretty-photo/thumbnails/item10.jpg"  alt="" /></a></li>
                            
                        <li><a href="/dreaming/lib/img/pretty-photo/fullscreen/item11-full.png" rel="prettyPhoto[gallery2]">
                            <img src="/dreaming/lib/img/pretty-photo/thumbnails/item11.jpg"  alt="" /></a></li>
                            
                        <li><a href="/dreaming/lib/img/pretty-photo/fullscreen/item12-full.png" rel="prettyPhoto[gallery2]">
                            <img src="/dreaming/lib/img/pretty-photo/thumbnails/item12.jpg"  alt="" /></a></li>
                            
                        <li><a href="/dreaming/lib/img/pretty-photo/fullscreen/item13-full.png" rel="prettyPhoto[gallery2]">
                            <img src="/dreaming/lib/img/pretty-photo/thumbnails/item13.jpg"  alt="" /></a></li>
                            
                    </ul>
                </div>
            </div>
        </div>
        <div class="clear">
        </div>
    </div>
    <div class="clear">
    </div>
    <div id="site_info">
        <p>
            Copyright <a href="#">BlueWhale Admin</a>. All Rights Reserved.
        </p>
    </div>
</body>
</html>
