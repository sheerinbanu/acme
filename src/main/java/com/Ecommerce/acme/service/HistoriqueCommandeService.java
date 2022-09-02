package com.Ecommerce.acme.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.acme.model.HistoriqueCommande;
import com.Ecommerce.acme.repository.HistoriqueCommandeRepository;

import lombok.Data;

@Data
@Service
public class HistoriqueCommandeService {
	
	@Autowired
	private HistoriqueCommandeRepository hcr;
	
	public Optional<HistoriqueCommande> getHistoriqueCommande(final int id){
		return hcr.findById(id);
	}

	public Iterable<HistoriqueCommande> getAllHistoriqueCommande() {
		return hcr.findAll();
	}

	public void deleteHistoriqueCommande(final int id) {
		hcr.deleteById(id);
	}
	
	public void insertHistoriqueCommande(HistoriqueCommande HistoriqueCommande) {
		hcr.save(HistoriqueCommande);
	}
}