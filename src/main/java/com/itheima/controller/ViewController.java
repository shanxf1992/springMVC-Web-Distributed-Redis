package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@Controller
@RequestMapping("view")
public class ViewController {

    @RequestMapping("{pageName}")
    public String tansfor(@PathVariable("pageName") String pageName) {

        return pageName;
    }

}
