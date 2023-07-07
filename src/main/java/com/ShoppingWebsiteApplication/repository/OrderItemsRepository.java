package com.ShoppingWebsiteApplication.repository;

import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.Order;
import com.ShoppingWebsiteApplication.model.OrderItems;

import java.util.List;

public interface OrderItemsRepository {
    void createOrderItems( OrderItems orderItems);

    void deleteOrderItemsById(Long orderItemsId);

    List<Item> getAllOrderItems(Long orderId);
}