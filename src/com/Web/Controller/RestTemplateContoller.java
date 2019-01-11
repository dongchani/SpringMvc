package com.Web.Controller;

import com.commons.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class RestTemplateContoller {
   @Autowired
    private  RestTemplate restTemplate;

    @RequestMapping("/nieguoxi")

    public String baidu(){
         return  restTemplate.getForObject("https://www.baidu.com",String.class);
    }
    @RequestMapping("/userTest")
    public User userTest(){
        /*getForObject发送get请求，将结果进行合适的转换*/
      User user =  restTemplate.getForObject("http://localhost:8080/tologin",User.class);
        return user;
    }
}
