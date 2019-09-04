package com.atitguigu.springboot.controller;

import com.atitguigu.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @author 研发部吴超军
 * @version 1.0
 * @date 2019/7/4 15:23
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@PathVariable("user") String user) {
        if("aaa".equals(user))
            throw  new UserNotExistException();
        return "helloworld";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));

        return "success";
    }
}