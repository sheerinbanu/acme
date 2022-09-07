package com.Ecommerce.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Ecommerce.acme.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
