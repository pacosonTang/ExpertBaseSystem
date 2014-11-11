<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'commone_top.jsp' starting page</title>
     <script src="<%=path %>/bootstrap/js/jquery.js"></script>
     <script type="text/javascript">
		$(function(){
			var cur_user = "<%=session.getAttribute("cur_realname")%>";
			if(cur_user == "null")
				window.location = "<%=basePath%>loginPage";
			var cur_level = "<%=session.getAttribute("cur_level")%>"; 
			if(cur_level == "0" || cur_level == "3")
				window.location = "<%=basePath%>loginPage";
		});
	</script>
  </head>
  
  <body>
    <span style="padding: 0px 80px">亲， 欢迎访问成都市科协专家库! </span>
   	<span style="padding-left: 500px;">用户类型： <s:property value="#session.cur_type"/></span>
   	<span style="padding: 0px 40px">用户名：<s:property value="#session.cur_realname"/></span>
   	<a href="<%=basePath %>logout">退出</a>  
  </body>
</html>
