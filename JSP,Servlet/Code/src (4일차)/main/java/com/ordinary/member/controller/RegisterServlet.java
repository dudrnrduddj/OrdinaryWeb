package com.ordinary.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ordinary.member.model.service.MemberService;
import com.ordinary.member.model.vo.Member;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/member/join.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이 방식은 url주소창에 주소를 그대로 적는 것과 같음 -> WEB-INF의 주소는 절대 접속 불가능
//		response.sendRedirect("/WEB-INF/views/member/register.jsp");
		// 아래와 같이 적어줘야 정상적으로 동작!
		request.getRequestDispatcher("/WEB-INF/views/member/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청에 대한 정보 인코딩
		request.setCharacterEncoding("UTF-8");
		
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		String memberName = request.getParameter("member-name");
		String memberGender = request.getParameter("member-gender");
		String memberAge = request.getParameter("member-age");
		String memberEmail = request.getParameter("member-email");
		String memberPhone = request.getParameter("member-phone");
		String memberAddress = request.getParameter("member-address");
		String memberHobby = request.getParameter("member-hobby");
	
		//회원가입 비즈니스 로직
		Member member = new Member(memberId, memberPw, memberName, memberGender, Integer.parseInt(memberAge), memberEmail, memberPhone, memberAddress, memberHobby);
		MemberService memberService = new MemberService();
		int result = memberService.insertMember(member);
		
		
		
		
		if(result > 0) {
			// 성공 메시지 출력
			// 1. redirect
			// response.sendRedirect("");
//			-> 단순한 페이지 이동 (완성된 페이지)
			// 2. requestDispatcher
			// request.setAttribute(string, object);
			// request.getRequestDispatcher("").forward(request, response);
//			-> 경우에 따라 다른 출력물을 보여주고싶을때 사용
//			-> 응답인데 왜 response가 아닌가? request객체의 정보를 사용해야 하므로..
//			
			
			response.sendRedirect("/index.jsp");
		}else {
			// 실패 메시지 출력
			request.setAttribute("msg", "회원가입 실패");
			request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp").forward(request, response);
		}
		
	}

}
