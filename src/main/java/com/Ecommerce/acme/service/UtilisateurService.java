package com.Ecommerce.acme.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.acme.model.Utilisateur;
import com.Ecommerce.acme.repository.UtilisateurRepository;

import lombok.Data;

@Data
@Service
public class UtilisateurService {
	
	@Autowired
	private UtilisateurRepository ur;
	
	public Optional<Utilisateur> getUtilisateur(final int id){
		return ur.findById(id);
	}

	public Iterable<Utilisateur> getAllUtilisateur() {
		return ur.findAll();
	}

	public void deleteProduit(final int id) {
		ur.deleteById(id);
	}
	
	public void insertProduit(Utilisateur utilisateur) {
		ur.save(utilisateur);
	}
}