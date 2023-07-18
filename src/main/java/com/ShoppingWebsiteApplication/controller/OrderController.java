package com.ShoppingWebsiteApplication.controller;


import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.Order;
//import com.ShoppingWebsiteApplication.model.UserOrderRequest;
//import com.ShoppingWebsiteApplication.model.UserOrderResponse;
import com.ShoppingWebsiteApplication.model.OrderItems;
import com.ShoppingWebsiteApplication.model.OrderStatus;
import com.ShoppingWebsiteApplication.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

//    @CrossOrigin
//        @GetMapping(value = "/get/{orderId}")
//        public Order getOrderById(@PathVariable Long orderId){
////            Order order = orderService.getOrderById(orderId);
////            System.out.print(order);
////            return order;
//        return new Order(null, null, null, null, null, null, null);
//
////            Order order = orderService.getOrderById(orderId);
////            order.setItemsId(stringToLongArray(order.getItemsIdAsString()));
////            return order;
//        }


    @CrossOrigin
    @GetMapping(value = "/get/{orderId}")
    public Order getOrderById(@PathVariable Long orderId){
//            Order order = orderService.getOrderById(orderId);
//            System.out.print(order);
//            return order;
        return orderService.getOrderById(orderId);
//            Order order = orderService.getOrderById(orderId);
//            order.setItemsId(stringToLongArray(order.getItemsIdAsString()));
//            return order;
    }

    @CrossOrigin
    @GetMapping(value = "/{orderId}")
    public Order getOrderBy(@PathVariable Long orderId) {
        return orderService.getOrderBy(orderId);
    }

    @CrossOrigin
    @GetMapping(value = "S/{orderId}")
    public String getOrder(@PathVariable Long orderId) {
        return "it works";
    }

    public static Long[] stringToLongArray(String items){
            String[] inputArray = items.split(",");
            Long[] arrayOfItems = new Long[inputArray.length];

            for(int i=0;i<inputArray.length;i++){
                arrayOfItems[i] = Long.parseLong(inputArray[i].trim());
            }
            return arrayOfItems;
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

    @PostMapping(value = "/create/orderItems")
    @CrossOrigin
    public void createOrderItems(@RequestBody OrderItems orderItems)  {
    }
    @CrossOrigin
    @GetMapping(value = "/getAll/orderItems")
    public OrderItems getAllOrderItems(Order order){
        return orderService.getOrderItems(order);
    }

}


