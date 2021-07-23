package com.example.demo;

import com.example.queue.MessageConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class DemoApplication {

	private static ExecutorService ces = Executors.newFixedThreadPool(2);

	@Autowired
	private MessageConsumer consumer1;

	@Autowired
	private MessageConsumer consumer2;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		ces.shutdown();
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		ces.submit(consumer1);
		ces.submit(consumer2);
	}
}