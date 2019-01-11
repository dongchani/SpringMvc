package com.app.service;

import org.springframework.stereotype.Component;

@Component
public class AopService {
    @Deprecated
    public  void sing(){
       /* System.out.println(1/0);*/
        /*System.out.println("唱歌");*/
        System.out.println("sing...");
    }
    @Deprecated
    public  void talk(){
        System.out.println("talk...");
    }
}
