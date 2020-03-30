package com.ecommercepractice.userservice.controller;

import com.ecommercepractice.userservice.models.User;
import com.ecommercepractice.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/user")
@RestController
@Slf4j // Lombok
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@RequestBody User user){
        log.info(String.format("USER | POST {%s}", user.toString()));
        userService.addUser(user);
    }

    @GetMapping
    public List<User> getAllUser(){
        log.info("USER | GET ALL");
        return userService.getAllusers();
    }

    //api/v1/user/:user_name
    @GetMapping(path = "{userId}")
    public User getUserByUserName(@PathVariable("userId") String userId){
        log.info(String.format("USER | GET | USER_ID {%s}",userId));
        return userService.getUserbyUserName(userId)
                .orElse(null);
    }
    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") String userId){
        log.info(String.format("USER | DELETE | USER_ID  {%s}",userId));
        userService.deleteUser(userId);
    }


    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") String userId, @RequestBody User user){
        log.info(String.format("USER | PUT | USER_ID {%s -USER{ %s }}",userId, user.toString()));
        userService.updateUser(userId,user);

    }

}
