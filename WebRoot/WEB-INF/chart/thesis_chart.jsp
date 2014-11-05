<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
	<head>
		<base href="<%=basePath%>">
		<title>Pie Chart</title>
		<link href="<%=path %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<script type="text/javascript" src="<%=path%>/bootstrap/js/jquery.js"></script>
		<script type="text/javascript" src="<%=path%>/bootstrap/js/Chart.js"></script>
		<script src="<%=path %>/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			
			function setChart_thesis(tempdata){
				
				var f_list = new Array();
				var s_list = new Array();
				var temp = tempdata.list;
				for(var i=0;i<12;i++){
					f_list[i] = temp[i].first_p;
					s_list[i] = temp[i].second_p;
				}
				var randomScalingFactor = function(){ return Math.round(Math.random()*100)};
				var barChartData={
					labels : [f_list[0],f_list[1],f_list[2],f_list[3],f_list[4],f_list[5],
							  f_list[6],f_list[7],f_list[8],f_list[9],f_list[10],f_list[11]],
					datasets:[
						{
							fillColor : "rgba(220,220,220,0.5)",
							strokeColor : "rgba(220,220,220,0.8)",
							highlightFill: "rgba(220,220,220,0.75)",
							highlightStroke: "rgba(220,220,220,1)",
							data : [s_list[0],s_list[1],s_list[2],s_list[3],s_list[4],s_list[5],
							  s_list[6],s_list[7],s_list[8],s_list[9],s_list[10],s_list[11]]
						}
					]
				}
				 
				var ctx = document.getElementById("canvas_thesis").getContext("2d");
				window.myBar = new Chart(ctx).Bar(barChartData, {
					responsive : true
				});
			}
			 
	</script> 
	</head>
	
	<body>
		<div class="panel panel-primary" style="width: 850px;margin-bottom: 5px;">
	   <div class="panel-heading" >
	      <h3 class="panel-title" align="center">一级学科【科技论文】百分占比情况</h3>
	   </div><!-- ./panel-heading -->
	   <div class="panel-body" style="padding: 5px;">
		<div style="width: 100%; font-family:courier ">
			<canvas id="canvas_thesis"></canvas>
		</div>
		</div></div>
	</body>
</html>
