package com.ordinary.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ordinary.member.model.vo.Member;

public class MemberDAO {
	public int insertMember(Connection conn, Member member) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = "INSERT INTO MEMBER_TBL VALUES(?,?,?,?,?,?,?,?,?,SYSDATE)";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getMemberPw());
		pstmt.setString(3, member.getMemberName());
		pstmt.setString(4, member.getMemberGender());
		pstmt.setInt(5, member.getMemberAge());
		pstmt.setString(6, member.getMemberEmail());
		pstmt.setString(7, member.getMemberPhone());
		pstmt.setString(8, member.getMemberAddress());
		pstmt.setString(9, member.getMemberHobby());
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		
		return result;
	}

	public Member checkLogin(Connection conn, Member member) throws SQLException {
		Member mOne = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ? AND MEMBER_PW = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getMemberPw());
		
		rset = pstmt.executeQuery();
		
		if(rset.next()) {
			mOne = new Member();
			mOne.setMemberId(rset.getString("MEMBER_ID"));
			mOne.setMemberName(rset.getString("MEMBER_NAME"));
		}
		pstmt.close();
		rset.close();
		
		return mOne;
	}

	public int deleteMember(String memberId, Connection conn) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "DELETE FROM MEMBER_TBL WHERE MEMBER_ID = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, memberId);
		result = pstmt.executeUpdate();
		
		pstmt.close();
		
		return result;
	}

	public Member selectOneById(String memberId, Connection conn) throws SQLException {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		Member member = null;
		
		String query = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, memberId);
		
		rset = pstmt.executeQuery();
		
		if(rset.next()) {
			member = new Member();
			member.setMemberId(rset.getString("MEMBER_ID"));
			member.setMemberPw(rset.getString("MEMBER_PW"));
			member.setMemberName(rset.getString("MEMBER_NAME"));
			member.setMemberGender(rset.getString("GENDER"));
			member.setMemberAge(rset.getInt("AGE"));
			member.setMemberEmail(rset.getString("EMAIL"));
			member.setMemberPhone(rset.getString("PHONE"));
			member.setMemberAddress(rset.getString("ADDRESS"));
			member.setMemberHobby(rset.getString("HOBBY"));
			member.setMemberRegDate(rset.getDate("REG_DATE"));
		}
		
		pstmt.close();
		rset.close();
		
		
		return member;
	}

	public int updateMember(Member member, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query= "UPDATE MEMBER_TBL SET EMAIL = ?, PHONE = ?, ADDRESS = ?, HOBBY = ? WHERE MEMBER_ID = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberEmail());
		pstmt.setString(2, member.getMemberPhone());
		pstmt.setString(3, member.getMemberAddress());
		pstmt.setString(4, member.getMemberHobby());
		pstmt.setString(5, member.getMemberId());
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		
		return result;
	}
	
	
}
