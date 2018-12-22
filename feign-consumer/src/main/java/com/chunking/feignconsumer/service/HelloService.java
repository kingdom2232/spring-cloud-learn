package com.chunking.feignconsumer.service;

import com.chunking.model.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author <a href="mailto:kingdom2232@sina.com">Jonas Wang</a>
 * @date 2018-12-21 19:45
 */
@FeignClient(value = "HELLO-SERVICE", fallback = HelloServiceFallback.class) //,
        //configuration = DisableHystrixConfiguration.class)
public interface HelloService{

    @RequestMapping("hello")
    String hello();

    @RequestMapping(value = "hello1", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "hello2", method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "hello3", method = RequestMethod.POST)
    String hello(@RequestBody User user);


}
