package com.glen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "bilance" )
public class Bilance {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private int id;
	
	@Column( name = "produkt_id", nullable = false )
	private int produktId;
	
	@Column( name = "transaction_id", nullable = false )
	private int transactionId;
	
	@Column( name = "bonus_code" )
	private int bonusCode;
	
	@Column( name = "midelman_fee_comision" )
	private double midelmanFeeComision;   // ne %
	
	@Column( name = "teardhura" )
	private double teardhura;
	
	@Column( name = "kosto" )
	private double kosto;
	
	@Column( name = "midelman_fee" )
	private double midelmanFee;   // ne vlere monetare
	
	
	

	public Bilance() {
		super();
	}

	

	public Bilance(int id, int produktId, int transactionId, int bonusCode, double midelmanFeeComision,
			double teardhura, double kosto, double midelmanFee) {
		super();
		this.id = id;
		this.produktId = produktId;
		this.transactionId = transactionId;
		this.bonusCode = bonusCode;
		this.midelmanFeeComision = midelmanFeeComision;
		this.teardhura = teardhura;
		this.kosto = kosto;
		this.midelmanFee = midelmanFee;
	}



	public int getTransactionId() {
		return transactionId;
	}



	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProduktId() {
		return produktId;
	}

	public void setProduktId(int produktId) {
		this.produktId = produktId;
	}

	public int getBonusCode() {
		return bonusCode;
	}

	public void setBonusCode(int bonusCode) {
		this.bonusCode = bonusCode;
	}

	public double getMidelmanFeeComision() {
		return midelmanFeeComision;
	}

	public void setMidelmanFeeComision(double midelmanFeeComision) {
		this.midelmanFeeComision = midelmanFeeComision;
	}

	public double getTeardhura() {
		return teardhura;
	}

	public void setTeardhura(double teardhura) {
		this.teardhura = teardhura;
	}

	public double getKosto() {
		return kosto;
	}

	public void setKosto(double kosto) {
		this.kosto = kosto;
	}

	public double getMidelmanFee() {
		return midelmanFee;
	}

	public void setMidelmanFee(double midelmanFee) {
		this.midelmanFee = midelmanFee;
	}



	@Override
	public String toString() {
		return "Bilance [id=" + id + ", produktId=" + produktId + ", transactionId=" + transactionId + ", bonusCode="
				+ bonusCode + ", midelmanFeeComision=" + midelmanFeeComision + ", teardhura=" + teardhura + ", kosto="
				+ kosto + ", midelmanFee=" + midelmanFee + "]";
	}

	
	
	
	

}
