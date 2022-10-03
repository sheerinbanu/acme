package com.Ecommerce.acme.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name= "selection")
@Data
public class Selection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_selection;
	private int quantity;
	private int size;
	private double margin_price;
	private double total;
	private int id_user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_product", referencedColumnName= "id_product", insertable = true, updatable = true)
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cart", referencedColumnName= "id_cart", insertable = true, updatable = true)
	private Cart cart;

	
	
}