package com.example.signeasy.dao.impl;

import com.example.signeasy.Entity.BorrowedBooks;
import com.example.signeasy.dao.BorrowedBooksDao;
import com.example.signeasy.pojo.BorrowPojo;
import com.example.signeasy.repository.BorrowedBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vaishakhnr on 10/19/17.
 */
@Component
@Transactional
public class BorrowedBooksImpl implements BorrowedBooksDao {
	@Autowired
	private BorrowedBooksRepository borrowedBooksRepository;

	@Override
	public Long getBorrowBookQuantity(long bookId) {
		List<BorrowedBooks> borrowedBooks = borrowedBooksRepository.findAllByBookIdAndReturned(bookId, false);
		if (borrowedBooks == null) return 0L;
		else return (long) borrowedBooks.size();
	}

	@Override
	public Long getBorrowBookQuantityByMember(long bookId, long memberId) {
		List<BorrowedBooks> borrowedBooks = borrowedBooksRepository.findAllByBookIdAndMemberIdAndReturned(bookId, memberId, false);
		if (borrowedBooks == null) return 0L;
		else return (long) borrowedBooks.size();
	}

	@Override
	public void updateBorrowBook(BorrowPojo borrowPojo) {
		BorrowedBooks borrowedBooks = new BorrowedBooks();
		borrowedBooks.setBookId(borrowPojo.getBookId());
		borrowedBooks.setMemberId(borrowPojo.getBookId());
		borrowedBooksRepository.save(borrowedBooks);
	}

	@Override
	public BorrowedBooks getBorrowBook(long bookId, long memeberId) {
		return borrowedBooksRepository.findFirstByBookIdAndMemberIdAndReturned(bookId, memeberId, false);
	}

	@Override
	public void updateBorrowBook(BorrowedBooks borrowedBooks) {
		borrowedBooksRepository.save(borrowedBooks);
	}
}
