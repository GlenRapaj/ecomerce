package com.glen.model;

public class MostSellingProductCategory {
	
	 private String kategoriaProduktit ;
		private String emerProdukti ;
		private double cmimi;
		
		
		public MostSellingProductCategory(String kategoriaProduktit, String emerProdukti, double cmimi) {
			super();
			this.kategoriaProduktit = kategoriaProduktit;
			this.emerProdukti = emerProdukti;
			this.cmimi = cmimi;
		}
		
		public MostSellingProductCategory() {
			super();
		}
		
		public String getKategoriaProduktit() {
			return kategoriaProduktit;
		}
		public void setKategoriaProduktit(String kategoriaProduktit) {
			this.kategoriaProduktit = kategoriaProduktit;
		}
		public String getEmerProdukti() {
			return emerProdukti;
		}
		public void setEmerProdukti(String emerProdukti) {
			this.emerProdukti = emerProdukti;
		}
		public double getCmimi() {
			return cmimi;
		}
		public void setCmimi(double cmimi) {
			this.cmimi = cmimi;
		}
		
		@Override
		public String toString() {
			return "MostSellingProductCategory [kategoriaProduktit=" + kategoriaProduktit + ", emerProdukti="
					+ emerProdukti + ", cmimi=" + cmimi + "]";
		}
		
		

}
