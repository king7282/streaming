$(document).ready(function() {
	var flag=0;
	
	$("#broadcast").click(function() {
		window.location = "Broadcast";
	});
	
	$("#show_broadcast").click(function() {
		$("#show_broadcast_modal").modal("show");
		
		if (flag==0) {
			$("#show_broadcast_watch").click(function() {
				var ID = $("#broadcast_id").val()
				window.location = "Broadcast/" + ID;
			});
			flag=1;
		}
	});
	
	
	$("#show_broadcast_cancel").click(function() {
		$("#broadcast_id").val('');
		$("#show_broadcast_modal").modal("hide");
	});
});