package com.ShoppingWebsiteApplication.service;

import com.ShoppingWebsiteApplication.model.UserItems;
import com.ShoppingWebsiteApplication.repository.UserItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserItemsServiceImpl implements UserItemsService {

    @Autowired
    UserItemsRepository userItemsRepository;


    @Override
    public void createUserItems(UserItems userItems) {
        try {
            userItemsRepository.createUserItems(userItems);
        } catch (Exception e) {
            System.out.print("Try Again");
        }
    }

    @Override
    public void deleteUserItem(String userName, Long ItemId) {
        userItemsRepository.deleteUserItem(userName, ItemId);
    }

    public void deleteUserItemsByUserName(String userName) {
        userItemsRepository.deleteUserItemsByUserName(userName);
    }

    @Override
    public List<Long> getAllUserItems(String userName) {

        return userItemsRepository.getAllUserItems(userName);
    }

    @Override
    public List<String> getAllUserNames() {
        return userItemsRepository.getAllUserNames();
    }
}
