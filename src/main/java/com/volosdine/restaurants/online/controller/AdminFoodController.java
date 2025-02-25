package com.volosdine.restaurants.online.controller;

import com.volosdine.restaurants.online.model.Food;
import com.volosdine.restaurants.online.model.Restaurant;
import com.volosdine.restaurants.online.model.User;
import com.volosdine.restaurants.online.request.CreateFoodRequest;
import com.volosdine.restaurants.online.response.MessageResponse;
import com.volosdine.restaurants.online.service.FoodService;
import com.volosdine.restaurants.online.service.RestaurantService;
import com.volosdine.restaurants.online.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/food")
public class AdminFoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<Food> createFood(@RequestBody CreateFoodRequest req,
                                           @RequestHeader("Authorization") String jwt) throws  Exception {
        User user = userService.findUserByJwtToken(jwt);
        Restaurant restaurant = restaurantService.getRestaurantByUserId(user.getId());
        Food food = foodService.createFood(req,req.getCategory(),restaurant);

        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<MessageResponse> deleteFood(@PathVariable Long id,
                                           @RequestHeader("Authorization") String jwt) throws  Exception {
        User user = userService.findUserByJwtToken(jwt);

       foodService.deleteFood(id);

        MessageResponse res = new MessageResponse();
        res.setMessage("food delete succesfully");

       return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Food> updateFoodAvailabilityStatus(@PathVariable Long id,
                                                                        @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);

        Food food = foodService.updateAvailabilityStatus(id);

        return new ResponseEntity<>(food, HttpStatus.OK);

    }
}
