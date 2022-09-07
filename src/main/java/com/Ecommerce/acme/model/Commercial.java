package com.Ecommerce.acme.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name= "commercial")
@Data
@EqualsAndHashCode(callSuper=false)
public class Commercial extends User{
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_commercial;
	private int margin_rate;

}
