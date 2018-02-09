package com.springframwork.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.springframwork.spring5webapp.model.Author;
import com.springframwork.spring5webapp.model.Book;
import com.springframwork.spring5webapp.model.Publisher;
import com.springframwork.spring5webapp.repositories.AuthorRepository;
import com.springframwork.spring5webapp.repositories.BookRepository;
import com.springframwork.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;

	private BookRepository bookRepository;

	private PublisherRepository publisherRepository;

	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.publisherRepository = publisherRepository;
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();
	}

	private void initData() {

		Publisher harchi = new Publisher("mina", "tehran");

		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234", harchi);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);

		publisherRepository.save(harchi);
		authorRepository.save(eric);
		bookRepository.save(ddd);

		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "23444", harchi);
		rod.getBooks().add(noEJB);

		authorRepository.save(rod);
		bookRepository.save(noEJB);
	}

}
