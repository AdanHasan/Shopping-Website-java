package com.ShoppingWebsiteApplication.repository;

import com.ShoppingWebsiteApplication.model.UserItems;

import java.util.List;

public interface UserItemsRepository {
    void createUserItems(UserItems userItems);
    void deleteUserItem(String userName, Long ItemId);
    void deleteUserItemsByUserName(String userName);
    List<Long> getAllUserItems(String userName);
    List<String> getAllUserNames();

}
