package com.ShoppingWebsiteApplication.repository;

import com.ShoppingWebsiteApplication.model.Order;
import com.ShoppingWebsiteApplication.model.OrderStatus;

import java.util.List;

public interface OrderRepository {

//    void createOrder( Order order);
Long createOrder( Order order);

    Order getOrderById( Long orderId);
//    Order getOrderBy(Long orderId);
//    String getOrder(Long orderId);


    OrderStatus getOrderStatusById(Long orderId);

    void deleteOrderById(Long orderId);
    void deleteOrderByUserName(String userName);


    void updateOrderShippingAddress( Long orderId , Order order);
    String geUserNameById(Long orderId);
    void updateOrderStatus( Long orderId);

    void updateTotalPrice(Long orderId, Order order);

    List<Order> getAllOrders();

    List<Long> getAllOrdersId();

    List<Long> getAllOrdersByUserName(String userName);

    List<Long> getAllTempOrdersByUserName(String userName);

    Long tempOrderByUserName(String userName);
    Long lastOrder();
}
