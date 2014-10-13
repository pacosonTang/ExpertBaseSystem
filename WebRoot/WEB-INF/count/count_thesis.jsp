<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>基本信息填写</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<style type="text/css">
		div#container{width:500px}
		div#menu {height:400px;width:180px;float:left;}
		div#content {background-color:;height:400px;width:650px;float:left;}
	</style>
	
    <link href="<%=path %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="<%=path %>/bootstrap/js/jquery.js"></script>
    <script src="<%=path %>/bootstrap/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
		
		$(function(){
			$(div[id='content']).html("<jsp:include page='/input-part/result-award.jsp' flush='true'></jsp:include>");
		});
		
		function toggleMenu(index){
			
			$("ul > li").removeClass("active");
			$("ul > li:eq(" + index + ")").addClass("active");
			
			//var menuLink = ["expert-basic","invent-patent","result-award","sci-project","sci-thesis"];
		 
			return false;
			
		}
		
		
		
	</script>
  </head>
  
  <body style="background-color: #fff">
  
    <div class="well well-sm">
    	亲， 欢迎访问成都市科协专家库! &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp; 用户类型： 管理员   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名：宫健
   	</div>
	
	<div class="panel panel-default" style="width: 1100px;height: 1100px;margin: 0px 160px 0px 100px;"><div class="panel-body">
		<ul class="nav nav-tabs">
		   <li><a href="count/skip_member!skip_member" style="padding-left: 60px;padding-right: 60px;">成都市科协专家库</a></li>
		   <li ><a href="count/skip_project!skip_project">科研项目</a></li>
		   <li ><a href="count/skip_award!skip_award">成果奖励</a></li>
		   <li class="active"><a href="count/skip_thesis!skip_thesis">科技论文</a></li>
		   <li ><a href="count/skip_patent!skip_patent">发明专利</a></li>
		   <li ><a href="count/skip_someone!skip_someone">找人</a></li>
		   
		   <li style="float: right;">
			   	<jsp:include page="/WEB-INF/count/common-subject.jsp" flush="true"></jsp:include><!-- 顶部 -->
		   </li>
		   
		</ul>
		
		<div id="container" style="width: 100%;height: 100%;margin-top: 10px;">
			 
			<div id="menu" class="well well-lg" style="margin-top: 0px;float: top;width: 20%;"><!-- 左边 -->
				
			</div><!-- ./well well-lg -->
				
			<div id="content"  style="margin: 0px 0px 0px 20px;width: 74%" ><!-- 右边 -->
				
				<jsp:include page="/input-part/sci-thesis.jsp" flush="true"></jsp:include><!-- 顶部 -->
				
			</div><!-- ./content  -->
		</div><!-- ./container -->
		
	</div></div>	
  </body>
  
  
</html>
