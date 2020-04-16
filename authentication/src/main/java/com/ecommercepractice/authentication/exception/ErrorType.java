package com.ecommercepractice.authentication.exception;

/**
 * Internal runtime exception flag.
 */
public enum ErrorType {
    EMAIL_ALREADY_USED    ("EmailAlreadyUsedException"),
    EMAIL_NOT_FOUND       ("EmailNotFoundException"),
    INVALID_PASSWORD     ("InvalidUserPasswordException"),
    MISSING_FIELDS       ("MissingFieldsBody"),
    EXPIRED_TOKEN        ("ExpiredUserTokenException"),
    INVALID_TOKEN        ("InvalidUserTokenException"),
    TOKEN_NO_FOUND        ("TokenNotFoundException")
    ;
    private final String label;

    ErrorType(String label){
        this.label = label;
    }

    public String getLabel(){
        return this.label;
    }
}
