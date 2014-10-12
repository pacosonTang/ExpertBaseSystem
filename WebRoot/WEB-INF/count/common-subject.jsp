<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>综合利用</title>
	<script src="<%=path %>/bootstrap/js/jquery.js"></script>
	
	<script type="text/javascript">
		
		$(function(){
			
			$(".form-control").bind("click", function() {
			  alert("User clicked on foo.");
			  load_subject();
			});
			
		});
		
		function load_subject(){//添加评论
			//请求的地址 　　
			var url = "replyAjax/replyAjaxAction!create_reply";
			var reply_con = $("textarea").val();
			var replier = "";
			var postid =  "<s:property value='#request.post_single.postid'/>";
			
			$.post(url,{
				'reply_con': reply_con,
				'replier': replier,
				'postid': postid,
				'pageindex':pageindex
				},
				function(data){
					member = eval('('+data+')');
					alert("回复成功!");
					$("textarea").val("");	
					reply_list = member;
					addReply_js(parseInt(reply_list[reply_list.length-2]));//调用js函数
				},'json');
		}
		
	</script>
</head>
<body>
	<div class="col-sm-10" style="width: 200px;height: 40px">
    	<input type="text" class="form-control" data-toggle="modal" data-target="#myModal" placeholder="点击选择学科" style="width: 160px; "/> 
    </div>
	
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	   <div class="modal-dialog">
	      <div class="modal-content">
	         <div class="modal-header">
	         	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	            <h4 class="modal-title" id="myModalLabel">选择学科</h4>
	         </div>
	         
	         <div class="modal-body">在这里添加一些文本</div>
	         
	         <div class="modal-footer">
	            <button type="button" class="btn btn-primary" data-dismiss="modal">确认</button>
	         </div>
	         
	      </div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
	</div><!-- /.modal fade -->
	<button type="button" class="btn btn-default" style="margin-bottom: 2px;width: 80px;">查询</button>
</body>
</html>