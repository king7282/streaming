$(document).ready(function() {
	var time = $("#broadcast_time").val();
	var server_ID = $("#ID").val();
	
	var canvas = document.getElementById("canvas");
	canvas.width = 1024;
	canvas.height = 768;
	
	var ctx = canvas.getContext("2d");

	var image = new Image();
	image.onload = function() {
 		ctx.drawImage(image, 0, 0);
		console.log("!!");
	};

	$("#time_apply").click(function() {
		time = $("#broadcast_time").val();
	});
	
	function get_screen() {
		var url = "/streaming/Broadcast/" + server_ID + "/getScreen";
		$.ajax({
			method : "GET",
			async: false,
			url : url,
			dataType: "JSON",
			data: { "time" : time},
			success:function(data){
				image.src = data.image;
			},
			error:function(error){
				console.log("something wrongs!!");
			}
		});
			
		setTimeout( get_screen, 50);
	}
	
	get_screen();
});