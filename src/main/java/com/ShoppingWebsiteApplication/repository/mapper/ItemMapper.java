package com.ShoppingWebsiteApplication.repository.mapper;

import com.ShoppingWebsiteApplication.model.Item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemMapper implements RowMapper<Item> {

    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Item(
                rs.getLong("id"),
//                new Long[]{rs.getLong("item_id")},
                rs.getString("title"),
                rs.getDouble("price"),
                rs.getLong("in_stock"),
                rs.getLong("quantity"),
                rs.getString("picture_url"),
                rs.getBoolean("liked"),
                rs.getBoolean("cart")

        );
    }
}
