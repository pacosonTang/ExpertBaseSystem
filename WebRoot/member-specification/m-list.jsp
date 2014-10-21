<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script src="<%=path %>/bootstrap/js/jquery.js"></script>
	<script type="text/javascript">
		
		
		function finduser(userid){
			window.location="count/someone_a!find_someone?keyword=" + userid;
		}
		/*ajax 访问函数
		function finduser(userid){
	
			alert(userid);
			var url = "count/someone_a!find_someone_id";//请求的地址 
			$.post(url,{
					keyword:userid//[逗号 连接 ]
				},
				function(data){
					member = eval('('+data+')');
					alert("success");
					setUser_detail(member);
				},"json"); 
		}
		
		function setUser_detail(temp_user){
			
			alert(temp_user);
		}*/
	</script>
	</head>
<body>
	
	<div class="panel panel-primary" style="width: 950px;margin-bottom: 10px;">
	   <div class="panel-heading" >
	      <h3 class="panel-title" align="center">【&nbsp;<s:property value="keyword"/>&nbsp;】下属会员列表</h3>
	   </div><!-- ./panel-heading -->
	   
	   <div class="panel-body" style="padding: 5px;">
	   		
			<table class="table" style="font-size: 14px;margin: 0px;">
                
            <s:iterator value="#request.list_total" status="st" id="userlist">
			<!-- 编号：<s:property value="#userlist.first_p"/> -->
			<s:if test="#st.index%10==0">
				<tr>
			</s:if>
			<td>
				<button class="btn btn-danger" type="button" style="width: 65px;" onclick="javascript:finduser(<s:property value="#userlist.first_p"/>)">
					<s:property value="#userlist.second_p"/>
				</button>
			</td>
		</s:iterator>
            </table>
            
	   </div><!-- ./panel-body-->
	 </div><!-- ./panel panel-primary-->
</body>
</html>