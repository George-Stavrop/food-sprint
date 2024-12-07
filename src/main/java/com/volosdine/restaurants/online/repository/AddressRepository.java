package com.volosdine.restaurants.online.repository;

import com.volosdine.restaurants.online.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
