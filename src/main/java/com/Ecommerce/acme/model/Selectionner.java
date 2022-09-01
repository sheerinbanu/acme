package com.Ecommerce.acme.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Selectionner {

	@EmbeddedId
	private SelectionnerId selectionnerId;
}

