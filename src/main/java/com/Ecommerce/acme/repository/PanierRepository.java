package com.Ecommerce.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.Ecommerce.acme.model.Panier;

public interface PanierRepository extends JpaRepository<Panier, Integer>{

}
