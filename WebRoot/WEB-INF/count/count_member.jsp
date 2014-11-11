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
	
  </head>
  
  <body style="background-color: #fff">
  
    <div class="well well-sm">
    	<jsp:include page="/WEB-INF/count/commone_top.jsp" flush="true"></jsp:include><!-- 顶部 -->
   	</div>
	
	<div class="panel panel-default" style="width: 1220px;height: 550px;margin: 0px 160px 0px 70px;"><div class="panel-body">
		<ul class="nav nav-tabs">
		   <li class="active"><a href="count/skip_member!skip_member" style="padding-left: 60px;padding-right: 60px;">成都市科协专家库</a></li>
		   <li ><a href="count/skip_chart!skip_chart">专家库统计图</a></li>
		   <li ><a href="count/skip_project!skip_project">科研项目</a></li>
		   <li ><a href="count/skip_award!skip_award">成果奖励</a></li>
		   <li ><a href="count/skip_thesis!skip_thesis">科技论文</a></li>
		   <li ><a href="count/skip_patent!skip_patent">发明专利</a></li>
		   <li ><a href="count/skip_someone!skip_someone">找人</a></li>
		   
		   <li style="float: right;">
			   	<jsp:include page="/WEB-INF/count/common-subject.jsp" flush="true"></jsp:include><!-- 顶部 -->
		   </li>
		  
		</ul>
		
		<div id="container" style="width: 100%;margin-top: 10px;">
			 
			<div id="menu"  style="margin-top: 0px;float: top;width: 18%;"><!-- 左边 -->
				<jsp:include page="/WEB-INF/demo-part/paging.jsp" flush="true"></jsp:include><!-- 分页 -->
			</div><!-- ./well well-lg -->
				
			<div id="content"  style="margin: 0px 0px 0px 10px; width: 80%;height: 500px;overflow: scroll;"><!-- 右边 -->
				<s:if test="#request.list_total!=null">
				<table style="vertical-align: top" id="toggle_2"><tbody>
					 <s:iterator value="#request.list_total" status="st" id="userDto">
				    	<s:if test="#st.index%4==0||#st.first">
				    		<tr>
				    	</s:if>
				    		<td style="padding-left: 10px;">
				    			<jsp:include page="/WEB-INF/demo-part/expert-basic.jsp" flush="true">
				    				<jsp:param value="${userDto.realname}" name="username"/>
				    				<jsp:param value="${userDto.patNum}" name="patent"/>
				    				<jsp:param value="${userDto.tNum}" name="thesis"/>
				    				<jsp:param value="${userDto.aNum}" name="award"/>
				    				<jsp:param value="${userDto.proNum}" name="project"/>
				    			</jsp:include>
			    			</td>
				   	 </s:iterator>
					
					</tbody></table>
				 </s:if>
			</div><!-- ./content  -->
		</div><!-- ./container -->
		
	</div></div>	
	
	<s:debug></s:debug>
		
  </body>
  
</html>
