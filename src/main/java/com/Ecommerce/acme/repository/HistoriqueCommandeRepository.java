package com.Ecommerce.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.acme.model.HistoriqueCommande;

public interface HistoriqueCommandeRepository extends JpaRepository<HistoriqueCommande,Integer> {

}
