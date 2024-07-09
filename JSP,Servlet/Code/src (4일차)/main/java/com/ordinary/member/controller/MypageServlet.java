package com.ordinary.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ordinary.member.model.service.MemberService;
import com.ordinary.member.model.vo.Member;

/**
 * Servlet implementation class MypageServlet
 */
@WebServlet("/member/mypage.do")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String memberId = request.getParameter("memberId");
//			String query = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ?";
			Member member = new Member();
			MemberService mService = new MemberService();
			member = mService.selectOneById(memberId);
			if(member != null){
				// 마이페이지로 이동
				request.setAttribute("member", member);
				request.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp").forward(request, response);
			}else {
				// 에러페이지로 이동
				request.setAttribute("msg", "마이페이지로 이동 불가");
				request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			// request.getRequestDispatcher()는 RequestDispatcher 객체를 반환함을 볼 수 있음.
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp");
			// RequestDispatcher의 메소드로 forward()를 사용
			view.forward(request, response);
		}
		
	}

}
