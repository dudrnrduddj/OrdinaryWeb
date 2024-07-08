# request 객체의 지속성

request객체는 forward를 통해 통신이 끊기지 않는 한 여러 서블릿에서 지정한 속성에 접근할 수 있게 된다.

예를 들어

**첫 번째 서블릿:** 
```
// 속성 설정
request.setAttribute("username", "JohnDoe");
request.setAttribute("role", "admin");

// 다음 서블릿으로 포워드
RequestDispatcher dispatcher = request.getRequestDispatcher("secondServlet");
dispatcher.forward(request, response);
```

**두 번째 서블릿:**
```
// 첫 번째 서블릿에서 설정한 속성에 접근
String username = (String) request.getAttribute("username"); // "JohnDoe"
String role = (String) request.getAttribute("role"); // "admin"

// 새로운 속성 설정
request.setAttribute("loggedIn", true);

// 다음 서블릿으로 포워드
RequestDispatcher dispatcher = request.getRequestDispatcher("thirdServlet");
dispatcher.forward(request, response);
```

**세 번째 서블릿:**
```
// 첫 번째 및 두 번째 서블릿에서 설정한 속성에 접근
String username = (String) request.getAttribute("username"); // "JohnDoe"
String role = (String) request.getAttribute("role"); // "admin"
Boolean loggedIn = (Boolean) request.getAttribute("loggedIn"); // true
```

RequestDispatcher를 통해 Forward되는 동안 동일한 HttpServletRequest 객체가 사용되기 때문에 각 서블릿에서 설정한 속성들은 후속 서블릿에서도 계속 사용할 수 있다.

### 주의점!! (redirect를 쓰게 될 경우)
그러나 주의할 점은, 포워드가 아닌 response.sendRedirect()를 사용할 경우, 클라이언트에게 HTTP 응답이 전송되고 클라이언트는 새로운 요청을 보내게 된다. 
이 경우, 새로운 HttpServletRequest 객체가 생성되므로 이전 요청에서 설정된 속성들은 새로운 요청에서 사용할 수 없다.

따라서 포워드를 사용하여 여러 서블릿 간에 데이터를 공유하고자 한다면 RequestDispatcher.forward(request, response)를 사용하면 되고,  각 서블릿에서 설정된 속성들을 동일한 요청 객체를 통해 사용할 수 있다.


# 브라우저의 URL 변경
### 클라이언트 측에서의 URL 변경
: 사용자가 웹 페이지에서 <a> 태그나 <form> 태그를 사용하여 새로운 URL로 요청을 보낼 경우, 브라우저의 주소창은 새로운 URL로 변경된다. 
이때 변경된 URL이 요청의 첫 시작점이 된다.

### 서블릿에서의 forward
: 서버 측에서는 RequestDispatcher를 사용하여 다른 리소스로 요청을 전달할 수 있다(forward). 이 경우에는 클라이언트의 주소창은 초기 요청 시의 URL을 유지한다. 
서버 측에서의 forward는 내부적인 서버 리소스 간의 통신에 사용되며, 클라이언트에게 새로운 URL을 제공하지 않는다.

```
<a href="myServlet">Go to My Servlet</a>
//http://example.com/myServlet의 URL을 표시함

// myServlet 내부
RequestDispatcher dispatcher = request.getRequestDispatcher("/mypage.jsp");
dispatcher.forward(request, response);
//  클라이언트는 여전히 http://example.com/myServlet의 URL을 표시함
```
이동한 myPage.jsp에서 a, form 태그의 주소값으로 요청을 보내면 그 url로 변경이 된다.

하지만 서버 내에서의 forward를 통한 url 이동은 클라이언트 측에서 변경되지 않는 것이다.



