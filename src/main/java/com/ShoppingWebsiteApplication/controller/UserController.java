package com.ShoppingWebsiteApplication.controller;


import com.ShoppingWebsiteApplication.model.CustomUser;
import com.ShoppingWebsiteApplication.model.CustomUserRequest;
import com.ShoppingWebsiteApplication.model.Order;
import com.ShoppingWebsiteApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


//    @PostMapping(value = "/create")
//    @CrossOrigin
//    public Long createUser(@RequestBody User user) {
//        return userService.createUser(user);
//    }


    @PostMapping("/create")
    @CrossOrigin
    public ResponseEntity<?> createUser(@RequestBody CustomUserRequest customUser){
        try{
            userService.createUser(customUser);
            return null;
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }


    @GetMapping(value = "/get/{userId}")
    public CustomUser getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }



    @DeleteMapping(value = "/delete/{userId}")
    private void deleteUserById(@PathVariable("userId") Long userId)
    {
        userService.deleteUserById(userId);
    }


    @CrossOrigin
    @PutMapping(value = "/update/{userName}")
    private void updateUser(@PathVariable String userName,@RequestBody CustomUser customUser)
    {
        userService.updateUser(customUser, userName);
    }

    @CrossOrigin
    @GetMapping(value = "/getAll")
    public List<CustomUser> getAllUsers(){
        return userService.getAllUsers();
    }


}