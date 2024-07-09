package com.ordinary.member.controller;

import java.io.IOException;
import java.net.http.HttpRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ordinary.member.model.service.MemberService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/member/remove.do")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// String query = "DELETE FROM MEMBER_TBL WHERE MEMBER_ID = (sessionScoper.memberId)";
		String memberId = request.getParameter("memberId");
		MemberService mService = new MemberService();
		int result = mService.deleteMember(memberId);
		if(result > 0) {
//			//로그아웃 후 메인으로 이동
//			// 1. 세션을 가져온 후
//			HttpSession session = request.getSession();
//			// 2. 세션을 파괴하고
//			if(session != null) {
//				session.invalidate();
//			}
//			// 3. 메인으로 페이지 이동
//			response.sendRedirect("/");
			
			// 위의 코드는 이미 LogoutServlet에서 구현했기 때문에!!!
			response.sendRedirect("/member/logout.do");
			// 이렇게 url을 이용해 servlet을 동작시키자!
			
			
		}else {
			// 실패 시 에러페이지 이동
			request.setAttribute("msg", "회원탈퇴 실패");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp");
			view.forward(request, response);
			
		}
		
	}

}
