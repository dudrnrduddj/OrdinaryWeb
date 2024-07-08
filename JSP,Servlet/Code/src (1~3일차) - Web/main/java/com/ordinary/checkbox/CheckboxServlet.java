package com.ordinary.checkbox;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckboxServlet
 */
@WebServlet("/CheckboxServlet")
public class CheckboxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckboxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String place = request.getParameter("place"); // name이 place인 값 하나를 가지고 옴 
		// 갖고오는 값이 여러개일 때
		String [] places = request.getParameterValues("place");
		String str = "";
		for(String p : places) {
			str += p + ", ";
		}
		// PrintWriter 스트림을 이용해 페이지 자체를 직접 작성해서 출력 시키는 법
		PrintWriter out = response.getWriter();
		// 글자 안깨지게 옵션 설정
		response.setContentType("text/html;charset=utf-8");
		out.println("<h1>관광지 선택 결과</h1>");
		out.println("<h2>" + str + "</h2>");
		
		// 페이지를 주소로 출력하는 법
//		response.sendRedirect("/checkbox/checkResult.html");
	}

	
}
