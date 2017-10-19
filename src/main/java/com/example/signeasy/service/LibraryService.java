package com.example.signeasy.service;

import com.example.signeasy.Entity.Book;
import com.example.signeasy.Entity.BorrowedBooks;
import com.example.signeasy.Entity.Member;
import com.example.signeasy.dao.BookDao;
import com.example.signeasy.dao.BorrowedBooksDao;
import com.example.signeasy.dao.MemberDao;
import com.example.signeasy.pojo.BaseResponse;
import com.example.signeasy.pojo.BorrowPojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vaishakhnr on 10/18/17.
 */
@Slf4j
@Service
public class LibraryService {
	@Autowired
	MemberDao memberDao;

	@Autowired
	BookDao bookDao;

	@Autowired
	BorrowedBooksDao borrowedBooksDao;

	@Transactional
	public boolean borrowBook(BorrowPojo borrowPojo) {
		if (validateRequest(borrowPojo, false)) {
			updateBorrowBook(borrowPojo);
			return true;
		}
		return false;
	}

	@Transactional
	public boolean returnBook(BorrowPojo borrowPojo) {
		if (validateRequest(borrowPojo, true)) {
			updateReturnBook(borrowPojo);
			return true;
		}
		return false;
	}


	private boolean validateRequest(BorrowPojo borrowPojo, boolean isReturning) {
		return borrowPojo.getQuantity() > 0 && validateMember(borrowPojo.getMemberId()) &&
				validateBook(borrowPojo, borrowPojo.getQuantity(), isReturning);
	}

	private boolean validateMember(long memberId) {
		Member member = memberDao.getMember(memberId);
		return member != null && member.isSubscribed();
	}

	private boolean validateBook(BorrowPojo borrowPojo, long borrowRequestQuantity, boolean isReturning) {
		Book book = bookDao.getBook(borrowPojo.getBookId());
		return book != null && validateBookQuantity(borrowPojo, book, isReturning);
	}

	private boolean validateBookQuantity(BorrowPojo borrowPojo, Book book, boolean isReturning) {
		Long borrowedBookQuantity = borrowedBooksDao.getBorrowBookQuantity(book.getId());
		if (!isReturning) return (book.getQuantity() - borrowedBookQuantity) >= borrowPojo.getQuantity();
		borrowedBookQuantity = borrowedBooksDao.getBorrowBookQuantityByMember(book.getId(), borrowPojo.getMemberId());
		log.info("borrowed books {} {} {}", borrowedBookQuantity, isReturning, borrowPojo.getQuantity());
		return borrowedBookQuantity >= borrowPojo.getQuantity();
	}

	private void updateBorrowBook(BorrowPojo borrowPojo) {
		for (int i = 0; i < borrowPojo.getQuantity(); i++) {
			borrowedBooksDao.updateBorrowBook(borrowPojo);
		}
	}

	private void updateReturnBook(BorrowPojo borrowPojo) {
		for (int i = 0; i < borrowPojo.getQuantity(); i++) {
			BorrowedBooks borrowedBooks = borrowedBooksDao.getBorrowBook(borrowPojo.getBookId(), borrowPojo.getMemberId());
			borrowedBooks.setReturned(true);
			borrowedBooksDao.updateBorrowBook(borrowedBooks);
		}
	}
}
