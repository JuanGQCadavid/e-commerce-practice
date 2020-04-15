package com.ecommercepractice.authentication.exception;

public enum ErrorType {
    EMAILALREADYUSED    ("EmailAlreadyUsedException"),
    EMAILNOTFOUND       ("EmailNotFoundException"),
    INVALIDPASSWORD     ("InvalidUserPasswordException"),
    MISSINGFIELDS       ("MissingFieldsBody"),
    EXPIREDTOKEN        ("ExpiredUserTokenException"),
    INVALIDTOKEN        ("InvalidUserTokenException"),
    TOKENNOFOUND        ("TokenNotFoundException")
    ;
    private final String label;

    ErrorType(String label){
        this.label = label;
    }

    public String getLabel(){
        return this.label;
    }
}
