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

@Data
@Entity
@Table(name= "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_order;
	private String order_date;
	private boolean validate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cart", referencedColumnName= "id_cart", insertable = true, updatable = false)
	private Cart cart;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", referencedColumnName= "id_user", insertable = true, updatable = false)
	private User user;

}

