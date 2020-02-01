package com.glen.model;

public class FullPayment {
	
	private String valuta;
	
	private double pagesa;

	public FullPayment(String valuta, double pagesa) {
		super();
		this.valuta = valuta;
		this.pagesa = pagesa;
	}

	public FullPayment() {
		super();
	}

	public String getValuta() {
		return valuta;
	}

	public void setValuta(String valuta) {
		this.valuta = valuta;
	}

	public double getPagesa() {
		return pagesa;
	}

	public void setPagesa(double pagesa) {
		this.pagesa = pagesa;
	}

	@Override
	public String toString() {
		return "FullPayment [valuta=" + valuta + ", pagesa=" + pagesa + "]";
	} 
	
	

}
