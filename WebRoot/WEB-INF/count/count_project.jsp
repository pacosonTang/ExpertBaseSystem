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
	 
  </head>
  
  <body style="background-color: #fff">
  
    <div class="well well-sm">
    	<jsp:include page="/WEB-INF/count/commone_top.jsp" flush="true"></jsp:include><!-- 顶部 -->
   	</div>
	
	<div class="panel panel-default" style="width: 1220px;height: 550px;margin: 0px 160px 0px 70px;"><div class="panel-body">
		<ul class="nav nav-tabs">
		   
		   <li ><a href="count/skip_member!skip_member" style="padding-left: 60px;padding-right: 60px;">成都市科协专家库</a></li>
		   <li ><a href="count/skip_chart!skip_chart">专家库统计图</a></li>
		   <li class="active" ><a href="count/skip_project!skip_project">科研项目</a></li>
		   <li ><a href="count/skip_award!skip_award">成果奖励</a></li>
		   <li ><a href="count/skip_thesis!skip_thesis">科技论文</a></li>
		   <li ><a href="count/skip_patent!skip_patent">发明专利</a></li>
		   <li ><a href="count/skip_someone!skip_someone">找人</a></li>
		   
		   <li style="float: right;">
			   	<jsp:include page="/WEB-INF/count/common-subject.jsp" flush="true"></jsp:include><!-- 顶部 -->
		   </li>
		   
		</ul>
		
		<div id="container" style="width: 100%;height: 100%;margin-top: 10px;">
			 
			<div id="menu"  style="margin-top: 0px;float: top;width: 18%;"><!-- 左边 -->
				<jsp:include page="/WEB-INF/demo-part/fourpaging.jsp" flush="true"></jsp:include><!-- 分页 -->
			</div><!-- ./well well-lg -->
				
			<div id="content"  style="margin: 0px 0px 0px 20px;width: 78%;height: 450px;overflow: scroll;" ><!-- 右边 -->
				
				<s:if test="#request.list_total!=null">
				 <table class="table table-bordered table-striped" style="font-size: 13px;margin: 0px;text-align: center;vertical-align: middle;">
			     	<thead><tr style="vertical-align: middle;">
			     		<th width="4%" style="text-align: center;vertical-align: middle;">编号</th>
			     		<th width="25%" style="text-align: center;vertical-align: middle;">项目名称</th>
			     		<th width="10%" style="text-align: center;vertical-align: middle;">委托单位</th>
			     		<th width="7%" style="text-align: center;vertical-align: middle;">项目<br/>级别</th>
			     		<th width="10%" style="text-align: center;vertical-align: middle;">项目<br/>时间</th>
			     		<th width="7%" style="text-align: center;vertical-align: middle;">完成<br/>状态</th>
			     		<th width="7%" style="text-align: center;vertical-align: middle;">本人<br/>作用</th>
			     		<th width="7%" style="text-align: center;vertical-align: middle;">自筹<br/>经费</th>
			     		<th width="7%" style="text-align: center;vertical-align: middle;">财政<br/>拨款</th>
			     		<th width="7%" style="text-align: center;vertical-align: middle;">负责人</th>
			     	</tr></thead><tbody>
				 <s:iterator value="#request.list_total" status="st" id="proDto">
		    		<tr>
			     		<td style="text-align: center;vertical-align: middle;"><span class="label label-info"><s:property value="#st.count"/></span></td>
			     		<td style="text-align: center;vertical-align: middle;"><s:property value="#proDto.name"/></td>
			     		<td style="text-align: center;vertical-align: middle;"><s:property value="#proDto.delegationUnit"/></td>
			     		<td style="text-align: center;vertical-align: middle;"><s:property value="#proDto.projectLevel"/></td>
			     		<td style="text-align: center;vertical-align: middle;"><s:property value="#proDto.projectTime"/></td>
			     		<td style="text-align: center;vertical-align: middle;"><s:property value="#proDto.completeStatus"/></td>
			     		<td style="text-align: center;vertical-align: middle;"><s:property value="#proDto.selfFunc"/></td>
			     		<td style="text-align: center;vertical-align: middle;"><s:property value="#proDto.allocation"/></td>
			     		<td style="text-align: center;vertical-align: middle;"><s:property value="#proDto.selffinance"/></td>
			     		<td style="text-align: center;vertical-align: middle;"><s:property value="#proDto.user.realname"/></td>
			     	</tr>
			     	
					</s:iterator>
				</tbody></table>
				</s:if>
				 
			</div><!-- ./content  -->
		</div><!-- ./container -->
		
	</div></div>
	
	<s:debug></s:debug>	
  </body>
  
  
</html>
