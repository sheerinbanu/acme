package com.Ecommerce.acme.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.data.annotation.Id;
import lombok.Data;

@Entity
@Table(name= "panier")
@Data
public class Panier {

	@Id
	private int idPanier;
	private int quantite;
	private int pointure;
	private float prixTotal;
}
