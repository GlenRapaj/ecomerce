package com.glen.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "produkte" )
public class Produkte {

	// shto   dhe cmimin
	   
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private int id;
	
	@Column( name = "masa", nullable = false )
	private String masa ;
	
	@Column( name = "sasia_disponueshme", nullable = false )
	private int sasiaDisponueshme ;
	
	@Column( name = "gjinia", nullable = false )
	private String gjinia ;
	
	@Column( name = "perberja", nullable = false )
	 private String perberja ;
	
	@Column( name = "pershkrim_produkti", nullable = false )
	 private String pershkrimProdukti ;
	 
	@Column( name = "sezoni", nullable = false )
	 private String sezoni ;
	 
	@Column( name = "bonus_code" )
	 private int bonusCode;
	
	@Column( name = "kategoria_produktit", nullable = false )
	 private String kategoriaProduktit ;
	
	@Column( name = "ngjyra" )
	 private String ngjyra;
	
	@Column( name = "tipi_produktit")
	 private String tipiProduktit;  // ngushta gjera shkurtra gjera
	
	private double kostoProduktit ;
	
	private int sasiablere ;
	
	@Column( name = "emer_produkti", nullable = false )
	private String emerProdukti ;
	
	@Column( name = "cmimi" )
	private double cmimi;
	
	// e shtuar
	@OneToMany( mappedBy = "productId", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private List<Paths> path ;
	
	












	public Produkte(int id, String masa, int sasiaDisponueshme, String gjinia, String perberja,
			String pershkrimProdukti, String sezoni, int bonusCode, String kategoriaProduktit, String ngjyra,
			String tipiProduktit, double kostoProduktit, int sasiablere, String emerProdukti, double cmimi,
			List<Paths> path) {
		super();
		this.id = id;
		this.masa = masa;
		this.sasiaDisponueshme = sasiaDisponueshme;
		this.gjinia = gjinia;
		this.perberja = perberja;
		this.pershkrimProdukti = pershkrimProdukti;
		this.sezoni = sezoni;
		this.bonusCode = bonusCode;
		this.kategoriaProduktit = kategoriaProduktit;
		this.ngjyra = ngjyra;
		this.tipiProduktit = tipiProduktit;
		this.kostoProduktit = kostoProduktit;
		this.sasiablere = sasiablere;
		this.emerProdukti = emerProdukti;
		this.cmimi = cmimi;
		this.path = path;
	}





	public Produkte() {
		super();
	}





	public List<Paths> getPath() {
		return path;
	}





	public void setPath(List<Paths> path) {
		this.path = path;
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





	public double getKostoProduktit() {
		return kostoProduktit;
	}


	public void setKostoProduktit(double kostoProduktit) {
		this.kostoProduktit = kostoProduktit;
	}


	public int getSasiablere() {
		return sasiablere;
	}


	public void setSasiablere(int sasiablere) {
		this.sasiablere = sasiablere;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMasa() {
		return masa;
	}
	public void setMasa(String masa) {
		this.masa = masa;
	}
	public int getSasiaDisponueshme() {
		return sasiaDisponueshme;
	}
	public void setSasiaDisponueshme(int sasiaDisponueshme) {
		this.sasiaDisponueshme = sasiaDisponueshme;
	}
	public String getGjinia() {
		return gjinia;
	}
	public void setGjinia(String gjinia) {
		this.gjinia = gjinia;
	}
	public String getPerberja() {
		return perberja;
	}
	public void setPerberja(String perberja) {
		this.perberja = perberja;
	}
	public String getPershkrimProdukti() {
		return pershkrimProdukti;
	}
	public void setPershkrimProdukti(String pershkrimProdukti) {
		this.pershkrimProdukti = pershkrimProdukti;
	}
	public String getSezoni() {
		return sezoni;
	}
	public void setSezoni(String sezoni) {
		this.sezoni = sezoni;
	}
	public int getBonusCode() {
		return bonusCode;
	}
	public void setBonusCode(int bonusCode) {
		this.bonusCode = bonusCode;
	}
	public String getKategoriaProduktit() {
		return kategoriaProduktit;
	}
	public void setKategoriaProduktit(String kategoriaProduktit) {
		this.kategoriaProduktit = kategoriaProduktit;
	}
	public String getNgjyra() {
		return ngjyra;
	}
	public void setNgjyra(String ngjyra) {
		this.ngjyra = ngjyra;
	}
	public String getTipiProduktit() {
		return tipiProduktit;
	}
	public void setTipiProduktit(String tipiProduktit) {
		this.tipiProduktit = tipiProduktit;
	}





	@Override
	public String toString() {
		return "Produkte [id=" + id + ", masa=" + masa + ", sasiaDisponueshme=" + sasiaDisponueshme + ", gjinia="
				+ gjinia + ", perberja=" + perberja + ", pershkrimProdukti=" + pershkrimProdukti + ", sezoni=" + sezoni
				+ ", bonusCode=" + bonusCode + ", kategoriaProduktit=" + kategoriaProduktit + ", ngjyra=" + ngjyra
				+ ", tipiProduktit=" + tipiProduktit + ", kostoProduktit=" + kostoProduktit + ", sasiablere="
				+ sasiablere + ", emerProdukti=" + emerProdukti + ", cmimi=" + cmimi + ", path=" + path + "]";
	}





   
	 
	 

}
