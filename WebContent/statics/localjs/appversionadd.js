$(function(){ 
	
	$("#back").on("click",function(){
		window.location.href = "list";
	});
	
});
$("#send").click(function(){
	alert("进入")
	var versionNo=$("#versionNo").val();
	var versionSize=$("#versionSize").val();
	var versionInfo=$("#versionInfo").val();
	 if(versionNo==null||versionNo==""){
		 alert("版本号不能为空");
		 return false;
	 }
	 if(versionSize==null||versionSize==""){
		 alert("版本大小不能为空");
		 return false;
	 }
	 if(versionInfo==null||versionInfo==""){
		 alert("版本简介不能为空");
		 return false;
	 }
	 $("form").submit();
});
      
      
      