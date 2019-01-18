package com.WebFluxReactive.handle;

import com.commons.entity.TsyRole;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

import  static  org.springframework.http.MediaType.APPLICATION_JSON;
import  static  org.springframework.web.reactive.function.server.ServerResponse.ok;
public class PersonHandler {
    public  static  Mono<ServerResponse> list(ServerRequest request){
        TsyRole tsyRole = new TsyRole();
        tsyRole.setId(10);
        tsyRole.setRoleName("doch");
/*        request.exchange().getSession().subscribe(session->session.getAttributes().put(""));*/
        /**
         * WebSessionManager：管理规范    ->websession管理
         * exchange（）：通过这个方法来拿到session
         * session的存储 通过源码WebSessionStore
         * 默认的实现基于内存：源码：InMemoryWebSessionStore保存到Map中
         */
        request.exchange().getSession().subscribe(new Consumer<WebSession>() {
            @Override
            public void accept(WebSession webSession) {

                webSession.getAttributes().put("roles",tsyRole);
            }
        });
      /*  return   ServerResponse.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).build();*/
return ok().contentType(APPLICATION_JSON).body(Mono.just(tsyRole),TsyRole.class);
    }
 /*   public Mono<ServerResponse> createPerson(ServerRequest request) {
        // ...
    }

    public Mono<ServerResponse> getPerson(ServerRequest request) {
        // ...
    }*/

 /*   *//***
     * 用一个方法来拿到“role”
     * @param request
     * @return
     */
/* public  static  Mono<ServerResponse> getlist(ServerRequest request){
     Object sessionResult = null;
      request.exchange().getSession().subscribe(new Consumer<WebSession>() {
          @Override
          public void accept(WebSession webSession) {
              webSession.getAttribute("roles");
          }
      });
     return ok().contentType(APPLICATION_JSON).body(Mono.just(),TsyRole.class);
 }*/
}
