package com.edu.diet.vo;

public class DietVo {

	private int dietNo;
	private String dietType;
	private String dietName;
	private int dietCal;
	
	
	public DietVo() {
		super();
	}


	public DietVo(int dietNo, String dietType, String dietName, int dietCal) {
		super();
		this.dietNo = dietNo;
		this.dietType = dietType;
		this.dietName = dietName;
		this.dietCal = dietCal;
	}


	public int getDietNo() {
		return dietNo;
	}


	public void setDietNo(int dietNo) {
		this.dietNo = dietNo;
	}


	public String getDietType() {
		return dietType;
	}


	public void setDietType(String dietType) {
		this.dietType = dietType;
	}


	public String getDietName() {
		return dietName;
	}


	public void setDietName(String dietName) {
		this.dietName = dietName;
	}


	public int getDietCal() {
		return dietCal;
	}


	public void setDietCal(int dietCal) {
		this.dietCal = dietCal;
	}
	
}
