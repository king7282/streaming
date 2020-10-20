<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>JYJ Streaming Service</title>
<script src="/streaming/js/jquery.min.js"></script>
<script src="/streaming/js/bootstrap.min.js"></script>
<link href="/streaming/css/bootstrap.min.css" rel="stylesheet"/>
<script src="/streaming/js/test.js"></script>
</head>
<body>
<div style="text-align:center;">
<font size="5em">ID : <input type="text" id="ID" value="${ID}" readonly></font>
</div>

<div style="text-align:center;padding-top:50px;">
	<div style="border:1px solid;width:1100px; height:800px;left:50%;margin:0 auto;">
		<video id="video" style="width:1024px;height:768px;padding-top:20px;"autoplay=""></video>
		<canvas id="canvas" ></canvas>
	</div>
</div>

<div style="width:100%;padding-top:50px;">
	<div style="width:50%;float:left;">
		<button type="button" style="margin-left:100px;" class="btn btn-primary" id="config">Config</button>
	</div>
	<div style="width:50%;float:left;text-align:right;">
		<button type="button" class="btn btn-primary" id="start">Start</button>
		<button type="button" class="btn btn-primary" id="finish" style="margin-right:100px;">Finish</button>
	</div>
</div>

<div class="modal fade" id="broadcast_config_modal">
	<div class="modal-dialog">
	
		<div class="modal-content">
			<div style="padding-top:10px;width:100%;text-align:center;">
				Delay : <input type="text" id="broadcast_delay">
			</div>
			<div style="padding-top:25px;text-align:right;">
				<button type="button" class="btn btn-primary" id="broadcast_config_apply">Apply</button>
				<button type="button" class="btn btn-primary" id="broadcast_config_cancel">Cancel</button>
			</div>
		</div>
	</div>
</div>
</body>
</html>