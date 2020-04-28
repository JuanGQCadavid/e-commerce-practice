package com.ecommercepractice.authentication.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Tuple of key value [key,Value], it is used when sending
 * the invalid fields onto the user.
 * @param <T>
 * @param <G>
 */
@Getter
@AllArgsConstructor
@ToString
public class Pair<T,G>  {
    private T key;
    private G value;
}
