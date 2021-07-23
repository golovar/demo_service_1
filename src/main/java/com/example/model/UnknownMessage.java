package com.example.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UnknownMessage extends BaseMessage {
    public UnknownMessage(String message) {
        super(message);
    }
}
