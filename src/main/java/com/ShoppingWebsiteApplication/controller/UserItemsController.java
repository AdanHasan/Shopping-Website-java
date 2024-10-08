package com.ShoppingWebsiteApplication.controller;

import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.UserItems;
import com.ShoppingWebsiteApplication.service.ItemService;
import com.ShoppingWebsiteApplication.service.UserItemsService;
import com.ShoppingWebsiteApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
    public void  createUserItems(@RequestBody UserItems userItems)  {
        Boolean userStatus = userService.userStatus(StringUtils.quote(userItems.getUserName()));
if (userStatus==true) {
    userItemsService.createUserItems(userItems);
}
else {
    System.out.println("Try Again!");
}
//            System.out.print(userItems.toString());

    }

//    @PostMapping(value = "/create")
//    @CrossOrigin
//    public void  createUserItems(@RequestBody UserItems userItems) {
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

//    @PostMapping(value = "/create")
//    @CrossOrigin
//    public void  createUserItems(@RequestBody UserItems userItems) {
//
//        List<Long> itemIds = userItemsService.getAllUserItems(userItems.getUserName());
//        List<Long> itemIdsIntered = userItems.getItems();
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
//                    System.out.println("Found in list");
//
//                }
//                else {
//                    userItemsService.createUserItems(userItems);
//
//
//                }
//            }
//        }
//    }



//    @CrossOrigin
//    @DeleteMapping(value="/delete/{userItemsId}")
//    private void deleteUserItemsById(@PathVariable("userItemsId") Long userItemsId)
//    {
//        userItemsService.deleteUserItemsById(userItemsId);
//    }

    @CrossOrigin
    @DeleteMapping(value="/delete/{userName}/{ItemId}")
    private void deleteUserItem(@PathVariable("userName") String userName,@PathVariable("ItemId") Long ItemId)
    {
        userItemsService.deleteUserItem(userName,ItemId);
    }



/////// delete حسب اليوزير نيم او اليوزير اي دي والايتم اي دي عشان نمحى من البوست مان

    @CrossOrigin
    @DeleteMapping(value="/delete/name/{userName}")
    private void deleteUserItemsByUserName(@PathVariable("userName") String userName)
    {
        userItemsService.deleteUserItemsByUserName(userName);
    }
//    @CrossOrigin
//    @DeleteMapping(value="/delete/{ItemsId}")
//    private void deleteUserItemsById(@PathVariable("ItemsId") Long ItemsId)
//    {
//        userItemsService.deleteUserItemsById(ItemsId);
//    }

//    @CrossOrigin
//    @GetMapping(value = "/getAll/{userId}")
//    public  List<Item> getAllUserItems(@PathVariable("userId") Long userId){
//        List<Long> itemIds =  userItemsService.getAllUserItems(userId);
//        List<Item> itemsList = new ArrayList<>();
//        for (Long id: itemIds) {
//            itemsList.add(itemService.getItemById(id));
//        }
//        return itemsList;
//    }

    @CrossOrigin
    @GetMapping(value = "/getAll/{userName}")
    public  List<Item> getAllUserItems(@PathVariable("userName") String userName){
//        try {
        Boolean userStatus = userService.userStatus(userName);
        if(userStatus==true) {
            List<Long> itemIds = userItemsService.getAllUserItems(userName);
            List<Item> itemsList = new ArrayList<>();
            for (Long id : itemIds) {
                itemsList.add(itemService.getItemById(id));
            }
            return itemsList;
                } else if (userStatus==false) {
            System.out.println(userName.replaceAll("'","") +" not active!");
            System.out.println("Please log in to see your favorite list");
        }
        else {
            System.out.println("Try again");

        }
//        }
//        catch (Exception error){
//            System.out.println("The user not active, try again!");
//            return null;
//        }

//        userName = userName.replaceAll("'","");
//        userName = StringUtils.quote(userName);


        return  null;
    }


//    @CrossOrigin
//    @GetMapping(value = "/get/{userName}")
//    public  List<Item> getAllUserItems(@PathVariable("userName") String userName){
//        List<Long> itemIds =  userItemsService.getAllUserItems(userName);
//        List<Item> itemsList = new ArrayList<>();
//        for (Long id: itemIds) {
//            itemsList.add(itemService.getItemById(id));
//        }
//        return itemsList;
//    }
@CrossOrigin
@GetMapping(value = "/getAll/userNames")
public List<String> getAllUserNames(){
    return userItemsService.getAllUserNames();
}
}
