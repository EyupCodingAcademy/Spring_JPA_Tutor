package com.example.jpademo.demo.Domain;

import javax.persistence.*;

@Entity(name = "Category")
@Table(name = "Category")
public class Category {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    private int category_id;

    @Column(columnDefinition = "varchar(50)", updatable = true, nullable = false)
    private String name;

    public Category() {

    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
