package com.ecommercepractice.userservice.controller;

import com.ecommercepractice.userservice.models.User;
import com.ecommercepractice.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/user")
@RestController
public class UserControlle {
    private final UserService userService;

    @Autowired
    public UserControlle(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllusers();
    }

    //api/v1/user/:user_name
    @GetMapping(path = "{username}")
    public User getUserByUserName(@PathVariable("username") String user_name){
        return userService.getUserbyUserName(user_name)
                .orElse(null);
    }
    @DeleteMapping(path = "{username}")
    public void deleteUser(@PathVariable("username") String user_name){
        userService.deleteUser(user_name);
    }


    @PutMapping(path = "{username}")
    public void updateUser(@PathVariable("username") String user_name, @RequestBody User user){
        userService.updateUser(user_name,user);

    }

}
