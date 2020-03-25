<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>创建商铺</title>
<link href="/resource/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
</head>
<body>

	<div>
		<h1>创建商铺</h1>
		<form id="form1">
			店铺名称：<input type="text" name="name"><br> 创建日期：<input
				type="date" name="created"><br> 销售商品：<span id="goods">

			</span> <br>
			店面图片：<input type="file" name="file" >
			<br>
			<button type="button" onclick="add()">创建</button>
		</form>
	</div>


</body>
<script type="text/javascript">
//文档就绪函数
$(function(){
	$.get("/selectGoods",{},function(goods){
		for(var i in goods){
			$("#goods").append("<input type='checkbox' name='gids' value='"+goods[i].id+"'>"+goods[i].name+"");
		}
		
	})
	
	
	
})
//执行增加
function add(){
	//获取带文件的form 表单,文件上传
	var formData = new FormData($("#form1")[0]);
	
	$.ajax({
		type:"post",
		data:formData,
		processData:false,//// 告诉jQuery不要去处理发送的数据
		contentType:false,// 告诉jQuery不要去设置Content-Type请求头
		url:"/add",
		success:function(flag){
			if(flag){
				alert("创建成功");
				location.href="/shops";
			}else{
				alert("创建失败");
			}
		}
		
		
		
	})
	
	
	
	
	/* $.post("/add",$("#form1").serialize(),function(flag){
		alert(flag)
			for(var i in  flag){
				alert(flag[i])
			}
		if(flag){
			alert("创建成功");
			location.href="/shops";
		}else{
			alert("创建失败");
		}
	}) */
	
}

</script>
</html>