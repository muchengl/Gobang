package com.lblog.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class IndexController {
    @RequestMapping("/index")
    public String toIndex(){
        return"index";
    }
}
