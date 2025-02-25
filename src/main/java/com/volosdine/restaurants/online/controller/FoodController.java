package com.volosdine.restaurants.online.controller;

import com.volosdine.restaurants.online.model.Food;
import com.volosdine.restaurants.online.model.Restaurant;
import com.volosdine.restaurants.online.model.User;
import com.volosdine.restaurants.online.request.CreateFoodRequest;
import com.volosdine.restaurants.online.service.FoodService;
import com.volosdine.restaurants.online.service.RestaurantService;
import com.volosdine.restaurants.online.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/search")
    public ResponseEntity<List<Food>> searchFood(@RequestParam String name,
                                           @RequestHeader("Authorization") String jwt) throws  Exception {
        User user = userService.findUserByJwtToken(jwt);

        List<Food> food = foodService.searchFood(name);

        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }


    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Food>> getRestaurantFood(

            @RequestParam(required = false) String food_category,
            @PathVariable Long restaurantId,
            @RequestHeader("Authorization") String jwt) throws  Exception {

        User user = userService.findUserByJwtToken(jwt);

        List<Food> food = foodService.getRestaurantsFood(restaurantId,food_category);


        return new ResponseEntity<>(food, HttpStatus.OK);
    }
}
