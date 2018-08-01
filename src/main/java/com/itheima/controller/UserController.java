package com.itheima.controller;


import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class UserController {

    @Value("#{userService}")
    private UserService userService;


    @RequestMapping("register")
    public ModelAndView registerUser(User user) {
        System.out.println("进入注册... ...");
        System.out.println(user);

        ModelAndView modelAndView = new ModelAndView("regiterSuccess");
        try {
            userService.registerUser(user);
            modelAndView.addObject("msg", "注册成功, 请登陆!");

        } catch (Exception e) {
            modelAndView.addObject("msg", "注册失败, 请重新注册!");
            e.printStackTrace();
        }

        return modelAndView;
    }

}
