package com.ecommercepractice.stockservice.util;
import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * Tuple of key value [key,Value], it is used when sending
 * the invalid fields onto the user.
 * @param <T>
 * @param <G>
 */
@Getter
@AllArgsConstructor
public class Pair<T,G>  {
    private T key;
    private G value;
}
