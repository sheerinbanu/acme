package com.Ecommerce.acme.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name= "cart")
@Data
public class Cart {

	@Id
	private int id_cart;
	private int quantity;
	private int size;
	private float total_price;
}
