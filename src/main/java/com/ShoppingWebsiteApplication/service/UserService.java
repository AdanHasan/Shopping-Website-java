package com.ShoppingWebsiteApplication.service;
import com.ShoppingWebsiteApplication.model.CustomUser;
import com.ShoppingWebsiteApplication.model.CustomUserRequest;

import java.util.List;
//import com.ShoppingWebsiteApplication.model.UserRequest;
//import com.ShoppingWebsiteApplication.model.UserResponse;


public interface UserService {
//    Long createUser( User user);
void createUser(CustomUserRequest user) throws Exception;
    CustomUser findUserByUsername(String username);
    CustomUser getUserById(Long userId);
    void deleteUserById( Long userId);
    void updateUser(CustomUser customUser, String userName);

    List<CustomUser> getAllUsers();
}
