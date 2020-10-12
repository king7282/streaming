<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>JYJ Streaming Service</title>
<script src="./js/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<link href="./css/bootstrap.min.css" rel="stylesheet"/>
<script src="./js/main.js"></script>
</head>
<body>
<div style="padding-top:20%; width:100%;text-align:center;">
	<button type="button" class="btn btn-primary" id="broadcast">Do Broadcasting</button>
</div>
<div style="padding-top:10%; width:100%;text-align:center;">
	<button type="button" class="btn btn-primary" id="show_broadcast">Watch Broadcasting</button>
</div>

<div class="modal fade" id="show_broadcast_modal">
	<div class="modal-dialog">
	
		<div class="modal-content">
			<div style="padding-top:10px;width:100%;text-align:center;">
				ID : <input type="text" id="broadcast_id">
			</div>
			<div style="padding-top:25px;text-align:right;">
				<button type="button" class="btn btn-primary" id="show_broadcast_watch">Watch</button>
				<button type="button" class="btn btn-primary" id="show_broadcast_cancel">Cancel</button>
			</div>
		</div>
	</div>
</div>
</body>
</html>