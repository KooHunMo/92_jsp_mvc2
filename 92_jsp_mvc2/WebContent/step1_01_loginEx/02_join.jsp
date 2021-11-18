<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02_join</title>
<script>

	function formValidationCheck(){ 
		<!-- DB에서 가져오는 것이 아닌 html 화면에서 가져오는 값은 getElementBy를 사용한다. --> 
		var id = document.getElementBy("id");
		if(id.value.length == 0){
			alert("아이디를 입력하세요");
			id.focus();
			return false;
		}
		
		var pw = document.getElementBy("pw");
		if(pw.value.length == 0){
			alert("비밀번호를 입력하세요");
			pw.focus();
			return false;
		}
		
		var name = document.getElementBy("name");
		if(name.value.length == 0){
			alert("이름을 입력하세요");
			name.focus();
			return false;
		}
		
		var tel = document.getElementBy("tel");
		if(tel.value.length == 0){
			alert("전화번호를 입력하세요");
			tel.focus();
			return false;
		}
		
		var email = document.getElementBy("email");
		if(email.value.length == 0){
			alert("이메일을 입력하세요");
			email.focus();
			return false;
		}
	}
	
</script>
</head>
<body>
	<div align="center">
		<h1>회원 가입</h1>
		<p>메가 아카데미를 찾아주셔서 감사합니다.</p>
		<hr>
		
		<form action="join92.do" method="post" onsubmit="return formValidationCheck()">
		
		<h4>로그인 정보</h4>
		<label for="id">아이디 : </label><input type="text" id="id" name="id" autofocus>
		<br><br>
		
		<label for="pw">비밀번호 : </label><input type="password" id="pw" name="pw">
		<br><br>
		
		<h4>개인 정보</h4>
		<label for="name">이름 : </label><input type="text" id="name" name="name" placeholder="공백없이 입력하세요">
		<br><br>
		<label for="contact">연락처 : </label><input type="text" id="tel" name="tel" placeholder="000-0000-0000">
		<br><br>
		<label for="email">이메일 : </label><input type="email" id="email" name="email">
		<br><br><br>
	</div>
	<div>
		<input type="submit" value="가입">
		<input type="reset" value="초기화">
	</div>
	</form>
</body>
</html>