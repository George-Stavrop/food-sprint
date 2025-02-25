package com.volosdine.restaurants.online.service;

import com.stripe.exception.StripeException;
import com.volosdine.restaurants.online.model.Order;
import com.volosdine.restaurants.online.response.PaymentResponse;

public interface PaymentService {

     PaymentResponse createPaymentLink(Order order) throws StripeException;
}
