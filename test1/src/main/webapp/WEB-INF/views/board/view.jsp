<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보는 페이지</title>
</head>
<body>
	<a href="/board">목록으로</a>
	<h2>게시글 보기</h2>
	
	제목 : ${data.getTitle() }<br>
	작성자 : ${data.getWriter() }<br>
	내용 : ${data.getContent() }<br>
	
</body>
</html>