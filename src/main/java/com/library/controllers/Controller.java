package com.library.controllers;

import com.library.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/")
    public String init(HttpServletRequest request){
        request.setAttribute("books", service.findAllBooks());
        request.setAttribute("mode", "BOOK_VIEW");
        return "index";
    }

    @GetMapping("/update")
    public String init(@RequestParam long id, HttpServletRequest request){
        request.setAttribute("book", service.findOne(id));
        request.setAttribute("mode", "BOOK_EDIT");
        return "index";
    }

}
