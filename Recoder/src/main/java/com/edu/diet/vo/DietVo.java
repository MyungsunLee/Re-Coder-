package com.edu.diet.vo;

public class DietVo {

	private int dietNo;
	private int dietCal;
	private String dietName;
	private String dietType;
	
	
	public DietVo() {
		super();
	}

	public DietVo(int dietNo, int dietCal, String dietName, String dietType) {
		super();
		this.dietNo = dietNo;
		this.dietCal = dietCal;
		this.dietName = dietName;
		this.dietType = dietType;
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

	public String getDietType() {
		return dietType;
	}

	public void setDietType(String dietType) {
		this.dietType = dietType;
	}
	
	
	
}
