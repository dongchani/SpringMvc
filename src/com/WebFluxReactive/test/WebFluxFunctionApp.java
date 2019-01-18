package com.WebFluxReactive.test;
import com.WebFluxReactive.handle.PersonHandler;


import reactor.netty.http.server.HttpServer;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

public class WebFluxFunctionApp {
    public static void main(String[] args) throws IOException{
        HttpServer.create().port(6060).handle(new ReactorHttpHandlerAdapter(toHttpHandler
                (route(accept(APPLICATION_JSON_UTF8).and(GET("/id/{id}"))
                        ,PersonHandler::list)))).bind().block();
                              System.in.read();

    }
}
