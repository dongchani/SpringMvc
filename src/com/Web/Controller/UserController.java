package com.Web.Controller;

import com.app.dao.UsersDao;
import com.commons.entity.User;
import org.omg.Dynamic.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@CrossOrigin/*加上注解可以访问    默认就禁止访问（不加注解更具有安全性）*/
    public class UserController {
        private Logger logger =LoggerFactory.getLogger(UserController.class);
        @Autowired
        private UsersDao usersDao;

/**
 * BindingResult针对javabean的属性验证，来确保属性的合法性 代表本次的验证结果（例如：登录为空的时候设置属性不能为空）
 */
    @RequestMapping("/Tologinpage")
        public String login(@Valid User user, BindingResult bindingResult, ModelMap modelMap, HttpSession httpSession) {

            if (bindingResult.hasErrors()){
             String msg=   bindingResult.getFieldError().getDefaultMessage();
             modelMap.put("msg",msg);
             return "login";
            }

              if ("admin".equals(user.getUserName())&&"123".equals(user.getUserPassword())){
                httpSession.setAttribute("user",user);
                return "index";
            }
            return "login";

        }
    /**
     * /user必须登录才能访问的路径
     * @return
     */
    @GetMapping("/user/home")
    public String home(){
        return "index";
    }

    @GetMapping("/tologin")
    public  String tologin(){
    /*    System.out.println(1/0);*/
        return "login";
    }
    /**
     * @CookieValue取cooke的值,
     * ,defaultValue=""不存在 就用默认的值
     *
     */
 /*   @GetMapping("/login")
    public  String Cookie(@CookieValue(name = "JSESSIONID")String cookie, Model model){
        System.out.println("cookie.....");
        model.addAttribute("sss",cookie);
        return "login";
    }*/
}
