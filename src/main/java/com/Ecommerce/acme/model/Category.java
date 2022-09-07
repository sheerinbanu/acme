package com.Ecommerce.acme.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name= "category")
@Data
public class Category {
	
	@Id
	private int idCategory;
	
	private String name;
	

}
