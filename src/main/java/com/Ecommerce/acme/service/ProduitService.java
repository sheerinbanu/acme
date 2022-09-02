package com.Ecommerce.acme.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.acme.model.Produit;
import com.Ecommerce.acme.repository.ProduitRepository;

import lombok.Data;

@Data
@Service
public class ProduitService {
	
	@Autowired
	private ProduitRepository pr;
	
	public Optional<Produit> getProduit(final int id){
		return pr.findById(id);
	}

	public Iterable<Produit> getAllProduit() {
		return pr.findAll();
	}

	public void deleteProduit(final int id) {
		pr.deleteById(id);
	}
	
	public void insertProduit(Produit Produit) {
		pr.save(Produit);
	}
}