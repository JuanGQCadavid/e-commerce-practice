package com.ecommercepractice.userservice.dao;

import com.ecommercepractice.userservice.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserDao {

    Optional<User> insertUser(User user);
    List<User> selectAllUsers();
    Optional<User> selectUserByUserId(Long userId);
    Optional<User> updateUserByUserId(Long userId, User user);
    Optional<User> deleteUserByUserId(Long userId);
    Optional<User> findUserByEamil(String email);

}
