<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'gdjt.jsp' starting page</title>
	
	<!--  -->
	<link href="<%=path %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=path %>/bootstrap/css/docs.css" rel="stylesheet">
	<!--<link href="<%=path %>/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
    <script src="<%=path %>/bootstrap/js/prettify.js"></script>
	<link href="<%=path %>/bootstrap/css/prettify.css" rel="stylesheet"> -->
    <script src="<%=path %>/bootstrap/js/jquery.js"></script>
    <script src="<%=path %>/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=path %>/bootstrap/js/bootstrap-dropdown.js"></script>
    
    
    <script type="text/javascript">
    
    	function toggleMenu(index){
			
			$("ul[id='someone'] > li").removeClass("active");
			$("ul[id='someone'] > li:eq(" + index + ")").addClass("active");
			document.getElementById("item" + index).scrollIntoView();
			return false;
		}
		
    </script>
  </head>
  <body>
  	 你好
  	 <ul class="nav nav-pills" style="margin-left: 20px;">
               
              <li class="dropdown active open">
                <a class="dropdown-toggle" id="drop4" role="button" data-toggle="dropdown" href="javascript:return false;" style="padding:10px 45px;">会员信息 <b class="caret"></b></a>
                <ul id="menu1" class="dropdown-menu" role="menu" aria-labelledby="drop4">
                  <li role="presentation"><a role="menuitem" tabindex="-1" href="#" style="padding: 3px 10px;">会员统计柱状图</a></li>
                  <li role="presentation" class="divider"></li>
                  <li role="presentation"><a role="menuitem" tabindex="-1" href="#">会员列表</a></li>
                </ul>
              </li>
            </ul>
  </body>
</html>
