
package com.ShoppingWebsiteApplication.model;

import java.util.List;

public class OrderItems {
    private String userName;

    private Long orderId;

    private Long quantity;

    private List<Long> items;

    private Long orderItemId;

    public OrderItems(String userName, Long orderId, Long orderItemId) {
        this.userName = userName;
        this.orderId = orderId;

        this.orderItemId = orderItemId;
    }

    public OrderItems(String userName, Long orderId, Long quantity, List<Long> items) {
        this.userName = userName;
        this.orderId = orderId;
        this.quantity = quantity;
        this.items = items;
    }

    public OrderItems(String userName, Long orderId) {
        this.userName = userName;
        this.orderId = orderId;
    }

    public OrderItems() {
    }

    public OrderItems(String userName, Long orderId, List<Long> itemsList) {
        this.userName = userName;
        this.orderId = orderId;
        this.items = itemsList;
    }

    public OrderItems(Long orderId, List<Long> itemsList) {
        this.orderId = orderId;
        this.items = itemsList;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<Long> getItems() {
        return items;
    }

    public void setItems(List<Long> items) {
        this.items = items;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }
}

