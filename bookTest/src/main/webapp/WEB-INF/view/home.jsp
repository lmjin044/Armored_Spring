<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp</title>
</head>
<body>
	<h2>개인 정보 입력</h2>
	
	<form method="get" action = "/infoInput">
		<!-- 만약 Controller 페이지에서 get 방식으로 이미 /home으로 지정했으면 중복임 -->
	이름 : <input type="text" name="uName"> <br>
	생년월일 : <input type="text" name ="uBirth"><br>
	<button>입력</button>
	
	</form>
</body>
</html>