package com.ShoppingWebsiteApplication.service;

import com.ShoppingWebsiteApplication.model.*;
import com.ShoppingWebsiteApplication.repository.OrderItemsRepository;
import com.ShoppingWebsiteApplication.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemsRepository orderItemsRepository;


//    @Override
//    public UserOrderResponse createOrder(UserOrderRequest userOrderRequest) throws Exception {
//        User selectedUser = userOrderRequest.getUser();
//        if (selectedUser != null) {
//            if (selectedUser.getId() != null) {
//                User existingUser = userService.getUserById(selectedUser.getId());
//                if (existingUser != null) {
//                    orderRepository.createOrder(userOrderRequest.toOrder());
//                } else {
//                    throw new Exception("Can't  create order with non existing user id " + selectedUser.getId());
//                }
//
//            } else {
//                throw new Exception("Can't create userOrder with user as null");
//            }
//        }
//        return null ;
//    }


    @Override
    public Long createOrder(Order order  ) {
        return orderRepository.createOrder(order);
    }

    @Override
    public Order getOrderById(Long orderId) {return orderRepository.getOrderById(orderId);
    }
    @Override
    public Order getOrderBy(Long orderId) {
        return orderRepository.getOrderBy(orderId);
    }

    @Override
    public String getOrder(Long orderId) {
        return "Haaa";
    }

    @Override
    public void deleteOrderById(Long orderId) {
         orderRepository.deleteOrderById(orderId);
    }

    @Override
    public void updateOrder( Long orderId , Order order) {orderRepository.updateOrder( orderId , order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }
    @Override
    public OrderItems getOrderItems(Order order) {
        return new OrderItems(order, orderItemsRepository.getAllOrderItems(order.getId()));
    }

}
