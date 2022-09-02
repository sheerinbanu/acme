package com.Ecommerce.acme.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.acme.model.Panier;
import com.Ecommerce.acme.repository.PanierRepository;

import lombok.Data;

@Data
@Service
public class PanierService {
	
	@Autowired
	private PanierRepository pr;
	
	public Optional<Panier> getPanier(final int id){
		return pr.findById(id);
	}

	public Iterable<Panier> getAllPanier() {
		return pr.findAll();
	}

	public void deletePanier(final int id) {
		pr.deleteById(id);
	}
	
	public void insertPanier(Panier Panier) {
		pr.save(Panier);
	}
}
