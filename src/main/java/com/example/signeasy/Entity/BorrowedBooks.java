package com.example.signeasy.Entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by vaishakhnr on 10/19/17.
 */
@Entity
@Data
@Table(name = "borrowed_books")
public class BorrowedBooks {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") private Long id;
	@Column(name = "member_id") private Long memberId;
	@Column(name = "book_id") private Long bookId;
	@Column(name = "returned") private boolean returned = false;
}
