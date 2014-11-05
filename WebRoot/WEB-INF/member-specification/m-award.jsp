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
    	     	 
    </style>
    
    <script type="text/javascript">
    	
    	function setAward_detail(award){
			
			for ( var i = 0; i < award.length; i++) {
				$("table[id='award']").append(
					"<tr>" + 
			     		"<td style='text-align: center;vertical-align: middle;'><span class='label label-info'>" + (i+1) + "</span></td>" + 
			     		"<td style='text-align: center;vertical-align: middle;'>"+ award[i].name + "</td>" + 
			     		"<td style='text-align: center;vertical-align: middle;'>"+ award[i].fruitName + "</td>" + 
			     		"<td style='text-align: center;vertical-align: middle;'>"+ award[i].rank + "</td>" + 
			     		"<td style='text-align: center;vertical-align: middle;'>"+ award[i].awardTime + "</td>" + 
			     		"<td style='text-align: center;vertical-align: middle;'>"+ "负责人" +"</td>" + 
			     	"</tr>"
				);
			}
		}
    	
    </script>
    
  </head>
  
  <body>
      <div class="panel panel-primary" style="width: 900px;margin-bottom: 10px;">
	   <div class="panel-heading" >
	      <h3 class="panel-title" align="center">会员成果奖励列表</h3>
	   </div><!-- ./panel-heading -->
	   
	   <div class="panel-body" style="padding: 5px;">
   		<table id="award" class="table table-bordered table-striped" style="font-size: 13px;margin: 0px;text-align: center;vertical-align: middle;">
	     	<tr style="vertical-align: middle;">
	     		<th width="7%" style="text-align: center;vertical-align: middle;">编号</th>
	     		<th width="25%" style="text-align: center;vertical-align: middle;">奖励名称</th>
	     		<th width="35%" style="text-align: center;vertical-align: middle;">获奖项目名称</th>
	     		<th width="10%" style="text-align: center;vertical-align: middle;">排名</th>
	     		<th width="15%" style="text-align: center;vertical-align: middle;">获奖时间</th>
	     		<th width="15%" style="text-align: center;vertical-align: middle;">获奖者</th>
	     	</tr>
	     	
		</table>
		
	   </div><!-- ./panel-body-->
	 </div><!-- ./panel panel-primary-->
  </body>
</html>
