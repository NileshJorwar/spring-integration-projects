package com.springintegration.channeldemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nilesh/springintegration")
public class Controller {

    @Autowired
    private IntegrationGateway integrationGateway;
    @GetMapping("/channels/{name}")
    public String getMessage(@PathVariable String name)
    {
     return integrationGateway.getMessage(name);
    }

}
