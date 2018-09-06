package com.library.controllers;

import com.library.models.Book;
import com.library.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private Service service;

    @GetMapping(value = "/")
    public String hello(){
        return "Hello world!";
    }

    @GetMapping("/findAll")
    public Collection<Book> getAllBooks(){
        return service.findAllBooks();
    }
}
