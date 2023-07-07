package com.ShoppingWebsiteApplication.repository;

import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.Order;
import com.ShoppingWebsiteApplication.repository.mapper.ItemMapper;
import com.ShoppingWebsiteApplication.repository.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.ShoppingWebsiteApplication.model.Order.arrayToString;


@Repository
public class OrderRepositoryImpl  implements OrderRepository {

    private static final String ORDERS_TABLE_NAME = "orders";
    private static final String TRY_TABLE_NAME = "try";

    @Autowired
    JdbcTemplate jdbcTemplate;



//    @Override
//    public void createOrder(Order order) {
//        String sql = "INSERT INTO " + ORDERS_TABLE_NAME + " ( order_date,  shipping_address , total_price  , item_id ) VALUES (  ? , ? , ? , ?)";
//        jdbcTemplate.update(sql, order.getOrderDate() , order.getShippingAddress(), order.getTotalPrice() , order.getItemId());
//    }


//    @Override
//    public Long createOrder(Order order) {
//        String sql = "INSERT INTO " + ORDERS_TABLE_NAME + " ( user_id , order_date,  shipping_address , total_price , status  , item_id ) VALUES ( ?, ?, ? , ? , ? , ?)";
//        jdbcTemplate.update(sql, order.getUserId() ,order.getOrderDate() , order.getShippingAddress(), order.getTotalPrice() , order.getStatus().name(), order.getItemId());
//        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
//    }

//    @Override
//    public Long createOrder(Order order) {
//        String sql = "INSERT INTO " + TRY_TABLE_NAME + " (order_date , shipping_address ) VALUES (? , ?)";
//        jdbcTemplate.update(sql, order.getOrderDate() , "israel");
//        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
//    }


//        @Override
//    public Long createOrder(Order order) {
//        String sql = "INSERT INTO " + ORDERS_TABLE_NAME + " (user_id , order_date,  shipping_address , total_price , status  , items) VALUES ( ?, ?, ? , ? , ? , ?)";
//        jdbcTemplate.update(sql, order.getUserId() ,order.getOrderDate(), "No Address", order.getTotalPrice() , "TEMP", order.getItems());
//        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
//    }

    @Override
    public Long createOrder(Order order) {
        String itemsIdAsString = arrayToString(order.getItemsId());
        String sql = "INSERT INTO " + ORDERS_TABLE_NAME + " (user_id , order_date,  shipping_address , total_price , status, items_id ) VALUES ( ?, ?, ? , ? , ?,?)";
        jdbcTemplate.update(sql, order.getUserId() ,order.getOrderDate(), "No Address", order.getTotalPrice() , "TEMP", itemsIdAsString);
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }
//@Override
//public Long createOrder(Order order) {
//    String sql = "INSERT INTO " + ORDERS_TABLE_NAME + " (user_id , order_date,  shipping_address , total_price , status  , item_id ) VALUES ( ?, ?, ? , ? , ? , ?)";
//    jdbcTemplate.update(sql, order.getUserId() ,order.getOrderDate(), "No Address", order.getTotalPrice() , "TEMP", order.getItemId());
//    return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
//}
    @Override
    public Order getOrderById(Long orderId) {
        String sql = "SELECT * FROM " + ORDERS_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new OrderMapper(), orderId);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }


    @Override
    public void deleteOrderById(Long orderId) {
        String sql = "DELETE FROM " + ORDERS_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql,orderId);
    }


//    @Override
//    public void updateOrder( Long orderId , Order order) {
//        String sql = "UPDATE " + ORDERS_TABLE_NAME + " SET user_id=?, order_date=?,  shipping_address=? , total_price=? , status=? , item_id=?  " +
//                " WHERE id=?";
//        jdbcTemplate.update(sql,order.getUserId() , order.getOrderDate() , order.getShippingAddress(), order.getTotalPrice(), order.getStatus().name() , order.getItemId(), orderId);
//    }


//
//    @Override
//    public void updateOrder( Long orderId , Order order) {
//        String sql = "UPDATE " + ORDERS_TABLE_NAME + " SET user_id=?, order_date=?,  shipping_address=? , total_price=? , status=? , items=?  " +
//                " WHERE id=?";
//        jdbcTemplate.update(sql,order.getUserId() , order.getOrderDate() , order.getShippingAddress(), order.getTotalPrice(), order.getStatus().name() , order.getItems(), orderId);
//    }

    @Override
    public void updateOrder( Long orderId , Order order) {
        String itemsIdAsString = arrayToString(order.getItemsId());
        String sql = "UPDATE " + ORDERS_TABLE_NAME + " SET user_id=?, order_date=?,  shipping_address=? , total_price=? , status=?, items_id=?   " +
                " WHERE id=?";
        jdbcTemplate.update(sql,order.getUserId() , order.getOrderDate() , order.getShippingAddress(), order.getTotalPrice(), order.getStatus().name() , itemsIdAsString,  orderId);
    }
//@Override
//public void updateOrder( Long orderId , Order order) {
//    String sql = "UPDATE " + ORDERS_TABLE_NAME + " SET user_id=?, order_date=?,  shipping_address=? , total_price=? , status=? , item_id=?  " +
//            " WHERE id=?";
//    jdbcTemplate.update(sql,order.getUserId() , order.getOrderDate() , order.getShippingAddress(), order.getTotalPrice(), order.getStatus().name() , order.getItemId(), orderId);
//}




//    @Override
//    public void updateOrder( Long orderId , Order order) {
//        String sql = "UPDATE " + TRY_TABLE_NAME + " SET  order_date=?,  shipping_address=?   " +
//                " WHERE id=?";
//        jdbcTemplate.update(sql, order.getOrderDate() , order.getShippingAddress(), orderId);
//    }

    @Override
    public List<Order> getAllOrders() {
        String sql = "SELECT * FROM " + ORDERS_TABLE_NAME ;
        try {
            return jdbcTemplate.query(sql, new OrderMapper());
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }


}
