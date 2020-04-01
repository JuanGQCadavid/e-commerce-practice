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
    public Optional<User> insertUser(User user) {
        System.out.println("Desde inser -> " + user);
        Optional<User> checkedUser = selectUserByUserName(user.getUserId());

        if (checkedUser.isPresent()){
            return Optional.empty();
        }

        DB.add(user);
        return Optional.of(user);
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
    public Optional updateUserbyUserName(String userId, User user) {

        return selectUserByUserName(userId)
                .map(userFound -> {
                    int indexOfUserToUpdate = DB.indexOf(userFound);
                    if(indexOfUserToUpdate >= 0){
                        DB.set(indexOfUserToUpdate,user);
                        return Optional.of(DB.get(indexOfUserToUpdate));
                    }
                    else{
                        return  Optional.empty();
                    }
                }).orElse(Optional.empty());
    }

    @Override
    public Optional deleteUserbyUserName(String userId) {
        Optional<User> userMaybe = selectUserByUserName(userId);
        if(!userMaybe.isPresent()){
            return Optional.empty();
        }
        userMaybe.get().setActive(false);

        return updateUserbyUserName(userId,userMaybe.get());
    }
}
