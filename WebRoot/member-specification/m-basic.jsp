<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'basic.jsp' starting page</title>
    <link href="<%=path %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="<%=path %>/bootstrap/js/jquery.js"></script>
    <script src="<%=path %>/bootstrap/js/bootstrap.min.js"></script>
    <style type="text/css">
    	
    	.table>tbody>tr>td{
    		padding:3px;	
    	}
    	th{
    		text-align: center;
    	}	 
    </style>
    
    <script type="text/javascript">
    	
    	$(function(){
    		
    	});
    	
    </script>
    
  </head>
  
  <body>
       <table class="table table-bordered" style="font-size: 13px;margin: 0px;text-align: center">
     	<tbody>
     	
     	<tr><!-- 基本 信息 start -->
     		<th colspan="6"><a class="btn btn-primary" href="javascript: return false;" style="width: 100%;font-size: 16px;padding: 5px;">基本信息</a></th>
     	</tr>
     	<tr>
     		<th>姓名</th>
     		<th>身份证号</th>
     		<th>性别</th>
     		<th colspan="3">生日</th>
     	</tr>
     	<tr>
     		<td>周锐锋</td>
     		<td>510102196910174364</td>
     		<td>女</td>
     		<td colspan="3">1969-10-17</td>
     	</tr><!-- 基本 信息 end -->
     	
     	<tr><!-- 教育 信息 start -->
     		<th colspan="6"><a class="btn btn-primary" href="javascript: return false;" style="width: 100%;font-size: 16px;padding: 5px;">教育信息</a></th>
     	</tr>
     	<tr>
     		<th>毕业院校</th>
     		<th>所学专业</th>
     		<th>毕业时间</th>
     		<th>学历</th>
     		<th colspan="2">学位</th>
     	</tr>
     	<tr>
     		<td>重庆医科大学</td>
     		<td>临床医学</td>
     		<td>1992-07-06</td>
     		<td>本科</td>
     		<td colspan="2">学士</td>
     	</tr><!-- 教育 信息 end -->
     	
     	<tr><!-- 职业 信息 start -->
     		<th colspan="6"><a class="btn btn-primary" href="javascript: return false;" style="width: 100%;font-size: 16px;padding: 5px;">职业信息</a></th>
     	</tr>
     	<tr>
     		<th>所属学会</th>
     		<th>工作单位</th>
     		<th>技术职称</th>
     		<th>职务</th>
     		<th colspan="2">现从事专业</th>
     	</tr>
     	<tr>
     		<td>成都市防痨协会</td>
     		<td>成都市公共卫生临床医疗中心</td>
     		<td>副主任医师</td>
     		<td>医疗组长</td>
     		<td colspan="2">艾滋病临床</td>
     	</tr><!-- 职业 信息 end -->
     	
     	<tr><!-- 联系 信息 start -->
     		<th colspan="6"><a class="btn btn-primary" href="javascript: return false;" style="width: 100%;font-size: 16px;padding: 5px;">联系信息</a></th>
     	</tr>
     	<tr>
     		<th>通讯地址</th>
     		<th>手机</th>
     		<th>办公电话</th>
     		<th>邮编</th>
     		<th>邮箱</th>
     		<th>QQ</th>
     	</tr>
     	<tr>
     		<td>成都市锦江区静明路377号</td>
     		<td>13981899327</td>
     		<td>028-64369017</td>
     		<td>610066</td>
     		<td> </td>
     		<td> </td>
     	</tr><!-- 联系 信息  over -->
     	
     	<tr><!-- 标签 信息 start -->
     		<th colspan="6"><a class="btn btn-primary" href="javascript: return false;" style="width: 100%;font-size: 16px;padding: 5px;">标签信息[擅长领域]</a></th>
     	</tr>
     	
     	<tr>
     		<td colspan="6">传染病控制：艾滋病、病毒性肝炎治疗和控制</td>
     	</tr><!-- 标签 信息 over-->
     	
    </tbody> </table>
  </body>
</html>
