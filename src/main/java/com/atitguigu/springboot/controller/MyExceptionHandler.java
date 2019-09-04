package com.atitguigu.springboot.controller;

import com.atitguigu.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 研发部吴超军
 * @version 1.0
 * @date 2019/7/12 10:12
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<String, Object> handleException(Exception e){

        Map<String ,Object> map = new HashMap<>();
        map.put("code","usernotexist");
        map.put("message",e.getMessage());
        return map;
    }

}