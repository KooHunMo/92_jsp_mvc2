<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<c:if test="${id != null}">
			${id}님 로그인을 환영합니다<br><br>
			<a href="update92.do">입사지원정보 수정</a><br><br>
			<a href="logout92.do">로그아웃</a><br><br>
			<a href="delete92.do">회원탈퇴</a><br><br>
		</c:if>	
		<c:if test="${id = null }">
			<a href="join.do">회원가입</a><br><br>
			<a href="login.do">로그인</a><br><br>
		</c:if>
	</div>
	
	<hr><br>
	<div align="center">
		<a href="apply92.do" src="img/applyonline.png" alt="입사지원하기"></a>
	</div>
</body>
</html>