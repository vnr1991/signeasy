package com.example.signeasy.repository;

import com.example.signeasy.Entity.BorrowedBooks;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by vaishakhnr on 10/19/17.
 */
public interface BorrowedBooksRepository extends CrudRepository<BorrowedBooks, Long> {
	/*
	find list of borrowed books of particular bookId that has been returned or not returned.
	 */
	List<BorrowedBooks> findAllByBookIdAndReturned(Long bookId, boolean returned);

	List<BorrowedBooks> findAllByBookIdAndMemberIdAndReturned(Long bookId, Long memberId, boolean returned);

	BorrowedBooks findFirstByBookIdAndMemberIdAndReturned(Long bookId, Long memberId, boolean returned);
}
