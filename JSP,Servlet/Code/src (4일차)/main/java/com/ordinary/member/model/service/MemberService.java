package com.ordinary.member.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ordinary.common.JDBCTemplate;
import com.ordinary.member.model.dao.MemberDAO;
import com.ordinary.member.model.vo.Member;

public class MemberService {

	private MemberDAO memberDAO;

	public MemberService() {
		this.memberDAO = new MemberDAO();
	}

	public int insertMember(Member member) {
		Connection conn = null;
		int result = 0;

		try {
			conn = JDBCTemplate.getConnection();
			result = memberDAO.insertMember(conn, member);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public Member checkLogin(Member member) {
		Connection conn = null;
		Member memberOne = null;

		try {
			conn = JDBCTemplate.getConnection();
			memberOne = memberDAO.checkLogin(conn, member);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return memberOne;
	}

	public int deleteMember(String memberId) {
		Connection conn = null;
		int result = 0;

		try {
			conn = JDBCTemplate.getConnection();
			result = memberDAO.deleteMember(memberId, conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public Member selectOneById(String memberId) {
		Connection conn = null;
		Member member = null;

		try {
			conn = JDBCTemplate.getConnection();
			member = memberDAO.selectOneById(memberId, conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return member;
	}

	public int updateMember(Member member) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = JDBCTemplate.getConnection();
			result = memberDAO.updateMember(member, conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
