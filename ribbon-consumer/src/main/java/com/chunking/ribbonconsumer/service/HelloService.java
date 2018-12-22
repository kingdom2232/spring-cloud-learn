package com.chunking.ribbonconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author <a href="mailto:kingdom2232@sina.com">Jonas Wang</a>
 * @date 2018-12-19 15:37
 */
@Service
public class HelloService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback", ignoreExceptions = {NullPointerException.class})
    public String helloService() {
        long start = System.currentTimeMillis();
        String result =  restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
        long end =System.currentTimeMillis();

        logger.info("Speend time : " + (end - start));
        return result;
    }

    public String helloFallback() {
        return "error";
    }
}
