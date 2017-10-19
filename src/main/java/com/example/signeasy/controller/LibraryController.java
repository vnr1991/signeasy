package com.example.signeasy.controller;

import com.example.signeasy.Entity.BorrowedBooks;
import com.example.signeasy.pojo.BaseResponse;
import com.example.signeasy.pojo.BorrowPojo;
import com.example.signeasy.service.LibraryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vaishakhnr on 10/18/17.
 */
@Slf4j
@RestController
@RequestMapping("/library")
public class LibraryController {
	@Autowired
	LibraryService libraryService;

	@RequestMapping(
			value = "/borrow",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse borrow(@RequestBody BorrowPojo borrowPojo) {
		try {
			if (!libraryService.borrowBook(borrowPojo)) {
				return new BaseResponse(1, "validation failed", null);
			}
			return new BaseResponse(0, "Success", null);
		} catch (Exception e) {
			log.error("Exception in borrow book {}", e);
			return new BaseResponse(1, "Failure", null);
		}
	}

	@RequestMapping(
			value = "/return",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse returnBook(@RequestBody BorrowPojo borrowPojo) {
		try {
			if (!libraryService.returnBook(borrowPojo)) {
				return new BaseResponse(1, "validation failed", null);
			}
			return new BaseResponse(0, "Success", null);
		} catch (Exception e) {
			log.error("Exception in borrow book {}", e);
			return new BaseResponse(1, "Failure", null);
		}
	}

}
