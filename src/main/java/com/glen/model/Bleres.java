package com.glen.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "bleres" )
public class Bleres {


	// nje klas model per transaksionet
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private int id;
	
	@Column( name = "email" )
	private String email;  // e kontrrollon llojin e transaksionit dhe e ploteson ne back-end
	
	@Column( name = "tel", columnDefinition = "int" )
	private int tel; // e kontrrollon llojin e transaksionit dhe e ploteson ne back-end
	
	@Column( name = "adresa", nullable = false )
	private String adresa;
	
	@Column( name = "qyteti" )
	private String qyteti;
	
	@Column( name = "shteti" )
	private String shteti;
	
 	@Column( name = "nr_llogarie" )
	 private float nrLlogarie;
	
	@Column( name = "bonus_code", columnDefinition = "int", nullable = true )
	private int bonusCode;
	
	@Column( name = "pagesa" )
	private double pagesa;  // si vlere numerike
	
	@Column( name = "valuta", nullable = false )
	private String valuta;
	
	@Column( name = "kodi_sigurise", columnDefinition = "int" )
	private int cvv;
	
	@Column( name = "kod_produkti", nullable = false, columnDefinition = "int" )
	private int kodProdukti;  // kod produkti te blere
	
	 @Column( name = "full_name", nullable = false )
	 private String fullName;  // emer i plote i bleresit
	
	@Column( name = "data_blerjes_produktit", nullable = false )
	private Date dataBlerjesProduktit;  // data e blerjes se produktit
	
	@Column( name = "max_dat_dorezimi" )
	private Date maxDatDorezimi;       // max data e dorezimit se produktit
	
	@Column( name = "dorezuar" )
	private boolean dorezuar;
	/*    */
	public Bleres(int id, String email, int tel, String adresa, String qyteti, String shteti, float nrLlogarie,
			int bonusCode, double pagesa, String valuta, int cvv, int kodProdukti, String fullName,
			Date dataBlerjesProduktit, Date maxDatDorezimi, boolean dorezuar) {
		super();
		this.id = id;
		this.email = email;
		this.tel = tel;
		this.adresa = adresa;
		this.qyteti = qyteti;
		this.shteti = shteti;
		this.nrLlogarie = nrLlogarie;
		this.bonusCode = bonusCode;
		this.pagesa = pagesa;
		this.valuta = valuta;
		this.cvv = cvv;
		this.kodProdukti = kodProdukti;
		this.fullName = fullName;
		this.dataBlerjesProduktit = dataBlerjesProduktit;
		this.maxDatDorezimi = maxDatDorezimi;
		this.dorezuar = dorezuar;
	}

	public Bleres() {
		super();
	}
/*   */
	@Override
	public String toString() {
		return "Bleres [id=" + id + ", email=" + email + ", tel=" + tel + ", adresa=" + adresa + ", qyteti=" + qyteti
				+ ", shteti=" + shteti + ", nrLlogarie=" + nrLlogarie + ", bonusCode=" + bonusCode + ", pagesa="
				+ pagesa + ", valuta=" + valuta + ", cvv=" + cvv + ", kodProdukti=" + kodProdukti + ", fullName="
				+ fullName + ", dataBlerjesProduktit=" + dataBlerjesProduktit + ", maxDatDorezimi=" + maxDatDorezimi
				+ ", dorezuar=" + dorezuar + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getQyteti() {
		return qyteti;
	}

	public void setQyteti(String qyteti) {
		this.qyteti = qyteti;
	}

	public String getShteti() {
		return shteti;
	}

	public void setShteti(String shteti) {
		this.shteti = shteti;
	}
/*    */
	public float getNrLlogarie() {
		return nrLlogarie;
	}

	public void setNrLlogarie(float nrLlogarie) {
		this.nrLlogarie = nrLlogarie;
	}

	public int getBonusCode() {
		return bonusCode;
	}

	public void setBonusCode(int bonusCode) {
		this.bonusCode = bonusCode;
	}

	public double getPagesa() {
		return pagesa;
	}

	public void setPagesa(double pagesa) {
		this.pagesa = pagesa;
	}

	public String getValuta() {
		return valuta;
	}

	public void setValuta(String valuta) {
		this.valuta = valuta;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public int getKodProdukti() {
		return kodProdukti;
	}

	public void setKodProdukti(int kodProdukti) {
		this.kodProdukti = kodProdukti;
	}
/*   */
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDataBlerjesProduktit() {
		return dataBlerjesProduktit;
	}

	public void setDataBlerjesProduktit(Date dataBlerjesProduktit) {
		this.dataBlerjesProduktit = dataBlerjesProduktit;
	}

	public Date getMaxDatDorezimi() {
		return maxDatDorezimi;
	}

	public void setMaxDatDorezimi(Date maxDatDorezimi) {
		this.maxDatDorezimi = maxDatDorezimi;
	}

	public boolean isDorezuar() {
		return dorezuar;
	}

	public void setDorezuar(boolean dorezuar) {
		this.dorezuar = dorezuar;
	}
	
	
	
	
	 

}
