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
                <tr>
                  <td align="right"><label>所属学会</label></td>
                  <td colspan="3">青年科学联合会</td>
                </tr>
                <tr>
                  <td align="right"><label>现从事专业</label></td>
                  <td colspan="3">数据挖掘</td>
                </tr>
                
            </table>
      	 	 
	   </div><!-- ./panel-body-->
	 </div><!-- ./panel panel-primary-->
	 
  </body>
</html>
