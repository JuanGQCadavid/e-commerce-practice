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
    public int insertUser(User user) {
        DB.add(user);
        return 1;
    }

    @Override
    public List<User> selectAllUsers() {
        return DB;
    }

    @Override
    public Optional<User> selectUserByUserName(String user_name) {
        return DB.stream()
                .filter(user -> user.getUsername().equals(user_name))
                .findFirst();
    }

    @Override
    public int updateUserbyUserName(String user_name, User user) {
        return selectUserByUserName(user_name)
                .map(user1 -> {
                    int indexOfUserToUpdate = DB.indexOf(user1);
                    if(indexOfUserToUpdate >= 0){
                        DB.set(indexOfUserToUpdate,user);
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }).orElse(0);
    }

    @Override
    public int deleteUserbyUserName(String user_name) {
        Optional<User> userMaybe = selectUserByUserName(user_name);

        if(!userMaybe.isPresent()){
            return 1;
        }

        DB.remove(userMaybe.get());
        return 0;
    }
}
