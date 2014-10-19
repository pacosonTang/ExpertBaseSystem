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
		<script>
			
			var randomScalingFactor = function(){ return Math.round(Math.random()*100)};
			
			var sub = ["理学","工学","农学","医学","哲学","经济学","教育学","文学","历史学","管理学","中小学教育学","法学"];
			var barChartData={
				
				labels : ["理学","工学","农学","医学","哲学","经济学","教育学","文学","历史学","管理学","中小学教育学","法学"],
				datasets:[
					{
						fillColor : "rgba(220,220,220,0.5)",
						strokeColor : "rgba(220,220,220,0.8)",
						highlightFill: "rgba(220,220,220,0.75)",
						highlightStroke: "rgba(220,220,220,1)",
						data : [randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),
								randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),
								randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor()
							   ]
					},
					{
						fillColor : "rgba(151,187,205,0.5)",
						strokeColor : "rgba(151,187,205,0.8)",
						highlightFill : "rgba(151,187,205,0.75)",
						highlightStroke : "rgba(151,187,205,1)",
						data : [randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),
								randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),
								randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor()
							   ]
					}
				]
			}
			
			window.onload = function(){
				var ctx = document.getElementById("canvas").getContext("2d");
				window.myBar = new Chart(ctx).Bar(barChartData, {
					responsive : true
				});
			}

	</script> 
	</head>
	
	<body>
		<div style="width: 100%; font-family:courier ">
			<canvas id="canvas"></canvas>
		</div>
	</body>
</html>
