package com.library.controllers;

import com.library.models.Book;
import com.library.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    public void save(@ModelAttribute Book book, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.save(book);
        request.setAttribute("books", service.findAllBooks());
        request.setAttribute("mode", "BOOK_VIEW");
        response.sendRedirect("/");
    }

    @GetMapping("/addBook")
    public String addBook(HttpServletRequest request){
        request.setAttribute("mode", "BOOK_ADD");
        return "index";
    }

    @GetMapping("/deleteBook")
    public void deleteBook(@RequestParam long id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.delete(id);
        response.sendRedirect("/");
    }




}
