package com.ecommercepractice.userservice.service;

import com.ecommercepractice.userservice.dao.IUserDao;
import com.ecommercepractice.userservice.exception.UserAlreadyCreatedException;
import com.ecommercepractice.userservice.exception.UserNotFoundException;
import com.ecommercepractice.userservice.models.User;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@Service
public class UserService {
    @Autowired
    @Qualifier("h2DAO")
    private IUserDao userDao;

    public User addUser(User user){
        if(userDao.findUserByEamil(user.getEmail()).isPresent()){
            throw new UserAlreadyCreatedException(user.getEmail(), user);
        }
        return userDao.insertUser(user).get();
    }

    public List<User> getAllusers(){
        return userDao.selectAllUsers();
    }

    public User getUserbyUserName(Long userId){
        return userDao.selectUserByUserId(userId).orElseThrow(() -> new UserNotFoundException(userId));
    }

    public User deleteUser(Long userId){
        return userDao.deleteUserByUserId(userId).orElseThrow(() -> new UserNotFoundException(userId));
    }

    public User updateUser(Long userId, User user){
        return userDao.updateUserByUserId(userId,user).orElseThrow(() -> new UserNotFoundException(userId));
    }
}
