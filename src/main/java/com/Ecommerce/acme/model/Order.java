package com.Ecommerce.acme.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

	@Data
	@Entity
	@Table(name= "order")
	public class Order {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id_order;
		private Date order_date;
		
	}

