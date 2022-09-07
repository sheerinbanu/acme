package com.Ecommerce.acme.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.acme.model.Category;
import com.Ecommerce.acme.repository.CategoryRepository;

import lombok.Data;

@Data
@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository cr;
	
	public Optional<Category> getCategory(final int id){
		return cr.findById(id);
	}

	public Iterable<Category> getAllCategory() {
		return cr.findAll();
	}

	public void deleteCategory(final int id) {
		cr.deleteById(id);
	}
	
	public void insertCategory(Category Category) {
		cr.save(Category);
	}
}