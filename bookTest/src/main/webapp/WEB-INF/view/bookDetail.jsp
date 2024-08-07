<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookDetail.jsp</title>
</head>
<body>
	<a href="bookWrite">입력창으로</a>
	<h2>도서정보 출력 페이지</h2>
	책 제목 : ${data.getTitle() }<br>
	출판사 : ${data.getPublisher() }<br>
	
</body>
</html>