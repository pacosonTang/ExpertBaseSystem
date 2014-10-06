<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/common.css">
	<link rel="stylesheet" type="text/css" href="css/icon.css"/>
	<link rel="stylesheet" type="text/css" href="ext4/resources/css/ext-all.css"/>
	
	<script type="text/javascript">
		var username = '<%=session.getAttribute("username")%>';
	</script>
	
	<script type="text/javascript" src="ext4/bootstrap.js"></script>
	<script type="text/javascript" src="ext4/locale/ext-lang-zh_CN.js"></script>
	
	<script type="text/javascript" src="app/model/Subject.js"></script>
	<script type="text/javascript" src="app/store/Subjects.js"></script>
	<script type="text/javascript" src="app/model/Level.js"></script>
	<script type="text/javascript" src="app/store/Levels.js"></script>
	<script type="text/javascript" src="app/model/Status.js"></script>
	<script type="text/javascript" src="app/store/Statuses.js"></script>
	<script type="text/javascript" src="app/model/Thesis.js"></script>
	<script type="text/javascript" src="app/model/Patent.js"></script>
	<script type="text/javascript" src="app/model/Award.js"></script>
	<script type="text/javascript" src="app/model/Project.js"></script>
	<script type="text/javascript" src="app/store/Awards.js"></script>
	<script type="text/javascript" src="app/store/Patents.js"></script>
	<script type="text/javascript" src="app/store/Thesises.js"></script>
	<script type="text/javascript" src="app/store/Projects.js"></script>
	<script type="text/javascript" src="app/model/Degree.js"></script>
	<script type="text/javascript" src="app/store/Educations.js"></script>
	<script type="text/javascript" src="app/store/Degrees.js"></script>
	<script type="text/javascript" src="app/model/Institution.js"></script>
	<script type="text/javascript" src="app/store/Institutions.js"></script>
	<script type="text/javascript" src="app/model/Major.js"></script>
	<script type="text/javascript" src="app/store/FirstMajors.js"></script>
	<script type="text/javascript" src="app/store/SecondMajors.js"></script>
	<script type="text/javascript" src="app/store/ThirdMajors.js"></script>
	<script type="text/javascript" src="app/model/Sex.js"></script>
	<script type="text/javascript" src="app/store/Sexs.js"></script>
	<script type="text/javascript" src="app/model/User.js"></script>
	<script type="text/javascript" src="app/store/Users.js"></script>
	<script type="text/javascript" src="app/model/Leader.js"></script>
	<script type="text/javascript" src="app/store/Leaders.js"></script>
	<script type="text/javascript" src="app/model/Server.js"></script>
	<script type="text/javascript" src="app/store/Servers.js"></script>
	<script type="text/javascript" src="app/controller/managerCl.js"></script>
	<script type="text/javascript" src="app/view/manager/managerMenu.js"></script>
	<script type="text/javascript" src="app/view/manager/managerPanel.js"></script>

  </head>
  
  <body>
    <div id="top">
    	<div id="information">
	        <div id="user">
	            <font color="#000000" size="-1">
	            	当前登录用户：<font color="#FF0000"><strong>${user.username}</strong></font>
	            </font>
	        </div>
	        <div id="operation">
	            <a href="exit.action"><font size="-1">注销</font></a>
	        </div>
	    </div>
    </div>
    <div id="main">
    	<h1>欢迎登录大学生科技创新园设备与耗材管理系统</h1>
    </div>
    <div id="bottom">
    	Copyright &copy; 2014, 四川省成都市科学技术协会,All Rights Reserved.
    </div>
    <div id="space">
    	
    </div>
    <div id="menu">
    	
    </div>
  </body>
</html>
