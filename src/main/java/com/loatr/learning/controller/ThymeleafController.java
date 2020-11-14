package com.loatr.learning.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {

    @RequestMapping("/learnJs")
    public String getLearnJs(){
        return "learnJs";
    }

}
