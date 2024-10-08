package com.ShoppingWebsiteApplication.repository;

import com.ShoppingWebsiteApplication.model.CustomUser;

import java.util.List;

public interface UserRepository {
    void createUser(CustomUser customUser);

    CustomUser findUserByUsername(String username);

    Boolean userStatus(String userName);

    CustomUser getUserById(Long userId);

    void deleteUserById(Long userId);

    void deleteUserByName(String userName);

    void updateUser(CustomUser customUser, String userName);

    Long getUserId(String userName);

    List<CustomUser> getAllUsers();


}
