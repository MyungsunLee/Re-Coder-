package com.edu.memberInfo.vo;

import java.util.Date;

public class MemberInfoVo {

	private int memberNo;
	private char memberInfoGender;
	private int memberInfoAge;
	private double memberInfoHeight;	// 계산 후에 int로 
	private double memberInfoWeight; // 계산 후에 int로
	private int	memberInfoActivity;
	private int memberInfoCal;
	private Date memberInfoDate;

	public MemberInfoVo() {
		super();
	}

	public MemberInfoVo(int memberNo, char memberInfoGender, int memberInfoAge, double memberInfoHeight,
			double memberInfoWeight, int memberInfoActivity, int memberInfoCal, Date memberInfoDate) {
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

	public double getMemberInfoHeight() {
		return memberInfoHeight;
	}

	public void setMemberInfoHeight(double memberInfoHeight) {
		this.memberInfoHeight = memberInfoHeight;
	}

	public double getMemberInfoWeight() {
		return memberInfoWeight;
	}

	public void setMemberInfoWeight(double memberInfoWeight) {
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
