package com.restapi.RESTAPI;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    @Cacheable("helloCache")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello, Spring Boot REST API!", HttpStatus.OK);
    }
}
