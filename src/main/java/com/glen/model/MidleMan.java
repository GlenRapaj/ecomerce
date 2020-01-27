package com.glen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "midleman" )
public class MidleMan {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private int id;
	
	@Column( name = "full_name", nullable = false )
	private String fullName;  // emer i plote i bleresit
	
	@Column( name = "email", nullable = false )
	private String email;  
	
	@Column( name = "tel", nullable = false )
	private int tel; 
	
	@Column( name = "nrllog" )
	private float nrLlog; 
	
	@Column( name = "kodsigurie" )
	private  int cvv;
	
	@Column( name = "adresa", nullable = false )
	private String adres;

	public MidleMan(String fullName, String email, int tel, float nrLlog, int cvv, String adres) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.tel = tel;
		this.nrLlog = nrLlog;
		this.cvv = cvv;
		this.adres = adres;
	}

	public MidleMan() {
		super();
	}

	@Override
	public String toString() {
		return "MidleMan [fullName=" + fullName + ", email=" + email + ", tel=" + tel + ", nrLlog=" + nrLlog + ", cvv="
				+ cvv + ", adres=" + adres + "]";
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public float getNrLlog() {
		return nrLlog;
	}

	public void setNrLlog(float nrLlog) {
		this.nrLlog = nrLlog;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}
	
	
}
