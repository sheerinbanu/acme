package com.Ecommerce.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.Ecommerce.acme.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
