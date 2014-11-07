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
    	
    	function setThesis_detail(thesis){
			
			$("table[id='thesis']").empty();
			$("table[id='thesis']").append("<tr style='vertical-align: middle;'>"+
	     		"<th width='7%' style='text-align: center;vertical-align: middle;'>编号</th>"+
	     		"<th width='60%' style='text-align: center;vertical-align: middle;'>论文名称</th>"+
	     		"<th width='10%' style='text-align: center;vertical-align: middle;'>收录年份</th>"+
	     		"<th width='10%' style='text-align: center;vertical-align: middle;'>作者</th>"+
	     	"</tr>");
			
			for ( var i = 0; i < thesis.length; i++) {
				$("table[id='thesis']").append(
					"<tr>" + 
			     		"<td style='text-align: center;vertical-align: middle;'><span class='label label-info'>" + (i+1) + "</span></td>" + 
			     		"<td style='text-align: center;vertical-align: middle;'>"+ thesis[i].name + "</td>" + 
			     		"<td style='text-align: center;vertical-align: middle;'>"+ thesis[i].pubTime + "</td>" + 
			     		"<td style='text-align: center;vertical-align: middle;'>"+ cur_username + "</td>" + 
			     	"</tr>"
				);
			}
		}
    	
    </script>
    
  </head>
  
  <body>
      <div class="panel panel-primary" style="width: 900px;margin-bottom: 10px;">
	   <div class="panel-heading" >
	      <h3 class="panel-title" align="center">会员<span id="fourname"></span>科技论文列表</h3>
	   </div><!-- ./panel-heading -->
	   
	   <div class="panel-body" style="padding: 5px;">
	   		
		<table id="thesis" class="table table-bordered table-striped" style="font-size: 13px;margin: 0px;text-align: center;vertical-align: middle;">
	     	
		</table>
      	 	 
	   </div><!-- ./panel-body-->
	 </div><!-- ./panel panel-primary-->
	 
  </body>
</html>
