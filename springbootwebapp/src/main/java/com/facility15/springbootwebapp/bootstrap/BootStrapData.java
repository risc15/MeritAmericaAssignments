/*
 * This file bootstraps some data into an in-memory database.
 * 
 * We use dependency injection
 */

package com.facility15.springbootwebapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.facility15.springbootwebapp.models.Author;
import com.facility15.springbootwebapp.models.Book;
import com.facility15.springbootwebapp.models.Publisher;
import com.facility15.springbootwebapp.repositories.AuthorRepository;
import com.facility15.springbootwebapp.repositories.BookRepository;
import com.facility15.springbootwebapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {
	
	// Class Attributes:
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	// Constructors:
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}
	
	// Methods:

	@Override
	public void run(String... args) throws Exception {
		// Here, we will initialize some books and authors:
		
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "123123");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development Without EJB", "456456");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		ddd.setIsbn("9791234567891");
		noEJB.setIsbn("9790987654321");
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		authorRepository.save(eric);
		bookRepository.save(ddd);
		// Create a publisher:
		
		Publisher koolBooks = new Publisher();
		koolBooks.setAddress("123 Business Ave");
		koolBooks.setPublisherName("Kool Books");
		koolBooks.setCity("That One City");
		koolBooks.setState("Not Texas");
		koolBooks.setZipCode(12345);
		publisherRepository.save(koolBooks);
		
		// Add publisher to books:
		ddd.setPublisher(koolBooks);
		noEJB.setPublisher(koolBooks);
		koolBooks.getBooks().add(ddd);
		koolBooks.getBooks().add(noEJB);
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(koolBooks);
		authorRepository.save(eric);
		bookRepository.save(ddd);
		publisherRepository.save(koolBooks);

		System.out.println("Started in Bootstrap.");
		System.out.println("Number of books: " + bookRepository.count());
		System.out.println("Number of publishers: " + publisherRepository.count());
		System.out.println("Number of books for publisher: " + koolBooks.getBooks().size());
		
		
	}

}
