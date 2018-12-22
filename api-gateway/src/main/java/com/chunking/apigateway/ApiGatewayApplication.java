package com.chunking.apigateway;

import com.chunking.apigateway.filter.AccessFilter;
import com.chunking.apigateway.filter.MyErrorAttributes;
import com.chunking.apigateway.filter.MyFilterProcessor;
import com.netflix.zuul.FilterProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        FilterProcessor.setProcessor(new MyFilterProcessor());
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }

    @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        return new PatternServiceRouteMapper("^(?<name>.+)-(?<version>v.+)$",
                "${version}/${name}");
    }

    @Bean
    public MyErrorAttributes errorAttributes() {
        return  new MyErrorAttributes();
    }

}

