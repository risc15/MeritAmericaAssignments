package com.facility15.springbootwebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.facility15.springbootwebapp.models.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
