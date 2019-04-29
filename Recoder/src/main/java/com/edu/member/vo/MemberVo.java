package com.edu.member.vo;

import java.util.Date;

public class MemberVo {

	private int memberNo;
	private char memberAuth;
	private String memberEmail;
	private String memberName;
	private Date memberCreDate;
	private String memberPassword;
	
	
	
	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public MemberVo() {
		super();
	}

	public MemberVo(int memberNo, char memberAuth, String memberEmail, String memberName, Date memberCreDate) {
		super();
		this.memberNo = memberNo;
		this.memberAuth = memberAuth;
		this.memberEmail = memberEmail;
		this.memberName = memberName;
		this.memberCreDate = memberCreDate;
	}

	
	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public char getMemberAuth() {
		return memberAuth;
	}

	public void setMemberAuth(char memberAuth) {
		this.memberAuth = memberAuth;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Date getMemberCreDate() {
		return memberCreDate;
	}

	public void setMemberCreDate(Date memberCreDate) {
		this.memberCreDate = memberCreDate;
	}
	
	
	
}
