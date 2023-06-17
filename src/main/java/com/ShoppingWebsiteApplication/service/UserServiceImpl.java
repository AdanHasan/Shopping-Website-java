package com.ShoppingWebsiteApplication.service;

//import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.CustomUser;
//import com.ShoppingWebsiteApplication.model.UserRequest;
//import com.ShoppingWebsiteApplication.model.UserResponse;
import com.ShoppingWebsiteApplication.model.CustomUserRequest;
import com.ShoppingWebsiteApplication.model.Order;
import com.ShoppingWebsiteApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


//    @Override
//    public Long createUser(User user) {
//        return userRepository.createUser(user);
//    }

    @Override
    public void createUser(CustomUserRequest customUserRequest) throws Exception {
        CustomUser existingCustomUser = userRepository.findUserByUsername(customUserRequest.getUsername());
        if(existingCustomUser != null){
            throw new Exception("Username " + customUserRequest.getUsername() + " is already taken");
        }
        userRepository.createUser(customUserRequest.toCustomUser());
    }

    @Override
    public CustomUser findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public CustomUser getUserById(Long userId) {
        return userRepository.getUserById(userId);
    }



    @Override
    public void deleteUserById(Long userId) {
         userRepository.deleteUserById(userId);
    }

    @Override
    public void updateUser(CustomUser customUser, Long userId) {userRepository.updateUser(customUser, userId);}

    @Override
    public List<CustomUser> getAllUsers() {
        return userRepository.getAllUsers();
    }

}
