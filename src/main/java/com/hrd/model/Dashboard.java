package com.hrd.model;

public class Dashboard {
	int total;
	int male;
	int female;
	
	public Dashboard() {
		super();
	}
	public Dashboard(int total, int male, int female) {
		super();
		this.total = total;
		this.male = male;
		this.female = female;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getMale() {
		return male;
	}
	public void setMale(int male) {
		this.male = male;
	}
	public int getFemale() {
		return female;
	}
	public void setFemale(int female) {
		this.female = female;
	}
	
}
