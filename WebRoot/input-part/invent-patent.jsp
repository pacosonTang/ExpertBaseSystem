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
  </head>
  
  <body>
     <table class="table table-bordered table-striped" style="font-size: 13px;margin: 0px;text-align: center">
     	<thead><tr>
     		<th width="7%" style="text-align: center">编号</th>
     		<th width="40%" style="text-align: center">专利名称</th>
     		<th width="24%" style="text-align: center">专利号</th>
     		<th width="14%" style="text-align: center">授权时间</th>
     		<th width="14%" style="text-align: center">获得者</th>
     	</tr></thead><tbody>
     	
     	<tr>
     		<td style="text-align: center"><span class="badge badge-info">1</span></td>
     		<td>基于JavaEE的可配置信息化应用平台 </td>
     		<td>200710029343</td>
     		<td>1991年9月</td>
     		<td>舒红平</td>
     	</tr>
     	
     	<tr>
     		<td style="text-align: center"><span class="badge badge-info">2</span></td>
     		<td>基于JavaEE的可配置信息化应用平台 </td>
     		<td>200710029343</td>
     		<td>1991年9月</td>
     		<td>舒红平</td>
     	</tr>
     	
     	<tr>
     		<td style="text-align: center"><span class="badge badge-info">3</span></td>
     		<td>基于JavaEE的可配置信息化应用平台 </td>
     		<td>200710029343</td>
     		<td>1991年9月</td>
     		<td>舒红平</td>
     	</tr>
     	
     	<tr>
     		<td style="text-align: center"><span class="badge badge-info">4</span></td>
     		<td>基于JavaEE的可配置信息化应用平台 </td>
     		<td>200710029343</td>
     		<td>1991年9月</td>
     		<td>舒红平</td>
     	</tr>
     	
    </tbody> </table>
  </body>
</html>
