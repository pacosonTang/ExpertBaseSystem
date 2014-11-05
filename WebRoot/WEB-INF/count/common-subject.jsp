<%@ page language="java" import="java.util.*"  pageEncoding="GBK" contentType="text/html; charset=GBK"%>
 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>�ۺ�����</title>
	<script src="<%=path %>/bootstrap/js/jquery.js"></script>
	
	<script type="text/javascript">
		
		var flag = -1;
		 
		$(function(){
				
			$(".form-control").bind("click", function() {
			  load_subject();
			});	
			var cur_sub = "<%=session.getAttribute("cur_sub")%>";
			if(cur_sub!="null")
				$("#seledsub").val(cur_sub);//����input��value����
				//findKey();//�൱�� ���� ��ѯ��ť�¼�				
		    else{
				$("input[id='seledsub']").trigger("click");
			}
		});
		
		function load_subject(){//
			
			if(flag != -1) return false;
			//����ĵ�ַ ����
			var url = "count/subject!findSubject";
			$.post(url,{
					postid:"1"//[���� ���� ]
				},
				function(data){
					member = eval('('+data+')');
					setSubject(member);
				},"json"); 
		}
		
		function setSubject(firstSubjects){
			
			flag = firstSubjects.length;
			$("#firstsub").empty();
			$("#tab-content").empty();
//			$("#firstsub").append("<li class='active'><a href='#l0' data-toggle='tab'>"+ firstSubjects[0].first + "</a></li>");
//			$("#tab-content").append("<div class='tab-pane active' id='l0'>"+ 0 + "</div>");
			for ( var i = 0; i < firstSubjects.length; i++) {
				
				$("#firstsub").append("<li class=''><a href='#l" + i + "' data-toggle='tab'>"+ firstSubjects[i].first + "</a></li>");
				$("#tab-content").append("<div class='tab-pane' id='l"+ i + "'></div>");
				//$("#l" + i).append("<table class='table' id='table" + i + "'></table>");
				
				var first = firstSubjects[i];
				//alert(firstSubjects[i].secondlist.length);
				for (var j = 0; j < first.secondlist.length; j++) {
					var second = first.secondlist[j];
					//alert(temp);��ӡ����ѧ���� 
					//$("#table" + i).append("<tr></tr>");
					//$("#table" + i + " > tr").append("<td>[" + second.secondsingle + "]</td>");
					$("#l"+ i).append("<br/><button type='button' class='btn btn-inverse' style='padding:5px;'>��"+ second.secondsingle + "��</button>");
					for ( var k = 0; k < second.third.length; k++){ 
						var third = second.third;
						$("#l"+ i).append("<button type='button' class='btn btn-primary' style='font-size: 13px;padding: 3px;margin-left:5px;'" + " onclick=javascript:selsub('"+ third[k]+ "')>"+ third[k] + "</button>");
						//$("#l"+ i).append("<button type='button' class='btn btn-primary' data-dismiss='modal' style='font-size: 13px;padding: 3px;margin-left:5px;'>"+ third[k] + "</button>");
					}
				}
			}
		}
		
		var keyword;
		function selsub(obj){
			keyword = obj;
			$("#selsub").text("��ѡ��Ŀ :  " + obj);
			$("#seledsub").val([obj]);
			findKey(obj);
		}
		
		function findKey(keyword){
			
			if(keyword == "undefined" || keyword == "null")
				keyword =  "<%=session.getAttribute("cur_sub")%>";;
			var access = "<%=session.getAttribute("access")%>";
			window.location= "count/" + access + "!total_"+ access + "?keyword=" + keyword + "&curpage=1";
		}
		
		function findInputKey(){
			 
			var keyword = $("#seledsub").val();
			var access = "<%=session.getAttribute("access")%>";
			window.location= "count/" + access + "!total_"+ access + "?keyword=" + keyword;
		}
		
		
	</script>
</head>
<body>
	<div class="col-sm-10" style="width: 200px;height: 40px">
    	<input id="seledsub" type="text" class="form-control" data-toggle="modal" data-target="#myModal" value="" placeholder="���ѡ��ѧ��" style="width: 160px; "/> 
    </div>
	
	<!-- ģ̬��Modal�� -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" 
	 style="width: 1000px;margin:10px 0px 0px 150px;">
	   <div class="modal-dialog" style="width: 100%;">
	      <div class="modal-content" style="width: 100%;">
	        
	         <div class="modal-header">
	         
	         	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	            <h4 class="modal-title" id="myModalLabel">
	            	<button type='button' class='btn btn-danger' style='font-size: 16px;padding: 3px;margin-left:5px;' id="selsub">ѡ��ѧ��</button>
	            	<button type='button' class='btn btn-primary' data-dismiss='modal' style='font-size: 16px;padding: 3px;margin-left:5px;'>ȷ��</button>
	            </h4>
	         	
	         </div><!--  modal-header over -->
	         
	         <div class="modal-body">
	         	<div class="tabbable tabs-left">
	              <ul class="nav nav-tabs" id="firstsub"></ul>
	              
	              <div class="tab-content" id="tab-content">
	              	
	              </div><!-- tab-content over -->
	            </div><!-- tabbable tabs-left over -->
	         </div><!-- modal-body over -->
	         
	      </div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
	</div><!-- /.modal fade -->
	<button type="button" class="btn btn-default" style="margin-bottom: 2px;width: 80px;" onclick="javascript:findInputKey()">��ѯ</button>
</body>
</html>