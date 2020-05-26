package com.dianer.aspectj;

/**
 * @program: dianer-study
 * @description:
 * @author: dianer
 * @create: 2020-05-26 21:05
 **/
public class CacheLockException extends RuntimeException {

    public CacheLockException() {
        super();
    }

    public CacheLockException(String message) {
        super(message);
    }

}
