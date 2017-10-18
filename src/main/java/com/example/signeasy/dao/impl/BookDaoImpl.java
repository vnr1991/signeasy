package com.example.signeasy.dao.impl;

import com.example.signeasy.Entity.Book;
import com.example.signeasy.repository.BookRepository;
import com.example.signeasy.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vaishakhnr on 10/18/17.
 */
@Component
@Transactional
public class BookDaoImpl implements BookDao {
	@Autowired
	BookRepository bookRepository;

	public void addOrUpdateBook(Book book) {
		bookRepository.save(book);
	}

	public Book getBook(Long id) {
		return bookRepository.findOne(id);
	}

	public void deleteBook(Long id) {
		bookRepository.delete(id);
	}
}
