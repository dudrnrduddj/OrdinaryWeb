<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 이 안에 자바 코드를 쓸 수 있음 -->
<%    
   /*  String userName = (String)request.getAttribute("userName"); */
    String color = (String)request.getAttribute("color");
    String colorStyle = (String)request.getAttribute("colorStyle");
    String pet = (String)request.getAttribute("pet");
    String food = (String)request.getAttribute("foodStr");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인 취향 테스트</title>
</head>
<body>
	<h1>개인 취향 테스트 결과</h1>
	<p>
	<!-- requestScope + 마침표 표기법으로  String userName = (String)request.getAttribute("userName")을 대체하게 됨 -->
		이름? ${userName} <br>
		종아하는 색? <span style = "color : <%=colorStyle%>"><b>${color}</b></span> <br>
		좋아하는 동물은? <%= pet %><br>
		좋아하는 음식은? <%= food %><br>
	</p>
	
</body>
</html>