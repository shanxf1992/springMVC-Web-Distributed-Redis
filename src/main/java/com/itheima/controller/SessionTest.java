package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("spring")
public class SessionTest {

    @RequestMapping("doSession")
    public void doSession(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        session.setAttribute("name", "zhangsan");

    }

    @RequestMapping("getSession")
    @ResponseBody
    public String getSession(HttpServletRequest request, HttpServletResponse response) {

        return (String) request.getSession().getAttribute("name");
    }
}
