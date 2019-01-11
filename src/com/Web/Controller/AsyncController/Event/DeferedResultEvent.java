package com.Web.Controller.AsyncController.Event;

import org.springframework.context.ApplicationEvent;

/**
 * 定义一个事件（延期事件）
 */
public class DeferedResultEvent extends ApplicationEvent {
    public DeferedResultEvent(Object source) {
        super(source);
    }
}
