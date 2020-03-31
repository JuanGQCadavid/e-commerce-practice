package com.ecommercepractice.userservice.dao;

import com.ecommercepractice.userservice.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserDao {

    User insertUser(User user);
    List<User> selectAllUsers();
    Optional<User> selectUserByUserName(String userId);
    User updateUserbyUserName(String userId, User user);
    User deleteUserbyUserName(String userId);

}
