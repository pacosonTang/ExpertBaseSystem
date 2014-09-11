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
	      <h3 class="panel-title">添加专家[唐荣]科研项目</h3>
	   </div><!-- ./panel-heading -->
	   
	   <div class="panel-body">

		<form class="form-horizontal" role="form" style="width: 600px;"><!-- 科研项目表单 -->
			
			<table style="margin-left: 20px;"><tr>
      	 		<td style="vertical-align: top">
      	 			
      	 			<div class="form-group" style="margin-bottom: 5px;margin-top: 10px;"><!-- 项目名称 -->
				      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">项目名称</label>
				      <div class="col-sm-10" style="width: 200px;height: 40px">
				         <input type="text" class="form-control" id="firstname" placeholder="请输入项目名称" />
				      </div>
				   </div>
				   
				   <div class="form-group" style="margin-bottom: 5px;"><!-- 项目时间 -->
				      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">项目时间</label>
				      <div class="col-sm-10" style="width: 200px;height: 40px">
				         <input type="text" class="form-control" id="firstname" placeholder="时间格式 : 1999-09-09" />
				      </div>
				   </div>
				   
				   <div class="form-group" style="margin-bottom: 5px;"><!-- 委托单位 -->
				      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">委托单位</label>
				      <div class="col-sm-10" style="width: 200px;height: 40px">
				         <input type="text" class="form-control" id="firstname" placeholder="请输入委托单位" />
				      </div>
				   </div>
      	 		</td>
      	 	
      	 		<td style="vertical-align: top">
      	 			
      	 			<div class="form-group" style="margin:10px 0px 5px 50px"><!-- 本人作用 -->
				      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">本人作用</label>
				      <div class="col-sm-10" style="width: 200px;height: 40px">
				         <select class="form-control">
					         <option>主研</option>
					         <option>主持</option>
					      </select>
				      </div>
				   	</div>
				   	
				   	<div class="form-group" style="margin:10px 0px 5px 50px"><!-- 项目级别 -->
				      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">项目级别</label>
				      <div class="col-sm-10" style="width: 200px;height: 40px">
				         <select class="form-control">
					         <option>国家级</option>
					         <option>省级</option>
					         <option>市级</option>
					      </select>
				      </div>
				   	</div>
				   	
				   	<div class="form-group" style="margin:10px 0px 5px 50px"><!-- 完成状态-->
				      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">完成状态</label>
				      <div class="col-sm-10" style="width: 200px;height: 40px">
				         <select class="form-control">
					         <option>在研</option>
					         <option>已完成</option>
					      </select>
				      </div>
				   	</div>
				   	
      	 		</td>
      	 		
      	 	</tr></table>
		</form><!-- 教育信息表单 -->

	   </div><!-- ./panel-body-->
	 </div><!-- ./panel panel-primary-->
  </body>
</html>
