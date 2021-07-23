package com.example.utils;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class UrlUtils {

    @Value("${service.base.url}")
    private String baseUrl;
    @Value("${service.base.port}")
    private String basePort;
    @Value("${service.base.endpoint.handle.message}")
    private String baseEndpointHandleMessage;


    public String getFullURLHandleMessage() {
        return baseUrl.concat(basePort).concat(baseEndpointHandleMessage);
    }

}
