package com.Ecommerce.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.acme.model.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Integer>{

}
