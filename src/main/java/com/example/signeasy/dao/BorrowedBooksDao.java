package com.example.signeasy.dao;

import com.example.signeasy.Entity.BorrowedBooks;
import com.example.signeasy.pojo.BorrowPojo;

/**
 * Created by vaishakhnr on 10/19/17.
 */
public interface BorrowedBooksDao {
	Long getBorrowBookQuantity(long bookId);

	Long getBorrowBookQuantityByMember(long bookId, long memberId);

	void updateBorrowBook(BorrowPojo borrowPojo);

	BorrowedBooks getBorrowBook(long bookId, long memeberId);

	void updateBorrowBook(BorrowedBooks borrowedBooks);
}
