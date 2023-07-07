package com.ShoppingWebsiteApplication.model;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Order {

    private Long id;

    private Long userId;

    private LocalDate orderDate;

    private String shippingAddress;

    private Double totalPrice;

    private OrderStatus status;

//    private Array itemId ;

    private Long[] itemsId;


    /*
     * itemsId_java = [123681236,9754983709234,8748593023]
     * itemsId_sql ="123681236,9754983709234,8748593023"
     *
     *
     * */

    public Long[] getItemsId() {
        return itemsId;
    }

    public void setItemsId(Long[] itemsId) {
        this.itemsId = itemsId;
    }

    public Order(Long id, Long userId, LocalDate orderDate, String shippingAddress, Double totalPrice, OrderStatus status, Long[] itemsId) {
        this.id = id;
        this.userId = userId;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.totalPrice = totalPrice;
        this.status = status;
        this.itemsId = itemsId;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }


    public OrderStatus getStatus() {
        return status;
    }

//    public Item[]  getItems() {
////        System.out.print(items);
//        return items;
//    }

//    public Long getItemId() {
//        return itemId;
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

//    public void setItemId( Item[]  items) {
//        this.items = items;
//    }

//    public void setItemId(Long itemId) {
//        this.itemId = itemId;
//    }


//    public UserOrderResponse toUserOrderResponse( User user , List<Order> orderList){
//        return new UserOrderResponse(
//                user,
//                orderList
//        );
//    }

    public static String arrayToString(Long[] array) {
        return Arrays.stream(array)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }

}
