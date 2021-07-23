package com.example.validator;

import com.example.model.MessageType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageTypeDecider {
    private static Map<MessageType, List<IValidator>> deciderMap = new HashMap<>();

    static {
        deciderMap.put(MessageType.HEXA, Arrays.asList(new HexaValueValidator()));
        deciderMap.put(MessageType.STRING, Arrays.asList(new NonNegativeValueValidator(), new NumberValueValidator()));
        deciderMap.put(MessageType.FRACTION, Arrays.asList(new FractionValueValidator()));
    }

    public static MessageType getMessageType(String value) {
        for (Map.Entry<MessageType, List<IValidator>> entry : deciderMap.entrySet()) {
            if (entry.getValue().stream().allMatch( v -> v.isValid(value))) {
                return entry.getKey();
            }
        }
        return MessageType.UNKNOWN;
    }
}
