<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>会员注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="regedit.action" method="post">
    	姓名：<input name="user.realname" type="text"/>
    	性别：<input name="user.sex" type="text"/>
    	出生日期：<input name="userDetail.birthday" type="text"/><!-- 时间选择器 -->
    	身份证号：<input name="user.idNo" type="text"/>
    	学历：<!-- 从后台异步加载 -->
    	毕业院校:<input name="userDetail.school" type="text"/>
    	毕业时间:<input name="userDetail.graduateTime" type="text"/>
    	所学专业：<!-- 从后台异步加载 -->
    	学位：<!-- 使用ajax从后台异步加载 -->
    	所属协会：<!-- 从后台异步加载 -->
    	工作单位：<input name="user.realname" type="text"/>
    	专业技术职称：<input name="user.realname" type="text"/>
    	职务：<input name="user.realname" type="text"/>
    	手机：<input name="user.realname" type="text"/>
    	办公电话：<input name="user.realname" type="text"/>
    	邮编：<input name="user.realname" type="text"/>
    	电子邮箱：<input name="user.realname" type="text"/>
    	QQ：<input name="user.realname" type="text"/>
    	擅长领域：<textarea rows="20" cols="500" name="userDetail.adept"></textarea>
    	现从事专业：<input name="user.realname" type="text"/>
    </form>
  </body>
</html>
