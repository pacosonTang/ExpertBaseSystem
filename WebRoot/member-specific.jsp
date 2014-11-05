
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
	
	<div class="panel panel-default" style="width: 1150px;height: 1100px;margin: 0px 160px 0px 100px;"><div class="panel-body">
		<ul class="nav nav-tabs">
		   <li><a href="<%=path%>/count-member.jsp" style="padding-left: 60px;padding-right: 60px;">成都市科协专家库</a></li>
		   <li ><a href="<%=path%>/count-sci-project.jsp">科研项目</a></li>
		   <li ><a href="<%=path%>/count-result-award.jsp">成果奖励</a></li>
		   <li ><a href="<%=path%>/count-sci-thesis.jsp">科技论文</a></li>
		   <li ><a href="<%=path%>/count-invent-patent.jsp">发明专利</a></li>
		   <li  class="active"><a href="<%=path%>/member-specific.jsp">找人</a></li>
		   <li style="float: right;">
    	 		<div class="col-sm-10" style="width: 200px;height: 40px">
			    	<input type="text" class="form-control" data-toggle="modal" data-target="#myModal" placeholder="点击选择学科" style="width: 160px; "/> 
			    </div>
				
				<!-- 模态框（Modal） -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				   <div class="modal-dialog">
				      <div class="modal-content">
				         <div class="modal-header">
				            <h4 class="modal-title" id="myModalLabel">选择学科</h4>
				         </div>
				         
				         <div class="modal-body">在这里添加一些文本</div>
				         
				         <div class="modal-footer">
				            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				            <button type="button" class="btn btn-primary">确认</button>
				         </div>
				         
				      </div><!-- /.modal-content -->
				</div><!-- /.modal-dialog -->
				</div><!-- /.modal fade -->
				<button type="button" class="btn btn-default" style="margin-bottom: 2px;width: 80px;">查询</button>
		   </li>
		</ul>
		
		<div id="container" style="width: 100%;margin-top: 10px;">
			 
			<div id="menu" class="well well-lg" style="margin-top: 0px;float: top;width: 220px;"><!-- 左边 -->
				 <ul class="nav nav-pills nav-stacked">
	              <li class="active"><a href="#">会员详细资料</a></li>
	              <li><a href="#">科研项目</a></li>
	              <li><a href="#">成果奖励</a></li>
	              <li><a href="#">科技论文</a></li>
	              <li><a href="#">发明专利</a></li>
	            </ul>
			</div><!-- ./well well-lg -->
				
			<div id="content"  style="margin: 0px 0px 0px 10px;width: 78%"><!-- 右边 -->
				<jsp:include page="/WEB-INF/member-specification/m-basic.jsp" flush="true"></jsp:include><!-- 顶部 -->
			</div><!-- ./content  -->
		</div><!-- ./container -->
		
	</div></div>	
  </body>
  
  
</html>
