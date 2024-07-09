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
 * Servlet implementation class UpdateSerlvet
 */
@WebServlet("/member/update.do")
public class UpdateSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// UPDATE MEMBER_TBL SET EMAIL = ?, PHONE = ?, ADDRESS = ?, HOBBY = ? WHERE MEMBER_ID = ?
			//한글 깨지지 않아야 함.
			request.setCharacterEncoding("UTF-8");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String hobby = request.getParameter("hobby");
			String memberId = request.getParameter("memberId");
			Member member = new Member();
			member.setMemberEmail(email);
			member.setMemberPhone(phone);
			member.setMemberAddress(address);
			member.setMemberHobby(hobby);
			member.setMemberId(memberId);
			
			MemberService mService = new MemberService();
			int result = mService.updateMember(member);
			
			if(result > 0) {
				// 마이페이지로 가서 수정 확인
				// response를 써도 되는 이유가 응답을 해서 트랜잭션을 마무리 하고 마이페이지 서블릿을 불러 새로운 트랜잭션이 시작되기 때문이다.
				// 따라서 굳이 request를 쓸 필요가 없음.
				response.sendRedirect("/member/mypage.do?memberId="+memberId);
				
			}else {
				request.setAttribute("msg", "정보수정이 완료되지 않았습니다.");
				request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp").forward(request, response);
			}
			
			
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("WEB-INF/views/common/error/errorPage.jsp").forward(request, response);
				
		}
		
		
	}

}
