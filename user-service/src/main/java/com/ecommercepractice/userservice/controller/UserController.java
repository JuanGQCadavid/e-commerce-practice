package com.ecommercepractice.userservice.controller;

import com.ecommercepractice.userservice.models.User;
import com.ecommercepractice.userservice.service.UserService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RequestMapping("api/v1/users")
@RestController
@Slf4j // Lombok
@Api(value = "User Management System",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)

@ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK -> The user has been fetched successfully"),
        @ApiResponse(code = 201, message = "OK -> The user has been created successfully"),
        @ApiResponse(code = 202, message = "Accepted -> The user has been updated successfully"),
        @ApiResponse(code = 204, message = "NO CONTENT -> The user has been removed successfully")
})
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserModelAssembler userModelAssembler;

    public HttpHeaders connectionWithOtherService(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "foo");
        return headers;
    }

    @ApiOperation(value = "CREATE a user.", response = User.class, responseContainer = "EntityModel")
    @PostMapping
    public ResponseEntity<EntityModel<User>> addUser(
            @ApiParam(name="UserData",
                    value = "Required user personal information",
                    required = true) @Valid @RequestBody User user){

        log.info(String.format("USER | POST {%s}", user.toString()));
        EntityModel<User> entityModel =  userModelAssembler.toModel(userService.addUser(user));

        return new ResponseEntity<EntityModel<User>>(entityModel, HttpStatus.CREATED);
    }

    @ApiOperation(value = "FETCH all the users on the system")
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
    @ApiOperation(value = "FETCH a user by its userId", response = User.class)
    @GetMapping(path = "{userId}")

    public ResponseEntity<EntityModel<User>> getUserByUserName(
            @ApiParam(name = "User id", value = "The user id associated to the user requested", required = true) @PathVariable("userId") Long userId){

        log.info(String.format("USER | GET | USER_ID {%s}",userId));
        EntityModel<User> entityModel = userModelAssembler.toModel(userService.getUserbyUserName(userId));

        return new ResponseEntity<EntityModel<User>>(entityModel,HttpStatus.OK);
    }

    @ApiOperation(value = "DELETE a user by its userId", response = java.lang.Void.class)
    @DeleteMapping(path = "{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity deleteUser(
            @ApiParam(name = "User id", value = "The user id associated to the user requested" , required = true) @PathVariable("userId") Long userId){

        log.info(String.format("USER | DELETE | USER_ID  {%s}",userId));
        EntityModel<User> entityModel = userModelAssembler.toModel(userService.deleteUser(userId));

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "UPDATE a user by its userId", response = User.class)
    @PutMapping(path = "{userId}")
    public ResponseEntity<EntityModel<User>> updateUser(
            @ApiParam(name = "User id", value = "The user id associated to the user requested" , required = true) @PathVariable("userId") Long userId,
            @ApiParam(name = "userData", value ="User info that are gonna be update" , required = true)@Valid @RequestBody User user){

        log.info(String.format("USER | PUT | USER_ID {%s -USER{ %s }}",userId, user.toString()));
        EntityModel<User> entityModel = userModelAssembler.toModel(userService.updateUser(userId,user));

        return new ResponseEntity<EntityModel<User>>(entityModel,HttpStatus.ACCEPTED);
    }
}
