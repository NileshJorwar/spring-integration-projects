package com.springintegration.channeldemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

@EnableIntegration
@Configuration
@IntegrationComponentScan
public class Config {

    @Bean
    public MessageChannel receiverChannel()
    {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel replyChannel()
    {
        return new DirectChannel();
    }
}
