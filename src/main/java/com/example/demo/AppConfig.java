package com.example.demo;

import com.example.model.BaseMessage;
import com.example.queue.MessageConsumer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Configuration
public class AppConfig {
    @Bean
    public BlockingQueue<BaseMessage> sharedQueue() {
        return new ArrayBlockingQueue<>(100);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
       return builder.build();
    }

    @Bean
    @Scope("prototype")
    public MessageConsumer messageConsumer(BlockingQueue<BaseMessage> sharedQueue) {
        return new MessageConsumer(sharedQueue);
    }

}