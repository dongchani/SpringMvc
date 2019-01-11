package com.Web.Controller.AsyncController;


import com.Web.Controller.AsyncController.Event.DeferedResultEvent;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.ConcurrentLinkedDeque;
@CrossOrigin/*跨域*/
@RestController
public class AsyncController  {

    @RequestMapping("/async")
    public String async1() throws InterruptedException{
        System.out.println("准备进行耗时操作....");
        Thread.sleep(15000);
         return "async";
    }





    /*访问多个线程   线程队列  返回值对象是DeferredResult*/
    private ConcurrentLinkedDeque<DeferredResult> results = new ConcurrentLinkedDeque <>();

    private WebApplicationContext webApplicationContext;

    public AsyncController(WebApplicationContext webApplicationContext ){
        this.webApplicationContext=webApplicationContext;
    }

    /**
     * DeferredResult 工作原理：
     *
     * 1.控制器返回 DeferredResult并将其保存在可以访问它的某个内存中队列或集合中。
     *
     * 2.Spring MVC调用servlet3.0规范中那个request.startAsync()。
     *
     * 3.同时，DispatcherServlet所有已配置的过滤器都会退出请求处理线程，但响应仍保持打开状态。
     * （前端控制器终止当前的请求与过滤器，响应仍然开放）
     *
     * 4.应用程序DeferredResult从某个线程设置，转发  Spring MVC将请求调度回Servlet容器。
     * （当其他线程设置好DeferredResult值以后，请求会再一次转发到相同的路径)
     *
     * 5.将DispatcherServlet被再次调用，并且处理与异步生产返回值恢复。
     * （通过异步的结果进行一次重复的处理）
     * @return
     */

    @RequestMapping("/result")//会请求两次
    public DeferredResult<String> quotes() {
        //点餐
        System.out.println("handler currentThred:"+Thread.currentThread().getName());
        DeferredResult<String> Result = new DeferredResult<>();
        // Save the deferredResult somewhere.. 1.保存延迟结果  2.发布一个异步事件 前台记录

        results.addFirst(Result);
        /*发布者*/
        webApplicationContext.publishEvent(new DeferedResultEvent(results));
        return Result;
    }

}
