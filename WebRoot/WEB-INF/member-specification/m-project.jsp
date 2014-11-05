<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@taglib prefix="s" uri="/struts-tags"%>

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
    	     	 
    </style>
    
    <script type="text/javascript">
		
		function setProject_detail(project){

			for ( var i = 0; i < project.length; i++) {
				$("table[id='project']").append(
					"<tr>" + 
			     		"<td style='text-align: center;vertical-align: middle;'><span class='label label-info'>"+ (i+1) + "</span></td>" + 
			     		"<td style='text-align: center;vertical-align: middle;'>"+ project[i].name + "</td>" + 
			     		"<td style='text-align: center;vertical-align: middle;'>"+ project[i].delegationUnit + "</td>" + 
			     		"<td style='text-align: center;vertical-align: middle;'>"+ project[i].projectLevel + "</td>" + 
			     		"<td style='text-align: center;vertical-align: middle;'>"+ project[i].projectTime + "</td>" + 
			     		"<td style='text-align: center;vertical-align: middle;'>"+ project[i].completeStatus + "</td>" + 
			     		"<td style='text-align: center;vertical-align: middle;'>"+ project[i].selfFunc + "</td>" + 
			     		"<td style='text-align: center;vertical-align: middle;'>"+ project[i].selffinance + "</td>" + 
			     		"<td style='text-align: center;vertical-align: middle;'>"+ project[i].allocation + "</td>" + 
			     		"<td style='text-align: center;vertical-align: middle;'>"+ "你好</td>" +
			     	"</tr>"
				);
			}
		}
		
    </script>
    
  </head>
  
  <body>
      <div class="panel panel-primary" style="width: 900px;margin-bottom: 10px;">
	   <div class="panel-heading" >
	      <h3 class="panel-title" align="center">会员科研项目列表</h3>
	   </div><!-- ./panel-heading -->
	   
	   <div class="panel-body" style="padding: 5px;">
	   		
	   		<table id="project" class="table table-bordered table-striped" style="font-size: 13px;margin: 0px;text-align: center;vertical-align: middle;">
		     	<tr style="vertical-align: middle;">
		     		<th width="4%" style="text-align: center;vertical-align: middle;">编号</th>
		     		<th width="25%" style="text-align: center;vertical-align: middle;">项目名称</th>
		     		<th width="10%" style="text-align: center;vertical-align: middle;">委托单位</th>
		     		<th width="7%" style="text-align: center;vertical-align: middle;">项目<br/>级别</th>
		     		<th width="10%" style="text-align: center;vertical-align: middle;">项目<br/>时间</th>
		     		<th width="7%" style="text-align: center;vertical-align: middle;">完成<br/>状态</th>
		     		<th width="7%" style="text-align: center;vertical-align: middle;">本人<br/>作用</th>
		     		<th width="7%" style="text-align: center;vertical-align: middle;">自筹<br/>经费</th>
		     		<th width="7%" style="text-align: center;vertical-align: middle;">财政<br/>拨款</th>
		     		<th width="7%" style="text-align: center;vertical-align: middle;">负责人</th>
		     	</tr>
				</tbody></table>
			 
	   </div><!-- ./panel-body-->
	 </div><!-- ./panel panel-primary-->
	 
  </body>
</html>
