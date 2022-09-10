package com.Ecommerce.acme.repository;

import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Ecommerce.acme.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	Set<Role> findByName(String name);
}