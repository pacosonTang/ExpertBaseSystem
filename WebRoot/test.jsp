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
	<link href="<%=path %>/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
	<link href="<%=path %>/bootstrap/css/docs.css" rel="stylesheet">
    <script src="<%=path %>/bootstrap/js/prettify.js"></script>
	<link href="<%=path %>/bootstrap/css/prettify.css" rel="stylesheet">
    <script src="<%=path %>/bootstrap/js/jquery.js"></script>
    <script src="<%=path %>/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=path %>/bootstrap/js/bootstrap-tab.js"></script>
    
    
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
  	<div class="tabbable tabs-left">
       <ul class="nav nav-tabs">
         <li class="active"><a href="#lA" data-toggle="tab">Section 1</a></li>
         <li class=""><a href="#lB" data-toggle="tab">Section 2</a></li>
         <li class=""><a href="#lC" data-toggle="tab">Section 3</a></li>
       </ul>
       <div class="tab-content">
         <div class="tab-pane active" id="lA">
           <p>I'm in Section A.</p>
         </div>
         <div class="tab-pane" id="lB">
           <p>Howdy, I'm in Section B.</p>
         </div>
         <div class="tab-pane" id="lC">
           <p>What up girl, this is Section C.</p>
         </div>
       </div>
     </div>
  </body>
</html>
