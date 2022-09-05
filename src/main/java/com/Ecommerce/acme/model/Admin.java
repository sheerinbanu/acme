package com.Ecommerce.acme.model;

import javax.persistence.Entity;
import javax.persistence.Table;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name= "admin")
@Data
@EqualsAndHashCode(callSuper=false)
public class Admin extends Utilisateur{
	
	private int idAdmin;
	


}
