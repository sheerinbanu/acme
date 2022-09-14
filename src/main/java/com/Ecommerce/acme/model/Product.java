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
@Table(name= "product")
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_product;
	private String name;
	private float unit_price;
	private String picture;
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_category", referencedColumnName= "id_category", insertable = true, updatable = true)
	//@Fetch(FetchMode.JOIN)
	private Category category;
}
