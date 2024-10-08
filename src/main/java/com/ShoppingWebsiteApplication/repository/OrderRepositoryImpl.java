package com.ShoppingWebsiteApplication.repository;

import com.ShoppingWebsiteApplication.model.Order;
import com.ShoppingWebsiteApplication.model.OrderStatus;
import com.ShoppingWebsiteApplication.repository.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private static final String ORDERS_TABLE_NAME = "orders";

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public Long createOrder(Order order) {
        String sql = "INSERT INTO " + ORDERS_TABLE_NAME + " (user_name , order_date,  shipping_address , total_price , status   ) VALUES ( ?, ?, ? , ? , ? )";
        jdbcTemplate.update(sql, order.getUserName(), order.getOrderDate(), "No Address", 0.0, "TEMP");
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }


    @Override
    public Order getOrderById(Long orderId) {
        String sql = "SELECT * FROM " + ORDERS_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new OrderMapper(), orderId);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public OrderStatus getOrderStatusById(Long orderId) {
        String sql = "SELECT status FROM " + ORDERS_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, OrderStatus.class, orderId);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public String geUserNameById(Long orderId) {
        String sql = "SELECT user_name FROM " + ORDERS_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, String.class, orderId);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public void deleteOrderById(Long orderId) {
        String sql = "DELETE FROM " + ORDERS_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, orderId);
    }

    @Override
    public void deleteOrderByUserName(String userName) {
        String sql = "DELETE FROM " + ORDERS_TABLE_NAME + " WHERE user_name=? ";
        jdbcTemplate.update(sql, userName);
    }


    @Override
    public void updateOrderShippingAddress(Long orderId, Order order) {
        String sql = "UPDATE " + ORDERS_TABLE_NAME + " SET   shipping_address=? " +
                " WHERE id=? AND status='TEMP'";
        jdbcTemplate.update(sql, order.getShippingAddress(), orderId);
    }

    @Override
    public void updateOrderStatus(Long orderId) {
        String sql = "UPDATE " + ORDERS_TABLE_NAME + " SET user_name=user_name, order_date=order_date,  shipping_address=shipping_address , total_price=total_price , status='CLOSE'  " +
                " WHERE id=?";
        jdbcTemplate.update(sql, orderId);
    }

    @Override
    public void updateTotalPrice(Long orderId, Order order) {
        String sql = "UPDATE " + ORDERS_TABLE_NAME + " SET  total_price=?   " +
                " WHERE id=?";
        jdbcTemplate.update(sql, order.getTotalPrice(), orderId);
    }


    @Override
    public List<Order> getAllOrders() {
        String sql = "SELECT * FROM " + ORDERS_TABLE_NAME;
        try {
            return jdbcTemplate.query(sql, new OrderMapper());
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public List<Long> getAllOrdersId() {
        String sql = "SELECT id FROM " + ORDERS_TABLE_NAME;
        try {
            return jdbcTemplate.queryForList(sql, Long.class);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public List<Long> getAllOrdersByUserName(String userName) {
        String sql = "SELECT id FROM " + ORDERS_TABLE_NAME + " WHERE user_name=" + userName;

        return jdbcTemplate.queryForList(sql, Long.class);
    }

    @Override
    public List<Long> getAllTempOrdersByUserName(String userName) {
        String sql = "SELECT id FROM " + ORDERS_TABLE_NAME + " WHERE user_name=" + userName + "AND status='TEMP'";

        return jdbcTemplate.queryForList(sql, Long.class);
    }


    @Override
    public Long tempOrderByUserName(String userName) {
        String sql = "SELECT id FROM " + ORDERS_TABLE_NAME + " WHERE user_name=" + userName + "AND status='TEMP' ORDER BY id DESC LIMIT 1";

        return jdbcTemplate.queryForObject(sql, Long.class);
    }

    @Override
    public Long lastOrder() {
        String sql = "SELECT id FROM " + ORDERS_TABLE_NAME + " ORDER BY id DESC LIMIT 1";

        return jdbcTemplate.queryForObject(sql, Long.class);
    }
}
