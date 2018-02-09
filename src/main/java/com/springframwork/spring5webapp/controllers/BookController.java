package com.springframwork.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springframwork.spring5webapp.repositories.BookRepository;

@Controller
public class BookController {

	private BookRepository bookRepository;
	
	public BookController(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@RequestMapping("/books")
	private String getBooks(Model model) {
		
		model.addAttribute("attbooks", bookRepository.findAll());
		
		return "books";
	}
}
