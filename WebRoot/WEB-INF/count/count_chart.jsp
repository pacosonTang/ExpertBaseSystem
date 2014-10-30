<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
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
			load_chart_list("memberNum",0);  
		});
		
		//ajax 访问函数
		function load_chart_list(num_type,item_index){//在后台加载数据，统计会员百分比
			
			var url = "count/chart_member!member_percentage";//请求的地址 
			$.post(url,{
					keyword:num_type //keyword:传输的是所要统计 字段
				},
				function(data){
					member = eval('('+data+')');
					changeLink(item_index);
					setChart(member); 
				},"json"); 
		}
		
		function changeLink(index){
		
			$("div[id='menu'] span").css("font-weight","");
			$("div[id='menu'] span:eq(" + index +")").css("font-weight","bold");
		}
		
	</script>
  </head>
  
  <body style="background-color: #fff">
  
    <div class="well well-sm">
    	亲， 欢迎访问成都市科协专家库! &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp; 用户类型： 管理员   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名：宫健
   	</div>
	
	<div class="panel panel-default" style="width: 1220px;height: 1100px;margin: 0px 160px 0px 70px;"><div class="panel-body">
		<ul class="nav nav-tabs">
		   <li ><a href="count/skip_member!skip_member" style="padding-left: 60px;padding-right: 60px;">成都市科协专家库</a></li>
		   <li class="active"><a href="count/skip_chart!skip_chart">专家库统计图</a></li>
		   <li ><a href="count/skip_project!skip_project">科研项目</a></li>
		   <li ><a href="count/skip_award!skip_award">成果奖励</a></li>
		   <li ><a href="count/skip_thesis!skip_thesis">科技论文</a></li>
		   <li ><a href="count/skip_patent!skip_patent">发明专利</a></li>
		   <li ><a href="count/skip_someone!skip_someone">找人</a></li>
		   
		</ul>
		
		<div id="container" style="width: 100%;margin-top: 10px;">
			 
			<div id="menu" style="margin-top: 0px;float: top;width: 20%;"><!-- 左边 -->
				<table class="table table-bordered" style="text-align: center">
					<tr><td><a href="javascript: load_chart_list('memberNum',0)" id="left_navi_1"><span>会员统计柱状图</span></a></td></tr>
		            <tr><td><a href="javascript: load_chart_list('projectNum',1)"><span>科研项目柱状图</span></a></td></tr>
		            <tr><td><a href="javascript: load_chart_list('awardNum',2)"><span>成果奖励柱状图</span></a></td></tr>
		            <tr><td><a href="javascript: load_chart_list('thesisNum',3)"><span>科技论文柱状图</span></a></td></tr>
		            <tr><td><a href="javascript: load_chart_list('patentNum',4)"><span>发明专利柱状图</span></a></td></tr>
				</table>
			</div><!-- ./well well-lg -->
				
			<div id="content"  style="margin: 0px 0px 0px 10px; width: 75%"><!-- 右边 -->
				
				<div class="alert alert-error" id="toggle_1">
				  	各个一级学科会员百分占比情况一览
				  	<jsp:include page="/WEB-INF/chart/member_chart.jsp"></jsp:include>
				</div>
				
			</div><!-- ./content  -->
		</div><!-- ./container -->
		
	</div></div>	
	
	<s:debug></s:debug>
		
  </body>
  
</html>
