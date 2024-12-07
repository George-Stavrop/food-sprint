package com.volosdine.restaurants.online.repository;

import com.volosdine.restaurants.online.model.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface  UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String username);
}
