package com.Ecommerce.acme.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Embeddable
@AllArgsConstructor
public class HistoriqueCommandeId implements Serializable{

	private int idCommercial;
	private int idProduit;
	private int idCommande;
	
		
	}
