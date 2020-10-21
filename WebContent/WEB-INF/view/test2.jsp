<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>JYJ Streaming Service</title>
<script src="/streaming/js/jquery.min.js"></script>
<script src="/streaming/js/bootstrap.min.js"></script>
<link href="/streaming/css/bootstrap.min.css" rel="stylesheet"/>
<script src="/streaming/js/test2.js"></script>
</head>
<body>

<div style="text-align:center;">
<font size="5em">ID : <input type="text" id="ID" value="${ID}" readonly></font>
</div>

<div style="text-align:center;padding-top:50px;">
	<div style="border:1px solid;width:1100px; height:800px;left:50%;margin:0 auto;">
		<canvas id="canvas"></canvas>
	</div>
</div>

<div style="width:100%;padding-top:20px;text-align:center;">
	time : <input type="text" id="broadcast_time" value="0">
	<button type="button" style="margin-left:10;" class="btn btn-primary" id="time_apply">Apply</button>
</div>
</body>
</html>