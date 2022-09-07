package com.Ecommerce.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Ecommerce.acme.model.OrderHistory;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory,Integer> {

}
