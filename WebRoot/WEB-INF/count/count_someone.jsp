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
    <title>基本信息填写</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style type="text/css">
		div#container{width:500px}
		div#menu {height:400px;width:180px;float:left;}
		div#content {background-color:;height:400px;width:650px;float:right;}
	</style>
	
    <link href="<%=path %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="<%=path %>/bootstrap/js/jquery.js"></script>
    <script src="<%=path %>/bootstrap/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
		
		function toggleMenu(index){
			document.getElementById("item" + index).scrollIntoView();
			return false;
		}
		
	</script>
	
	<style type="text/css">
		div#menu{
			position: fixed;
			left: 92px;
			top: 150px;
		}
	</style>
  </head>
  
  <body style="background-color: #fff;padding: 0px">
  
    <div class="well well-sm">
    	亲， 欢迎访问成都市科协专家库! &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp; 用户类型： 管理员   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名：宫健
   	</div>
	
	<div class="panel panel-default" style="width: 1220px;height: 1100px;margin: 0px 160px 0px 70px;"><div class="panel-body">
		<ul class="nav nav-tabs">
		   
		  <li ><a href="count/skip_member!skip_member" style="padding-left: 60px;padding-right: 60px;">成都市科协专家库</a></li>
		   <li ><a href="count/skip_project!skip_project">科研项目</a></li>
		   <li ><a href="count/skip_award!skip_award">成果奖励</a></li>
		   <li ><a href="count/skip_thesis!skip_thesis">科技论文</a></li>
		   <li ><a href="count/skip_patent!skip_patent">发明专利</a></li>
		   <li class="active"><a href="count/skip_someone!skip_someone">找人</a></li>
		   <li style="float: right;">
			   	<jsp:include page="/WEB-INF/count/common-subject.jsp" flush="true"></jsp:include><!-- 顶部 -->
		   </li>
		</ul>
		
		<div id="container" style="width: 100%;margin-top: 10px;">
			 
			<div id="menu" style="margin: 0px 0px 0px 5px;float: top;width: 180px; "><!-- 左边 -->
				<table class="table table-bordered" style="text-align: center">
					<tr class="error"><td><a href="javascript: toggleMenu(0);">会员列表</a></td></tr>
		            <tr class="error"><td><a href="javascript: toggleMenu(1);">会员详细资料</a></td></tr>
	    	        <tr class="error"><td><a href="javascript: toggleMenu(2);">科研项目</a></td></tr>
	                <tr class="error"><td><a href="javascript: toggleMenu(3);">成果奖励</a></td></tr>
	                <tr class="error"><td><a href="javascript: toggleMenu(4);">科技论文</a></td></tr>
	                <tr class="error"><td><a href="javascript: toggleMenu(4);">发明专利</a></td></tr>
				</table>
			</div><!-- ./well well-lg -->
				
			<div id="content"  style="margin: 0px 0px 0px 230px;width: 78%;float: left"><!-- 右边 -->
				
				<div style="margin-left: 10px;width: 940px;margin-top: 5px;">
					<div data-spy="scroll" data-target="#navbar-example" data-offset="0" style="height:600px;overflow:auto; position: relative;">
					   
					   <h4 id="item0"></h4>
					   <jsp:include page="/member-specification/m-list.jsp" flush="true"></jsp:include>
					   
					   <h4 id="item1"></h4>
					   <jsp:include page="/member-specification/m-basic.jsp"></jsp:include>
					   
					   <h4 id="item2" style="margin-top: 50px;">科研项目</h4>
					   <jsp:include page="/member-specification/m-project.jsp"></jsp:include>
					   
					   <h4 id="item3" style="margin-top: 50px;">成果奖励</h4>
					   <jsp:include page="/member-specification/m-award.jsp"></jsp:include>
					   
					   <h4 id="item4" style="margin-top: 50px;">科技论文</h4>
					   <jsp:include page="/member-specification/m-thesis.jsp"></jsp:include>
					   
					   <h4 id="item5" style="margin-top: 50px;">发明专利</h4>
					   <jsp:include page="/member-specification/m-patent.jsp"></jsp:include>
					    
					</div>
				  
				  </div>
				
			</div><!-- ./content  -->
		</div><!-- ./container -->
		
	</div></div>	
	<s:debug></s:debug>
	<s:property value="#session.access" />
  </body>
  
</html>
