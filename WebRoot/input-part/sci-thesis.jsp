<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'basic.jsp' starting page</title>
  </head>
  
  <body>
      <div class="panel panel-primary">
	   <div class="panel-heading">
	      <h3 class="panel-title">添加专家[唐荣]科技论文</h3>
	   </div><!-- ./panel-heading -->
	   
	   <div class="panel-body">

		<form class="form-horizontal" role="form" style="width: 600px;"><!-- 科技论文表单 -->
			
			<table style="margin-left: 20px;"><tr>
      	 		<td style="vertical-align: top">
      	 			
      	 			<div class="form-group" style="margin-bottom: 5px;margin-top: 10px;"><!-- 论文名称 -->
				      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">论文名称</label>
				      <div class="col-sm-10" style="width: 200px;height: 40px">
				         <input type="text" class="form-control" id="firstname" placeholder="请输入论文名称" />
				      </div>
				   </div>
				   
				   <div class="form-group" style="margin-bottom: 5px;"><!-- 发表时间 -->
				      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">发表时间</label>
				      <div class="col-sm-10" style="width: 200px;height: 40px">
				         <input type="text" class="form-control" id="firstname" placeholder="请输入发表时间" />
				      </div>
				   </div>
				   
      	 		</td>
      	 	
      	 		<td style="vertical-align: top">
      	 			
      	 			<div class="form-group" style="margin:10px 0px 5px 50px"><!-- 是否收录 -->
				      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">是否收录</label>
				      <div class="col-sm-10" style="width: 200px;height: 40px">
				         <select class="form-control">
					         <option>是</option>
					         <option>否</option>
					      </select>
				      </div>
				   	</div>
				   	
				   	<div class="form-group" style="margin:10px 0px 5px 50px"><!-- 是否核心期刊 -->
				      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">是否录为<br/>核心期刊</label>
				      <div class="col-sm-10" style="width: 200px;height: 40px">
				         <select class="form-control">
					         <option>是</option>
					         <option>否</option>
					      </select>
				      </div>
				   	</div>
				   	
      	 		</td>
      	 		
      	 	</tr></table>
      	 	
		</form><!-- 科技论文表单 -->

	   </div><!-- ./panel-body-->
	 </div><!-- ./panel panel-primary-->
  </body>
</html>
