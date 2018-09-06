package com.library.controllers;

import com.library.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/")
    public String init(HttpServletRequest request){
        request.setAttribute("books", service.findAllBooks());
        return "index";
    }
}
