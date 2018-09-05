package com.library.controllers;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController

public class RestController {

    @GetMapping(value = "/")
    public String hello(){
        return "Hello world!";
    }
}
