package com.facility15.springbootwebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.facility15.springbootwebapp.models.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
