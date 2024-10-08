package com.ShoppingWebsiteApplication.model;

import java.util.List;

public class UserItems {
//    private Long userId;
    private String userName;

    //     private Long username;
    private List<Long> items ;

//    public UserItems(Long userId, List<Long> items) {
//        this.userId = userId;
//        this.items = items;
//    }

//    public UserItems(String userName, List<Long> items) {
//        this.userName = userName;
//        this.items = items;
//    }

//    public UserItems(Long userId, String userName, List<Long> items) {
//        this.userId = userId;
//        this.userName = userName;
//        this.items = items;
//    }


    public UserItems( String userName, List<Long> items) {
//        this.userId = userId;
        this.userName = userName;
        this.items = items;
    }

//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }


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
