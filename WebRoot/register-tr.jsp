<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册账号</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <link href="<%=path %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="<%=path %>/bootstrap/js/jquery.js"></script>
    <script src="<%=path %>/bootstrap/js/bootstrap.min.js"></script>
	
  </head>
  
  <body>
  
   <div class="well well-sm">亲， 欢迎访问成都市科协专家库!</div>
   
   <div class="container" style="height: 200px;width: 900px;margin: 100px 0px 0px 200px">
   	  
   	  <div class="alert alert-info" style="margin-bottom: 5px;font-size: 16px;padding: 5px;" align="center">
   	  		<b>感谢您加入成都市科协！注册信息待管理员审核后方可使用！</b>
	  </div>
	  
	  <div class="jumbotron" style="padding-left: 10px;padding-top: 5px;">
	   		<table>
	   			<tr height="30px">
	   				<td colspan="2">
   						<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[&nbsp;账号，密码输入规范&nbsp;]：</label>长度为8~20个字符；支持数字、大小写字母和标点符号；不允许有空格！
	   				</td>
	   			</tr>
	   			
	   			<tr>
	   				<td>
	   					<form action="register_simple.action" method="post" class="form-horizontal" role="form" style="width: 500px">
						   <div class="form-group" style="margin-bottom: 5px;">
						      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">账号</label>
						      <div class="col-sm-10" style="width: 300px;height: 40px">
						         <input type="text" class="form-control" id="firstname" placeholder="请输入账号" />
						      </div>
						   </div>
						   
						   <div class="form-group" style="margin-bottom: 5px;">
							   <label for="inputPassword" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">密码</label>
							   <div class="col-sm-10" style="width: 300px;height: 40px">
							  	 <input type="password" class="form-control" id="inputPassword" placeholder="请输入密码" />
							   </div>
						   </div> 
						   
						   <div class="form-group" style="margin-bottom: 5px;">
							   <label for="inputPassword" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">真实姓名</label>
							   <div class="col-sm-10" style="width: 300px;height: 40px">
							   
							   	<table>
							   		<tr>
							   			<td><input name="user.realname" type="text" class="form-control" id="inputPassword" placeholder="请输入真实姓名" /></td>
							   			<td><label>&nbsp;&nbsp;&nbsp;&nbsp;[审核凭证]</label></td>
							   		</tr>
							   	</table>
							   	
							   </div>
						   </div> 
						   
						   <div class="form-group" style="margin-bottom: 5px;margin-left: 35px;">
						      <div class="col-sm-offset-2 col-sm-10" style="margin-left: 30px">
						        <table>
						        	<tr>
						        		<td>
						        			<button type="button" class="btn btn-primary btn-lg " style="width: 180px;height: 56px;">注册</button>		
						        		</td>
						        		
						        		<td>
					        			   <ul type="none" style="margin-left: -15px;">
								         	<li style="margin-top: 10px;"><a href="<%=path%>/login.jsp">直接登录>></a></li>
								         </ul>
						        		</td>
						        	</tr>
						        </table>
						      </div>
						   </div>
						</form>
	   				</td>
	   				
	   				<td>
						<img alt="你好啊" src="cdkx-index.png" width="330px" height="142px"/>	   					
	   				</td>
	   			</tr>
	   		</table>
	   </div>
	</div>
  </body>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
</html>
