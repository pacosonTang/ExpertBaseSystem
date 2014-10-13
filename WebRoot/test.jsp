<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册账号</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <link href="<%=path %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="<%=path %>/bootstrap/js/jquery.js"></script>
    <script src="<%=path %>/bootstrap/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
		
		$(function(){
			
			$(".form-control").bind("click", function() {
			  alert("User clicked on foo.");
			});
			load_subject();
			
		});
		
		
		function load_subject(){//添加评论
			//请求的地址 　　
			var url = "count/subject!findSubject";
			alert("发送请求");
			$.post(url,{
					postid:"1"
				},
				function(data){
					member = eval('('+data+')');
					alert("回复成功!我日你哥哥");
				},"json"); 
		}
		
	</script>
	
  </head>
  
  <body>
		
		   
  </body>
   
</html>
