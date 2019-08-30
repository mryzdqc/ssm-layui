<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="../js/jquery-2.2.4.min.js"></script>
</head>
<body>

<!-- <form method="post" action="sss.action">
	<input type="hidden" name="_method" value="DELETE">
	<input name="name">
	<input type="submit">
</form> -->

<script type="text/javascript">
function openfile(){
	$("[name=file]")[0].click();
}
function upload(){
	var formData = new FormData();
    formData.append("file",$("[name=file]")[0].files[0]);
    $.ajax({
        url:'sss.action',
        type:'post',
        data: formData,
        contentType: false,
        processData: false,
        success:function(res){
           $(".upimg").attr("src",res);
        }
    });
}
</script>

<button onclick="openfile()">
测试
</button>
<button onclick="upload()">
上传
</button>
<img class="upimg" src="">
</div>

<form method="post" action="sss.action" enctype="multipart/form-data " style="display:none">
<input type="file" name="file"/> 
<input type="submit" />
</form>

</body>
</html>