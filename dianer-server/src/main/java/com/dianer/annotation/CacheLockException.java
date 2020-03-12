package com.dianer.annotation;

/**
 * @program: root
 * @description:
 * @author: dianer
 * @create: 2020-03-07 14:19
 **/
public class CacheLockException extends RuntimeException {

    public CacheLockException(String message) {
        super(message);
    }
}
