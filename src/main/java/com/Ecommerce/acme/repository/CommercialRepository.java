package com.Ecommerce.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Ecommerce.acme.model.Commercial;

@Repository
public interface CommercialRepository extends JpaRepository<Commercial, Integer>{

}
