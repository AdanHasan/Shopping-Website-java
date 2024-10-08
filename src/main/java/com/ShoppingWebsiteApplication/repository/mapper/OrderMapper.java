package com.ShoppingWebsiteApplication.repository.mapper;

import com.ShoppingWebsiteApplication.model.Order;
import com.ShoppingWebsiteApplication.model.OrderStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class OrderMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Order(
                rs.getLong("id"),
                rs.getString("user_name"),
                rs.getDate("order_date").toLocalDate(),
                rs.getString("shipping_address"),
                rs.getDouble("total_price"),
                OrderStatus.valueOf(rs.getString("status"))
        );
    }
}

