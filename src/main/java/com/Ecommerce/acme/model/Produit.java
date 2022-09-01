package com.Ecommerce.acme.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Entity
@Table(name= "produit")
@Data
public class Produit {

	@Id
	private int idProduit;
	private String nom;
	private float prixVenteUnitaire;
	private String photo;
}
