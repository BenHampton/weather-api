package com.weatherapi.weatherapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping(value = "/hello-world")
    public String hello() {
        return "Hello World";
    }
}
