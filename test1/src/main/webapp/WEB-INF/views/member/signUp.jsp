<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id = "signFm" method ="post" action ="/signUp">
	<div class ="joinInput">
		<label>아이디</label>
		<input type ="text" name = "userId" placeholder = "아이디입력"> 
	</div>
	
	<div class ="joinInput">
		<label>비밀번호</label>
		<input type ="text" name = "userPw" placeholder = "비밀번호입력"> 
	</div>
	
	<div class ="joinInput">
		<label>연락처</label>
		<input type ="text" name = "userPn" placeholder = "연락처입력"> 
	</div>
	
	<div class ="joinInput">
		<label>생년월일</label>
		<input type ="text" name = "userBd" placeholder = "생년월일입력"> 
	</div>
	
	<button id = "joinBt">등록</button>
	</form>
</body>
</html>