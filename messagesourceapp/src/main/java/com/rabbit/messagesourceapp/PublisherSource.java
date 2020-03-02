package com.rabbit.messagesourceapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableBinding({Source.class})

public class PublisherSource {


    Source source;

    public PublisherSource(Source source)
    {
        this.source = source;
    }

    @PostMapping(value = "/create")
    public String sendMessage(@RequestBody String payload) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        TransactionModel transactionModel = objectMapper.readValue(payload,TransactionModel.class);
        source.output().send(MessageBuilder.withPayload(transactionModel).build());
        return "Success is there !";
    }
}
