package com.chunking.feignconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author <a href="mailto:kingdom2232@sina.com">Jonas Wang</a>
 * @date 2018-12-21 22:49
 */
@FeignClient(value = "HELLO-SERVICE")
public interface RefactorHelloService extends com.chunking.api.service.HelloService {
}
