package com.library.controllers;

import com.library.models.Book;
import com.library.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private Service service;

    @GetMapping("/findAll")
    public Collection<Book> getAllBooks(){
        return service.findAllBooks();
    }

    @GetMapping("/delete")
    public void deleteBook(@RequestParam long id){
        service.delete(id);
    }
}
