package com.ShoppingWebsiteApplication.controller;


import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.Order;
//import com.ShoppingWebsiteApplication.model.UserOrderRequest;
//import com.ShoppingWebsiteApplication.model.UserOrderResponse;
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

import java.time.LocalDate;
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

//    @PostMapping(value = "/create")
//     @CrossOrigin
//    public UserOrderResponse createOrder(@RequestBody UserOrderRequest userOrderRequest) throws Exception {
//        return orderService.createOrder(userOrderRequest);
//    }
@PostMapping(value = "/create")
@CrossOrigin
public Long createOrder(@RequestBody Order order)  {
    Boolean userStatus = userService.userStatus(StringUtils.quote(order.getUserName()));
    if (userStatus==true) {
        return orderService.createOrder(order);
    }
    return null;
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


//    @CrossOrigin
//    @GetMapping(value = "/get/{orderId}")
//    public Order getOrderById(@PathVariable Long orderId){
//            Order order = orderService.getOrderById(orderId);
////            System.out.print(order);
////            return order;
//            Order orders = orderService.getOrderById(orderId);
//            orders.setItemsId(stringToLongArray(orders.getItemsIdAsString()));
//            return order;
////        return orderService.getOrderById(orderId);
//
//    }

    @CrossOrigin
    @GetMapping(value = "/get/{orderId}")
    public Order getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

//    @CrossOrigin
//    @GetMapping(value = "S/{orderId}")
//    public String getOrder(@PathVariable Long orderId) {
//        return "it works";
//    }
//
//    public static Long[] stringToLongArray(String items){
//            String[] inputArray = items.split(",");
//            Long[] arrayOfItems = new Long[inputArray.length];
//
//            for(int i=0;i<inputArray.length;i++){
//                arrayOfItems[i] = Long.parseLong(inputArray[i].trim());
//            }
//            return arrayOfItems;
//        }

    @CrossOrigin
        @DeleteMapping(value="/delete/{orderId}")
        private void deleteOrderById(@PathVariable("orderId") Long orderId)
        {
            List<Long> orderItems =orderItemsRepository.getAllOrderItems(orderId);

            OrderStatus status= orderRepository.getOrderStatusById(orderId);
            if (status.equals(OrderStatus.TEMP)) {
                orderService.deleteOrderById(orderId);
                for (Long id:orderItems) {
                    itemRepository.incItemQuantity(id);

                }

            }
            else{
                System.out.print("Try Again");}
        }

        //هاي يتمحى كلشي حتى لو كلوز او تيمب عشان لما نمحى اليزور كلو فاظن هاي لازم تنمحى كلها الكريأة وكمان نمحى كريأة الdelete user ن عندر الاوردير ايتيمز
    @CrossOrigin
    @DeleteMapping(value="/delete/name/{userName}")
    private void deleteOrderByUserName(@PathVariable("userName") String userName)
    {
        orderService.deleteOrderByUserName(userName);
    }


    @CrossOrigin
        @PutMapping(value = "/update/shippingAddress/{orderId}")
        private void updateOrderShippingAddress(@PathVariable Long orderId ,@RequestBody Order order)
        {
            orderService.updateOrderShippingAddress(orderId , order);
        }

//    @CrossOrigin
//    @PutMapping(value = "/update/shippingAddress/{orderId}")
//    private void updateOrderShippingAddress(@PathVariable Long orderId ,@RequestBody  String shippingAddress)
//    {
//        orderService.updateOrderShippingAddress(orderId , shippingAddress);
//    }

//اي الكريأة عندي بغدر اسميها closeOrder
    @CrossOrigin
    @PutMapping(value = "/update/status/{orderId}")
    private void updateOrderStatus(@PathVariable Long orderId )
    {
           Long numberOfItems= orderItemsRepository.numberOfOrderItemsInOrder(orderId);
           Order order = orderService.getOrderById(orderId);
            if (numberOfItems>0&&(order.getShippingAddress()!="No Address")) {
                orderService.updateOrderStatus(orderId);
            }

            else {
                System.out.print("Try Again");
            }

        // }
//           else{
//               System.out.print("Try Again");
//               //Lelian
////               System.out.print("Order Status is COLSE, you can not update this order");
//
//           }
    }

    @CrossOrigin
    @GetMapping(value = "/getAll")
    public List<Order> getAllOrders(){

    return orderService.getAllOrders();
    }

    @CrossOrigin
    @GetMapping(value = "/getAll/userName/{userName}")
    public List<Long> getAllOrdersByUserName(@PathVariable String userName){
        Boolean userStatus = userService.userStatus(userName);
        if (userStatus==true) {
            return orderService.getAllOrdersByUserName(userName);
        }
        return null;
    }

    @PostMapping(value = "/create/orderItems")
    @CrossOrigin
    public void createOrderItems(@RequestBody OrderItems orderItems)  {
    }
//    @CrossOrigin
//    @GetMapping(value = "/getAll/orderItems")
//    public OrderItems getAllOrderItems(Order order){
//        return orderService.getOrderItems(order);
//    }

}


