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
		<script type="text/javascript" src="<%=path%>/bootstrap/js/jquery.js"></script>
		<script type="text/javascript" src="<%=path%>/bootstrap/jquery-chart/jquery.jqplot.min.js"></script>
		<script type="text/javascript" src="<%=path%>/bootstrap/jquery-chart/jqplot.pieRenderer.min.js"></script>
		<link rel="stylesheet" type="text/css" hrf="<%=path%>/bootstrap/jquery-chart/jquery.jqplot.min.css" />
		<script type="text/javascript">
			$(document).ready(function(){
		    var plot1 = $.jqplot('chart', [[['a',25],['b',14],['c',7],['d',7]]], {
		        gridPadding: {top:0, bottom:38, left:0, right:0},
		        seriesDefaults:{
		            renderer:$.jqplot.PieRenderer, 
		            trendline:{ show:false }, 
		            rendererOptions: { padding: 4, showDataLabels: true }
		        },
		        legend:{
		            show:true, 
		            placement: 'outside', 
		            rendererOptions: {
		                numberRows: 1
		            }, 
		            location:'s',
		            marginTop: '15px'
		        }       
		    });
		});
		</script>
	</head>
	
	<body>
		<div id="chart" style="width:300px;height:420px;" ></div>
	</body>
</html>
