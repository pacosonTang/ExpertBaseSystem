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
    	     	 
    </style>
    
    <script type="text/javascript">
    	
    	$(function(){
    		
    	});
    	
    </script>
    
  </head>
  
  <body>
      <div class="panel panel-primary" style="width: 270px;">
	   <div class="panel-heading" >
	      <h3 class="panel-title" align="center">会员-舒红平</h3>
	   </div><!-- ./panel-heading -->
	   
	   <div class="panel-body" style="padding: 5px;">
	   		
			<table class="table table-bordered" style="font-size: 13px;margin: 0px;">
                
                <tr>
                  <td width="30%" align="right"><label>科技论文</label></td>
                  <td width="25%">521项</td>
                  <td width="25%" align="right"><label>发明专利 </label></td>
                  <td>600项</td>
                </tr>
                <tr>
                  <td align="right"><label>成果奖励</label> </td>
                  <td colspan="3">一等奖211项，二等奖311项，三等奖411项</td>
                </tr>
                 <tr>
                  <td align="right"><label>科研项目 </label></td>
                  <td colspan="3">已验收211项，未验收311项，在研141项</td>
                </tr>
            </table>
      	 	 
	   </div><!-- ./panel-body-->
	 </div><!-- ./panel panel-primary-->
	 
  </body>
</html>
