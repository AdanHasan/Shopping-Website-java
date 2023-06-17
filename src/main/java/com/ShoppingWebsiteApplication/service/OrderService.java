package com.ShoppingWebsiteApplication.service;

import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.Order;
//import com.ShoppingWebsiteApplication.model.UserOrderRequest;
//import com.ShoppingWebsiteApplication.model.UserOrderResponse;

import java.util.List;

public interface OrderService {

//    UserOrderResponse createOrder (UserOrderRequest userOrderRequest) throws Exception;

    Long createOrder (Order order ) ;

    Order getOrderById( Long orderId);

    void deleteOrderById( Long orderId);

    void updateOrder(Long orderId ,  Order order);

    List<Order> getAllOrders();

}
