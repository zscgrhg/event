package com.example.event;

import com.example.event.beans.UserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContext;

@SpringBootApplication
@EnableAsync
public class EventApplication implements CommandLineRunner{

	@Autowired
	ApplicationEventPublisher publisher;

	public static void main(String[] args) {
		SpringApplication.run(EventApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {



		for (int i = 0; i < 100; i++) {
			System.out.println("start---"+i +"  @ "+Thread.currentThread().getName());
			publisher.publishEvent(new UserEvent("oops"+i));
			System.out.println("after ---"+i+"  @ "+Thread.currentThread().getName());
			Thread.sleep(3000);
		}
	}
}
