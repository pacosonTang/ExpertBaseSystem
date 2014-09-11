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
    <link href="<%=path %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="<%=path %>/bootstrap/js/jquery.js"></script>
    <script src="<%=path %>/bootstrap/js/bootstrap.min.js"></script>
  </head>
  
  <body>
      <div class="panel panel-primary">
	   <div class="panel-heading">
	      <h3 class="panel-title">添加专家个人资料</h3>
	   </div><!-- ./panel-heading -->
	   
	   <div class="panel-body">
	      	 
	      	 <form class="form-horizontal" role="form" style="width: 600px;"><!-- 基本信息表单 -->
	      	 	
	      	 	<label>基本信息</label>
	      	 	<table style="margin-left: 20px;"><tr>
	      	 		<td style="vertical-align: top">
	      	 			
	      	 			<div class="form-group" style="margin-bottom: 5px;margin-top: 10px;"><!-- 姓名 -->
					      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">姓名</label>
					      <div class="col-sm-10" style="width: 200px;height: 40px">
					         <input type="text" class="form-control" id="firstname" placeholder="请输入姓名" />
					      </div>
					   </div>
					   
					   <div class="form-group" style="margin-bottom: 5px;"><!-- 身份证号 -->
					      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">身份证号</label>
					      <div class="col-sm-10" style="width: 200px;height: 40px">
					         <input type="text" class="form-control" id="firstname" placeholder="请输入身份证号" />
					      </div>
					   </div>
					   
					   <div class="form-group" style="margin-bottom: 5px;"><!-- 生日 -->
					      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">生日</label>
					      <div class="col-sm-10" style="width: 200px;height: 40px">
					         <input type="text" class="form-control" id="firstname" placeholder="格式如  : 1999-09-09 " />
					      </div>
					   </div>
					   
					   <div class="form-group" style="margin-bottom: 5px;"><!-- 生日 -->
					   	   <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">性别</label>
						   <label class="checkbox-inline">
						       <input type="radio" name="optionsRadiosinline" value="option1" checked>男&nbsp;&nbsp;&nbsp;&nbsp;
						      <input type="radio" name="optionsRadiosinline" value="option2">女
						   </label>
						</div>
	      	 		</td>
	      	 	
	      	 		<td style="vertical-align: top">
	      	 			<img src="<%=path %>/trong.jpg" class="img-thumbnail" style="height: 190px;width: 160px;margin-left: 130px;"/>
	      	 			<br/>
						<input type="text" class="form-control" data-toggle="modal" data-target="#myModal" placeholder="点击选择图片" style="width: 160px;margin-left: 130px;"/>
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
	      	 		
	      	 	</tr></table>
			</form><!-- 基本信息表单 -->
			
			<form class="form-horizontal" role="form" style="width: 600px;"><!-- 教育信息表单 -->
				<label style="margin-top: 5px;">教育信息</label>
				<table style="margin-left: 20px;"><tr>
	      	 		<td style="vertical-align: top">
	      	 			
	      	 			<div class="form-group" style="margin-bottom: 5px;margin-top: 10px;"><!-- 毕业院校 -->
					      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">毕业院校</label>
					      <div class="col-sm-10" style="width: 200px;height: 40px">
					         <input type="text" class="form-control" id="firstname" placeholder="请输入毕业院校" />
					      </div>
					   </div>
					   
					   <div class="form-group" style="margin-bottom: 5px;"><!-- 毕业时间 -->
					      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">毕业时间</label>
					      <div class="col-sm-10" style="width: 200px;height: 40px">
					         <input type="text" class="form-control" id="firstname" placeholder="请输入毕业时间" />
					      </div>
					   </div>
	      	 		</td>
	      	 	
	      	 		<td style="vertical-align: top">
	      	 			
	      	 			<div class="form-group" style="margin:10px 0px 5px 50px"><!-- 学位 -->
					      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">学位</label>
					      <div class="col-sm-10" style="width: 200px;height: 40px">
					         <select class="form-control">
						         <option>学士</option>
						         <option>硕士</option>
						         <option>博士</option>
						         <option>博士后</option>
						      </select>
					      </div>
					   </div>
	      	 			 
	      	 			<label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;margin-left: 50px;">所学专业</label>
	      	 				
	      	 			  <div class="col-sm-10" style="width: 200px;height: 40px">
					      	<input type="text" class="form-control" data-toggle="modal" data-target="#myModal" placeholder="点击选择专业" style="width: 160px; "/> 
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
	      	 		
	      	 	</tr></table>
			</form><!-- 教育信息表单 -->
			
			<form class="form-horizontal" role="form" style="width: 600px;"><!-- 职业信息表单 -->
				<label style="margin-top: 5px;">职业信息</label>
				<table style="margin-left: 20px;"><tr>
				
	      	 		<td style="vertical-align: top">
	      	 			
	      	 			<div class="form-group" style="margin-bottom: 5px;margin-top: 10px;"><!-- 所属学会 -->
					      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">所属学会</label>
					      <div class="col-sm-10" style="width: 200px;height: 40px">
					         <input type="text" class="form-control" id="firstname" placeholder="请输入所属学会" />
					      </div>
					   </div>
					   
					   <div class="form-group" style="margin-bottom: 5px;"><!-- 技术职称 -->
					      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">技术职称</label>
					      <div class="col-sm-10" style="width: 200px;height: 40px">
					         <input type="text" class="form-control" id="firstname" placeholder="请输入技术职称" />
					      </div>
					   </div>
					   
					   <div class="form-group" style="margin-bottom: 5px;"><!-- 现从事专业 -->
					      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">现从事<br/>专业</label>
					      <div class="col-sm-10" style="width: 200px;height: 40px">
					         <input type="text" class="form-control" id="firstname" placeholder="请输入现从事专业" />
					      </div>
					   </div>
	      	 		</td>
	      	 		
	      	 		<td style="vertical-align: top">
	      	 			
	      	 			<div class="form-group" style="margin-bottom: 5px;margin-top: 10px;margin-left: 50px;"><!-- 工作单位 -->
					      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">工作单位</label>
					      <div class="col-sm-10" style="width: 200px;height: 40px">
					         <input type="text" class="form-control" id="firstname" placeholder="请输入工作单位" />
					      </div>
					   </div>
					   
					   <div class="form-group" style="margin-bottom: 5px;margin-left: 50px;"><!-- 职务-->
					      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">职务</label>
					      <div class="col-sm-10" style="width: 200px;height: 40px">
					         <input type="text" class="form-control" id="firstname" placeholder="请输入职务" />
					      </div>
					   </div>
					    
	      	 		</td>
	      	 		
	      	 	</tr></table>
			</form><!-- 职业信息表单 -->
			
			<form class="form-horizontal" role="form" style="width: 600px;"><!-- 联系信息表单 -->
				<label style="margin-top: 5px;">联系信息</label>
				<table style="margin-left: 20px;"><tr>
				
	      	 		<td style="vertical-align: top">
	      	 			
	      	 			<div class="form-group" style="margin-bottom: 5px;margin-top: 10px;"><!-- 地址 -->
					      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">地址</label>
					      <div class="col-sm-10" style="width: 200px;height: 40px">
					         <input type="text" class="form-control" id="firstname" placeholder="请输入地址" />
					      </div>
					   </div>
					   
					   <div class="form-group" style="margin-bottom: 5px;"><!-- 办公电话 -->
					      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">办公电话</label>
					      <div class="col-sm-10" style="width: 200px;height: 40px">
					         <input type="text" class="form-control" id="firstname" placeholder="请输入办公电话" />
					      </div>
					   </div>
					   
					   <div class="form-group" style="margin-bottom: 5px;"><!-- 邮箱 -->
					      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">邮箱</label>
					      <div class="col-sm-10" style="width: 200px;height: 40px">
					         <input type="text" class="form-control" id="firstname" placeholder="请输入邮箱" />
					      </div>
					   </div>
	      	 		</td>
	      	 		
	      	 		<td style="vertical-align: top">
	      	 			
	      	 			<div class="form-group" style="margin-bottom: 5px;margin-top: 10px;margin-left: 50px;"><!-- 手机-->
					      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">手机</label>
					      <div class="col-sm-10" style="width: 200px;height: 40px">
					         <input type="text" class="form-control" id="firstname" placeholder="请输入手机" />
					      </div>
					   </div>
					   
					   <div class="form-group" style="margin-bottom: 5px;margin-left: 50px;"><!-- 邮编-->
					      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">邮编</label>
					      <div class="col-sm-10" style="width: 200px;height: 40px">
					         <input type="text" class="form-control" id="firstname" placeholder="请输入邮编" />
					      </div>
					   </div>
					   
					   <div class="form-group" style="margin-bottom: 5px;margin-left: 50px;"><!-- QQ-->
					      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">QQ</label>
					      <div class="col-sm-10" style="width: 200px;height: 40px">
					         <input type="text" class="form-control" id="firstname" placeholder="请输入QQ"/>
					      </div>
					   </div>
	      	 		</td>
	      	 	</tr></table>
			</form><!-- 联系信息表单 -->
			
			<form class="form-horizontal" role="form" style="width: 600px;"><!-- 标签信息表单 -->
				
			    <div class="form-group" style="margin-bottom: 5px;margin-left: 5px;"><!-- QQ-->
				    <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">个人标签</label>
				    <div class="col-sm-10" style="width: 515px;height: 40px">
				    	<textarea class="form-control" rows="1" placeholder="标签格式 : 以空格隔开"></textarea>
			    	</div>
				</div>
	      	 		 
			</form><!-- 联系信息表单 -->
						
	   </div><!-- ./panel-body-->
	 </div><!-- ./panel panel-primary-->
  </body>
</html>
