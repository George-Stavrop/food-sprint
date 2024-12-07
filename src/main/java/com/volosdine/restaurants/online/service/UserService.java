package com.volosdine.restaurants.online.service;

import com.volosdine.restaurants.online.model.User;

public interface UserService {

    public User findUserByJwtToken(String jwt) throws Exception;

    public User findUserByEmail(String email) throws Exception;
}
