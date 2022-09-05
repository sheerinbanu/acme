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
public class Commercial extends Utilisateur{
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCommercial;
	
	private int tauxMarge;

}
