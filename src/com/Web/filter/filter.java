package com.Web.filter;

import com.commons.entity.TsyUser;
import org.springframework.security.config.annotation.AbstractConfiguredSecurityBuilder;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.openid.OpenIDLoginConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
@Component
public class filter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest re=(HttpServletRequest)  servletRequest;
        HttpServletResponse response =(HttpServletResponse) servletResponse;
               String name= re.getParameter("name");
                 if("abcd".equals(name)){
                     filterChain.doFilter(servletRequest, servletResponse);
                   /*  response.sendRedirect("/login");*/
                 //  servletRequest.getRequestDispatcher("/login").forward(servletRequest, servletResponse);
                 }else {
                   //  response.sendRedirect("errorlogin");
                     servletRequest.getRequestDispatcher("/errorlogin").forward(servletRequest, servletResponse);
                    // response.sendRedirect("/login");
                 }


    }
}

