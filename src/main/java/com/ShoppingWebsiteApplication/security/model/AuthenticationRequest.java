package com.ShoppingWebsiteApplication.security.model;



import java.io.Serializable;

public class AuthenticationRequest implements Serializable {

    private String username;
    private String password;

//    private Boolean active;




    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Boolean getActive() {
//        return active;
//    }
//
//    public void setActive(Boolean active) {
//        this.active = active;
//    }

    //need default constructor for JSON Parsing
    public AuthenticationRequest() {}

    public AuthenticationRequest(
    String username, String password ) {
        this.setUsername(username);
        this.setPassword(password);
//        this.active=active;
    }
}