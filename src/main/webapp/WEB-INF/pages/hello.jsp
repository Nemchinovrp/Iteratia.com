<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<style>
		<%@include file="/WEB-INF/css/bootstrap.css"%>
	</style>
</head>
<div class="container-fluid">
	<body>
	<h1>Iteratia.com</h1>
	<h1>Список таблиц</h1>
	<a href="${pageContext.request.contextPath}/User">Список пользователей</a>
	<br>
	<a href="${pageContext.request.contextPath}/Account">Список счетов</a>
	<br>
	<a href="${pageContext.request.contextPath}/Transaction">Список транзакций</a>

	</body>

</div>

</html>