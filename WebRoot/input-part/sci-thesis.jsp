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
     		<th width="60%" style="text-align: center">论文名称</th>
     		<th width="10%" style="text-align: center">收录年份 </th>
     		<th width="10%" style="text-align: center">作者</th>
     	</tr></thead><tbody>
     	
     	<tr>
     		<td style="text-align: center"><span class="badge badge-info">1</span></td>
     		<td>舒红平,游志胜,王运锋,费向东.空中交通管理系统中航迹发散判据及抑制处理 控制与决策 2005年第3期[EI:2005189081892]</td>
     		<td>2010 </td>
     		<td>舒红平</td>
     	</tr>
     	
     	<tr>
     		<td style="text-align: center"><span class="badge badge-info">2</span></td>
     		<td>舒红平,游志胜,王运锋,费向东.空中交通管理系统中航迹发散判据及抑制处理 控制与决策 2005年第3期[EI:2005189081892]</td>
     		<td>2010 </td>
     		<td>舒红平</td>
     	</tr>
     	
     	<tr>
     		<td style="text-align: center"><span class="badge badge-info">3</span></td>
     		<td>舒红平,游志胜,王运锋,费向东.空中交通管理系统中航迹发散判据及抑制处理 控制与决策 2005年第3期[EI:2005189081892]</td>
     		<td>2010 </td>
     		<td>舒红平</td>
     	</tr>
     	
     	<tr>
     		<td style="text-align: center"><span class="badge badge-info">4</span></td>
     		<td>舒红平,游志胜,王运锋,费向东.空中交通管理系统中航迹发散判据及抑制处理 控制与决策 2005年第3期[EI:2005189081892]</td>
     		<td>2010 </td>
     		<td>舒红平</td>
     	</tr>
     	
    </tbody> </table>
  </body>
</html>
