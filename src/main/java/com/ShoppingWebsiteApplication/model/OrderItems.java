//package com.ShoppingWebsiteApplication.model;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class OrderItems {
//
//    private Order order;
//    private List<Item> items ;
//
//    public OrderItems( Order order, List<Item> items) {
//        this.order = order;
//        this.items = items;
//    }
//
//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }
//
//    public List<Item> getItems() {
//        return items;
//    }
//
//    public void setItems(List<Item> items) {
//        this.items = items;
//    }
//
//
//}

package com.ShoppingWebsiteApplication.model;

import java.util.List;

public class OrderItems {
    private String userName;

    private Long orderId;

    private Long quantity;

    private List<Long> items ;

    private Long orderItemId;

//    public OrderItems(Long orderId, List<Long> items) {
//        this.orderId = orderId;
//        this.items = items;
//    }
//    public static Long count(Long[] array) {
//        Long j = null;
//        Long countItems = null;
//        for(int i = 1; i < 5; i++) {
//            while ( j < 5) {
//                j++;
//            }
//            countItems=j;
//            System.out.println("i"+i);
//            System.out.println("j"+j);
//            System.out.println("countItems"+countItems);
//        }
//        return countItems;
//    }

    public OrderItems(String userName , Long orderId, Long orderItemId) {
        this.userName=userName;
        this.orderId = orderId;

        this.orderItemId = orderItemId;
    }
    public OrderItems(String userName, Long orderId, Long quantity, List<Long> items) {
        this.userName=userName;
        this.orderId = orderId;
        this.quantity = quantity;
        this.items = items;
    }

    public OrderItems(String userName, Long orderId) {
        this.userName=userName;
        this.orderId = orderId;
    }

    public OrderItems() {
    }

    public OrderItems(String userName,Long orderId, List<Long> itemsList) {
        this.userName=userName;
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

