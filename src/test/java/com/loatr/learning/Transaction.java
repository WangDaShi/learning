package com.loatr.learning;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Transaction {

    private String id;
    private LocalDateTime now;
    private Integer num;
    
    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

    public LocalDateTime getNow(){
        return this.now;
    }

    public void setNow(LocalDateTime now){
        this.now = now;
    }

    public Integer getNum(){
        return this.num;
    }

    public void setNum(Integer num){
        this.num = num;
    }
}
