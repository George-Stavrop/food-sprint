package com.volosdine.restaurants.online.repository;

import com.volosdine.restaurants.online.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

    public Cart findByCustomerId(Long userId);
}
