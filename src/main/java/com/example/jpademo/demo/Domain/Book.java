package com.example.jpademo.demo.Domain;

import javax.persistence.*;

@Entity(name="Book")
@Table(name="Book")

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Book_id", updatable = false)

    private int Book_id;

    @Column(name="name", updatable = true, nullable = false,  columnDefinition = "varchar(200)")
    private String name;

    @Column(name="synopsis", updatable = true, nullable = false, columnDefinition = "varchar(200)")
    private String synopsis;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    public Book()
    {

    }

    public Book(String name, String synopsis, Category category) {
        this.name = name;
        this.synopsis = synopsis;
        this.category = category;
    }

    public int getBook_id() {
        return Book_id;
    }

    public void setBook_id(int book_id) {
        Book_id = book_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
