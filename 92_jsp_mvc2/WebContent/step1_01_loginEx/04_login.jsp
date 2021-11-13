<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04_login.jsp</title>
</head>
<body>
	<div align="center">
	<h1>로그인</h1>
	<p>입사지원을 위해서는 로그인이 필요합니다.</p>
	<hr>
		<form action="join92.do" method="post">
			<p><label><input type="text" name="id" autofocus></label></p>
			<p><label><input type="password" name="pw" autofocus></label></p>
			<input type=submit value="로그인">
		</form>
	</div>
</body>
</html>