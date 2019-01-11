package com.Web.Globalcontrool;

import com.Web.Controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(basePackages = "com.Web.Globalcontrool")

public class Globalcontrrol extends ResponseEntityExceptionHandler{
    private Logger logger =LoggerFactory.getLogger(UserController.class);
    /**
     * 异常处理的方法
     */
    @ExceptionHandler(RuntimeException.class)
    public String ExceptionHandler(){
        logger.warn("出错了");
        return "error";
    }

}
