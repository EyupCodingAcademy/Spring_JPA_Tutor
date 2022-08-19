package com.example.jpademo.demo.Service;

import com.example.jpademo.demo.Domain.Book;
import com.example.jpademo.demo.Domain.Category;
import com.example.jpademo.demo.Repository.BookRepository;
import com.example.jpademo.demo.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book getOne(int Book_id) {
        return bookRepository.findById( Book_id).orElse(null);
    }

    @Autowired
    CategoryRepository categoryRepository;

    public Book save(Optional<Integer> Book_id, String name, String synopsis, int category_id){
        Category category = categoryRepository.findById(category_id).orElse(null);
        if(category == null) {
            throw new IllegalArgumentException("Category does not exist");
        }
        Book book = new Book(name,synopsis,category);
        return save(book);
    }

    public Book save(Book book) {
        if(book.getName() == null || book.getName() == "") {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        bookRepository.save(book);
        return book;
    }

    public void delete(int Book_id) {
        bookRepository.deleteById(Book_id);
    }


}
