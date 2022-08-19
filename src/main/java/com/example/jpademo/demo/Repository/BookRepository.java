package com.example.jpademo.demo.Repository;

import com.example.jpademo.demo.Domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {

}
