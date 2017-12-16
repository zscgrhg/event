package com.example.event.beans;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ListenerRegister {
    @EventListener
    @Order(3)
    public void processUserEvent(UserEvent event) throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("            on event->" + event.getSource() + "  @ " + Thread.currentThread().getName());
    }

    @EventListener
    @Order(4)
    @Async
    public void processUserEvent(ApplicationEvent event) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("            on any event-> " + event.getSource() + "  @ " + Thread.currentThread().getName());
    }
}
