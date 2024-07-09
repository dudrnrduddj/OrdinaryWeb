<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>마이페이지</title>
	</head>
	<body>
		<h1>마이페이지</h1>
		<form action="/member/update.do" method="post">
			<!-- requestScope의 member는 Member의 인스턴스를 가리키므로 필드로 접근이 가능(private도 가능) -->
			<input type="hidden" name="memberId" value="${requestScope.member.memberId }">
			아이디 : <span>${requestScope.member.memberId }</span> <br>
			<!-- 비밀번호 : <input type="password" value=""> -->
			이름 : <span>${requestScope.member.memberName }</span> <br>
			성별 : <span>${requestScope.member.memberGender }</span> <br>
			나이 : <span>${requestScope.member.memberAge }</span> <br>
			이메일 : <input type="text" name="email" value="${requestScope.member.memberEmail }"> <br>
			전화번호 : <input type="text" name="phone" value="${requestScope.member.memberPhone }"> <br>
			주소 : <input type="text" name="address" value="${requestScope.member.memberAddress }"> <br>
			<!-- 필드명으로도 접근이 가능하지만 getter를 써도 됨. -->
			취미 : <input type="text" name="hobby" value="${requestScope.member.getMemberHobby() }"> <br>
			가입일자 : <span>${requestScope.member.memberRegDate }</span> <br>
			<input type="submit" value="수정">
		</form>
	</body>
</html>