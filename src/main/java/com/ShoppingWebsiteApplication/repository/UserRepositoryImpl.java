package com.ShoppingWebsiteApplication.repository;

import com.ShoppingWebsiteApplication.model.CustomUser;
import com.ShoppingWebsiteApplication.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserRepositoryImpl implements UserRepository {


    private static final String USER_TABLE_NAME = "user";


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void createUser(CustomUser customUser) {
        String sql = "INSERT INTO " + USER_TABLE_NAME + " (first_name,  last_name, email,username, password,  phone, country,city,active ,roles, permissions) VALUES (?, ?, ?, ?,?, ?, ?,?, ? ,?,?)";
        jdbcTemplate.update(sql, customUser.getFirstName(), customUser.getLastName(), customUser.getEmail(), customUser.getUsername(), customUser.getPassword(), customUser.getPhone(), customUser.getAddr()[0], customUser.getAddr()[1], 0, customUser.getRoles(), customUser.getPermissions());
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
    public Boolean userStatus(String userName) {
        String sql = "SELECT active FROM " + USER_TABLE_NAME + " WHERE username=" + userName;
        return jdbcTemplate.queryForObject(sql, Boolean.class);
    }

    @Override
    public Long getUserId(String userName) {
        String sql = "SELECT id FROM " + USER_TABLE_NAME + " WHERE username='" + userName + "'";
        return jdbcTemplate.queryForObject(sql, Long.class);
    }

    @Override
    public CustomUser getUserById(Long userId) {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserMapper(), userId);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }


    @Override
    public void deleteUserById(Long userId) {
        String sql = "DELETE FROM " + USER_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public void deleteUserByName(String userName) {
        String sql = "DELETE FROM " + USER_TABLE_NAME + " WHERE username=?";
        jdbcTemplate.update(sql, userName);
    }


    @Override
    public void updateUser(CustomUser customUser, String userName) {
        String sql = "UPDATE " + USER_TABLE_NAME + " SET   active=?" +
                " WHERE username=?";
        jdbcTemplate.update(sql, customUser.getActive(), userName);
    }


    @Override
    public List<CustomUser> getAllUsers() {
        String sql = "SELECT * FROM " + USER_TABLE_NAME;
        try {
            return jdbcTemplate.query(sql, new UserMapper());
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }


}





