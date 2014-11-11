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
    	.table>tbody>tr>th{
    		align:center;
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
	   
       <table class="table table-bordered table-striped" style="font-size: 13px;margin: 0px; " id="user_specific">
     	 
     	<tr><!-- 基本 信息start-->
     		<th rowspan="3" width="50px"  style="vertical-align: middle;">个人<br/>基础<br/>信息</th>
     		<th width="80px">姓名</th>
     		<td width="130px"></td>
     		<th width="80px">身份证号</th>
     		<td width="150px"></td>
     	 
     		<th width="80px">性别</th>
     		<td></td>
     		<th width="80px">生日</th>
     		<td></td>
     	</tr>
     	<tr>
     		<th>毕业院校</th>
     		<td></td>
     		<th>毕业时间</th>
     		<td></td>
   		 
     		<th>学历</th>
     		<td></td>
     		<th>学位</th>
     		<td></td>
     	</tr><tr>	
     		<th>所学专业</th>
     		<td></td>
     		<th>所属学会</th>
     		<td colspan="5"></td>
     	</tr>
     	 <!-- 基本 信息 end -->
     	 
     	<tr><!-- 工作 信息start -->
     		<th  style="vertical-align: middle;">工作<br/>信息</th>
     		<th style="vertical-align: middle;">工作单位</th>
     		<td colspan="3" style="vertical-align: middle;"></td>
     		<th style="vertical-align: middle;">技术职称</th>
     		<td style="vertical-align: middle;"></td>
     		<th style="vertical-align: middle;">职务</th>
     		<td style="vertical-align: middle;"></td>
     	</tr>
     	
     	<!-- 工作 信息 end -->
     	
     	<tr><!-- 通讯 信息  start -->
     		<th rowspan="2" style="vertical-align: middle;">通讯<br/>信息</th>
     		<th>手机</th>
     		<td></td>
     		<th>办公电话</th>
     		<td></td>
     		<th>邮编</th>
     		<td></td>
     		<th>邮箱</th>
     		<td></td>
   		</tr><tr>
     		<th>QQ</th>
     		<td></td>
   			<th>通讯地址</th>
     		<td  colspan="5"></td>
     	</tr>
     	 <!-- 联系 信息  over -->
     	
     	<tr><!-- 标签 信息 start -->
     		<th rowspan="2" style="vertical-align: middle;">专业<br/>信息</th>     		
     		<th>擅长领域</th>
     		<td colspan="9"></td>
   		</tr><tr>
     		<th>现从事<br/>专业</th>
     		<td colspan="9"></td>
     	</tr>
     	
     	<tr>
     		
     	</tr><!-- 标签 信息 over-->
     	
    </table>
     </div><!-- ./panel-body-->
	 </div><!-- ./panel panel-primary-->
  </body>
</html>
