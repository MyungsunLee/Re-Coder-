package com.edu.memberInfo.vo;

import java.util.Date;

public class MemberInfoVo {

	private int memberNo;
	private char memberInfoGender;
	private int memberInfoAge;
	private float memberInfoHeight;	// 계산 후에 int로 
	private float memberInfoWeight; // 계산 후에 int로
	private int	memberInfoActivity;
	private int memberInfoCal;
	private Date memberInfoDate;
	
	
	public MemberInfoVo() {
		super();
	}

	
	public MemberInfoVo(int memberNo, char memberInfoGender, int memberInfoAge, float memberInfoHeight,
			float memberInfoWeight, int memberInfoActivity, int memberInfoCal, Date memberInfoDate) {
		super();
		this.memberNo = memberNo;
		this.memberInfoGender = memberInfoGender;
		this.memberInfoAge = memberInfoAge;
		this.memberInfoHeight = memberInfoHeight;
		this.memberInfoWeight = memberInfoWeight;
		this.memberInfoActivity = memberInfoActivity;
		this.memberInfoCal = memberInfoCal;
		this.memberInfoDate = memberInfoDate;
	}


	public int getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}


	public char getMemberInfoGender() {
		return memberInfoGender;
	}


	public void setMemberInfoGender(char memberInfoGender) {
		this.memberInfoGender = memberInfoGender;
	}


	public int getMemberInfoAge() {
		return memberInfoAge;
	}


	public void setMemberInfoAge(int memberInfoAge) {
		this.memberInfoAge = memberInfoAge;
	}


	public float getMemberInfoHeight() {
		return memberInfoHeight;
	}


	public void setMemberInfoHeight(float memberInfoHeight) {
		this.memberInfoHeight = memberInfoHeight;
	}


	public float getMemberInfoWeight() {
		return memberInfoWeight;
	}


	public void setMemberInfoWeight(float memberInfoWeight) {
		this.memberInfoWeight = memberInfoWeight;
	}


	public int getMemberInfoActivity() {
		return memberInfoActivity;
	}


	public void setMemberInfoActivity(int memberInfoActivity) {
		this.memberInfoActivity = memberInfoActivity;
	}


	public int getMemberInfoCal() {
		return memberInfoCal;
	}


	public void setMemberInfoCal(int memberInfoCal) {
		this.memberInfoCal = memberInfoCal;
	}


	public Date getMemberInfoDate() {
		return memberInfoDate;
	}


	public void setMemberInfoDate(Date memberInfoDate) {
		this.memberInfoDate = memberInfoDate;
	}


	
	
}
