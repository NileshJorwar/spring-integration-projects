package com.nilesh.springintegrationchannels.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
public class ChannelConfig {

    @Bean
    public MessageChannel inputChannel()
    {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel outputChannel()
    {
        return new DirectChannel();
    }

}
