package com.example.signeasy.repository;

import com.example.signeasy.Entity.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vaishakhnr on 10/18/17.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
