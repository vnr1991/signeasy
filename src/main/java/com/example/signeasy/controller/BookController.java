package com.example.signeasy.controller;

import com.example.signeasy.Entity.Book;
import com.example.signeasy.pojo.BaseResponse;
import com.example.signeasy.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

/**
 * Created by vaishakhnr on 10/11/17.
 */
@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bookService;

	@RequestMapping(
			value = "/add",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse addBook(@RequestBody Book book) {
		log.info("addBook request {}", book);
		try {
			bookService.addBook(book);
			return new BaseResponse(0, "Success", null);
		} catch (Exception e) {
			log.error("exception in addBook {}", e);
			return new BaseResponse(1, "Failure", null);
		}
	}

	@RequestMapping(
			value = "/update",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse updateBook(@RequestBody Book book) {
		log.info("updateBook request {}", book);
		try {
			bookService.updateBook(book);
			return new BaseResponse(0, "Success", null);
		} catch (Exception e) {
			log.error("exception in updateBook {}", e);
			return new BaseResponse(1, "Failure", null);
		}
	}

	@RequestMapping(
			value = "/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse getBook(@PathVariable(value = "id") Long id) {
		log.info("getBook request {}", id);
		try {
			Book book = bookService.getBook(id);
			if (book == null) {
				return new BaseResponse(0, "Book not found", null);
			}
			return new BaseResponse(0, "Success", book);
		} catch (Exception e) {
			log.error("exception in getBook {}", e);
			return new BaseResponse(1, "Failure", null);
		}
	}

	@RequestMapping(
			value = "/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse deleteBook(@PathVariable(value = "id") Long id) {
		log.info("deleteBook request {}", id);
		try {
			bookService.deleteBook(id);
			return new BaseResponse(0, "Success", null);
		} catch (Exception e) {
			log.error("exception in deleteBook {}", e);
			return new BaseResponse(1, "Failure", null);
		}
	}
}
