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
		
		var new_find_id;
		var cur_username = "";
		
		//ajax 访问函数
		function finduser(userid){
			
			new_find_id = userid;
			//alert(userid);
			var url = "count/someone_a!find_someone_id";//请求的地址 
			$.post(url,{
					keyword:userid //[逗号 连接 ]
				},
				function(data){
					member = eval('('+data+')');
					//alert("success");
					setUser_detail(member);
				},"json"); 
		}
		function setUser_detail(temp_user){//显示用户基本信息
			
			access = new Array(-1,-1,-1,-1);//初试值为-1
			cur_username = temp_user.list[0].realname;
			$("span[id='fourname']").text(" [" + cur_username + "] ");
			$("table[id='user_specific'] td:eq(0)").text(temp_user.list[0].realname);
			$("table[id='user_specific'] td:eq(1)").text(temp_user.list[0].idNo);
			$("table[id='user_specific'] td:eq(2)").text(temp_user.list[0].sex);
			$("table[id='user_specific'] td:eq(3)").text(temp_user.list[0].birthday);
			$("table[id='user_specific'] td:eq(4)").text(temp_user.list[0].school);
			$("table[id='user_specific'] td:eq(5)").text(temp_user.list[0].graduateTime);
			$("table[id='user_specific'] td:eq(6)").text(temp_user.list[0].education.name);
 			$("table[id='user_specific'] td:eq(7)").text(temp_user.list[0].degree.name);
			$("table[id='user_specific'] td:eq(8)").text(temp_user.list[0].major.name);
			$("table[id='user_specific'] td:eq(9)").text(temp_user.list[0].institution.name);
			$("table[id='user_specific'] td:eq(10)").text(temp_user.list[0].workUnit);
			$("table[id='user_specific'] td:eq(11)").text(temp_user.list[0].title);
			$("table[id='user_specific'] td:eq(12)").text(temp_user.list[0].duty);
			$("table[id='user_specific'] td:eq(13)").text(temp_user.list[0].telephone);
			$("table[id='user_specific'] td:eq(14)").text(temp_user.list[0].officePhone);
			$("table[id='user_specific'] td:eq(15)").text(temp_user.list[0].postcode);
			$("table[id='user_specific'] td:eq(16)").text(temp_user.list[0].email);
			$("table[id='user_specific'] td:eq(17)").text(temp_user.list[0].qq);
			$("table[id='user_specific'] td:eq(18)").text(temp_user.list[0].address);
			$("table[id='user_specific'] td:eq(19)").text(temp_user.list[0].adept);
			$("table[id='user_specific'] td:eq(20)").text(temp_user.list[0].currentMajor);
			$("table[id='project']").empty();
			$("table[id='patent']").empty();
			$("table[id='award']").empty();
			$("table[id='thesis']").empty();
			$("#user_specific").show();
		}
		
	</script>
	</head>
<body>
	
	<div class="panel panel-primary" style="width: 900px;margin-bottom: 10px;">
	   <div class="panel-heading" >
	      <h3 class="panel-title" align="center">【&nbsp;<s:property value="someoneKey"/>&nbsp;】下属会员列表</h3>
	   </div><!-- ./panel-heading -->
	   
	   <div class="panel-body" style="padding: 5px;">
	   		
		<table class="table" style="font-size: 14px;margin: 0px;text-align: left;">
                
            <s:iterator value="#request.list_total" status="st" id="userlist">
			<!-- 编号：<s:property value="#userlist.first_p"/> -->
			<s:if test="#st.index%10==0">
				<tr>
			</s:if>
			<td style="width: 80px;">
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