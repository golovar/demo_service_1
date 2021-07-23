package com.example.handler;

import com.example.model.BaseMessage;
import com.example.model.FractionMessage;
import com.example.model.HexaMessage;
import com.example.model.StringMessage;
import com.example.model.UnknownMessage;
import com.example.validator.MessageTypeDecider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;

@Slf4j
@Service
public class MessageHandler {
    @Autowired
    private BlockingQueue<BaseMessage> sharedQueue;

    public BaseMessage handleMessage(String value) {
        BaseMessage message = null;

        switch (MessageTypeDecider.getMessageType(value)) {
            case HEXA:
                message = new HexaMessage(value);
                message.handleMessage(sharedQueue, message);
                break;
            case STRING:
                message = new StringMessage(value);
                message.handleMessage(sharedQueue, message);
                break;
            case FRACTION:
                message = new FractionMessage(value);
                message.handleMessage(sharedQueue, message);
                break;
            case UNKNOWN:
                message = new UnknownMessage(value);
                log.info(message.getMessage());
                break;
        }
        return message;
    }
}
