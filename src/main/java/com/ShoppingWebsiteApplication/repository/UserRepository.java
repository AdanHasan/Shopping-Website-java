package com.ShoppingWebsiteApplication.repository;

import com.ShoppingWebsiteApplication.model.CustomUser;

import java.util.List;

public interface UserRepository {
//    Long createUser( User user);
void createUser(CustomUser customUser);
    CustomUser findUserByUsername(String username);
    CustomUser getUserById(Long userId);

    void deleteUserById(Long userId);

    void updateUser(CustomUser customUser, Long userId);

    List<CustomUser> getAllUsers();



}
