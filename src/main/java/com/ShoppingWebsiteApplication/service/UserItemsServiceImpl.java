package com.ShoppingWebsiteApplication.service;


import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.OrderItems;
import com.ShoppingWebsiteApplication.model.UserItems;
import com.ShoppingWebsiteApplication.repository.UserItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserItemsServiceImpl implements UserItemsService {

    @Autowired
    UserItemsRepository userItemsRepository;

//    @Override
//    public void createUserItems(UserItems userItems) {
//        userItemsRepository.createUserItems(userItems);
//
//    }


    @Override
    public void createUserItems(UserItems userItems) {
        try {
            userItemsRepository.createUserItems(userItems);
        }
        catch (Exception e){
          System.out.print("Try Again");
        }
    }





//    @Override
//    public void createUserItems(UserItems userItems) {
//        String newUserName = "'"+ userItems.getUserName()+"'";
//        List<Long> itemIds = userItemsRepository.getAllUserItems(newUserName);
//        List<Long> z = new ArrayList<>();
//        List<Long> entered =userItems.getItems();
//        List<Long> filteredEntered = new ArrayList<>();
//        UserItems newUserItems=new UserItems (userItems.getUserName(),z);
//        UserItems secondUserItems=new UserItems (userItems.getUserName(),filteredEntered);
//        filteredEntered.add(entered.get(0));
//
//        if(itemIds.isEmpty()){
//            for (int i = 0; i <entered.size() ; i++) {
//                if(!(entered.get(i)==entered.get(0))){
//                    filteredEntered.add(entered.get(i));
//                }
//            }
//            userItemsRepository.createUserItems(secondUserItems);
//        }
//        else{
//            for (int i = 0; i <entered.size() ; i++) {
//                if(!(entered.get(i)==entered.get(0))){
//                    filteredEntered.add(entered.get(i));
//                }
//            }
//            filteredEntered.forEach(itemId ->{if (!(itemIds.contains(itemId))){
//                z.add(itemId);
//            }
//            });
//            userItemsRepository.createUserItems(newUserItems);
//        }
//    }

//
//        List<Long> itemIds = userItemsService.getAllUserItems(userItems.getUserName());
////        List<Long> itemIdsIntered = userItems.getItems();
//
//        boolean ans = itemIds.isEmpty();
//        System.out.println(ans);
//        System.out.println(itemIds);
//
//
//        if (ans == true) {
//            userItemsService.createUserItems(userItems);
//            System.out.println("First Created!!!");
//
//        } else {
//            for (long id : itemIds) {
//                if(userItems.getItems().contains(id)){
//                        System.out.println("Found in list");
//
//                    }
//                else {
//                        userItemsService.createUserItems(userItems);
//
//
//                }
//            }
//        }
//    }


//    @Override
//    public void deleteUserItemsById(Long userItemsId) {
//        userItemsRepository.deleteUserItemsById(userItemsId);
//    }

    @Override
    public void deleteUserItem(String userName,Long ItemId) {
        userItemsRepository.deleteUserItem(userName,ItemId);
    }
    public void deleteUserItemsByUserName(String userName) {
        userItemsRepository.deleteUserItemsByUserName(userName);
    }


//    @Override
//    public List<Long> getAllUserItems(Long userId) {
//        return  userItemsRepository.getAllUserItems(userId);
//    }

    @Override
    public List<Long> getAllUserItems(String userName) {

        return userItemsRepository.getAllUserItems(userName);
    }
    @Override
    public List<String> getAllUserNames() {
        return userItemsRepository.getAllUserNames();
    }
}
