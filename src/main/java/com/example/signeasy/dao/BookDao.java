package com.example.signeasy.dao;

import com.example.signeasy.Entity.Book;

/**
 * Created by vaishakhnr on 10/18/17.
 */
public interface BookDao {
	void addOrUpdateBook(Book book);
	Book getBook(Long id);
	void deleteBook(Long id);
}
