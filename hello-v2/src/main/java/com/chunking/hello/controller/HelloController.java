package com.chunking.hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author <a href="mailto:kingdom2232@sina.com">Jonas Wang</a>
 * @date 2018-12-18 0:10
 */
@RestController
public class HelloController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    // @Value("${book.name}")
    // private String name;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() throws Exception{
        List<ServiceInstance> instances = client.getInstances("HELLO-V2");
        instances.forEach(instance ->
            logger.info("/hello, hose:" + instance.getHost() + ", port:" + instance.getPort())
        );
        // int sleepTime = new Random().nextInt(3000);
        // logger.info("sleepTime:" + sleepTime);
        // Thread.sleep(sleepTime);
        logger.info("hello method called!");
        return "Hello World";
    }
}
