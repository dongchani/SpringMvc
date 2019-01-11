package com.Web.Controller;

import com.app.dao.UsersDao;
import com.commons.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController{

    @Autowired
    private UsersDao usersDao;

    @RequestMapping("/test")/*地址栏的输入=>HandlerMapping处理*/
    /*方法的参数=》handlerMethod处理*/
    public String test(User user) {/*执行的方法交给HandlerAdapter处理*/
        usersDao.user();
        //出现的异常交给HandlerExceptionResolver进行处理
     return "index";/*视图的前缀=> （ViewResolver 逻辑视图名）*/
    }


    @GetMapping("/login")
    public  String login(){
        return "login";
    }
    @PostMapping("/errorlogin")
    public  String login1(){
        return "login";
    }



    @RequestMapping("/Toindex1")
    public  String toindex(){
        return "index";
    }


    //getPrincipal能传到页面上去
    //getDetails   debug看值

    @RequestMapping("/admin/Toadmin")
    public  String admin(Model model){
     Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
     model.addAttribute("user",authentication.getPrincipal());
        return "admin";
    }



    /* @Override
     *//*书上继承AbstractController*//*
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("hello,SpringMvc");
        *//*既包含视图信息 也包含模型数据信息  index是逻辑视图的名称，由于示例不需要返回模型数据，故Model为空*//*
        return new ModelAndView("index");
    }*/
}

/*  */
