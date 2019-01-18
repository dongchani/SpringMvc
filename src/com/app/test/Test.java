package com.app.test;


import com.app.Appconfig;
import com.app.service.UserService1;
import com.commons.entity.TsyMenu;
import com.commons.entity.TsyUser;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);
        UserService1 userService = applicationContext.getBean(UserService1.class);
        TsyUser tSysUser = (TsyUser) userService.loadUserByUsername("doch");
        List<TsyMenu> list = tSysUser.getHierarchicalMenu();
        System.out.println();



    }
}
