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
     		<th width="6%" style="text-align: center">编号</th>
     		<th width="30%" style="text-align: center">项目名称</th>
     		<th width="13%" style="text-align: center">委托单位</th>
     		<th width="10%" style="text-align: center">项目级别</th>
     		<th width="10%" style="text-align: center">完成状态</th>
     		<th width="10%" style="text-align: center">本人作用</th>
     		<th width="12%" style="text-align: center">项目经费</th>
     		<th style="text-align: center">负责人</th>
     	</tr></thead><tbody>
     	
     	<tr>
     		<td style="text-align: center"><span class="badge badge-info">1</span></td>
     		<td>综合不确定因素影响的短期冲突检测模型研究</td>
     		<td>西南交通大学</td>
     		<td>国家级</td>
     		<td>已验收</td>
     		<td>住持</td>
     		<td>自筹2.0<br/>拨款2.5</td>
     		<td>舒红平</td>
     	</tr>
     	
     	<tr>
     		<td style="text-align: center"><span class="badge badge-info">1</span></td>
     		<td>综合不确定因素影响的短期冲突检测模型研究</td>
     		<td>西南交通大学</td>
     		<td>国家级</td>
     		<td>已验收</td>
     		<td>住持</td>
     		<td>自筹2.0<br/>拨款2.5</td>
     		<td>舒红平</td>
     	</tr>
     	
     	<tr>
     		<td style="text-align: center"><span class="badge badge-info">1</span></td>
     		<td>综合不确定因素影响的短期冲突检测模型研究</td>
     		<td>西南交通大学</td>
     		<td>国家级</td>
     		<td>已验收</td>
     		<td>住持</td>
     		<td>自筹2.0<br/>拨款2.5</td>
     		<td>舒红平</td>
     	</tr>
     	
     	<tr>
     		<td style="text-align: center"><span class="badge badge-info">1</span></td>
     		<td>综合不确定因素影响的短期冲突检测模型研究</td>
     		<td>西南交通大学</td>
     		<td>国家级</td>
     		<td>已验收</td>
     		<td>住持</td>
     		<td>自筹2.0<br/>拨款2.5</td>
     		<td>舒红平</td>
     	</tr>
     	
     	<tr>
     		<td style="text-align: center"><span class="badge badge-info">1</span></td>
     		<td>综合不确定因素影响的短期冲突检测模型研究</td>
     		<td>西南交通大学</td>
     		<td>国家级</td>
     		<td>已验收</td>
     		<td>住持</td>
     		<td>自筹2.0<br/>拨款2.5</td>
     		<td>舒红平</td>
     	</tr>
     	
    </tbody> </table>
  </body>
</html>
