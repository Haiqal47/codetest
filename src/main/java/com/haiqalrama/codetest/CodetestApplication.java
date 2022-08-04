package com.haiqalrama.codetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class CodetestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodetestApplication.class, args);
    }

    @Bean
    public ErrorAttributes errorAttributes() {
        return new DefaultErrorAttributes() {
            @Override
            public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
                Map<String, Object> defaultErrorAttributes = super.getErrorAttributes(webRequest, options);
                Map<String, Object> responseAttributes = new HashMap<>();
                responseAttributes.put("data", null);
                responseAttributes.put("status", defaultErrorAttributes.getOrDefault("status", 500));
                responseAttributes.put("message", defaultErrorAttributes
                        .getOrDefault("error", "Internal Server Error"));
                return responseAttributes;
            }
        };
    }

}
