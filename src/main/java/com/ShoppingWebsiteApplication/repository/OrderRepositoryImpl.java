package com.ShoppingWebsiteApplication.repository;

import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.Order;
import com.ShoppingWebsiteApplication.model.OrderStatus;
import com.ShoppingWebsiteApplication.repository.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//import static com.ShoppingWebsiteApplication.model.Order.arrayToString;


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

//    @Override
//    public Long createOrder(Order order) {
//        String itemsIdAsString = arrayToString(order.getItemsId());
//        String sql = "INSERT INTO " + ORDERS_TABLE_NAME + " (user_id , order_date,  shipping_address , total_price , status, items_id ) VALUES ( ?, ?, ? , ? , ?,?)";
//        jdbcTemplate.update(sql, order.getUserId() ,order.getOrderDate(), "No Address", order.getTotalPrice() , "TEMP", itemsIdAsString);
//        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
//    }

//@Override
//public Long createOrder(Order order) {
//    String sql = "INSERT INTO " + ORDERS_TABLE_NAME + " (user_id , order_date,  shipping_address , total_price , status  , item_id ) VALUES ( ?, ?, ? , ? , ? , ?)";
//    jdbcTemplate.update(sql, order.getUserId() ,order.getOrderDate(), "No Address", order.getTotalPrice() , "TEMP", order.getItemId());
//    return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
//}

    @Override
    public Long createOrder(Order order) {
//        List<Long>

        String sql = "INSERT INTO " + ORDERS_TABLE_NAME + " (user_name , order_date,  shipping_address , total_price , status   ) VALUES ( ?, ?, ? , ? , ? )";
        jdbcTemplate.update(sql, order.getUserName() ,order.getOrderDate(), "No Address", 0.0 , "TEMP");
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }


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
    public OrderStatus getOrderStatusById(Long orderId) {
        String sql = "SELECT status FROM " + ORDERS_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, OrderStatus.class,orderId);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }
    @Override
    public String geUserNameById(Long orderId) {
        String sql = "SELECT user_name FROM " + ORDERS_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, String.class,orderId);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }


//    @Override
//    public Order getOrderById(Long orderId) {
//        String sql = "SELECT * FROM " + ORDERS_TABLE_NAME + " WHERE id=?";
//            return jdbcTemplate.queryForObject(sql, new OrderMapper(), orderId);
//    }
    @Override
    public void deleteOrderById(Long orderId) {
        String sql = "DELETE FROM " + ORDERS_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql,orderId);
    }
    @Override
    public void deleteOrderByUserName(String userName) {
        String sql = "DELETE FROM " + ORDERS_TABLE_NAME + " WHERE user_name=? ";
        jdbcTemplate.update(sql,userName);
    }


//    @Override
//    public Order getOrderBy(Long orderId) {
//        String sql = "SELECT * FROM " + ORDERS_TABLE_NAME + " WHERE id=?";
//        try {
//            return jdbcTemplate.queryForObject(sql, new OrderMapper(), orderId);
//        } catch (EmptyResultDataAccessException error) {
//            return null;
//        }
//    }
//    @Override
//    public String getOrder(Long orderId) {
//        String sql = "SELECT * FROM " + ORDERS_TABLE_NAME + " WHERE id=?";
//
//            return "it works";
//
//    }


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

//    @Override
//    public void updateOrder( Long orderId , Order order) {
//        String itemsIdAsString = arrayToString(order.getItemsId());
//        String sql = "UPDATE " + ORDERS_TABLE_NAME + " SET user_id=?, order_date=?,  shipping_address=? , total_price=? , status=?, items_id=?   " +
//                " WHERE id=?";
//        jdbcTemplate.update(sql,order.getUserId() , order.getOrderDate() , order.getShippingAddress(), order.getTotalPrice(), order.getStatus().name() , itemsIdAsString,  orderId);
//    }

    @Override
    public void updateOrderShippingAddress( Long orderId , Order order) {
        String sql = "UPDATE " + ORDERS_TABLE_NAME + " SET   shipping_address=? " +
                " WHERE id=? AND status='TEMP'";
        jdbcTemplate.update(sql  , order.getShippingAddress(), orderId );
    }

    @Override
    public void updateOrderStatus( Long orderId) {
        String sql = "UPDATE " + ORDERS_TABLE_NAME + " SET user_name=user_name, order_date=order_date,  shipping_address=shipping_address , total_price=total_price , status='CLOSE'  " +
                " WHERE id=?";
        jdbcTemplate.update(sql  ,orderId );
    }

    @Override
    public void updateTotalPrice(Long orderId, Order order) {
        String sql = "UPDATE " + ORDERS_TABLE_NAME + " SET  total_price=?   " +
                " WHERE id=?";
        jdbcTemplate.update(sql,order.getTotalPrice(),orderId );
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
    @Override
    public List<Long> getAllOrdersId() {
        String sql = "SELECT id FROM " + ORDERS_TABLE_NAME ;
        try {
            return jdbcTemplate.queryForList(sql,Long.class );
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }
//    @Override
//    public List<Order> getAllOrdersByUserName(String userName) {
//        String sql = "SELECT * FROM " + ORDERS_TABLE_NAME + " WHERE user_name='?'";
//        try {
//            return jdbcTemplate.query(sql, new OrderMapper(),userName);
//        } catch (EmptyResultDataAccessException error){
//            return null;
//        }
//    }
@Override
public List<Long> getAllOrdersByUserName(String userName) {
    String sql = "SELECT id FROM " + ORDERS_TABLE_NAME + " WHERE user_name=" + userName;

    return jdbcTemplate.queryForList(sql, Long.class);
}

    @Override
    public List<Long> getAllTempOrdersByUserName(String userName) {
        String sql = "SELECT id FROM " + ORDERS_TABLE_NAME + " WHERE user_name=" + userName +"AND status='TEMP'";

        return jdbcTemplate.queryForList(sql, Long.class);
    }



    @Override
    public Long tempOrderByUserName(String userName) {
        String sql = "SELECT id FROM " + ORDERS_TABLE_NAME + " WHERE user_name=" + userName +"AND status='TEMP' ORDER BY id DESC LIMIT 1";

        return jdbcTemplate.queryForObject(sql, Long.class);
    }

    @Override
    public Long lastOrder() {
        String sql = "SELECT id FROM " + ORDERS_TABLE_NAME + " ORDER BY id DESC LIMIT 1";

        return jdbcTemplate.queryForObject(sql, Long.class);
    }
}
