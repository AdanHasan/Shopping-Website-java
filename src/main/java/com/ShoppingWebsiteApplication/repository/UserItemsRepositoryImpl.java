package com.ShoppingWebsiteApplication.repository;


import com.ShoppingWebsiteApplication.model.UserItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserItemsRepositoryImpl implements UserItemsRepository {
    private static final String USER_ITEMS_TABLE_NAME = "userItems";

    @Autowired
    JdbcTemplate jdbcTemplate;

//    @Override
//    public void createUserItems(UserItems userItems) {
//        for (Long itemId: userItems.getItems()){
//            String sql = "INSERT INTO " + USER_ITEMS_TABLE_NAME + " (item_id, user_id) VALUES (?,?)";
//            jdbcTemplate.update(sql, itemId, userItems.getUserId());
//        }
//    }

//    @Override
//    public void createUserItems(UserItems userItems) {
//        for (Long itemId: userItems.getItems()){
//            String sql = "INSERT INTO " + USER_ITEMS_TABLE_NAME + " (item_id, user_name) VALUES (?,?)";
//            jdbcTemplate.update(sql, itemId, userItems.getUserName());
//        }
//    }

    @Override
    public void createUserItems(UserItems userItems) {

        for (Long itemId : userItems.getItems()) {
            String sql = "INSERT INTO " + USER_ITEMS_TABLE_NAME + " (item_id,   user_name) VALUES (?,?)";

                jdbcTemplate.update(sql, itemId, userItems.getUserName());

        }
    }

//    @Override
//    public void deleteUserItemsById(Long userItemsId) {
//        String sql = "DELETE FROM " + USER_ITEMS_TABLE_NAME + " WHERE id=?";
//        jdbcTemplate.update(sql,userItemsId);
//
//    }

    @Override
    public void deleteUserItem(String userName,Long ItemId) {
        String sql = "DELETE FROM " + USER_ITEMS_TABLE_NAME + " WHERE user_name=? AND item_id=?";
        jdbcTemplate.update(sql,userName,ItemId);
    }

    @Override
    public void deleteUserItemsByUserName(String userName) {
        String sql = "DELETE FROM " + USER_ITEMS_TABLE_NAME + " WHERE user_name=?";
        jdbcTemplate.update(sql,userName);
    }

//    @Override
//    public List<Long> getAllUserItems(Long userId) {
//        String sql = "SELECT item_id FROM " + USER_ITEMS_TABLE_NAME + " WHERE user_id=" + userId ;
//        try{
//            return jdbcTemplate.queryForList(sql, Long.class);
//        }
//        catch (EmptyResultDataAccessException error){
//            return null;
//        }
//    }


    @Override
    public List<Long> getAllUserItems(String userName) {
        String sql = "SELECT item_id FROM " + USER_ITEMS_TABLE_NAME + " WHERE user_name=" + userName ;
        try{
            return jdbcTemplate.queryForList(sql, Long.class);
        }
        catch (EmptyResultDataAccessException error){
            return null;
        }
    }
    @Override
    public List<String> getAllUserNames() {
        String sql = "SELECT distinct user_name FROM " + USER_ITEMS_TABLE_NAME ;

        try {
            return jdbcTemplate.queryForList(sql,String.class);
        } catch (EmptyResultDataAccessException error){
            return null;
        }    }
}