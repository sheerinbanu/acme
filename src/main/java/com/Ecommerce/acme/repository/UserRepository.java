package com.Ecommerce.acme.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Ecommerce.acme.model.Role;
import com.Ecommerce.acme.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String username);
	List<User> findAllByRole(Role role);
    Optional<User> findById(int id);
    void deleteById(int id);
}
