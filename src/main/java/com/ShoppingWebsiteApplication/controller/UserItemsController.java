package com.ShoppingWebsiteApplication.controller;

import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.UserItems;
import com.ShoppingWebsiteApplication.service.ItemService;
import com.ShoppingWebsiteApplication.service.UserItemsService;
import com.ShoppingWebsiteApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/userItems")
public class UserItemsController {

    @Autowired
    UserItemsService userItemsService;

    @Autowired
    ItemService itemService;

    @Autowired
    UserService userService;

    @PostMapping(value = "/create")
    @CrossOrigin
    public void createUserItems(@RequestBody UserItems userItems) {
        Boolean userStatus = userService.userStatus(StringUtils.quote(userItems.getUserName()));
        if (userStatus == true) {
            userItemsService.createUserItems(userItems);
        } else {
            System.out.println("Try Again!");
        }

    }


    @CrossOrigin
    @DeleteMapping(value = "/delete/{userName}/{ItemId}")
    private void deleteUserItem(@PathVariable("userName") String userName, @PathVariable("ItemId") Long ItemId) {
        userItemsService.deleteUserItem(userName, ItemId);
    }


    @CrossOrigin
    @DeleteMapping(value = "/delete/name/{userName}")
    private void deleteUserItemsByUserName(@PathVariable("userName") String userName) {
        userItemsService.deleteUserItemsByUserName(userName);
    }


    @CrossOrigin
    @GetMapping(value = "/getAll/{userName}")
    public List<Item> getAllUserItems(@PathVariable("userName") String userName) {
//        try {
        Boolean userStatus = userService.userStatus(userName);
        if (userStatus == true) {
            List<Long> itemIds = userItemsService.getAllUserItems(userName);
            List<Item> itemsList = new ArrayList<>();
            for (Long id : itemIds) {
                itemsList.add(itemService.getItemById(id));
            }
            return itemsList;
        } else if (userStatus == false) {
            System.out.println(userName.replaceAll("'", "") + " not active!");
            System.out.println("Please log in to see your favorite list");
        } else {
            System.out.println("Try again");

        }


        return null;
    }


    @CrossOrigin
    @GetMapping(value = "/getAll/userNames")
    public List<String> getAllUserNames() {
        return userItemsService.getAllUserNames();
    }
}
