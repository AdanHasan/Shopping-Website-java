package com.ShoppingWebsiteApplication.controller;


import com.ShoppingWebsiteApplication.model.Order;
import com.ShoppingWebsiteApplication.model.OrderItems;
import com.ShoppingWebsiteApplication.model.OrderStatus;
import com.ShoppingWebsiteApplication.repository.ItemRepository;
import com.ShoppingWebsiteApplication.repository.OrderItemsRepository;
import com.ShoppingWebsiteApplication.repository.OrderRepository;
import com.ShoppingWebsiteApplication.service.OrderService;
import com.ShoppingWebsiteApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")

public class OrderController {


    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemsRepository orderItemsRepository;

    @Autowired
    ItemRepository itemRepository;

    @PostMapping(value = "/create")
    @CrossOrigin
    public Long createOrder(@RequestBody Order order) {
        Boolean userStatus = userService.userStatus(StringUtils.quote(order.getUserName()));
        if (userStatus == true) {
            return orderService.createOrder(order);
        }
        return null;
    }


    @CrossOrigin
    @GetMapping(value = "/get/{orderId}")
    public Order getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @CrossOrigin
    @DeleteMapping(value = "/delete/{orderId}")
    private void deleteOrderById(@PathVariable("orderId") Long orderId) {
        List<Long> orderItems = orderItemsRepository.getAllOrderItems(orderId);

        OrderStatus status = orderRepository.getOrderStatusById(orderId);
        if (status.equals(OrderStatus.TEMP)) {
            orderService.deleteOrderById(orderId);
            for (Long id : orderItems) {
                itemRepository.incItemQuantity(id);

            }

        } else {
            System.out.print("Try Again");
        }
    }

    @CrossOrigin
    @DeleteMapping(value = "/delete/name/{userName}")
    private void deleteOrderByUserName(@PathVariable("userName") String userName) {
        orderService.deleteOrderByUserName(userName);
    }


    @CrossOrigin
    @PutMapping(value = "/update/shippingAddress/{orderId}")
    private void updateOrderShippingAddress(@PathVariable Long orderId, @RequestBody Order order) {
        orderService.updateOrderShippingAddress(orderId, order);
    }


    @CrossOrigin
    @PutMapping(value = "/update/status/{orderId}")
    private void updateOrderStatus(@PathVariable Long orderId) {
        Long numberOfItems = orderItemsRepository.numberOfOrderItemsInOrder(orderId);
        Order order = orderService.getOrderById(orderId);
        if (numberOfItems > 0 && (order.getShippingAddress() != "No Address")) {
            orderService.updateOrderStatus(orderId);
        } else {
            System.out.print("Try Again");
        }
    }

    @CrossOrigin
    @GetMapping(value = "/getAll")
    public List<Order> getAllOrders() {

        return orderService.getAllOrders();
    }

    @CrossOrigin
    @GetMapping(value = "/getAll/userName/{userName}")
    public List<Long> getAllOrdersByUserName(@PathVariable String userName) {
        Boolean userStatus = userService.userStatus(userName);
        if (userStatus == true) {
            return orderService.getAllOrdersByUserName(userName);
        }
        return null;
    }

    @PostMapping(value = "/create/orderItems")
    @CrossOrigin
    public void createOrderItems(@RequestBody OrderItems orderItems) {
    }

}


