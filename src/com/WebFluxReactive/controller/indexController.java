package com.WebFluxReactive.controller;

import com.commons.entity.TsyRole;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class indexController {
    @RequestMapping("/test1")
    @ResponseBody
    public String test(){

        /*return ResponseEntity.of(Optional.of("webFlux Example"));*/
      /*  ResponseEntity responseEntity =new ResponseEntity(HttpStatus.OK);*/
        return  "test";
    }
    @RequestMapping("/toIndex")
    public  String index(Model model){
      /*  List<TsyRole> list = new ArrayList<>();*/
        TsyRole tsyRole =  new TsyRole();
        tsyRole.setRoleName("doch");
        tsyRole.setId(1);
        model.addAttribute("role",tsyRole);
        return "index";
    }
    @ModelAttribute("roles")
    public  List<TsyRole> roles(){
        return Arrays.asList(new TsyRole(1,"doch"),new TsyRole(2,"ADMIN"));
    }
}
