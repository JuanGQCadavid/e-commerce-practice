package com.ecommercepractice.userservice.dao;


import com.ecommercepractice.userservice.models.User;
import com.ecommercepractice.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("h2DAO")
public class H2UserDataAccessRepository implements IUserDao {
    @Autowired
    UserRepository repository;

    @Override
    public Optional<User> insertUser(User user) {
        return Optional.of(repository.save(user));
    }

    @Override
    public List<User> selectAllUsers() {
        return repository.findAll();
    }

    @Override
    public Optional<User> selectUserByUserId(Long userId) {
        return repository.findById(userId);
    }

    @Override
    public Optional<User> updateUserByUserId(Long userId, User user) {
        Optional<User> oldUserOptional = repository.findById(userId);
        if(!oldUserOptional.isPresent()){
            return Optional.empty();
        }
        user.setUserId(userId);
        return Optional.of(repository.save(user));
    }

    @Override
    public Optional<User> deleteUserByUserId(Long userId) {
        Optional<User> oldUserOptional = repository.findById(userId);
        if(!oldUserOptional.isPresent()){
            return Optional.empty();
        }
        User newUser = oldUserOptional.get();
        newUser.setActive(false);
        return Optional.of(repository.save(newUser));

    }

    @Override
    public Optional<User> findUserByEamil(String email) {
        return repository.findByEmail(email);
    }
}
