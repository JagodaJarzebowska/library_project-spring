package com.library.services;

import com.library.dao.DaoRepository;
import com.library.models.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
}
