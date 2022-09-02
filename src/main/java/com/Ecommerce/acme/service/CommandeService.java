package com.Ecommerce.acme.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.acme.model.Commande;
import com.Ecommerce.acme.repository.CommandeRepository;

import lombok.Data;

@Data
@Service
public class CommandeService {
	
	@Autowired
	private CommandeRepository cr;
	
	public Optional<Commande> getCommande(final int id){
		return cr.findById(id);
	}

	public Iterable<Commande> getAllCommande() {
		return cr.findAll();
	}

	public void deleteCommande(final int id) {
		cr.deleteById(id);
	}
	
	public void insertCommande(Commande Commande) {
		cr.save(Commande);
	}
}
