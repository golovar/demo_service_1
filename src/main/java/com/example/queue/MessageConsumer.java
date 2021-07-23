package com.example.queue;

import com.example.model.BaseMessage;
import com.example.utils.UrlUtils;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.concurrent.BlockingQueue;

@Slf4j
@NoArgsConstructor
@Data
public class MessageConsumer implements Runnable{
    private BlockingQueue<BaseMessage> sharedQueue;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UrlUtils urlUtils;

    public MessageConsumer(BlockingQueue<BaseMessage> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while(true){
            try {
                BaseMessage message = sharedQueue.take();
                sendMessage(message);

                log.info(message.getMessage());
            } catch (Exception err) {
               err.printStackTrace();
            }
        }
    }

    public String sendMessage(BaseMessage message){
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlUtils.getFullURLHandleMessage());
        String result = restTemplate.postForObject(builder.toUriString(), message.getMessage(), String.class);
        return result;
    }


}