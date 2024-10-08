package com.ShoppingWebsiteApplication.service;

import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.OrderItems;

import java.util.HashMap;
import java.util.List;

public interface OrderItemsService {

    void calculate(OrderItems orderItems);

    void calculateTry(Long orderId);

    void delt(Long itemId, Long orderId);

    void createOrderItems(OrderItems orderItems);

    void createOrderItem(OrderItems orderItems);

    void deleteOrderItemsById(Long orderItemsId);

    void deleteOrderItemsById(Long orderId, Long ItemsId);

    void deleteOrderItemsByOrderId(Long orderId);

    void deleteOrderItemsByUserName(Long orderId);

    void deleteUser(String userName);

    void updateOrderItemQuantity(Long orderId, Long ItemsId);

    void decOrderItemQuantity(Long orderId, Long ItemsId);

    List<Long> getAllOrderItems(Long orderId);

    List<OrderItems> getAllOrdersItems();

    List<Long> getAllOrderIds();

    List<HashMap<Long, Item>> getAllTry(Long orderId);

    Long quantity(Long orderId, Long itemId);

    Long getOrderItemQuantity(String userName, Long itemId);


}
