package com.ecommercepractice.authentication.util;

import lombok.Getter;

/**
 * Tuple of key value [key,Value], it is used when sending
 * the invalid fields onto the user.
 * @param <T>
 * @param <G>
 */
@Getter
public class Pair<T,G>  {
    private T key;
    private G value;

    public Pair(T key, G value){
        this.key = key;
        this.value = value;
    }

}
