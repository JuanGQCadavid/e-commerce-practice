package com.ecommercepractice.userservice.service;
import com.ecommercepractice.userservice.dao.IUserDao;
import com.ecommercepractice.userservice.exception.UserNotFoundException;
import com.ecommercepractice.userservice.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    @Qualifier("fakeDao")
    private IUserDao userDao;


    public UserService() {

    }

    public User addUser(User user){
        return userDao.insertUser(user);
    }

    public List<User> getAllusers(){
        return userDao.selectAllUsers();
    }

    public User getUserbyUserName(String userId){

        return userDao.selectUserByUserName(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

    }

    public User deleteUser(String userId){
        return userDao.deleteUserbyUserName(userId);
    }

    public User updateUser(String userId, User user){
        return userDao.updateUserbyUserName(userId,user);
    }
}
