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
	private Double unit_price;
	private String name;
	private String description;
	private String picture;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_category", referencedColumnName= "id_category", insertable = true, updatable = true)
	private Category category;
	
}