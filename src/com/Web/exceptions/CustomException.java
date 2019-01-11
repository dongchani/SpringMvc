package com.Web.exceptions;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("出错了....");
        request.setAttribute("error",ex);
        ModelAndView modelAndView = new ModelAndView("error");
        return modelAndView;
    }
}
