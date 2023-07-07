package com.ShoppingWebsiteApplication.model;

import java.util.ArrayList;
import java.util.List;

public class OrderItems {

    private Order order;
    private List<Item> items ;

    public OrderItems( Order order, List<Item> items) {
        this.order = order;
        this.items = items;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }


}