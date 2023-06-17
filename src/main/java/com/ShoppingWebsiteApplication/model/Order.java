package com.ShoppingWebsiteApplication.model;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Order {

    private Long id;

    private Long userId;

    private LocalDate orderDate;

    private String  shippingAddress;

    private Double totalPrice;

    private OrderStatus status;

//    private Array itemId ;


    private Item[]  items ;

//     private Long itemId;

//     private List<Item> getItemIds(Array itemArray) throws SQLException{
//         if (itemArray != null){
//             ResultSet itemResultSet =  itemArray.getResultSet();
//             List<Item> itemIds = new ArrayList<>();
//             while (itemResultSet.next()){
//                 itemIds.add(itemResultSet.getLong(1));
//             }
//             Item[] items = new Item[itemIds.size()];
//             for (int i=0; i< itemIds.size(); i++)
//                 items[i] =itemIds.get(i);
//             return items
//         }
//         return new Item[0];
//     }


//    private List <Item>;


    public Order(Long id , Long userId , LocalDate orderDate , String  shippingAddress , Double totalPrice, OrderStatus status,  Item[]  items) {
        this.id = id;
        this.userId = userId;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.totalPrice = totalPrice;
        this.status = status;
        this.items = items;
    }

//    public Order(Long id , Long userId , LocalDate orderDate , String  shippingAddress , Double totalPrice, OrderStatus status,  Long  itemId) {
//        this.id = id;
//        this.userId = userId;
//        this.orderDate = orderDate;
//        this.shippingAddress = shippingAddress;
//        this.totalPrice = totalPrice;
//        this.status = status;
//        this.itemId = itemId;
//    }
//    public Order(){
//
//    }


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

    public Item[]  getItems() {
//        System.out.print(items);
        return items;
    }

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

    public void setItemId( Item[]  items) {
        this.items = items;
    }

//    public void setItemId(Long itemId) {
//        this.itemId = itemId;
//    }


//    public UserOrderResponse toUserOrderResponse( User user , List<Order> orderList){
//        return new UserOrderResponse(
//                user,
//                orderList
//        );
//    }



}
