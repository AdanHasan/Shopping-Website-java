package com.ShoppingWebsiteApplication.service;

import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.Order;
import com.ShoppingWebsiteApplication.model.OrderItems;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface OrderItemsService {

    //    @Override
    //    public void createOrderItems(OrderItems orderItems) {
    //        orderItemsRepository.createOrderItems(orderItems);
    //        Double total=0.0;
    //        System.out.println("start"+total);
    //        Order order = orderService.getOrderById(orderItems.getOrderId());
    //        List<Long> Items =orderItemsRepository.getAllOrderItems(orderItems.getOrderId());
    //
    //        for (Long id: Items) {
    //            total += itemService.getItemPriceById(id);
    //            System.out.println("now"+itemService.getItemPriceById(id));
    //
    //        }
    ////        total=orderItemsRepository.getPrice(orderItems);
    //        order.setTotalPrice(total);
    ////        orderRepository.updateTotalPrice(orderItems.getOrderId(),order);
    //
    //        System.out.println("after"+total);
    //        orderRepository.updateTotalPrice(orderItems.getOrderId(),order);
    //
    //    }
    void calculate(OrderItems orderItems);
    void calculateTry(Long orderId);
    void delt( Long itemId ,Long orderId);


    void createOrderItems(OrderItems orderItems);
    void createOrderItem(OrderItems orderItems);

    void deleteOrderItemsById(Long orderItemsId);

     void deleteOrderItemsById( Long orderId, Long ItemsId);

     void deleteOrderItemsByOrderId(Long orderId);

    void deleteOrderItemsByUserName(Long orderId);
     void deleteUser( String userName);

    void updateOrderItemQuantity( Long orderId, Long ItemsId);
    void decOrderItemQuantity( Long orderId, Long ItemsId);

    List<Long> getAllOrderItems(Long orderId);
    List<OrderItems> getAllOrdersItems();

    List<Long> getAllOrderIds();
    List<HashMap<Long,Item>> getAllTry(Long orderId);
    Long quantity(Long orderId,Long itemId);

    Long getOrderItemQuantity(String userName,Long itemId);


}
