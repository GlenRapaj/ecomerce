package com.glen.model;



import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	
	// @Column( name = "bonus_code", columnDefinition = "int", nullable = true )
	// private int bonusCode;
	
	@Column( name = "pagesa" )
	private double pagesa;  // si vlere numerike
	
	@Column( name = "valuta", nullable = false )
	private String valuta;
	
	@Column( name = "kodi_sigurise", columnDefinition = "int" )
	private int cvv;
	
	// @Column( name = "kod_produkti", nullable = false, columnDefinition = "int" )
	// private int kodProdukti;  // kod produkti te blere
	
	 @Column( name = "full_name", nullable = false )
	 private String fullName;  // emer i plote i bleresit
	
	@Column( name = "data_blerjes_produktit", nullable = false )
	private Date dataBlerjesProduktit;  // data e blerjes se produktit
	
	@Column( name = "max_dat_dorezimi" )
	private Date maxDatDorezimi;       // max data e dorezimit se produktit
	
	@Column( name = "dorezuar" )
	private boolean dorezuar;
	
	@ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
	@JoinTable( name = "bleres_produkte",
			joinColumns = {
					@JoinColumn( name = "bleres_id", referencedColumnName = "id", nullable = false ),
			},
			inverseJoinColumns = { 
					@JoinColumn( referencedColumnName = "id", name = "produkt_id", nullable = false )
			})
	 @JsonIgnoreProperties("bleresit")
	private List<Produkte> produktet ;
	
	
	/*    */
	

	public Bleres() {
		super();
	}
	
	

public Bleres(int id, String email, int tel, String adresa, String qyteti, String shteti, float nrLlogarie,
			double pagesa, String valuta, int cvv, String fullName, Date dataBlerjesProduktit, Date maxDatDorezimi,
			boolean dorezuar ) {  // , List<Produkte> produktet
		super();
		this.id = id;
		this.email = email;
		this.tel = tel;
		this.adresa = adresa;
		this.qyteti = qyteti;
		this.shteti = shteti;
		this.nrLlogarie = nrLlogarie;
		this.pagesa = pagesa;
		this.valuta = valuta;
		this.cvv = cvv;
		this.fullName = fullName;
		this.dataBlerjesProduktit = dataBlerjesProduktit;
		this.maxDatDorezimi = maxDatDorezimi;
		this.dorezuar = dorezuar;
		// this.produktet = produktet;
	}



/*   */


	public int getId() {
		return id;
	}

	public List<Produkte> getProduktet() {
		return produktet;
	}


	public void setProduktet(List<Produkte> produktet) {
		this.produktet = produktet;
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


	@Override
	public String toString() {
		return "Bleres [id=" + id + ", email=" + email + ", tel=" + tel + ", adresa=" + adresa + ", qyteti=" + qyteti
				+ ", shteti=" + shteti + ", nrLlogarie=" + nrLlogarie + ", pagesa=" + pagesa + ", valuta=" + valuta
				+ ", cvv=" + cvv + ", fullName=" + fullName + ", dataBlerjesProduktit=" + dataBlerjesProduktit
				+ ", maxDatDorezimi=" + maxDatDorezimi + ", dorezuar=" + dorezuar + ", produktet=" + produktet + "]";
	}
	
	
	
	public void addAitem( Produkte produkte ) {
		produktet.add( produkte );
	} 
	 

}
