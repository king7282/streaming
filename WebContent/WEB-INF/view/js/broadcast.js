$(document).ready(function() {
	var flag = 1;
	$("#config").click(function() {
		$("#broadcast_config_modal").modal("show");
		
		if(flag == 1) {
			$("#broadcast_config_apply").click(function() { 
				var delay = $("#broadcast_delay").val();
				console.log(delay);
			});
			flag = 0;
		}
	});
	
	$("#broadcast_config_cancel").click(function() {
		$("#broadcast_config_modal").modal("hide");
		$("#broadcast_delay").val('');
	});
	
	$("#start").click(function(){
		console.log("send server start signal");
	});
	
	$("#finish").click(function() {
		console.log("send server finish signal");
	});
	
});