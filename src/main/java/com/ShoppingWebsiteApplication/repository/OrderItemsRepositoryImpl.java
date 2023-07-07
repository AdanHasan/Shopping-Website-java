package com.ShoppingWebsiteApplication.repository;

import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.Order;
import com.ShoppingWebsiteApplication.model.OrderItems;
import com.ShoppingWebsiteApplication.repository.OrderItemsRepository;
import com.ShoppingWebsiteApplication.repository.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderItemsRepositoryImpl implements OrderItemsRepository {

    private static final String ORDER_ITEMS_TABLE_NAME = "orderItems";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void createOrderItems(OrderItems orderItems) {
        for (Item item: orderItems.getItems()){
            String sql = "INSERT INTO " + ORDER_ITEMS_TABLE_NAME + " (item_id, order_id) VALUES (?,?)";
            jdbcTemplate.update(sql, item.getId(), orderItems.getOrder().getId());
        }
    }

    @Override
    public void deleteOrderItemsById(Long orderItemsId) {
        String sql = "DELETE FROM " + ORDER_ITEMS_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql,orderItemsId);
    }

    @Override
    public List<Item> getAllOrderItems(Long orderId) {
        String sql = "SELECT * FROM " + ORDER_ITEMS_TABLE_NAME + " WHERE order_id=" + orderId ;
        try{
            return jdbcTemplate.query(sql, new ItemMapper());
        }
        catch (EmptyResultDataAccessException error){
            return null;
        }
    }
}



