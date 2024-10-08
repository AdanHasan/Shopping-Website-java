package com.ShoppingWebsiteApplication.repository;

import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.OrderItems;
import com.ShoppingWebsiteApplication.model.UserItems;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserItemsRepository {
 void   createUserItems( UserItems userItems);

//   void deleteUserItemsById( Long userItemsId);

    void deleteUserItem( String userName,Long ItemId);

    void deleteUserItemsByUserName(String userName);

//    List<Long> getAllUserItems( Long userId);

    List<Long> getAllUserItems( String userName);
    List<String> getAllUserNames();

}
