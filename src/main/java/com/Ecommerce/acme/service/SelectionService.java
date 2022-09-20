package com.Ecommerce.acme.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Ecommerce.acme.model.Selection;
import com.Ecommerce.acme.repository.SelectionRepository;
import lombok.Data;

@Data
@Service
public class SelectionService {
	
	@Autowired
	private SelectionRepository ss;
	
	public Optional<Selection> getSelection(final int id){
		return ss.findById(id);
	}

	public Iterable<Selection> getAllSelection() {
		
			return ss.findAll();
		
	}

	public void deleteSelection(final int id) {
		ss.deleteById(id);
	}
	
	public void insertSelection(Selection Selection) {
		ss.save(Selection);
	}
	
	
}
