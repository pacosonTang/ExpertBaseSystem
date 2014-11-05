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
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style type="text/css">
		div#container{width:500px}
		div#menu {height:400px;width:180px;float:left;}
		div#content {background-color:;height:400px;width:650px;float:right;}
	</style>
	
    <link href="<%=path %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="<%=path %>/bootstrap/js/jquery.js"></script>
    <script src="<%=path %>/bootstrap/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
		
		var access = new Array(-1,-1,-1,-1);//初试值为-1		
		function toggleMenu(index){//让各个标签置顶
			
			if(index > 1 )
				if(access[index-2] == -1)
					find_specific_four(index);
			 
			access[index-2] = index;//存储已经加载了的信息，2项目，3奖励， 4论文， 5专利
			document.getElementById("item" + index).scrollIntoView();
			changeLink(index);
			return false;
		}
		
		function changeLink(index){
		
			$("div[id='menu'] span").css("font-weight","");
			$("div[id='menu'] span:eq(" + index +")").css("font-weight","bold");
		}

		//ajax 访问函数
		function find_specific_four(index){//在后台加载数据，项目2，奖励3， 论文4， 专利5， index=2, 3, 4, 5
			
			access[index-2] = true;
			var url = "count/specific!specific_four";//请求的地址 
			$.post(url,{
					someoneKey:cur_find_id, //[逗号 连接 ]
					specific_type:index
				},
				function(data){
					member = eval('('+data+')');
 					//alert("success");
					setSpesific_detail(member.list,index);
				},"json"); 
		}
		function setSpesific_detail(specific,type){//显示用户基本信息
			
			switch(type){
				case 2:setProject_detail(specific);break;
				case 3:setAward_detail(specific);break;
				case 4:setThesis_detail(specific);break;
				case 5:setPatent_detail(specific);break;
				default:break;
			} 
		}
		
	</script>
	
	<style type="text/css">
		div#menu{
			position: fixed;
			left: 92px;
			top: 150px;
		}
	</style>
  </head>
  
  <body style="background-color: #fff;padding: 0px">
  
    <div class="well well-sm">
    	亲， 欢迎访问成都市科协专家库! &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp; 用户类型： 管理员   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名：宫健
   	</div>
	
	<div class="panel panel-default" style="width: 1220px;height: 550px;margin: 0px 160px 0px 70px;"><div class="panel-body">
		<ul class="nav nav-tabs">
		   
		  <li ><a href="count/skip_member!skip_member" style="padding-left: 60px;padding-right: 60px;">成都市科协专家库</a></li>
		  <li ><a href="count/skip_chart!skip_chart">专家库统计图</a></li>
		   <li ><a href="count/skip_project!skip_project">科研项目</a></li>
		   <li ><a href="count/skip_award!skip_award">成果奖励</a></li>
		   <li ><a href="count/skip_thesis!skip_thesis">科技论文</a></li>
		   <li ><a href="count/skip_patent!skip_patent">发明专利</a></li>
		   <li class="active"><a href="count/skip_someone!skip_someone">找人</a></li>
		   <li style="float: right;">
			   	<jsp:include page="/WEB-INF/count/common-subject.jsp" flush="true"></jsp:include><!-- 顶部 -->
		   </li>
		</ul>
		
		<div id="container" style="width: 100%;margin-top: 10px;">
			 
			<div id="menu" style="margin: 0px 0px 0px 5px;float: top;width: 180px; "><!-- 左边 -->
				<table class="table table-bordered" style="text-align: center">
					<tr class="error"><td><a href="javascript: toggleMenu(0);"><span>会员列表</span></a></td></tr>
		            <tr class="error"><td><a href="javascript: toggleMenu(1);"><span>会员基本信息</span></a></td></tr>
	    	        <tr class="error"><td><a href="javascript: toggleMenu(2);"><span>会员科研项目列表</span></a></td></tr>
	                <tr class="error"><td><a href="javascript: toggleMenu(3);"><span>会员成果奖励列表</span></a></td></tr>
	                <tr class="error"><td><a href="javascript: toggleMenu(4);"><span>会员科技论文列表</span></a></td></tr>
	                <tr class="error"><td><a href="javascript: toggleMenu(5);"><span>会员发明专利列表</span></a></td></tr>
	                
				</table>
			</div><!-- ./well well-lg -->
				
			<div id="content"  style="margin: 0px 0px 0px 220px;width: 75%;float: left"><!-- 右边 -->
				
				<div style="margin-left: 10px;width: 105%;margin-top: 5px;height: 450px;overflow: scroll;">
					<div data-spy="scroll" data-target="#navbar-example" data-offset="0" >
					   
					   <h4 id="item0"></h4><!-- 会员列表 -->
					   <jsp:include page="/WEB-INF/member-specification/m-list.jsp"></jsp:include>
					   
					   <h4 id="item1"></h4>
					   <jsp:include page="/WEB-INF/member-specification/m-basic.jsp"></jsp:include>
					   
					   <h4 id="item2" style="margin-top: 10px;"></h4><!-- 项目 -->
					   <jsp:include page="/WEB-INF/member-specification/m-project.jsp"></jsp:include>
					   
					   <h4 id="item3" style="margin-top: 10px;"></h4><!-- 奖励 -->
					   <jsp:include page="/WEB-INF/member-specification/m-award.jsp"></jsp:include>
					   
					   <h4 id="item4" style="margin-top: 10px;"></h4><!-- 论文 -->
					   <jsp:include page="/WEB-INF/member-specification/m-thesis.jsp"></jsp:include>
					   
					   <h4 id="item5" style="margin-top: 10px;"></h4><!-- 专利 -->
					   <jsp:include page="/WEB-INF/member-specification/m-patent.jsp"></jsp:include>
					    
					</div>
				  
				  </div>
				
			</div><!-- ./content  -->
		</div><!-- ./container -->
		
	</div></div>	
	<s:debug></s:debug>
	<s:property value="#session.access" />
  </body>
  
</html>
