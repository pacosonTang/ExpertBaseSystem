<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>成都市科协专家库登录端github</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="bootstrap/js/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
	
  </head>
  
  <body>
   
   <div class="well well-sm">欢迎访问成都市科协专家库!</div>
   
   <div class="container" style="height: 200px;width: 900px;margin: 100px 0px 0px 200px">
	   <div class="jumbotron" style="padding-left: 10px;padding-top: 20px;">
	   		<table>
	   			<tr>
	   				<td>
	   					<form class="form-horizontal" role="form" style="width: 500px" action="login.action" method="post">
						   <div class="form-group" style="margin-bottom: 5px;">
						      <label for="firstname" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">账号</label>
						      <div class="col-sm-10" style="width: 300px;height: 40px">
						         <input type="text" name="user.username" class="form-control" id="firstname" placeholder="请输入账号" />
						      </div>
						   </div>
						   <div class="form-group" style="margin-bottom: 5px;">
							   <label for="inputPassword" class="col-sm-2 control-label" style="width: 80px;padding: 5px;">密码</label>
							   <div class="col-sm-10" style="width: 300px;height: 40px">
							  	 <input type="password" name="user.password" class="form-control" id="inputPassword" placeholder="请输入密码" />
							   </div>
						   </div> 
						   
						   <div class="form-group" style="margin-bottom: 5px;margin-left: 40px;">
						      <div class="col-sm-offset-2 col-sm-10" style="margin-left: 30px">
						        <table>
						        	<tr>
						        		<td>
						        			<input type="submit" class="btn btn-primary btn-lg" value="登录" style="width: 150px;height: 56px;"/>	
						        		</td>
						        		
						        		<td style="">
					        			   <ul type="none" style="margin-left: -5px;">
								         	<li><a href="<%=path%>/for_help.jsp">忘记密码?</a></li>
								         	<li style="margin-top: 10px;"><a href="<%=path%>/register.jsp">立即注册>></a></li>
								         </ul>
						        		</td>
						        	</tr>
						        </table>
						      </div>
						   </div>
						</form>
	   				</td>
	   				
	   				<td>
						<img alt="你好啊" src="img/cdkx-index.png" width="330px" height="142px"/>
	   				</td>
	   			</tr>
	   		</table>
	   </div>
	</div>
	<s:debug></s:debug>
  </body>
</html>
