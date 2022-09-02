package com.Ecommerce.acme.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.acme.model.Commercial;
import com.Ecommerce.acme.repository.CommercialRepository;

import lombok.Data;

@Data
@Service
public class CommercialService {
	
	@Autowired
	private CommercialRepository cr;
	
	public Optional<Commercial> getCommercial(final int id){
		return cr.findById(id);
	}

	public Iterable<Commercial> getAllCommercial() {
		return cr.findAll();
	}

	public void deleteCommercial(final int id) {
		cr.deleteById(id);
	}
	
	public void insertCommercial(Commercial Commercial) {
		cr.save(Commercial);
	}
}