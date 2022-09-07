package com.Ecommerce.acme.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.acme.model.Compose;
import com.Ecommerce.acme.repository.ComposeRepository;

import lombok.Data;

@Data
@Service
public class ComposeService {
	
	@Autowired
	private ComposeRepository cr;
	
	public Optional<Compose> getCompose(final int id){
		return cr.findById(id);
	}

	public Iterable<Compose> getAllCompose() {
		return cr.findAll();
	}

	public void deleteCompose(final int id) {
		cr.deleteById(id);
	}
	
	public void insertCompose(Compose Compose) {
		cr.save(Compose);
	}
}
