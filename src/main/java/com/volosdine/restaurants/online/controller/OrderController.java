package com.volosdine.restaurants.online.controller;

import com.volosdine.restaurants.online.model.Order;
import com.volosdine.restaurants.online.model.User;
import com.volosdine.restaurants.online.request.OrderRequest;
import com.volosdine.restaurants.online.response.PaymentResponse;
import com.volosdine.restaurants.online.service.OrderService;
import com.volosdine.restaurants.online.service.PaymentService;
import com.volosdine.restaurants.online.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private PaymentService paymentService;


    @PostMapping("/order")
    public ResponseEntity<PaymentResponse> createOrder(@RequestBody OrderRequest req,
                                                       @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
        Order order = orderService.createOrder(req, user);
        PaymentResponse paymentResponse = paymentService.createPaymentLink(order);
        return new ResponseEntity<>(paymentResponse, HttpStatus.OK);
    }


    @GetMapping("/order/user")
    public ResponseEntity<List<Order>> getOrderHistory(
                                             @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
        List<Order> orders = orderService.getUsersOrder(user.getId());
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }












}
