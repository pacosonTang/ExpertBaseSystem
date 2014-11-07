<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'basic.jsp' starting page</title>
    <link href="<%=path %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="<%=path %>/bootstrap/js/jquery.js"></script>
    <script src="<%=path %>/bootstrap/js/bootstrap.min.js"></script>
    <style type="text/css">
    	
    	.table>tbody>tr>td{
    		padding:3px;	
    	}
    	th{
    		align: center;
    	}
    		 
    </style>
    
    <script type="text/javascript">
    	
    	$(function(){
    		
    	});
    	
    </script>
    
  </head>
  
  <body>
  
  	<div class="panel panel-primary" style="width: 900px;margin-bottom: 10px;">
	   <div class="panel-heading" >
	      <h3 class="panel-title" align="center">会员<span id="fourname"></span>基本信息</h3>
	   </div><!-- ./panel-heading -->
	   
	   <div class="panel-body" style="padding: 5px;" >
	   
       <table class="table table-bordered" style="font-size: 13px;margin: 0px;" id="user_specific">
     	<tbody>
     	
     	<tr><!-- 基本 信息start-->
     		<th>姓名</th>
     		<th>身份证号</th>
     		<th>性别</th>
     		<th colspan="3">生日</th>
     	</tr>
     	<tr>
     		<td></td>
     		<td></td>
     		<td></td>
     		<td colspan="3"></td>
     	</tr><!-- 基本 信息 end -->
     	
     	<tr><!-- 教育 信息 start -->
     		<th>毕业院校</th>
     		<th>所学专业</th>
     		<th>毕业时间</th>
     		<th>学历</th>
     		<th colspan="2">学位</th>
     	</tr>
     	<tr>
     		<td></td>
     		<td></td>
     		<td></td>
     		<td></td>
     		<td colspan="2"></td>
     	</tr><!-- 教育 信息 end -->
     	
     	<tr><!-- 职业 信息start -->
     		<th>所属学会</th>
     		<th>工作单位</th>
     		<th>技术职称</th>
     		<th>职务</th>
     		<th colspan="2">现从事专业</th>
     	</tr>
     	<tr>
     		<td></td>
     		<td></td>
     		<td></td>
     		<td></td>
     		<td colspan="2"></td>
     	</tr><!-- 职业 信息 end -->
     	
     	<tr><!-- 联系 信息  start -->
     		<th>通讯地址</th>
     		<th>手机</th>
     		<th>办公电话</th>
     		<th>邮编</th>
     		<th>邮箱</th>
     		<th>QQ</th>
     	</tr>
     	<tr>
     		<td></td>
     		<td></td>
     		<td></td>
     		<td></td>
     		<td></td>
     		<td></td>
     	</tr><!-- 联系 信息  over -->
     	
     	<tr><!-- 标签 信息 start -->
     		<th colspan="6">标签信息[擅长领域]</th>
     	</tr>
     	
     	<tr>
     		<td colspan="6"></td>
     	</tr><!-- 标签 信息 over-->
     	
    </tbody> </table>
     </div><!-- ./panel-body-->
	 </div><!-- ./panel panel-primary-->
  </body>
</html>
