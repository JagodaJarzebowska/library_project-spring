package com.library.controllers;

import com.library.models.Book;
import com.library.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), false));
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Book book, BindingResult bindingResult, HttpServletRequest request){
        service.save(book);
        book = null;
        request.setAttribute("books", null);
        request.setAttribute("books", service.findAllBooks());
        request.setAttribute("mode", "BOOK_VIEW");
        return "index";
    }

}
