package com.ecommercepractice.userservice.dao;

import com.ecommercepractice.userservice.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserDao {

    int insertUser(User user);
    List<User> selectAllUsers();
    Optional<User> selectUserByUserName(String userId);
    int updateUserbyUserName(String userId, User user);
    int deleteUserbyUserName(String userId);

}
