package com.ecommercepractice.userservice.service;
import com.ecommercepractice.userservice.dao.IUserDao;
import com.ecommercepractice.userservice.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    private final IUserDao userDao;

    @Autowired
    public UserService(@Qualifier("fakeDao") IUserDao userDao) {
        this.userDao = userDao;
    }

    public int addUser(User user){
        return userDao.insertUser(user);
    }
    public List<User> getAllusers(){
        return userDao.selectAllUsers();
    }

    public Optional<User> getUserbyUserName(String userId){
        return userDao.selectUserByUserName(userId);
    }

    public int deleteUser(String userId){
        return userDao.deleteUserbyUserName(userId);
    }

    public int updateUser(String userId, User user){
        return userDao.updateUserbyUserName(userId,user);
    }
}
