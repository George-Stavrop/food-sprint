package com.volosdine.restaurants.online.request;

import jakarta.persistence.ElementCollection;
import lombok.Data;

import java.util.List;

@Data
public class AddCartItemRequest {

    private Long foodId;
    private int quantity;

    @ElementCollection
    private List<String> ingredients;
}
