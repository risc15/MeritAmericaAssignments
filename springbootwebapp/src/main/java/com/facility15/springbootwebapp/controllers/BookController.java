/*
 *  The book controller takes in HTTP requests specific to books.
 *  
 *  This differs from the Merit Bank App since that only returned
 *  JSON to be processed by React.
 *  
 *  In this case, 
 */


package com.facility15.springbootwebapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.facility15.springbootwebapp.models.Book;
import com.facility15.springbootwebapp.repositories.BookRepository;

@Controller
public class BookController {
	
	// Attributes:
	
	private final BookRepository bookRepository;
	
	// Constructor:
	
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	// Methods:
	
	@RequestMapping("/books")
	public String getBooks(Model model) {
	//public Iterable<Book> getBooks(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "books/list";
		//return bookRepository.findAll();
	}
	
	@PostMapping(value = "/books", consumes="application/json", produces="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Book addBook(@RequestBody Book book) {
		bookRepository.save(book);
		return book;
	}
}
