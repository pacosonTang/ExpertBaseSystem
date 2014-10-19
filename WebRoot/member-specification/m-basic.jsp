<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'basic.jsp' starting page</title>
    <link href="<%=path %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="<%=path %>/bootstrap/js/jquery.js"></script>
    <script src="<%=path %>/bootstrap/js/bootstrap.min.js"></script>
    <style type="text/css">
    	
    	.table>tbody>tr>td{
    		padding:3px;	
    	}
    	th{
    		text-align: center;
    	}	 
    </style>
    
    <script type="text/javascript">
    	
    	$(function(){
    		
    	});
    	
    </script>
    
  </head>
  
  <body>
  		
	<nav id="navbar-example" class="navbar navbar-default navbar-static" role="navigation">
	   <div class="navbar-header">
	      <button class="navbar-toggle" type="button" data-toggle="collapse" 
	         data-target=".bs-js-navbar-scrollspy">
	         <span class="sr-only">切换导航</span>
	         <span class="icon-bar"></span>
	         <span class="icon-bar"></span>
	         <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#">教程名称</a>
	   </div>
	   <div class="collapse navbar-collapse bs-js-navbar-scrollspy">
	      <ul class="nav navbar-nav">
	         <li><a href="#ios">iOS</a></li>
	         <li><a href="#svn">SVN</a></li>
	         <li class="dropdown">
	            <a href="#" id="navbarDrop1" class="dropdown-toggle" 
	               data-toggle="dropdown">Java
	               <b class="caret"></b>
	            </a>
	            <ul class="dropdown-menu" role="menu" 
	               aria-labelledby="navbarDrop1">
	               <li><a href="#jmeter" tabindex="-1">jmeter</a></li>
	               <li><a href="#ejb" tabindex="-1">ejb</a></li>
	               <li class="divider"></li>
	               <li><a href="#spring" tabindex="-1">spring</a></li>
	            </ul>
	         </li>
	      </ul>
	   </div>
	</nav>
	<div data-spy="scroll" data-target="#navbar-example" data-offset="0" 
	   style="height:200px;overflow:auto; position: relative;">
	   <h4 id="ios">iOS</h4>
	   <p>iOS 是一个由苹果公司开发和发布的手机操作系统。最初是于 2007 年首次发布 iPhone、iPod Touch 和 Apple 
	      TV。iOS 派生自 OS X，它们共享 Darwin 基础。OS X 操作系统是用在苹果电脑上，iOS 是苹果的移动版本。
	   </p>
	   <h4 id="svn">SVN</h4>
	   <p>Apache Subversion，通常缩写为 SVN，是一款开源的版本控制系统软件。Subversion 由 CollabNet 公司在 2000 年创建。但是现在它已经发展为 Apache Software Foundation 的一个项目，因此拥有丰富的开发人员和用户社区。
	   </p>
	   <h4 id="jmeter">jMeter</h4>
	   <p>jMeter 是一款开源的测试软件。它是 100% 纯 Java 应用程序，用于负载和性能测试。
	   </p>
	   <h4 id="ejb">EJB</h4>
	   <p>Enterprise Java Beans（EJB）是一个创建高度可扩展性和强大企业级应用程序的开发架构，部署在兼容应用程序服务器（比如 JBOSS、Web Logic 等）的 J2EE 上。
	   </p>
	   <h4 id="spring">Spring</h4>
	   <p>Spring 框架是一个开源的 Java 平台，为快速开发功能强大的 Java 应用程序提供了完备的基础设施支持。
	   </p>
	   <p>Spring 框架最初是由 Rod Johnson 编写的，在 2003 年 6 月首次发布于 Apache 2.0 许可证下。
	   </p>
	</div>

  
       <table class="table table-bordered" style="font-size: 13px;margin: 0px;text-align: center">
     	<tbody>
     	
     	<tr><!-- 基本 信息 start -->
     		<th colspan="6"><a class="btn btn-primary" href="javascript: return false;" style="width: 100%;font-size: 16px;padding: 5px;">基本信息</a></th>
     	</tr>
     	<tr>
     		<th>姓名</th>
     		<th>身份证号</th>
     		<th>性别</th>
     		<th colspan="3">生日</th>
     	</tr>
     	<tr>
     		<td>周锐锋</td>
     		<td>510102196910174364</td>
     		<td>女</td>
     		<td colspan="3">1969-10-17</td>
     	</tr><!-- 基本 信息 end -->
     	
     	<tr><!-- 教育 信息 start -->
     		<th colspan="6"><a class="btn btn-primary" href="javascript: return false;" style="width: 100%;font-size: 16px;padding: 5px;">教育信息</a></th>
     	</tr>
     	<tr>
     		<th>毕业院校</th>
     		<th>所学专业</th>
     		<th>毕业时间</th>
     		<th>学历</th>
     		<th colspan="2">学位</th>
     	</tr>
     	<tr>
     		<td>重庆医科大学</td>
     		<td>临床医学</td>
     		<td>1992-07-06</td>
     		<td>本科</td>
     		<td colspan="2">学士</td>
     	</tr><!-- 教育 信息 end -->
     	
     	<tr><!-- 职业 信息 start -->
     		<th colspan="6"><a class="btn btn-primary" href="javascript: return false;" style="width: 100%;font-size: 16px;padding: 5px;">职业信息</a></th>
     	</tr>
     	<tr>
     		<th>所属学会</th>
     		<th>工作单位</th>
     		<th>技术职称</th>
     		<th>职务</th>
     		<th colspan="2">现从事专业</th>
     	</tr>
     	<tr>
     		<td>成都市防痨协会</td>
     		<td>成都市公共卫生临床医疗中心</td>
     		<td>副主任医师</td>
     		<td>医疗组长</td>
     		<td colspan="2">艾滋病临床</td>
     	</tr><!-- 职业 信息 end -->
     	
     	<tr><!-- 联系 信息 start -->
     		<th colspan="6"><a class="btn btn-primary" href="javascript: return false;" style="width: 100%;font-size: 16px;padding: 5px;">联系信息</a></th>
     	</tr>
     	<tr>
     		<th>通讯地址</th>
     		<th>手机</th>
     		<th>办公电话</th>
     		<th>邮编</th>
     		<th>邮箱</th>
     		<th>QQ</th>
     	</tr>
     	<tr>
     		<td>成都市锦江区静明路377号</td>
     		<td>13981899327</td>
     		<td>028-64369017</td>
     		<td>610066</td>
     		<td> </td>
     		<td> </td>
     	</tr><!-- 联系 信息  over -->
     	
     	<tr><!-- 标签 信息 start -->
     		<th colspan="6"><a class="btn btn-primary" href="javascript: return false;" style="width: 100%;font-size: 16px;padding: 5px;">标签信息[擅长领域]</a></th>
     	</tr>
     	
     	<tr>
     		<td colspan="6">传染病控制：艾滋病、病毒性肝炎治疗和控制</td>
     	</tr><!-- 标签 信息 over-->
     	
    </tbody> </table>
  </body>
</html>
