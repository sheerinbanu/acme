package com.Ecommerce.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Ecommerce.acme.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
