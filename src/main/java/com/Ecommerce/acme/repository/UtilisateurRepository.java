package com.Ecommerce.acme.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Ecommerce.acme.model.Utilisateur;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer>{

}
