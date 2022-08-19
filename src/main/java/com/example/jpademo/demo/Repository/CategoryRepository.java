package com.example.jpademo.demo.Repository;

import com.example.jpademo.demo.Domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
