package com.Ecommerce.acme.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Embeddable
@AllArgsConstructor
public class SelectionnerId implements Serializable{

	
	private int idProduit;
	private int idPanier;
	
		
	}
