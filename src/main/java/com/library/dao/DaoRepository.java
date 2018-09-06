package com.library.dao;

import com.library.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoRepository extends CrudRepository<Book, Long> {
}
