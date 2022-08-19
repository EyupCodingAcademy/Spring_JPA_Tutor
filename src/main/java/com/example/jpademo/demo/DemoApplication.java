package com.example.jpademo.demo;

import com.example.jpademo.demo.Domain.Book;
import com.example.jpademo.demo.Domain.Category;
import com.example.jpademo.demo.Repository.BookRepository;
import com.example.jpademo.demo.Repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BookRepository bookRepository,
										CategoryRepository categoryRepository) {
		return args -> {
			Category c = new Category("Fantasy");
			categoryRepository.save(c);

			Book book = new Book(
					"Guards! Guards!",
					"Sam Vimes is the Captain of the night watch",
					c);
			bookRepository.save(book);
		};
	}
}
