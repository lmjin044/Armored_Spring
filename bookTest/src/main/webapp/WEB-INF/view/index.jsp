<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관리</title>
<link rel="stylesheet" href="/css/default.css">

</head>
<body>

	

	<div id ="wrap">
		<h2>도서관리</h2>
	
		<div id="mainTitle">
			<h3>등록도서 목록</h3>
			<a href="/bookWrite" id="enroll">도서등록</a>
		</div>
		<div id ="bookListWrap">
			<ul id="bookList">
				<c:forEach var="row" items="${list }">
				<li class="blist">
					<span class="title">
						<a href ="/book/view?id=${row.bookId}"> ${row.bookTitle }</a>
					</span>
					<span class="auth">${row.bookAuthor }</span>
					<span class="bookCode">${row.bookId }</span>
					<span class="category">${row.publisher }</span>
				</li>
				</c:forEach>
				
				<li class="blist">
					<span class="title">자바의 기초</span>
					<span class="auth">김씨</span>
					<span class="bookCode">ㅈ78ㄱ258</span>
					<span class="category">전자공학</span>
				</li>
			</ul>
			
			<ul id="bookList">
				<li class="blist">
					<span class="title">자바의 중급</span>
					<span class="auth">이씨</span>
					<span class="bookCode">ㅈ78ㅇ862</span>
					<span class="category">전자공학</span>
				</li>
			</ul>
			
			<ul id="bookList">
				<li class="blist">
					<span class="title">자바의 상급</span>
					<span class="auth">박씨</span>
					<span class="bookCode">ㅈ78ㅂ239</span>
					<span class="category">전자공학</span>
				</li>
			</ul>
			
			<ul id="bookList">
				<li class="blist">
					<span class="title">자바의 심화</span>
					<span class="auth">최씨</span>
					<span class="bookCode">ㅈ78ㅊ156</span>
					<span class="category">전자공학</span>
				</li>
			</ul>
			
			<ul id="bookList">
				<li class="blist">
					<span class="title">자바의 고급</span>
					<span class="auth">정씨</span>
					<span class="bookCode">ㅈ78ㅈ182</span>
					<span class="category">전자공학</span>
				</li>
			</ul>															
			
			
			
		</div>
		
		
		
	</div>
</body>
</html>