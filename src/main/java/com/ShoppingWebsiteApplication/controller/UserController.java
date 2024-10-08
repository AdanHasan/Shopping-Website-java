package com.ShoppingWebsiteApplication.controller;


import com.ShoppingWebsiteApplication.model.CustomUser;
import com.ShoppingWebsiteApplication.model.CustomUserRequest;
import com.ShoppingWebsiteApplication.model.Order;
import com.ShoppingWebsiteApplication.model.OrderStatus;
import com.ShoppingWebsiteApplication.repository.ItemRepository;
import com.ShoppingWebsiteApplication.repository.OrderItemsRepository;
import com.ShoppingWebsiteApplication.repository.OrderRepository;
import com.ShoppingWebsiteApplication.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    OrderItemsService orderItemsService;

    @Autowired
    ItemService itemService;

    @Autowired
    OrderService orderService;

    @Autowired
    UserItemsService userItemsService;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    OrderItemsRepository orderItemsRepository;
//    @PostMapping(value = "/create")
//    @CrossOrigin
//    public Long createUser(@RequestBody User user) {
//        return userService.createUser(user);
//    }


    @PostMapping("/create")
    @CrossOrigin
    public ResponseEntity<?> createUser(@RequestBody CustomUserRequest customUser){
        try{
            userService.createUser(customUser);
            return null;
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }


    @GetMapping(value = "/get/{userId}")
    public CustomUser getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

    @CrossOrigin
    @GetMapping(value = "/get/status/{userName}")
    public Boolean userStatus(@PathVariable String userName){
        return userService.userStatus(userName);
    }

    @CrossOrigin
    @GetMapping(value = "/get/id/{userName}")
    public Long getUserId(@PathVariable String userName){
        return userService.getUserId(userName);
    }

//يمكن هاي لازم نمحاها
    @DeleteMapping(value = "/delete/{userId}")
    private void deleteUserById(@PathVariable("userId") Long userId)
    {
        userService.deleteUserById(userId);
    }

    @CrossOrigin
    @DeleteMapping(value = "/delete/name/{userName}")
    private void deleteUserByName(@PathVariable("userName") String userName)
    {
        String newUserName = "'"+ userName+"'";
        List<Long> orderIds = orderService.getAllOrdersByUserName(newUserName);
        System.out.println(orderIds);

        for (Long orderId: orderIds) {
            OrderStatus orderStatus=orderRepository.getOrderStatusById(orderId);
            System.out.print(orderId);

            System.out.print(orderStatus);
    if( orderStatus.equals(OrderStatus.CLOSE)) {
        orderItemsService.deleteOrderItemsByUserName(orderId);

//        List<Long> orderItems =orderItemsRepository.getAllOrderItems(orderId);
//        System.out.println(orderItems);
//        for (Long orderItemId:orderItems) {
//            System.out.println(orderItemId);
//
//            itemRepository.incItemQuantity(orderItemId);
//        }
/////////////ازا من نفس الايتيم في تنين وواحد تيمب وواحد كلوز برجعو عشره وهو لازم تسعه
//        orderItemsService.deleteOrderItemsByUserName(orderId);

    }
    else if (orderStatus.equals(OrderStatus.TEMP)) {
//        orderItemsService.deleteOrderItemsByUserName(orderId);
        List<Long> orderItems =orderItemsRepository.getAllOrderItems(orderId);
        System.out.println(orderItems);
        for (Long orderItemId:orderItems) {
            System.out.println(orderItemId);
            Long quantity =orderItemsRepository.getOrderItemQuantity(userName,orderItemId);
            System.out.println("quantity"+quantity);

//            itemRepository.incItemQuantity(orderItemId);
            itemRepository.incItemQuantitys(orderItemId,quantity);
        }
///////////ازا من نفس الايتيم في تنين وواحد تيمب وواحد كلوز برجعو عشره وهو لازم تسعه
        orderItemsService.deleteOrderItemsByUserName(orderId);

    }
        }
        orderService.deleteOrderByUserName(userName);
        userItemsService.deleteUserItemsByUserName(userName);
        userService.deleteUserByName(userName);
    }

    @CrossOrigin
    @PutMapping(value = "/update/{userName}")
    private void updateUser(@PathVariable String userName,@RequestBody CustomUser customUser)
    {
        userService.updateUser(customUser, userName);
    }

//    @CrossOrigin
//    @PutMapping(value = "/update/{userId}")
//    private void updateUser(@PathVariable Long userId,@RequestBody CustomUser customUser)
//    {
//        userService.updateUser(customUser, userId);
//    }

    @CrossOrigin
    @GetMapping(value = "/getAll")
    public List<CustomUser> getAllUsers(){
        return userService.getAllUsers();
    }


}