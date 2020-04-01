package com.ecommercepractice.userservice.controller;

import com.ecommercepractice.userservice.models.User;
import com.ecommercepractice.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RequestMapping("api/v1/user")
@RestController
@Slf4j // Lombok
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("userModelAss")
    private UserModelAssembler userModelAssembler;

    public UserController() {

    }

    public HttpHeaders connectionWithOtherService(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "foo");

        return headers;
    }


    @PostMapping
    public ResponseEntity<EntityModel<User>> addUser(@Valid @RequestBody User user){

        log.info(String.format("USER | POST {%s}", user.toString()));
        EntityModel<User> entityModel =  userModelAssembler.toModel(userService.addUser(user));

        return new ResponseEntity<EntityModel<User>>(entityModel, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<User>>> getAllUser(){
        log.info("USER | GET ALL");

        CollectionModel<EntityModel<User>> collectionModel =
                new CollectionModel<EntityModel<User>>(
                        userService.getAllusers()
                            .stream()
                            .map(user -> {
                                    return userModelAssembler.toModel(user);
                            })
                            .collect(Collectors.toList()));
        return new ResponseEntity<CollectionModel<EntityModel<User>>>(collectionModel, HttpStatus.OK);
    }

    //api/v1/user/:user_name
    @GetMapping(path = "{userId}")
    public ResponseEntity<EntityModel<User>> getUserByUserName(@PathVariable("userId") String userId){

        log.info(String.format("USER | GET | USER_ID {%s}",userId));
        EntityModel<User> entityModel = userModelAssembler.toModel(userService.getUserbyUserName(userId).get());

        return new ResponseEntity<EntityModel<User>>(entityModel,HttpStatus.OK);
    }

    @DeleteMapping(path = "{userId}")
    public ResponseEntity<EntityModel<User>> deleteUser(@PathVariable("userId") String userId){

        log.info(String.format("USER | DELETE | USER_ID  {%s}",userId));
        EntityModel<User> entityModel = userModelAssembler.toModel(userService.deleteUser(userId));

        return new ResponseEntity<EntityModel<User>>(entityModel,HttpStatus.OK);
    }


    @PutMapping(path = "{userId}")
    public ResponseEntity<EntityModel<User>> updateUser(@PathVariable("userId") String userId,@Valid @RequestBody User user){

        log.info(String.format("USER | PUT | USER_ID {%s -USER{ %s }}",userId, user.toString()));
        EntityModel<User> entityModel = userModelAssembler.toModel(userService.updateUser(userId,user));

        return new ResponseEntity<EntityModel<User>>(entityModel,HttpStatus.ACCEPTED);
    }

}
