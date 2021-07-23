package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.BlockingQueue;

@Data
@AllArgsConstructor
public abstract class BaseMessage {
    private String message;

    public void handleMessage(BlockingQueue<BaseMessage> sharedQueue, BaseMessage message) {
        sharedQueue.add(message);
    }
}
