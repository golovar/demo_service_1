package com.example.controller;

import com.example.handler.MessageHandler;
import com.example.model.BaseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private MessageHandler messageHandler;

    @GetMapping("/sendMessage")
    public String sendMessage(@RequestParam(value = "message", defaultValue = "") String message) {
        BaseMessage baseMessage = messageHandler.handleMessage(message);

        return String.format(baseMessage.getMessage());
    }
}
