package com.Ecommerce.acme.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.acme.model.Selectionner;
import com.Ecommerce.acme.repository.SelectionnerRepository;

import lombok.Data;

@Data
@Service
public class SelectionnerService {
	
	@Autowired
	private SelectionnerRepository sr;
	
	public Optional<Selectionner> getSelectionner(final int id){
		return sr.findById(id);
	}

	public Iterable<Selectionner> getAllSelectionner() {
		return sr.findAll();
	}

	public void deleteSelectionner(final int id) {
		sr.deleteById(id);
	}
	
	public void insertSelectionner(Selectionner Selectionner) {
		sr.save(Selectionner);
	}
}
