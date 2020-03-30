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
public class UserControlle {
    private final UserService userService;

    @Autowired
    public UserControlle(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@RequestBody User user){
        log.info("USER | POST  { " +user.toString() + "}");
        userService.addUser(user);
    }

    @GetMapping
    public List<User> getAllUser(){
        log.info("USER | GET ALL");
        return userService.getAllusers();
    }

    //api/v1/user/:user_name
    @GetMapping(path = "{user_id}")
    public User getUserByUserName(@PathVariable("user_id") String user_id){
        log.info("USER | GET | USER_ID  { " + user_id + "}");
        return userService.getUserbyUserName(user_id)
                .orElse(null);
    }
    @DeleteMapping(path = "{user_id}")
    public void deleteUser(@PathVariable("user_id") String user_id){
        log.info("USER | DELETE | USER_ID  { " + user_id + "}");
        userService.deleteUser(user_id);
    }


    @PutMapping(path = "{user_id}")
    public void updateUser(@PathVariable("user_id") String user_id, @RequestBody User user){
        log.info("USER | PUT | USER_ID  { " + user_id +  "  - USER {" + user.toString() + "}" + "}");
        userService.updateUser(user_id,user);

    }

}
