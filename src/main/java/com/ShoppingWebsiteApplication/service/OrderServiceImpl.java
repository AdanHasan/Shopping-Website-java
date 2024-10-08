package com.ShoppingWebsiteApplication.service;

import com.ShoppingWebsiteApplication.model.*;
import com.ShoppingWebsiteApplication.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;


    @Override
    public Long createOrder(Order order) {
        String newUserName = "'" + order.getUserName() + "'";

        List<Long> arrOfTempOrders = orderRepository.getAllTempOrdersByUserName(newUserName);
        if (arrOfTempOrders.size() == 0) {
            return orderRepository.createOrder(order);
        }
        return null;
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.getOrderById(orderId);
    }

    @Override
    public void deleteOrderById(Long orderId) {
        orderRepository.deleteOrderById(orderId);
    }

    public void deleteOrderByUserName(String userName) {
        orderRepository.deleteOrderByUserName(userName);
    }

    @Override
    public void updateOrderShippingAddress(Long orderId, Order order) {
        orderRepository.updateOrderShippingAddress(orderId, order);
    }

    @Override
    public void updateOrderStatus(Long orderId) {
        orderRepository.updateOrderStatus(orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @Override
    public List<Long> getAllOrdersByUserName(String userName) {
        return orderRepository.getAllOrdersByUserName(userName);
    }


}
