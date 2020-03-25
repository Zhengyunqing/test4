<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商铺列表</title>
<link href="/resource/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
</head>
<body>

	<h1>店铺详情</h1>
	<table class="table">
		<tr>
			<td>店铺名称：${shop.name }</td>
		</tr>
		<tr>
			<td>创建时间：<fmt:formatDate value="${shop.created }"
					pattern="yyyy-MM-dd" />
			</td>
		</tr>
		<tr>
			<td>所售商品：<c:forEach items="${shop.goods}" var="good">
			  ${good.name }
			</c:forEach>
			</td>
		</tr>

	</table>
</body>
</html>