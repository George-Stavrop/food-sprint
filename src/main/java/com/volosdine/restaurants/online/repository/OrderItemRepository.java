package com.volosdine.restaurants.online.repository;

import com.volosdine.restaurants.online.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
