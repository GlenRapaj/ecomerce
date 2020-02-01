package com.glen.model;

public class MostSellingProductCategory {
	
	 private String kategoria_produktit ;
		private String emer_produkti ;
		private double pagesa;
		
		
		public MostSellingProductCategory(String kategoriaProduktit, String emerProdukti, double cmimi) {
			super();
			this.kategoria_produktit = kategoriaProduktit;
			this.emer_produkti = emerProdukti;
			this.pagesa = cmimi;
		}
		
		public MostSellingProductCategory() {
			super();
		}
		
		public String getKategoriaProduktit() {
			return kategoria_produktit;
		}
		public void setKategoriaProduktit(String kategoriaProduktit) {
			this.kategoria_produktit = kategoriaProduktit;
		}
		public String getEmerProdukti() {
			return emer_produkti;
		}
		public void setEmerProdukti(String emerProdukti) {
			this.emer_produkti = emerProdukti;
		}
		public double getCmimi() {
			return pagesa;
		}
		public void setCmimi(double cmimi) {
			this.pagesa = cmimi;
		}
		
		@Override
		public String toString() {
			return "MostSellingProductCategory [kategoriaProduktit=" + kategoria_produktit + ", emerProdukti="
					+ emer_produkti + ", cmimi=" + pagesa + "]";
		}
		
		

}
