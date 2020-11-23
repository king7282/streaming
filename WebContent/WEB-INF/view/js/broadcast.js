$(document).ready(function() {
	var modal_flag = 1, video_flag = 0, server_ID = $("#ID").val();
	
	$("#config").click(function() {
		$("#broadcast_config_modal").modal("show");
		
		if(modal_flag == 1) {
			$("#broadcast_config_apply").click(function() { 
				var delay = $("#broadcast_delay").val();
				var url = "/streaming/Broadcast/" + server_ID + "/config";
				
				$.ajax({
					method: "POST",
					url : url,
					data : {"delay" : delay},
					success : function(data) {
						console.log("config SUCCESS!!");
					},
					error : function(e) {
						console.log("config FAIL!!");
					}
				});
			});
			modal_flag = 0;
		}
	});
	
	$("#broadcast_config_cancel").click(function() {
		$("#broadcast_config_modal").modal("hide");
		$("#broadcast_delay").val('');
	});
	
	$("#start").click(function(){
		console.log("send server start signal");
		video_flag = 1;
	});
	
	$("#finish").click(function() {
		console.log("send server finish signal");
		video_flag = 0;
	});
	
	(function() {
		var canvas = document.getElementById('canvas');
		canvas.width = 1024;
		canvas.height = 768;
		
  		var context = canvas.getContext('2d');
  		var video = document.getElementById('video');
  		navigator.getMedia =  navigator.getUserMedia ||
  		navigator.webkitGetUserMedia ||
  		navigator.mozGetuserMedia ||
  		navigator.msGetUserMedia;
  
  		navigator.getMedia({
    		video: true,
    		audio: false
  		}, function(stream) {
			video.srcObject = stream;
    		video.play();
  		}, function(error) {
    	// an error occurred
  		});
  
  		video.addEventListener('play', function() {
    		draw( this, context, 1024, 768 );
  		}, false );
  
		function draw( video, context, width, height ) {
    		var image, data, i, r, g, b, brightness;
    
    		context.drawImage( video, 0, 0, width, height );
    
 /*   		image = context.getImageData( 0, 0, width, height );
    		data = image.data;
    
    		for( i = 0 ; i < data.length ; i += 4 ) {
     			r = data[i];
      			g = data[i + 1];
      			b = data[i + 2];
      			brightness = ( r + g + b ) / 3;
      			//data[i + 4] = brightness;
      			//data[i] = data[i + 1] = data[i + 2] = brightness;
    		}
    
    		image.data = data;
    
    		context.putImageData( image, 0, 0 );*/
			
    		setTimeout( draw, 10, video, context, width, height );

			if(video_flag == 1) {
				var url = "/streaming/Broadcast/" + server_ID + "/setScreen";
				var imageData = canvas.toDataURL("image/jpg");
				
				$.ajax({
					method: "POST",
					url : url,
					data : {"image" : imageData},
					success : function(data) {
						console.log("SUCCESS!!");
					},
					error : function(e) {
						console.log("Something wrongs");
					}
				});
			}
			
  		}

  		canvas.style.display = "none";
	} )();
});