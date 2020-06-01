package com.ecommercepractice.assemblerservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * DTO used in Service exceptions.
 */
public class ServiceFail {
    private String timeStamp;

    private String message;

    private String errorType;

    private Object payload;
}
