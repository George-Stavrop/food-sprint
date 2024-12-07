package com.volosdine.restaurants.online.service;

import com.volosdine.restaurants.online.model.Order;
import com.volosdine.restaurants.online.model.User;
import com.volosdine.restaurants.online.request.OrderRequest;

import java.util.List;

public interface OrderService {

    public Order createOrder(OrderRequest order, User user) throws Exception;

    public Order updateOrder(Long orderId, String orderStatus) throws Exception;

    public void cancelOrder(Long orderId) throws Exception;

    public List<Order> getUsersOrder(Long userId) throws Exception;

    public List<Order> getRestaurantsOrder(Long restaurantId, String oderStatus) throws Exception;

    public Order findOrderById(Long orderId) throws Exception;
}
