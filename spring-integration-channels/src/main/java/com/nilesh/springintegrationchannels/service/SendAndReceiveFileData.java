package com.nilesh.springintegrationchannels.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;
import org.springframework.messaging.MessageChannel;

import java.io.File;

@Configuration
@EnableIntegration
public class SendAndReceiveFileData {

    @Autowired
    public MessageChannel inputChannel;

    //public String FILE_PATTERN = "testFile.txt";


    @Bean
    @InboundChannelAdapter(value = "inputChannel", poller = @Poller(fixedDelay = "1000"))
    /*Inbound adapters, as we have seen, are used to bring in messages from the external system (in this case a filesystem directory).
    Our inbound adapter configuration consists of:
    An @InboundChannelAdapter annotation that marks the bean configuration as an adapter — we configure the channel to which the adapter will feed its messages (in our case, an MPEG file) and a poller, a component which helps the adapter poll the configured folder at the specified interval
    A standard Spring java configuration class that returns a FileReadingMessageSource, the Spring Integration class implementation that handles filesystem polling
            Outbound adapters are used to send messages outwards. Spring Integration supports a large variety of out-of-the-box adapters for various common use cases.
    */
    public FileReadingMessageSource fileReader()
    {
        FileReadingMessageSource fileReadingMessageSource = new FileReadingMessageSource();
        fileReadingMessageSource.setDirectory(new File("source"));
        //fileReadingMessageSource.setFilter(new SimplePatternFileListFilter(FILE_PATTERN));
        return fileReadingMessageSource;
    }

    @Bean
    @ServiceActivator(inputChannel = "inputChannel")
    /*The Service Activator is any POJO that defines the @ServiceActivator annotation on a given method. This allows us to execute any method on our POJO when a message is received from an inbound channel, and it allows us to write messages to an outward channel.
    In our example, our service activator receives a file from the configured input channel and writes it to the configured folder.*/
    public FileWritingMessageHandler fileWriter()
    {
        FileWritingMessageHandler fileWritingMessageHandler = new FileWritingMessageHandler(new File("destination"));
        fileWritingMessageHandler.setExpectReply(false);
        return fileWritingMessageHandler;
    }
}
