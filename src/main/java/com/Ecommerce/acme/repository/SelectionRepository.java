package com.Ecommerce.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Ecommerce.acme.model.Selection;
import com.Ecommerce.acme.model.User;

public interface SelectionRepository extends JpaRepository<Selection, Integer> {
	
}
