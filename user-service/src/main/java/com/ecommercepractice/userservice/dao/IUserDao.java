package com.ecommercepractice.userservice.dao;

import com.ecommercepractice.userservice.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserDao {
    /**
     * Store a user onto the database
     * @param user
     * @return Optional<User> if the user is created
     */
    Optional<User> insertUser(User user);

    /**
     * Fetch all the users on the DB
     * @return List<User>
     */
    List<User> selectAllUsers();

    /**
     * Find a user by its userId, if there is no such user
     * that correspond to the userId it should return
     * a Optional of empty.
     * @param userId
     * @return Optional<User> if the user exists Optional.empty if not.
     */
    Optional<User> selectUserByUserId(Long userId);

    /**
     * Fetch the user with id userId, and save it agian
     * with the information hand down by the user Object
     * but with tje userId as id.
     * @param userId
     * @param user
     * @return Optional<User> if the user exists Optional.empty if not.
     */
    Optional<User> updateUserByUserId(Long userId, User user);

    /**
     * Update the user param isActive with false
     * indicating that the user is no long active
     * on the platform.
     * @param userId
     * @return Optional<User> if the user exists Optional.empty if not.
     */
    Optional<User> deleteUserByUserId(Long userId);

    /**
     * Fetch a user by its email.
     * @param email
     * @return Optional<User> if the user exists Optional.empty if not.
     */
    Optional<User> findUserByEamil(String email);

}
