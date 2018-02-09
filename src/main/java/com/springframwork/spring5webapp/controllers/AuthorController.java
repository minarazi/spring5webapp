package com.springframwork.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springframwork.spring5webapp.repositories.AuthorRepository;

@Controller
public class AuthorController {
	private AuthorRepository authorRepository;

	public AuthorController(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}

	@RequestMapping("/authors")
	private String getauthors(Model model) {

		model.addAttribute("attauthors", authorRepository.findAll());

		return "authors";
	}

}
