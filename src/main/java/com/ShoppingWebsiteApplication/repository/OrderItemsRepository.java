package com.ShoppingWebsiteApplication.repository;

import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.OrderItems;

import java.util.HashMap;
import java.util.List;

public interface OrderItemsRepository {
    void createOrderItems(OrderItems orderItems);

    void createOrderItem(OrderItems orderItems);

    void deleteOrderItemsById(Long orderItemsId);

    void deleteOrderItemsById(Long orderId, Long ItemsId);

    void deleteOrderItemsByOrderId(Long orderId);

    void deleteOrderItemsByUserName(Long orderId);

    void deleteUser(String userName);

    void updateOrderItemQuantity(Long orderId, Long ItemsId);

    void decOrderItemQuantity(Long orderId, Long ItemsId);

    Long quantity(Long orderId, Long itemId);

    Long numberOfOrderItemsInOrder(Long orderId);

    Long getOrderItemQuantity(String userName, Long itemId);

    Long getOrderItemQuantityById(Long orderId, Long itemId);

    Long getOrderItemQuantityTry(Long orderId, Long itemId);

    List<Long> getAllOrderItems(Long orderId);

    List<OrderItems> getAllOrdersItems();

    List<Long> getAllOrderIds();

    List<HashMap<Long, Item>> getAllTry(Long orderId);


}
