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
    	
    	function setPatent_detail(patent){
    	
			$("table[id='patent']").empty();
			$("table[id='patent']").append("<tr style='vertical-align: middle;'>" +
	     		"<th width='7%' style='text-align: center;vertical-align: middle;'>编号</th>" +
	     		"<th width='40%' style='text-align: center;vertical-align: middle;'>专利名称</th>" +
	     		"<th width='24%' style='text-align: center;vertical-align: middle;'>专利号</th>" +
	     		"<th width='14%' style='text-align: center;vertical-align: middle;'>授权时间</th>" +
	     		"<th width='14%' style='text-align: center;vertical-align: middle;'>获得者</th>" +
	     	"</tr>	");
			
			for ( var i = 0; i < patent.length; i++) {
				$("table[id='patent']").append(
					"<tr>" + 
			     		"<td style='text-align: center;vertical-align: middle;'><span class='label label-info'>"+ (i+1) + "</span></td>" + 
			     		"<td style='text-align: center;vertical-align: middle;'>"+ patent[i].name + "</td>" + 
			     		"<td style='text-align: center;vertical-align: middle;'>"+ patent[i].patentNo + "</td>" + 
			     		"<td style='text-align: center;vertical-align: middle;'>"+ patent[i].authorityTime + "</td>" +
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
	      <h3 class="panel-title" align="center">会员<span id="fourname"></span>发明专利列表</h3>
	   </div><!-- ./panel-heading -->
	   
	   <div class="panel-body" style="padding: 5px;">
	   	
	   	<table id="patent" class="table table-bordered table-striped" style="font-size: 13px;margin: 0px;text-align: center;vertical-align: middle;">
	     	
		</table>	
			 
	   </div><!-- ./panel-body-->
	 </div><!-- ./panel panel-primary-->
	 
  </body>
</html>
