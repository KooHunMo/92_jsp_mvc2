<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:choose>
		<c:when test="${isLogin = true}">
			<script>
				alert("${sessionScope.id}님 로그인을 환영합니다");
				location.href="main92.do";
			</script>
		</c:when>
		<c:otherwise>
			<script>
			alert("아이디와 패스워드를 정확히 입력해주세요");
			history.go(-1);
			</script>
		</c:otherwise>
	</c:choose>
	
</body>
</html>