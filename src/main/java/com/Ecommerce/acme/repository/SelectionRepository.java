package com.Ecommerce.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Ecommerce.acme.model.Selection;

public interface SelectionRepository extends JpaRepository<Selection, Integer> {
	
}
