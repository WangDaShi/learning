package com.loatr.learning.controller;

import com.loatr.learning.model.Note;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
public class RestApiController {

    private Random r = new Random();
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("random/{max}")
    public Integer getRandomNumber(@PathVariable("max") int max){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return r.nextInt(max);
    }

    @PostMapping("post")
    public String receiveMsg1(@RequestBody Note note){
        logger.debug("id:{},content:{}",note.getId(),note.getContent());
        return "success";
    }

    @PostMapping("note/add")
    public String receiveMsg2(@RequestParam String content){
        logger.debug("{}",content);
        return content;
    }

}
