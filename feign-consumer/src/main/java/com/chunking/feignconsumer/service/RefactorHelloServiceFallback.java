// package com.chunking.feignconsumer.service;
//
// import com.chunking.model.entity.User;
// import org.springframework.stereotype.Component;
//
// /**
//  * @author <a href="mailto:kingdom2232@sina.com">Jonas Wang</a>
//  * @date 2018-12-21 22:49
//  */
// @Component
// public class RefactorHelloServiceFallback implements RefactorHelloService {
//     @Override
//     public String hello(String name) {
//         return "error";
//     }
//
//     @Override
//     public User hello(String name, Integer age) {
//         return new User("Unknown", -1);
//     }
//
//     @Override
//     public String hello(User user) {
//         return "error";
//     }
// }
