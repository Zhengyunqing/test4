<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商铺列表</title>
<link href="/resource/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
</head>
<body>


	<h1>商品列表</h1>
	<form action="/shops" method="post">
	销售商品：<span id="goods">
	
	</span><br>
	店铺名称： <input type="text" name="name" value="${name}">
	<button type="submit" class="btn btn-success">查询</button>
	
	
	
	</form>
	<button class="btn btn-info" type="button" onclick="add()">增加 </button>
	<table class="table">
		<tr>
			<td>编号</td>
			<td>商铺名称</td>
			<td>创建日期</td>
			<td>销售的商品</td>
			<td>店铺图片</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${shops}" var="shop" varStatus="i">
			<tr>
				<td>${i.count }</td>
				<td>${shop.name }</td>
				<td><fmt:formatDate value="${shop.created}" pattern="yyyy-MM-dd"/> </td>
				<td><c:forEach items="${shop.goods}" var="good">
				    ${good.name}
				</c:forEach> </td>
				<td><img alt="" src="/pic/${shop.picture}"> </td>
				<td><a href="/detail?id=${shop.id}">详情</a></td>
			</tr>
		</c:forEach>

	</table>

</body>
<script type="text/javascript">
//当页面打开时，查询所有商品，并放在goods的内容中
$(function(){
	//1 查询所有商品，并放在goods的内容中
	$.get("/selectGoods",{},function(goods){
		for(var i in goods){
		  $("#goods").append("<input type='checkbox' name='gids' value='"+goods[i].id+"'>"+goods[i].name+"")	
		}
		
		//2 查询条件的回显 1,2,3
		var gids = '${gids}';//从model中获取的内容
		 gids=gids.split(",");//分割字符串
		for(var i in gids){//遍历
			$("[type='checkbox'][value='"+gids[i]+"']").prop("checked",true);
		}
	})
	
	
	
	
})


//去增加
function add(){
	location.href="add";//跳转到增加页面
}


</script>
</html>