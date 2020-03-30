package com.ecommercepractice.userservice.dao;

import com.ecommercepractice.userservice.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserDao {

    int insertUser(User user);
    List<User> selectAllUsers();

    Optional<User> selectUserByUserName(String user_name);
    int updateUserbyUserName(String user_name, User user);
    int deleteUserbyUserName(String user_name);
}
