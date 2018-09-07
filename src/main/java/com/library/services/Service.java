package com.library.services;

import com.library.dao.DaoRepository;
import com.library.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private DaoRepository daoRepository;

    public Collection<Book> findAllBooks(){
        List<Book> books =  new ArrayList<>();
        for (Book book : daoRepository.findAll()) {
            books.add(book);
        }
        return books;
    }

    public void delete(long id){
        daoRepository.deleteById(id);
    }

    public Book  findOne(long id){
        return daoRepository.findById(id).orElse(null);
    }

    public void save(Book book){
        daoRepository.save(book);
    }


}
