package com.ShoppingWebsiteApplication.repository.mapper;


import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.Order;
import com.ShoppingWebsiteApplication.model.OrderStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Order(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getDate("order_date").toLocalDate(),
                rs.getString("shipping_address"),
                rs.getDouble("total_price"),
                OrderStatus.valueOf(rs.getString("status")),
                new Long[]{rs.getLong("items_id")}

               //getItemIds(rs.getArray("items"))
//                (Item[]) rs.getArray("items").getArray()
//                rs.getLong("item_id")
//                (Item[]) rs.getArray("items").getArray()
//                rs.getArray("item_id")
//             new Long[]{rs.getLong("item_id")}
        );


    }
//    private Item[] getItemIds(Array itemArray) throws SQLException{
//         if (itemArray != null){
//             ResultSet itemResultSet =  itemArray.getResultSet();
//             List<Long> itemIds = new ArrayList<Long>();
//             while (itemResultSet.next()){
//
//                 itemIds.add(itemResultSet.getLong(1));
//                 itemIds.add(itemResultSet.getString(2));
//                 itemIds.add(itemResultSet.getDouble(3));
//                 itemIds.add(itemResultSet.getLong(4));
//                 itemIds.add(itemResultSet.getLong(5));
//                 itemIds.add(itemResultSet.getLong(6));
//                 itemIds.add(itemResultSet.getLong(7));
//                 itemIds.add(itemResultSet.getLong(8));
//             }
//             Item[] items = new Item[itemIds.size()];
//             for (int i=0; i< itemIds.size(); i++)
//                 items[i].setId(itemIds.get(i));
//             return items;
//         }
//         return new Item[0];
//     }
    }

