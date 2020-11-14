package com.loatr.learning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class RestApiController {

    private Random r = new Random();

    @GetMapping("random/{max}")
    public Integer getRandomNumber(@PathVariable("max") int max){
        return r.nextInt(max);
    }

    @GetMapping("test")
    public String getTest(){
        return "test";
    }

}
