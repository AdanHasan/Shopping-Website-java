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

    Boolean userStatus(String userName);

    CustomUser getUserById(Long userId);
    void deleteUserById( Long userId);
    void deleteUserByName(String userName);

    void updateUser(CustomUser customUser, String userName);

//void updateUser(CustomUser customUser, Long userId);
Long getUserId(String userName);

    List<CustomUser> getAllUsers();
}
