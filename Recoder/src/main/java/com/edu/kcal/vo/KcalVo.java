package com.edu.kcal.vo;

import java.util.Date;

public class KcalVo {

	private int memberInfoNo;
	private char memberInfoGender;
	private float memberInfoHeight;	// 계산 후에 int로 
	private float memberInfoWeight; // 계산 후에 int로
	private int	memberInfoActivity;
	private int memberInfoCal;
	private Date memberInfoDate;
	
	
	public KcalVo() {
		super();
	}

	public KcalVo(int memberInfoNo, char memberInfoGender, float memberInfoHeight, float memberInfoWeight,
			int memberInfoActivity, int memberInfoCal, Date memberInfoDate) {
		super();
		this.memberInfoNo = memberInfoNo;
		this.memberInfoGender = memberInfoGender;
		this.memberInfoHeight = memberInfoHeight;
		this.memberInfoWeight = memberInfoWeight;
		this.memberInfoActivity = memberInfoActivity;
		this.memberInfoCal = memberInfoCal;
		this.memberInfoDate = memberInfoDate;
	}

	
	public int getMemberInfoNo() {
		return memberInfoNo;
	}

	public void setMemberInfoNo(int memberInfoNo) {
		this.memberInfoNo = memberInfoNo;
	}

	public char getMemberInfoGender() {
		return memberInfoGender;
	}

	public void setMemberInfoGender(char memberInfoGender) {
		this.memberInfoGender = memberInfoGender;
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
