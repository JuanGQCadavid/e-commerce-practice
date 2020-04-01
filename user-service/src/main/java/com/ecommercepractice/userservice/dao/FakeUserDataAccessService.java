package com.ecommercepractice.userservice.dao;

import com.ecommercepractice.userservice.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fakeDao")
public class FakeUserDataAccessService implements IUserDao {
    private static List<User> DB = new ArrayList<User>();

    @Override
    public User insertUser(User user) {
        DB.add(user);
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        return DB;
    }

    @Override
    public Optional<User> selectUserByUserName(String userId) {
        return DB.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst();
    }

    @Override
    public User updateUserbyUserName(String userId, User user) {
        return selectUserByUserName(userId)
                .map(user1 -> {
                    int indexOfUserToUpdate = DB.indexOf(user1);
                    if(indexOfUserToUpdate >= 0){
                        DB.set(indexOfUserToUpdate,user);
                        return DB.get(indexOfUserToUpdate);
                    }
                    else{
                        return null;
                    }
                }).orElse(null);
    }

    @Override
    public User deleteUserbyUserName(String userId) {
        Optional<User> userMaybe = selectUserByUserName(userId);
        if(!userMaybe.isPresent()){
            return null;
        }
        userMaybe.get().setActive(false);
        return updateUserbyUserName(userId,userMaybe.get());
    }
}
