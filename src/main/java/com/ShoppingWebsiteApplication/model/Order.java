package com.ShoppingWebsiteApplication.model;


import java.time.LocalDate;

public class Order {

    private Long id;
    private String userName;

    private LocalDate orderDate;

    private String shippingAddress;

    private Double totalPrice;

    private OrderStatus status;


    public Order() {
    }

    public Order(Long id, String userName, LocalDate orderDate, String shippingAddress, Double totalPrice, OrderStatus status) {
        this.id = id;

        this.userName = userName;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public Order(String userName, LocalDate orderDate) {
        this.userName = userName;
        this.orderDate = orderDate;
    }


    public Long getId() {
        return id;
    }


    public String getUserName() {
        return userName;
    }

    public LocalDate getOrderDate() {
        orderDate = LocalDate.now();
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


    public void setId(Long id) {
        this.id = id;
    }


    public void setUserName(String userName) {
        this.userName = userName;
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


}
