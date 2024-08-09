<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>커피 상세 정보</title>
	<script
        src="https://code.jquery.com/jquery-3.7.1.js"
        integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous">
    </script>
<link rel="stylesheet" href="/css/info.css">
<script src="/javascript/info.js"></script>
<script>
	inputType=["text","number","radio"]
	inputName=["itemName","price","deCaffein"]

</script>
</head>
<body>
<form id="fm" method="get" action="/coffee/delete">
<input type="hidden" name ="id" value="${coffee.coffeeId }">
	<div id ="wrap">
		<a href="/coffee/index">HOME</a>
		<table id="viewBox">
		
			<tr>
				<td class="fieldName">메뉴명</td>
				<td class="value">${coffee.itemName }</td>
			</tr>
			<tr>
				<td class="fieldName">가격</td>
				<td class="value">
				
				<fmt:formatNumber value ="${coffee.price }" type="currency"/>
				
				</td>
			</tr>
			<tr>
				<td class="fieldName">카페인 유무</td>
				<td class="value">
					<c:choose>
						<c:when test="${coffee.deCaffein ==1 }">
							카페인 있음
						</c:when>
						<c:otherwise>
							카페인 없음
						</c:otherwise>
					</c:choose>
				</td>
			</tr>						
			<tr>
				<td colspan="2">
					<button type="button" id="modify">수정</button>
					<button type="button" id="delete">삭제</button>
				</td>
			</tr>
		</table>
	
	</div>
	
</form>	
</body>
</html>