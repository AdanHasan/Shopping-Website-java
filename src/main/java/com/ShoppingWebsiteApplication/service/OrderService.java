package com.ShoppingWebsiteApplication.service;

import com.ShoppingWebsiteApplication.model.Order;


import java.util.List;

public interface OrderService {

    Long createOrder(Order order);

    Order getOrderById(Long orderId);

    void deleteOrderById(Long orderId);

    void deleteOrderByUserName(String userName);

    void updateOrderShippingAddress(Long orderId, Order order);

    void updateOrderStatus(Long orderId);

    List<Order> getAllOrders();

    List<Long> getAllOrdersByUserName(String userName);


}
