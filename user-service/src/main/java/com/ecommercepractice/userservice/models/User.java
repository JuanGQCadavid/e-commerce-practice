package com.ecommercepractice.userservice.models;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class User {
    private  String user_id;
    private  String first_name;
    private  String second_name;
    private  boolean is_active;
    private  String email;

}
