package com.ecommercepractice.userservice.controller;

import com.ecommercepractice.userservice.models.User;
import com.ecommercepractice.userservice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation(value = "CREATE a user.", response = User.class, responseContainer = "EntityModel")
    @PostMapping
    public ResponseEntity<EntityModel<User>> addUser(
            @ApiParam(name="User",value = "Required user personal information", required = true) @Valid @RequestBody User user){
        log.info(String.format("USER | POST {%s}", user.toString()));
        EntityModel<User> entityModel =  userModelAssembler.toModel(userService.addUser(user));
        return new ResponseEntity(entityModel, HttpStatus.CREATED);
    }

    @ApiOperation(value = "FETCH all the users on the system")
    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<User>>> getAllUser(){
        log.info("USER | GET ALL");
        CollectionModel<EntityModel<User>> collectionModel = new CollectionModel<EntityModel<User>>(userService.getAllusers()
                            .stream()
                            .map(user -> {
                                    return userModelAssembler.toModel(user);
                            })
                            .collect(Collectors.toList()));
        return new ResponseEntity(collectionModel, HttpStatus.OK);
    }

    //api/v1/user/:user_name
    @ApiOperation(value = "FETCH a user by its userId", response = User.class)
    @GetMapping(path = "{userId}")

    public ResponseEntity<EntityModel<User>> getUserByUserName(
            @ApiParam(name = "User id", value = "The user id associated to the user requested", required = true) @PathVariable("userId") Long userId){
        log.info(String.format("USER | GET | USER_ID {%s}",userId));
        EntityModel<User> entityModel = userModelAssembler.toModel(userService.getUserbyUserName(userId));
        return new ResponseEntity(entityModel,HttpStatus.OK);
    }

    @ApiOperation(value = "DELETE a user by its userId", response = java.lang.Void.class)
    @DeleteMapping(path = "{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity deleteUser(
            @ApiParam(name = "User id", value = "The user id associated to the user requested" , required = true) @PathVariable("userId") Long userId){
        log.info(String.format("USER | DELETE | USER_ID  {%s}",userId));
        userModelAssembler.toModel(userService.deleteUser(userId));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "UPDATE a user by its userId", response = User.class)
    @PutMapping(path = "{userId}")
    public ResponseEntity<EntityModel<User>> updateUser(
            @ApiParam(name = "User id", value = "The user id associated to the user requested" , required = true) @PathVariable("userId") Long userId,
            @ApiParam(name = "User", value ="User info that are gonna be update" , required = true)@Valid @RequestBody User user){
        log.info(String.format("USER | PUT | USER_ID {%s -USER{ %s }}",userId, user.toString()));
        EntityModel<User> entityModel = userModelAssembler.toModel(userService.updateUser(userId,user));
        return new ResponseEntity(entityModel,HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "FETCH a user by its userId", response = User.class)
    @GetMapping(path = "/email/{userEmail:.+}")
    public ResponseEntity<EntityModel<User>> getUserByEmail(
            @ApiParam(name = "User id", value = "The user id associated to the user requested", required = true) @PathVariable("userEmail") String userEmail){
        log.info(String.format("USER | GET | USER_ID {%s}",userEmail));
        EntityModel<User> entityModel = userModelAssembler.toModel(userService.getUserByEmail(userEmail));
        return new ResponseEntity(entityModel,HttpStatus.OK);
    }
}
