package com.ShoppingWebsiteApplication.service;

import com.ShoppingWebsiteApplication.model.OrderItems;
import com.ShoppingWebsiteApplication.model.UserItems;

import java.util.List;


public interface UserItemsService {
    void  createUserItems( UserItems userItems);

//    void deleteUserItemsById( Long userItemsId);

    void deleteUserItem( String userName,Long ItemId);
    void deleteUserItemsByUserName(String userName);

//    List<Long> getAllUserItems(Long userId);
      List<Long> getAllUserItems(String userName);
    List<String> getAllUserNames();

}