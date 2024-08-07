<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>input</title>
</head>
<body>
	<h2>은행명과 통장 잔고를 입력하세요</h2>
	<form method="post" action="result">
	은행명 : <input type="text" name="bank"> <br>
	통장 잔액 : <input type="text" name="balance">원<br>
	
	<button>입력</button>
	
	</form>
</body>
</html>