package com.glen.model;

public class BonusSellers {

	private int bonusCode ;
	private int numberOfSells ;
	
	public BonusSellers(int bonusCode, int numberOfSells) {
		super();
		this.bonusCode = bonusCode;
		this.numberOfSells = numberOfSells;
	}

	public BonusSellers() {
		super();
	}

	@Override
	public String toString() {
		return "BonusSellers [bonusCode=" + bonusCode + ", numberOfSells=" + numberOfSells + "]";
	}

	public int getBonusCode() {
		return bonusCode;
	}

	public void setBonusCode(int bonusCode) {
		this.bonusCode = bonusCode;
	}

	public int getNumberOfSells() {
		return numberOfSells;
	}

	public void setNumberOfSells(int numberOfSells) {
		this.numberOfSells = numberOfSells;
	}
	
	
	
}
