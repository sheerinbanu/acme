package com.Ecommerce.acme.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Embeddable
@AllArgsConstructor
public class ComposeId implements Serializable{
	
	private int id_product;
	private int id_cart;

	
		
	}
