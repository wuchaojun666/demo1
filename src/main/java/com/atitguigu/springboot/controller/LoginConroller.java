package com.atitguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author 研发部吴超军
 * @version 1.0
 * @date 2019/7/8 9:19
 */
@Controller
public class LoginConroller {

    //    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            //登陆成功,防止表单重新 重定向
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else{
            //登陆失败
            map.put("msg","用户名密码错误");
            return "login.html";
        }
    }

}