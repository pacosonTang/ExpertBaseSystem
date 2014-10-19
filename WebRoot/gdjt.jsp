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
	<link href="<%=path %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="<%=path %>/bootstrap/js/jquery.js"></script>
    <script src="<%=path %>/bootstrap/js/bootstrap.min.js"></script>
    
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
  	<div style="margin-left: 80px;width: 940px;margin-top: 300px;">
	<nav id="navbar-example" class="navbar navbar-default navbar-static" role="navigation">
	   <div class="navbar-header">
	      <button class="navbar-toggle" type="button" data-toggle="collapse" 
	         data-target=".bs-js-navbar-scrollspy">
	         <span class="icon-bar"></span>
	         <span class="icon-bar"></span>
	         <span class="icon-bar"></span>
	         <span class="icon-bar"></span>
	         <span class="icon-bar"></span>
	      </button>
	      <!-- <a class="navbar-brand" href="#">教程名称</a> -->
	   </div>
	   <div class="collapse navbar-collapse bs-js-navbar-scrollspy" style="padding: 0px;margin: 0px;height: 30px;">
	      <ul class="nav navbar-nav" style="margin: 0px;" id="someone">
	         <li class="active"><a href="javascript:toggleMenu(0)">会员列表</a></li>
	         <li><a href="javascript:toggleMenu(1)">会员详细资料</a></li>
	         <li><a href="javascript:toggleMenu(2)">科研项目</a></li>
	         <li><a href="javascript:toggleMenu(3)">成果奖励</a></li>
	         <li><a href="javascript:toggleMenu(4)">科技论文</a></li>
	         <li><a href="javascript:toggleMenu(5)">发明专利</a></li>
	      </ul>
	   </div>
	</nav>
	
	<div data-spy="scroll" data-target="#navbar-example" data-offset="0" style="height:200px;overflow:auto; position: relative;">
	   
	   <h4 id="item0" style="margin-top: 200px;">list</h4>
	   <p>iOS 是一个由苹果公司开发和发布的手机操作系统。最初是于 2007 年首次发布 iPhone、iPod Touch 和 Apple 
	      TV。iOS 派生自 OS X，它们共享 Darwin 基础。OS X 操作系统是用在苹果电脑上，iOS 是苹果的移动版本。
	   </p>
	   
	   <h4 id="item1" style="margin-top: 200px;">specific</h4>
	   <p>Apache Subversion，通常缩写为 SVN，是一款开源的版本控制系统软件。Subversion 由 CollabNet 公司在 2000 年创建。但是现在它已经发展为 Apache Software Foundation 的一个项目，因此拥有丰富的开发人员和用户社区。
	   </p>
	   
	   <h4 id="item2" style="margin-top: 200px;">pro</h4>
	   <p>jMeter 是一款开源的测试软件。它是 100% 纯 Java 应用程序，用于负载和性能测试。
	   </p>
	   
	   <h4 id="item3" style="margin-top: 200px;">award</h4>
	   <p>Enterprise Java Beans（EJB）是一个创建高度可扩展性和强大企业级应用程序的开发架构，部署在兼容应用程序服务器（比如 JBOSS、Web Logic 等）的 J2EE 上。
	   </p>
	   
	   <h4 id="item4" style="margin-top: 200px;">thesis</h4>
	   <p>Spring 框架是一个开源的 Java 平台，为快速开发功能强大的 Java 应用程序提供了完备的基础设施支持。
	   </p>
	    
	   <h4 id="item5" style="margin-top: 200px;">patent</h4>
	   <p>Spring 框架是一个开源的 Java 平台，为快速开发功能强大的 Java 应用程序提供了完备的基础设施支持。
	   </p>
	    
	</div>
  
  </div>
  
  </body>
</html>
