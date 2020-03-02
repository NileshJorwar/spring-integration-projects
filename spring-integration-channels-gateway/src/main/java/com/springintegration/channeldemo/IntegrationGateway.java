package com.springintegration.channeldemo;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface IntegrationGateway {
    @Gateway(requestChannel = "gatewayChannel")
    public String getMessage(String name);
}