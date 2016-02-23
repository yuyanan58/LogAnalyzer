<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>Typography | BlueWhale Admin</title>
	<%@ include file="./include/head-include.jsp" %>
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
			<jsp:include page="./include/header.jsp"/>
        </div>
        <div class="clear">
        </div>
        <div class="grid_12">
			<jsp:include page="./include/nav.jsp" />
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
                <h2>
                    Buttons</h2>
                <div class="block">
                    
                    
                    <h5>Sizes</h5>
				<button class="btn btn-small">Small Button</button>
				<button class="btn">Regular Button</button>
				<button class="btn btn-large">Large Button</button>
				
				<br /><br />
				

			
				<h5>Mini</h5>
				<a class="btn-mini btn-black btn-comment"><span></span>Comment</a>

				<a class="btn-mini btn-black btn-heart"><span></span>Like</a>
				<a class="btn-mini btn-black btn-star"><span></span>Favorite</a>
				<a class="btn-mini btn-black btn-cart"><span></span>Shopping Cart</a>
				<a class="btn-mini btn-black btn-print"><span></span>Print Page</a>
				<a class="btn-mini btn-black btn-rss"><span></span>RSS Feed</a>
				
				
				<a class="btn-mini btn-black btn-person"><span></span>Add User</a>
			
				<a class="btn-mini btn-black btn-check"><span></span>Accept</a>
				<a class="btn-mini btn-black btn-dollar"><span></span>Money</a>
				<a class="btn-mini btn-black btn-refresh"><span></span>Refresh</a>
				<a class="btn-mini btn-black btn-home"><span></span>Go Home</a>
				<a class="btn-mini btn-black btn-plus"><span></span>Add</a>
				
				
				<a class="btn-mini btn-black btn-minus"><span></span>Remove</a>
			
				<a class="btn-mini btn-black btn-cross"><span></span>Delete</a>
				<a class="btn-mini btn-black btn-arrow-left"><span></span>Left</a>
				<a class="btn-mini btn-black btn-arrow-right"><span></span>Right</a>
				<a class="btn-mini btn-black btn-arrow-up"><span></span>Up</a>
				<a class="btn-mini btn-black btn-arrow-down"><span></span>Down</a>
				
				
				
				
				<br /><br />
				

			
				<h5>Icon</h5>
				<button class="btn-icon btn-grey btn-comment"><span></span>Comment</button>

				<button class="btn-icon btn-grey btn-heart"><span></span>Like</button>
				<button class="btn-icon btn-grey btn-star"><span></span>Favorite</button>
				<button class="btn-icon btn-grey btn-cart"><span></span>Shopping Cart</button>
				<button class="btn-icon btn-grey btn-print"><span></span>Print Page</button>
				<button class="btn-icon btn-grey btn-rss"><span></span>RSS Feed</button>
				
				
				<button class="btn-icon btn-grey btn-person"><span></span>Add User</button>
			
				<button class="btn-icon btn-grey btn-check"><span></span>Accept</button>
				<button class="btn-icon btn-grey btn-dollar"><span></span>Money</button>
				<button class="btn-icon btn-grey btn-refresh"><span></span>Refresh</button>
                
                <br /><br />
                
				<button class="btn-icon btn-grey btn-home"><span></span>Go Home</button>
				<button class="btn-icon btn-grey btn-plus"><span></span>Add</button>
				
				
				<button class="btn-icon btn-grey btn-minus"><span></span>Remove</button>
			
				<button class="btn-icon btn-grey btn-cross"><span></span>Delete</button>
				<button class="btn-icon btn-grey btn-arrow-left"><span></span>Left</button>
				<button class="btn-icon btn-grey btn-arrow-right"><span></span>Right</button>
				<button class="btn-icon btn-grey btn-arrow-up"><span></span>Up</button>
				<button class="btn-icon btn-grey btn-arrow-down"><span></span>Down</button>
				
				<br /><br />
				
				<h5>Extra Colors</h5>
				
				<button class="btn btn-blue">Button</button>

				<button class="btn btn-orange">Button</button>
				<button class="btn btn-red">Button</button>
				<button class="btn btn-green">Button</button>
				<button class="btn btn-black">Button</button>
				<button class="btn btn-purple">Button</button>
				<button class="btn btn-navy">Button</button>
			
				<button class="btn btn-maroon">Button</button>
				<button class="btn btn-grey">Button</button>
				<button class="btn btn-yellow">Button</button>
				<button class="btn btn-teal">Button</button>
				<button class="btn btn-pink">Button</button>
                    
                    
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
