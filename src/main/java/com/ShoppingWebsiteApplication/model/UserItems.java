package com.ShoppingWebsiteApplication.model;

import java.util.List;

public class UserItems {
    private String userName;

    private List<Long> items;


    public UserItems(String userName, List<Long> items) {
        this.userName = userName;
        this.items = items;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Long> getItems() {
        return items;
    }

    public void setItems(List<Long> items) {
        this.items = items;
    }


}
