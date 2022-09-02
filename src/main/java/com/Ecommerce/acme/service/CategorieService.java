package com.Ecommerce.acme.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.acme.model.Categorie;
import com.Ecommerce.acme.repository.CategorieRepository;

import lombok.Data;

@Data
@Service
public class CategorieService {
	
	@Autowired
	private CategorieRepository cr;
	
	public Optional<Categorie> getAdmin(final int id){
		return cr.findById(id);
	}

	public Iterable<Categorie> getAllAdmin() {
		return cr.findAll();
	}

	public void deleteCategorie(final int id) {
		cr.deleteById(id);
	}
	
	public void insertCategorie(Categorie Categorie) {
		cr.save(Categorie);
	}
}