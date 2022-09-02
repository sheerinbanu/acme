package com.Ecommerce.acme.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;



@Entity
@Table(name= "commercial")
@Data
@EqualsAndHashCode(callSuper=false)
public class Commercial extends Utilisateur{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCommercial;
	
	private int tauxMarge;

}
