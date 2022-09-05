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
	@Table(name= "commande")
	public class Commande {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int idCommande;
		
		private Date dateCommande;
		
	}

