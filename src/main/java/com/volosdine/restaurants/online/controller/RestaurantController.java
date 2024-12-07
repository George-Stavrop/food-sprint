package com.volosdine.restaurants.online.controller;

import com.volosdine.restaurants.online.dto.RestaurantDto;
import com.volosdine.restaurants.online.model.Restaurant;
import com.volosdine.restaurants.online.model.User;
import com.volosdine.restaurants.online.service.RestaurantService;
import com.volosdine.restaurants.online.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private UserService userService;

    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> searchRestaurant(
            @RequestHeader("Authorization") String jwt,
            @RequestParam String keyword
            ) throws Exception {

        User user = userService.findUserByJwtToken(jwt);

        List<Restaurant> restaurant = restaurantService.searchRestaurants(keyword);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Restaurant>> getAllRestaurants(
            @RequestHeader("Authorization") String jwt
    ) throws Exception {

        User user = userService.findUserByJwtToken(jwt);

        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> findRestaurantById(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    ) throws Exception
    {
        User user = userService.findUserByJwtToken(jwt);

        Restaurant restaurant = restaurantService.findRestaurantById(id);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PutMapping("/{id}/add-favorites")
    public ResponseEntity<RestaurantDto> addToFavorites(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    ) throws Exception
    {
        User user = userService.findUserByJwtToken(jwt);

        RestaurantDto restaurant = restaurantService.addToFavorites(id,user);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
}
