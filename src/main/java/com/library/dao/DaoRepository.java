package com.library.dao;

import com.library.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface DaoRepository extends CrudRepository<Book, Long> {
}
