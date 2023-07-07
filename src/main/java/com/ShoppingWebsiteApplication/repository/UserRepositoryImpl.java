package com.ShoppingWebsiteApplication.repository;

//import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.CustomUser;
import com.ShoppingWebsiteApplication.model.Order;
import com.ShoppingWebsiteApplication.repository.mapper.OrderMapper;
import com.ShoppingWebsiteApplication.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserRepositoryImpl implements UserRepository {


    private static final String USER_TABLE_NAME = "user";

    private static final String REGISTERED_TABLE_NAME = "registered";

    @Autowired
    JdbcTemplate jdbcTemplate;



//    @Override
//    public Long createUser(User user) {
//        String sql = "INSERT INTO " + USER_TABLE_NAME + " (first_name,  last_name, email, password , phone, address  ) VALUES (?, ? , ? , ? , ? , ?)";
//        jdbcTemplate.update(sql, user.getFirstName() , user.getLastName() , user.getEmail(), user.getPassword(), user.getPhone(), user.getAddress());
//        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
//    }

    @Override
    public void createUser(CustomUser customUser) {
        String sql = "INSERT INTO " + USER_TABLE_NAME + " (first_name,  last_name, email,username, password,  phone, address,active ,roles, permissions) VALUES (?, ?, ?, ?,?, ?, ?,?, ? ,?)";
        jdbcTemplate.update(sql, customUser.getFirstName(), customUser.getLastName(), customUser.getEmail() , customUser.getUsername(), customUser.getPassword(), customUser.getPhone(), customUser.getAddress(),0, customUser.getRoles(), customUser.getPermissions());
    }

    @Override
    public CustomUser findUserByUsername(String username) {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE username=?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserMapper(), username);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }


    @Override
    public CustomUser getUserById(Long userId) {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserMapper(), userId);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }


    @Override
    public void deleteUserById(Long userId) {
        String sql = "DELETE FROM " + USER_TABLE_NAME + " WHERE id=?";
         jdbcTemplate.update(sql,userId);
    }

//    @Override
//    public void updateUser(CustomUser customUser, Long userId) {
//        String sql = "UPDATE " + USER_TABLE_NAME + " SET first_name=?, last_name=? , email=? , username=? , password=? , phone=?, address=? , active=?" +
//                " WHERE id=?";
//        jdbcTemplate.update(sql, customUser.getFirstName() , customUser.getLastName() , customUser.getEmail(), customUser.getUsername(), customUser.getPassword(), customUser.getPhone(), customUser.getAddress(),customUser.getActive(), userId);
//    }


    @Override
    public void updateUser(CustomUser customUser, String userName) {
        String sql = "UPDATE " + USER_TABLE_NAME + " SET   active=?" +
                " WHERE username=?";
        jdbcTemplate.update(sql, customUser.getActive(), userName);
    }


//    @Override
//    public void updateUser(CustomUser customUser, Long userId) {
//        String sql = "UPDATE " + REGISTERED_TABLE_NAME + " SET username=?, password=? , active=?" +
//                " WHERE id=?";
//        jdbcTemplate.update(sql, customUser.getUsername(), customUser.getPassword(), customUser.getActive(), userId);
//    }


    @Override
    public  List<CustomUser> getAllUsers() {
        String sql = "SELECT * FROM " + USER_TABLE_NAME ;
        try {
            return jdbcTemplate.query(sql, new UserMapper());
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }


}





