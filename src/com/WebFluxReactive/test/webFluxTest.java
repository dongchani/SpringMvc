package com.WebFluxReactive.test;

import com.WebFluxReactive.WebFluxConfig;
import com.app.Appconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;

public class webFluxTest {
    public static void main(String[] args) throws IOException  {
        /*获取配置文件类*/
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class,WebFluxConfig.class);
        HttpHandler httpHandler=WebHttpHandlerBuilder.applicationContext(applicationContext).build();
        /*Webflux Http处理程序适配器*/
        ReactorHttpHandlerAdapter httpHandlerAdapter = new ReactorHttpHandlerAdapter(httpHandler);
        /*创建端口号*/
        HttpServer.create().port(8080).handle(httpHandlerAdapter).bind().block();
            System.in.read();

    }
}
