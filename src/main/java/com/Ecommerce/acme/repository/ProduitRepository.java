package com.Ecommerce.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.acme.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer>{

}
