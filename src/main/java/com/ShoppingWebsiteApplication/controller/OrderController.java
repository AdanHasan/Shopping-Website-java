package com.ShoppingWebsiteApplication.controller;


import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.Order;
//import com.ShoppingWebsiteApplication.model.UserOrderRequest;
//import com.ShoppingWebsiteApplication.model.UserOrderResponse;
import com.ShoppingWebsiteApplication.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")

public class OrderController {


        @Autowired
        OrderService orderService;

//    @PostMapping(value = "/create")
//     @CrossOrigin
//    public UserOrderResponse createOrder(@RequestBody UserOrderRequest userOrderRequest) throws Exception {
//        return orderService.createOrder(userOrderRequest);
//    }
@PostMapping(value = "/create")
@CrossOrigin
public Long createOrder(@RequestBody Order order)  {
    return orderService.createOrder(order);
}

    @CrossOrigin
        @GetMapping(value = "/get/{orderId}")
        public Order getOrderById(@PathVariable Long orderId){
            return orderService.getOrderById(orderId);
        }


    @CrossOrigin
        @DeleteMapping(value="/delete/{orderId}")
        private void deleteOrderById(@PathVariable("orderId") Long orderId)
        {
            orderService.deleteOrderById(orderId);
        }

    @CrossOrigin
        @PutMapping(value = "/update/{orderId}")
        private void updateOrder(@PathVariable Long orderId ,@RequestBody Order order)
        {
            orderService.updateOrder(orderId , order);
        }


    @CrossOrigin
    @GetMapping(value = "/getAll")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }


}


