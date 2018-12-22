package com.chunking.feignconsumer.service;

import com.chunking.model.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:kingdom2232@sina.com">Jonas Wang</a>
 * @date 2018-12-21 23:25
 */
@Component
public class HelloServiceFallback implements HelloService {
    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello(String name) {
        return "error";
    }

    @Override
    public User hello(String name, Integer age) {
        return new User("unknown", 0);
    }

    @Override
    public String hello(User user) {
        return "error";
    }
}
