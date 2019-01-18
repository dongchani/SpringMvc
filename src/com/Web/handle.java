package com.Web;

import com.commons.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class handle  implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        User user = (User) authentication.getPrincipal();
        request.getSession().setAttribute("","拿到的菜单");
       /* user.get*/
        /**
         * 两种实现方式
         * 第一种：在sql后加上menu and role
         * 第二种：查出的菜单放到session里
         */
        /*1.根据角色查询菜单
        * 2.查出的菜单放到session里
        * */
    }
}
