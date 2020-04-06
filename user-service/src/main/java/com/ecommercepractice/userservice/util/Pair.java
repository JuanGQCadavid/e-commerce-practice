package com.ecommercepractice.userservice.util;

import lombok.Getter;

@Getter
public class Pair <T,G>  {
    private T key;
    private G value;

    public Pair(T key, G value){
        this.key = key;
        this.value = value;
    }

}
