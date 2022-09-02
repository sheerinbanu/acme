package com.Ecommerce.acme.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Entity
@Table(name= "produit")
@Data
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProduit;
	private String nom;
	private float prixVenteUnitaire;
	private String photo;
}
