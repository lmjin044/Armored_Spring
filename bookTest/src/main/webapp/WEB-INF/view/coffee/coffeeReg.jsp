<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href = "/coffee/index">메뉴로 돌아가기</a>

	<h2>커피 메뉴 등록</h2>
	<form method="post" action="/coffee/coffeeReg">
		<div id="formWrap">
			<div class="inputField">
				<label for="itemName">메뉴명</label> 
				<input type="text" name="itemName">
			</div>
			<div class="inputField">
				<label for="price">가격</label> 
				<input type="number" name="price">원
			</div>
			<div class="inputField">
				<label for="deCaffein">디카페인 여부 : </label> 
				없음 = <input type="radio" name="deCaffein" value ="0" checked>
				있음 = <input type="radio" name="deCaffein" value ="1">
			</div>
		</div>
			
		<button>등록</button>
		
	
	
	</form>
</body>
</html>