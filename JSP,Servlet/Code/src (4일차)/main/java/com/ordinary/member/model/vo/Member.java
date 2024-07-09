package com.ordinary.member.model.vo;

import java.sql.Date;

public class Member {
	private String memberId;
	private String memberPw; 
	private String memberName;
	private String memberGender;
	private int memberAge;
	private String memberEmail;
	private String memberPhone;
	private String memberAddress;
	private String memberHobby;
	private Date memberRegDate;
	
	
	public Member(String memberId, String memberPw) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
	}
	public Member(String memberId, String memberPw, String memberName, String memberGender, int memberAge,
			String memberEmail, String memberPhone, String memberAddress, String memberHobby) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberGender = memberGender;
		this.memberAge = memberAge;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
		this.memberAddress = memberAddress;
		this.memberHobby = memberHobby;
	}
	public Member() {
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public int getMemberAge() {
		return memberAge;
	}
	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	public String getMemberHobby() {
		return memberHobby;
	}
	public void setMemberHobby(String memberHobby) {
		this.memberHobby = memberHobby;
	}
	public Date getMemberRegDate() {
		return memberRegDate;
	}
	public void setMemberRegDate(Date memberRegDate) {
		this.memberRegDate = memberRegDate;
	}
	
}
