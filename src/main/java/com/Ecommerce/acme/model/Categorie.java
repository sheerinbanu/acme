package com.Ecommerce.acme.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name= "categorie")
@Data
public class Categorie {
	
	@Id
	private int idCategorie;
	private String nom;
	

}
