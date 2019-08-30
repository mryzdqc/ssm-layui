<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>

	
		<c:if test="${info==null}">
			<form action="insert.action" method="post">
		</c:if>
		<c:if test="${info!=null}">
			<form action="update.action" method="post">
			<input name="id" type="hidden" value="${info.id}">
		</c:if>

		<input name="name" value="${info.name}">  <input type="submit">
	</form>

</body>
</html>