package com.glen.model;


public class RezultatBilanci {

	private double teardhura;
	
	private double kosto;
	
	private double midelmanFee;
	
	private String valuta ;

	public RezultatBilanci(double teardhura, double kosto, double midelmanFee, String valuta) {
		super();
		this.teardhura = teardhura;
		this.kosto = kosto;
		this.midelmanFee = midelmanFee;
		this.valuta = valuta;
	}

	public RezultatBilanci() {
		super();
	}


	@Override
	public String toString() {
		return "RezultatBilanci [teardhura=" + teardhura + ", kosto=" + kosto + ", midelmanFee=" + midelmanFee
				+ ", valuta=" + valuta + "]";
	}

	
	
	public String getValuta() {
		return valuta;
	}

	public void setValuta(String valuta) {
		this.valuta = valuta;
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
	
	
	
}
