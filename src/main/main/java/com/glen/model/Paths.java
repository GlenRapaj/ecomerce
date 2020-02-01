package com.glen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table( name = "paths" )
public class Paths {
	
	// Nje klase qe mban pathet e fotove te produkteve
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private  int id ;
	
	@Column( name = "path" )
	private String path;
	
	@Column( name = "alt" )
	private String alt;
	
	
  // @JsonIdentityInfo
	@ManyToOne  ()
	@JoinColumn( name = "product_id"  ) //  , nullable = false
	 @JsonBackReference // e shtuar 
	private  Produkte productId ;

	public Paths(int id, String path, Produkte productId, String alt) {
		super();
		this.id = id;
		this.path = path;
		this.productId = productId;
		this.alt = alt;
	}

	public Paths() {
		super();
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Produkte getProductId() {
		return productId;
	}

	public void setProductId(Produkte productId) {
		productId = productId;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	@Override
	public String toString() {
		return "Paths [id=" + id + ", path=" + path + ", alt=" + alt + ", productId=" + productId + "]";
	}
	
	
	

}
