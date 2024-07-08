## Forward 와 Redirect 기본 개념
Forward 메서드는 웹 애플리케이션의 한 서블릿에서 다른 리소스로 요청을 전달하며, 이 리소스는 다른 서블릿, JSP 페이지 또는 HTML 파일이 될 수 있습니다. 
브라우저로 요청을 전달을 하는 것이 아니라 서버 내의 다른 리소스를 호출합니다.

Redirect 메서드는 요청을 브라우저로 전달하여 다른 웹 애플리케이션을 요청합니다. Redirect는 같은 URL을 호출하더라도 request에 있는 정보를 사용하지 않고 새롭게 요청합니다.

### Forward
![image](https://github.com/dudrnrduddj/OrdinaryWeb/assets/128364199/3da7e14a-c61d-44b1-a59a-eb22f95c00a4)

Forward는 요청 정보를 WAS 내에서 다른 리소스로 전달합니다. 
요청 정보를 함께 전달하여 다른 리소스에서 이를 처리할 수 있습니다. 
페이지 이동이 없이 WAS 내부에서 다른 리소스를 호출하기에 속도가 Redirect보다 빠릅니다. 
내부에서 forward 하기 때문에 최초 요청한 URL이 변경되지 않습니다.

```
@WebServlet("/myView.do")
public class MyViewServlet extends HttpServlet {
    ...
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
                   throws ServletException, IOException {
        String url = "myViewPage.jsp";  // forward할 url
        
        // 사용자 처리
        
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }
    ...
}
```
브라우저에서 myView.do로 WAS에 요청을 하면, 해당 요청을 처리하는 MyViewServlet에서 사용자 요청을 처리하고 그 처리 결과를 보여주는 페이지로 forward 하여 추가 request 없이 처리 결과 페이지를 전송합니다.


### Redirect
![image](https://github.com/dudrnrduddj/OrdinaryWeb/assets/128364199/ae051ea6-fe19-419a-a527-7a42f110a839)

Redirect는 요청을 Web Browser에게 전달하여 새로 요청하게 만듭니다. 덕분에 forward와 달리 WAS 서버와 Web Browser 간에 두 번의 통신이 일어나게 되어 forward보다 속도가 느립니다. 그리고 새로운 URL로 요청하기 때문에 request 정보가 기본적으로 전달되지 않습니다. 그러나 forward와 달리 아래처럼 외부에 있는 다른 서버나 혹은 같은 서버에서도 콘텍스트가 다른 URL에 요청을 redirect 할 수 있습니다.



![image](https://github.com/dudrnrduddj/OrdinaryWeb/assets/128364199/cef4f969-1757-45b5-a3c3-4f03b67f3d8d)

조금 더 Redirect 과정을 상세히 들여다보면 Web Browser에서 WAS로 check.jsp를 요청합니다.
처리 결과에 따라서 응답으로 main.jsp로 Redirect 하라고 Response를 보냅니다.
그러면 HTTP 응답 코드 302를 받은 Web Browser는 함께 받은 Location인 main.jsp를 다시 요청합니다.
마지막으로 요청을 받은 서버에서 main.jsp를 Response로 결과를 돌려보냅니다.



## 추가 정리 (forward 와 sendRedirect)
### 1. forward
  #### 1) forward란?
  forward()는 위에서 말한 RequestDispatcher 인터페이스의 역할을 수행하는 메서드다.
  forward()은 사용자 요청에 의해 컨테이너에서 생성된 request와 response를 다른 리소스(서블릿, jsp, html)로 넘겨주는 역할을 한다.

  #### 2) http 와 RequestDispatcher
  흔히 우리가 사용하는 웹서비스의 프로토콜인 HTTP 방식은 클라이언트가 요청(request)하고 서버가 응답(response)를 하면 한 번의 과정이 끝나게 된다.
  그리고 이러한 Http 방식을 통해 데이터를 주고 받은 하나의 단위를 트랜잭션이라 한다.

  위에서 말한대로 Http 프로토콜은 요청과 응답으로 이뤄지고 응답이 이뤄지면서 통신이 끝난다.
  여기서 중요한 점은 request는 응답 전까지 계속 여러번 사용할 수 있다는 점이다.
  서블릿은 클라이언트의 요청인 request 객체를 response하기 전까지 여러 서블릿에서 계속 돌려쓸 수 있다.

  따라서 response로 응답하여 통신이 끝나기 전까진 request 객체를 이리저리 옮겨가며 쓸 수 있다는 것이다.

### 2. sendRedirect
  #### 1) sendRedirect란?
  sendRedirect("URL") 메서드를 사용하면 서버가 request에 대해 response하고 난 뒤 메서드에 입력된 경로로 이동한다는 뜻이다.

### 3. forward VS sendRedirect
  forward와 차이점은 sendRedirect()를 쓰면 클라이언트와 서버 간 통신이 끝난다는 것이다.
  RequestDispatcher객체의 forward는 일부러 response하지 않고 응답을 끌면서 다른 리소스로 전달한다.
  반면 response객체의 sendRedirect()는 응답을 끝내는 역할을 한다.
