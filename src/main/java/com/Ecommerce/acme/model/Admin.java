package com.Ecommerce.acme.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name= "admin")
@Data
@EqualsAndHashCode(callSuper=false)
public class Admin extends Utilisateur{
	@Id
	private int idAdmin;
	


}
