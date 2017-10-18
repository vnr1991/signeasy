package com.example.signeasy.service;

import com.example.signeasy.Entity.Book;
import com.example.signeasy.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vaishakhnr on 10/11/17.
 */
@Service
public class BookService {
	@Autowired
	BookDao bookDao;

	public void addBook(Book book) {
		bookDao.addOrUpdateBook(book);
	}

	public void updateBook(Book book) {
		bookDao.addOrUpdateBook(book);
	}

	public Book getBook(Long id) {
		return bookDao.getBook(id);
	}

	public void deleteBook(Long id) {
		bookDao.deleteBook(id);
	}
}
