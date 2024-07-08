### jsp -> servlet으로 로그인되어 있는 아이디값 보내는 법
1. **a태그로 요청**
```
ex)
// 로그인 정보 session에 저장되어있음
<a href="/member/remove.do?memberId=${sessionScope.memberId} ">회원탈퇴</a>
```
**?key=value 형태로 쿼리스트링을 이용하여 키,값을 서버로 전송!!**


2. **form 태그로 요청**
```
ex)
<form action="/member/remove.do" method="get">
	<input type="hidden" name="memberId" value="${memberId }">
	<input type="submit" value="회원탈퇴">
</form> --%>
```
-----
### servlet -> jsp로 쿼리스트링 보내기
response로 url 이동을 할때도 만약 전달할 쿼리스트링이 필요하다면 ?key=value형태로 전달해주면 된다.
단, 위와의 차이점으로는 서블릿은 자바코드이므로 태그를 사용하는 것과 다른 형태로 
```
//ex)
response.sendRedirect("/member/mypage.do?memberId="+memberId);
```
와 같이 쿼리스트링을 추가해주자! (단, 오른쪽의 memberId는 코드 내부에서 미리 초기화한 변수)
