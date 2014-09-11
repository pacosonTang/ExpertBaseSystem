<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>页面错误</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="专家信息库管理系统">
	<meta http-equiv="description" content="统一页面错误处理">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		body,div{margin:0;padding:0;}
		div{
			width:80%;
			height:100%;
			margin:50px auto;
		}
	</style>
  </head>
  
  <body>
    <div>
    	<font color="red" size="+4"><s:property value="exception.message"/></font><br/>
    	<font color="blue" size="+3">我们将尽快联系管理员，解决问题</font><br/>
    	<font color="blue" size="+3">造成不变，尽请谅解！</font><br/>
    	<a href="javascript(void);" onclick="history.go(-1);">返回</a>
    </div>
  </body>
</html>
