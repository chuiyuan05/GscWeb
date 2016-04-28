package com.woaigsc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by chuiyuan on 16-4-20.
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/hello" , method = RequestMethod.GET)
    public String printHello(ModelMap modelMap){
        modelMap.addAttribute("msg","hello spring mvc");
        System.out.println("in printHello");
        return  "hello";
    }
}
