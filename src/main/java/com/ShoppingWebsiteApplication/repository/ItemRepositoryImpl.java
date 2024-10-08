package com.ShoppingWebsiteApplication.repository;

import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.repository.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public class ItemRepositoryImpl implements ItemRepository {

    private static final String ITEM_TABLE_NAME = "item";

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public Long createItem(Item item) {
        String sql = "INSERT INTO " + ITEM_TABLE_NAME + " (title, price,in_stock, picture_url , liked , cart) VALUES ( ?,? ,?, ?,? , ? , ?)";
        jdbcTemplate.update(sql, item.getTitle(), item.getPrice(), item.getInStock(), item.getPictureUrl(), item.getLiked(), item.getCart());
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }


    @Override
    public Item getItemById(Long itemId) {
        String sql = "SELECT * FROM " + ITEM_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new ItemMapper(), itemId);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public Double getItemPriceById(Long itemId) {
        String sql = "SELECT price FROM " + ITEM_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, Double.class, itemId);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public Long getItemQuantityById(Long itemId) {
        String sql = "SELECT in_stock FROM " + ITEM_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, Long.class, itemId);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }


    @Override
    public void deleteItemById(Long itemId) {
        String sql = "DELETE FROM " + ITEM_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, itemId);
    }

    @Override
    public void updateItem(Item item, Long itemId) {
        String sql = "UPDATE " + ITEM_TABLE_NAME + " SET title=?, price=? , in_stock=?  ,   picture_url=? , liked=? , cart=? " +
                " WHERE id=?";
        jdbcTemplate.update(sql, item.getTitle(), item.getPrice(), item.getInStock(), item.getPictureUrl(), item.getLiked(), item.getCart(), item.getId());
    }

    @Override
    public void updateItemQuantity(Long itemId) {
        String sql = "UPDATE " + ITEM_TABLE_NAME + " SET  in_stock=(in_stock-1) " +
                " WHERE id=?";
        jdbcTemplate.update(sql, itemId);
    }

    @Override
    public void incItemQuantitys(Long itemId, Long quantity) {
        String sql = "UPDATE " + ITEM_TABLE_NAME + " SET  in_stock=(in_stock+" + quantity + ") " +
                " WHERE id=?";
        jdbcTemplate.update(sql, itemId);
    }

    @Override
    public void decItemQuantity(Long itemId) {
        String sql = "UPDATE " + ITEM_TABLE_NAME + " SET  in_stock=(in_stock-1) " +
                " WHERE id=?";
        jdbcTemplate.update(sql, itemId);
    }

    @Override
    public void incItemQuantity(Long itemId) {
        String sql = "UPDATE " + ITEM_TABLE_NAME + " SET  in_stock=(in_stock+1) " +
                " WHERE id=?";
        jdbcTemplate.update(sql, itemId);
    }


    @Override
    public List<Item> getAllItems() {
        String sql = "SELECT * FROM " + ITEM_TABLE_NAME;
        try {
            return jdbcTemplate.query(sql, new ItemMapper());
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }


}
