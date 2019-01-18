package com.WebFluxReactive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class indexController {
    @RequestMapping("/test1")
    @ResponseBody
    public String test(){

        /*return ResponseEntity.of(Optional.of("webFlux Example"));*/
      /*  ResponseEntity responseEntity =new ResponseEntity(HttpStatus.OK);*/
        return  "test";
    }
}
