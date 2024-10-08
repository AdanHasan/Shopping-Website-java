package com.ShoppingWebsiteApplication.controller;

import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.OrderItems;
import com.ShoppingWebsiteApplication.repository.OrderRepository;
import com.ShoppingWebsiteApplication.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/orderItems")
public class OrderItemsController {

    @Autowired
    OrderItemsService orderItemsService;

    @Autowired
    ItemService itemService;

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;
    @Autowired
    UserItemsService userItemsService;
    @Autowired
    OrderRepository orderRepository;

    @PostMapping(value = "/create")
    @CrossOrigin
    public void createOrderItems(@RequestBody OrderItems orderItems) {
        orderItemsService.createOrderItems(orderItems);
    }

    @PostMapping(value = "/create/one")
    @CrossOrigin
    public void createOrderItem(@RequestBody OrderItems orderItems) {
        orderItemsService.createOrderItem(orderItems);

    }

    @CrossOrigin
    @PutMapping(value = "/update/quantity/{orderId}/{ItemsId}")
    private void updateOrderItemQuantity(@PathVariable("orderId") Long orderId, @PathVariable("ItemsId") Long ItemsId) {
        orderItemsService.updateOrderItemQuantity(orderId, ItemsId);
    }

    @CrossOrigin
    @PutMapping(value = "/decrease/quantity/{orderId}/{ItemsId}")
    private void decOrderItemQuantity(@PathVariable("orderId") Long orderId, @PathVariable("ItemsId") Long ItemsId) {
        orderItemsService.decOrderItemQuantity(orderId, ItemsId);
    }

    @CrossOrigin
    @GetMapping(value = "/get/quantity/{orderId}/{ItemId}")
    private Long quantity(@PathVariable("orderId") Long orderId, @PathVariable("ItemId") Long ItemId) {
        return orderItemsService.quantity(orderId, ItemId);
    }

    @CrossOrigin
    @GetMapping(value = "/get/quantity/item/{userName}/{ItemId}")
    private Long getOrderItemQuantity(@PathVariable("userName") String userName, @PathVariable("ItemId") Long ItemId) {
        return orderItemsService.getOrderItemQuantity(userName, ItemId);
    }

    @CrossOrigin
    @DeleteMapping(value = "/delete/{orderItemsId}")
    private void deleteOrderItemsById(@PathVariable("orderItemsId") Long orderItemsId) {
        orderItemsService.deleteOrderItemsById(orderItemsId);
    }

    @CrossOrigin
    @DeleteMapping(value = "/delete/{orderId}/{ItemsId}")
    private void deleteOrderItemsById(@PathVariable("orderId") Long orderId, @PathVariable("ItemsId") Long ItemsId) {
        orderItemsService.deleteOrderItemsById(orderId, ItemsId);
    }

    @CrossOrigin
    @DeleteMapping(value = "/delete/allItems/{orderId}")
    private void deleteOrderItemsByOrderId(@PathVariable("orderId") Long orderId) {
        orderItemsService.deleteOrderItemsByOrderId(orderId);
    }

    @CrossOrigin
    @DeleteMapping(value = "/delete/userName/{userName}")
    private void deleteOrderItemsByUserName(@PathVariable("userName") String userName) {
        List<Long> orderIds = orderService.getAllOrdersByUserName(userName);
        for (Long id : orderIds) {
            orderItemsService.deleteOrderItemsByUserName(id);

        }

    }

    @CrossOrigin
    @DeleteMapping(value = "/delete/user/{userName}")
    private void deleteUser(@PathVariable("userName") String userName) {
        List<Long> orderIds = orderService.getAllOrdersByUserName(userName);
        for (Long id : orderIds) {
            orderItemsService.deleteOrderItemsByUserName(id);
        }
        orderService.deleteOrderByUserName(userName);
        userItemsService.deleteUserItemsByUserName(userName);
        userService.deleteUserByName(userName);

    }

    @CrossOrigin
    @GetMapping(value = "/getAll/{orderId}")
    public List<Item> getAllOrderItems(@PathVariable("orderId") Long orderId) {

        String userName = orderRepository.geUserNameById(orderId);
        List<Long> itemIds = orderItemsService.getAllOrderItems(orderId);
        List<Item> itemsList = new ArrayList<>();
        for (Long id : itemIds) {
            Item item = itemService.getItemById(id);
            item.setQuantity(orderItemsService.getOrderItemQuantity(userName, id));
            itemService.getItemById(id).setQuantity(orderItemsService.getOrderItemQuantity(userName, id));
            itemsList.add(item);
        }
        return itemsList;
    }


    @CrossOrigin
    @GetMapping(value = "/getAllTry/{orderId}")
    public List<HashMap<Long, Item>> getAllTry(@PathVariable("orderId") Long orderId) {
        List<Long> itemIds = orderItemsService.getAllOrderItems(orderId);
        List<HashMap<Long, Item>> itemsList = new ArrayList<>();
        HashMap<Long, Item> itemsListQuantity = new HashMap<Long, Item>();
        String userName = orderRepository.geUserNameById(orderId);
        System.out.println(itemIds);
        for (Long id : itemIds) {
            System.out.println(id);
            itemsListQuantity.put(orderItemsService.getOrderItemQuantity(userName, id), itemService.getItemById(id));
            System.out.println(orderItemsService.getOrderItemQuantity(userName, id));
            System.out.println(itemService.getItemById(id));

            System.out.println(itemsListQuantity);
            itemsList.add(itemsListQuantity);
        }


        return itemsList;
    }

    @CrossOrigin
    @GetMapping(value = "/getAll/orderIds")
    public List<Long> getAllOrderIds() {
        return orderItemsService.getAllOrderIds();
    }

}
