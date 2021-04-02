/*
 * UserController.java
 * -------------------
 * 
 * This file is a REST controller, which manages the flow of data into model objects and updates
 * the view whenever data changes. It keeps the view and model separate.
 * 
 */

package com.meritamerica.userlist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.userlist.models.User;
import com.meritamerica.userlist.repositories.UserRepository;

//import net.javaguides.springboot.model.User;
//import net.javaguides.springboot.repository.UserRepository;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("users")
    public List < User > getUsers() {
        return this.userRepository.findAll();
    }
}
