package com.springintegration.channeldemo;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class Service {
    @ServiceActivator(inputChannel = "gatewayChannel")
    public void anotherMessageToSendBack(Message<String> incomingMessage)
    {
        MessageChannel replyChannel1 = (MessageChannel) incomingMessage.getHeaders().getReplyChannel();
        MessageBuilder.fromMessage(incomingMessage);
        Message<String> returningMessage = MessageBuilder.withPayload("Welcome to Spring Integration Dear Mr. "+incomingMessage.getPayload()).build();
        replyChannel1.send(returningMessage);
    }
}
