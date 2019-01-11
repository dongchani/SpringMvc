package com.Web.Controller.AsyncController.Event;

import com.Web.Controller.AsyncController.Event.DeferedResultEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.ConcurrentLinkedDeque;
@Component
public class ListenerEvent {
    @Async
    @EventListener

    public  void handleResult(DeferedResultEvent deferredResult) {
        System.out.println("handler currentThred:"+Thread.currentThread().getName());
        Object source =deferredResult.getSource();
        if (source instanceof ConcurrentLinkedDeque){
            /*线程安全的队列*/
            ConcurrentLinkedDeque<DeferredResult> results=(ConcurrentLinkedDeque<DeferredResult>)source;
            /*调用这个poll方法  获取并移除集合的头部元素  （:为了解决集合的资源浪费）*/
            DeferredResult deferredResult1 =results.poll();
            /*在其他线程里设置deferredResult的值*/
            deferredResult1.setResult("test");
        }
    }
}
