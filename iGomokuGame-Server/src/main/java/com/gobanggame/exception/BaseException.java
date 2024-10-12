package com.gobanggame.exception;

/**
 * @program: gobanggame
 * @description: 自定义异常的基类
 **/
public class BaseException extends RuntimeException {
    public BaseException() {
    }

    public BaseException(String msg) {
        super(msg);
    }

}
