<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>专家和学科目录选择</title>
    <link href="<%=path %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="<%=path %>/bootstrap/js/jquery.js"></script>
    <script src="<%=path %>/bootstrap/js/bootstrap.min.js"></script>
  </head>
  
  <body>
	<div  style="width: 100%;margin-left: 170px;margin-bottom: 0px" ><!-- 左边 -->
		 
	 <form class="form-horizontal" role="form" style="width: 800px;"><!-- 专家-学科信息表单 -->
			
			<table style="margin-left: 20px;"><tr>
      	 		<td style="vertical-align: top">
      	 			
      	 			<label for="firstname" class="col-sm-2 control-label" style="width: 120px;padding: 5px; ">所选学科领域</label>
      	 			  <div class="col-sm-10" style="width: 200px;height: 40px">
				      	<input type="text" class="form-control" data-toggle="modal" data-target="#myModal" placeholder="点击选择学科领域" style="width: 160px; "/> 
				      </div>
					<!-- 模态框（Modal） -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					   <div class="modal-dialog">
					      <div class="modal-content">

					         <div class="modal-header">
					            <h4 class="modal-title" id="myModalLabel">选择专家</h4>
					         </div>
					         
					         <div class="modal-body">在这里添加一些文本</div>
					         
					         <div class="modal-footer">
					            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					            <button type="button" class="btn btn-primary">确认</button>
					         </div>
					         
					      </div><!-- /.modal-content -->
					</div><!-- /.modal-dialog -->
					</div><!-- /.modal fade -->
      	 			
      	 		</td>
      	 	
      	 		<td style="vertical-align: top">
      	 			
      	 			<label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px; ">所选专家</label>
      	 				
      	 			  <div class="col-sm-10" style="width: 200px;height: 40px">
				      	<input type="text" class="form-control" data-toggle="modal" data-target="#myModal" placeholder="点击选择专家" style="width: 160px; "/> 
				      </div>
					
					<!-- 模态框（Modal） -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					   <div class="modal-dialog">
					      <div class="modal-content">
					         
					         <div class="modal-header">
					            <h4 class="modal-title" id="myModalLabel">选择专家</h4>
					         </div>
					         
					         <div class="modal-body">在这里添加一些文本</div>
					         
					         <div class="modal-footer">
					            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					            <button type="button" class="btn btn-primary">确认</button>
					         </div>
					         
					      </div><!-- /.modal-content -->
					</div><!-- /.modal-dialog -->
					</div><!-- /.modal fade -->
      	 			
      	 		</td>
      	 		
      	 		<td>
      	 			<button type="button" class="btn btn-default" style="margin-bottom: 2px;">搜索</button>
      	 		</td>
      	 	</tr></table>
		</form><!-- 教育信息表单 -->
		 
	</div><!-- /.well well-lg -->
  </body>
  
  
</html>
