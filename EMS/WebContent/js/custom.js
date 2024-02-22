$(document).ready(function(){
	$("#add_new_user").click(function(){
		window.location.href='addUser';
	})
	$(".edit_userBtn_cls").click(function(){
		var idarr=$(this).attr("id").split("_");
		var id=idarr[2];
		window.location.href='editUser?id='+id;
	})
})