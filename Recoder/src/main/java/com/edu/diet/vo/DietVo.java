package com.edu.diet.vo;

public class DietVo {

	private int dietNo;
	private int dietCal;
	private String dietName;
	private String diteType;
	
	
	public DietVo() {
		super();
	}

	public DietVo(int dietNo, int dietCal, String dietName, String diteType) {
		super();
		this.dietNo = dietNo;
		this.dietCal = dietCal;
		this.dietName = dietName;
		this.diteType = diteType;
	}

	
	public int getDietNo() {
		return dietNo;
	}

	public void setDietNo(int dietNo) {
		this.dietNo = dietNo;
	}

	public int getDietCal() {
		return dietCal;
	}

	public void setDietCal(int dietCal) {
		this.dietCal = dietCal;
	}

	public String getDietName() {
		return dietName;
	}

	public void setDietName(String dietName) {
		this.dietName = dietName;
	}

	public String getDiteType() {
		return diteType;
	}

	public void setDiteType(String diteType) {
		this.diteType = diteType;
	}
	
	
	
}
