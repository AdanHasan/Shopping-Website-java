package com.ShoppingWebsiteApplication.service;

import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.Order;
import com.ShoppingWebsiteApplication.model.OrderItems;
//import com.ShoppingWebsiteApplication.model.UserOrderRequest;
//import com.ShoppingWebsiteApplication.model.UserOrderResponse;

import java.util.List;

public interface OrderService {

//    UserOrderResponse createOrder (UserOrderRequest userOrderRequest) throws Exception;

    Long createOrder (Order order ) ;

    Order getOrderById( Long orderId);

//    Order getOrderBy(Long orderId);
//    String getOrder(Long orderId);


    void deleteOrderById( Long orderId);
    void deleteOrderByUserName(String userName);

    void updateOrderShippingAddress(Long orderId ,  Order order);
    void updateOrderStatus( Long orderId);
    List<Order> getAllOrders();
//    OrderItems getOrderItems(Order order);

     List<Long> getAllOrdersByUserName(String userName);


}
