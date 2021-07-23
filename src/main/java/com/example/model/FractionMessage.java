package com.example.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class FractionMessage extends BaseMessage {

    public FractionMessage(String message) {
        super(message);
    }
}
