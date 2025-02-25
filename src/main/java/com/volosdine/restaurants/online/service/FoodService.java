package com.volosdine.restaurants.online.service;

import com.volosdine.restaurants.online.model.Category;
import com.volosdine.restaurants.online.model.Food;
import com.volosdine.restaurants.online.model.Restaurant;
import com.volosdine.restaurants.online.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {

    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);

    void deleteFood(Long foodId) throws Exception;

    public List<Food> getRestaurantsFood(Long restaurantId,
                                          String foodCategory);

    public List<Food> searchFood(String keyword);

    public Food findFoodById(Long id) throws Exception;

    public Food updateAvailabilityStatus(Long foodId) throws Exception;
}
