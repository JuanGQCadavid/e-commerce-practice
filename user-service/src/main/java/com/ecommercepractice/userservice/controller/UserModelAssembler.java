package com.ecommercepractice.userservice.controller;

import com.ecommercepractice.userservice.models.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


/**
 * This is a class used for HATEOUS response.
 */
@Component()
public class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {


    /**
     * Creates links reponse pointing to the methods allowed
     *  by the api, indicating how can the request user proceed
     *  across the API.
     * @param User
     * @return EntityModel<user>
     */
    @Override
    public EntityModel<User> toModel(User entity) {
        return new EntityModel<>(entity,
                linkTo(methodOn(UserController.class).getUserByUserName(entity.getUserId())).withRel("GET_USER"),
                linkTo(methodOn(UserController.class).deleteUser(entity.getUserId())).withRel("DELETE_USER"),
                linkTo(methodOn(UserController.class).addUser(entity)).withRel("CREATE_USER"),
                linkTo(methodOn(UserController.class).updateUser(entity.getUserId(),entity)).withRel("UPDATE_USER")
                );
    }
}
