package com.ecommercepractice.userservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private  String username;
    private  String first_name;
    private  String second_name;
    private  boolean is_active;
    private  String email;

    public User(@JsonProperty("username") String username,
                @JsonProperty("first_name") String first_name,
                @JsonProperty("second_name") String second_name,
                @JsonProperty("is_active") boolean is_active,
                @JsonProperty("email") String email) {

        this.username = username;
        this.first_name = first_name;
        this.second_name = second_name;
        this.is_active = is_active;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public String getEmail() {
        return email;
    }
}
