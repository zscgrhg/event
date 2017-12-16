package com.example.event.beans;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ListenerRegister {
    @EventListener
    public void processUserEvent(UserEvent event) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("            on event->" + event.getSource() + "  @ " + Thread.currentThread().getName());
    }

    @EventListener
    @Async
    public void processUserEvent(ApplicationEvent event) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("            on any event-> " + event.getSource() + "  @ " + Thread.currentThread().getName());
    }
}
