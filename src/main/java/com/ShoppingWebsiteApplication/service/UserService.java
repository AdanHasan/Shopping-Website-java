package com.ShoppingWebsiteApplication.service;

import com.ShoppingWebsiteApplication.model.CustomUser;
import com.ShoppingWebsiteApplication.model.CustomUserRequest;

import java.util.List;

public interface UserService {
    void createUser(CustomUserRequest user) throws Exception;

    CustomUser findUserByUsername(String username);

    Boolean userStatus(String userName);

    CustomUser getUserById(Long userId);

    void deleteUserById(Long userId);

    void deleteUserByName(String userName);

    void updateUser(CustomUser customUser, String userName);

    Long getUserId(String userName);

    List<CustomUser> getAllUsers();
}
