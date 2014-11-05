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
    
    <title>My JSP 'paging.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="<%=path %>/bootstrap/js/jquery.js"></script>
	<script type="text/javascript">
		
		$(function(){
			setSelect();
				
			 
		})
		
		//设置select的option
		function setSelect(){
			$("select").empty();
			var item_total = "<%=session.getAttribute("item_total")%>";
			item_total = item_total/10;
			$("select").append("<option></option>");
			for ( var int = 0; int < item_total; int++) 
				$("select").append("<option>"+ (int+1) + "</option>");
		}
		
		function loadpage(){
			
			var pageindex =  $("select option:selected").text();
			var access = "<%=session.getAttribute("access")%>";
			if(pageindex=="") return;
			window.location= "count/"+ access + "!page_four?curpage="+ pageindex;
		}
		
	</script>
  </head>
  
  <body>
     <table>
		<tr>
			<td colspan="2" style="text-align: center">
				<a href="javascript: return false;" class="btn btn-large btn-primary disabled" style="padding: 10px 50px;">共有<s:property value="#session.item_total"/>条记录</a></td>
		</tr>
		<tr>
			<td>当前第<s:property value="#request.curpage"/>页</td>
		</tr>
		<tr>
			<td>
				跳转到第	   
				<select onchange="javascript:loadpage()">
				</select>页         
			</td>
		</tr>
	</table>
  </body>
</html>
