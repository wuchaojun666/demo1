package com.atitguigu.springboot.exception;

/**
 * @author 研发部吴超军
 * @version 1.0
 * @date 2019/7/12 9:48
 */
public class UserNotExistException extends RuntimeException{

    public UserNotExistException() {
        super("用户不存在");
    }
}