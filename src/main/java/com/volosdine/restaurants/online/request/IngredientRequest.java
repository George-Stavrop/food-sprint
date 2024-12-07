package com.volosdine.restaurants.online.request;

import com.volosdine.restaurants.online.model.IngredientCategory;
import lombok.Data;

@Data
public class IngredientRequest {
    private Long restaurantId;
    private String name;
    private Long categoryId;
}
