package com.example.jpademo.demo.Resource;

import com.example.jpademo.demo.Domain.Book;
import com.example.jpademo.demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookResource {

    @Autowired
    BookService bookService;

    @GetMapping("/")
    public ResponseEntity<List<Book>> get() {
        List<Book> books = bookService.getAll();

        return new ResponseEntity<>(books, HttpStatus.OK);

    }

    @GetMapping("/{Book_id}")
    public ResponseEntity<Book> getOne(HttpServletRequest request, @PathVariable("Book_id") int Book_id) {
        Book book = bookService.getOne(Book_id);
       if(book != null)
        return new ResponseEntity<>(book,HttpStatus.OK);
       else
           return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/create")
    public ResponseEntity<Book> create (HttpServletRequest request, @RequestBody Map<String,Object> bookMap) {
        String name = (String) bookMap.get("name");
        String synopsis = (String) bookMap.get("synopsis");
        int category_id = (int) bookMap.get("category_id");

        Book book = bookService.save(null,name,synopsis,category_id);

        return new ResponseEntity<>(book,HttpStatus.CREATED);
    }

    @PutMapping("/update/{Book_id}")
    public ResponseEntity<Map<String,Boolean>> update(
            HttpServletRequest request,
            @PathVariable("Book_id") int Book_id,
            @RequestBody Map<String,Object> bookMap){

        String name = (String) bookMap.get("name");
        String synopsis = (String) bookMap.get("synopsis");
        int category_id = (int) bookMap.get("category_id");

        Book book = bookService.save(Optional.ofNullable(Book_id),name,synopsis,category_id);

        Map<String,Boolean> map = new HashMap<>();
        map.put("success",true);
        return new ResponseEntity<>(map,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{Book_id}")
    public ResponseEntity<Map<String,Boolean>> delete(
            HttpServletRequest request,
            @PathVariable("Book_id") int Book_id) {
        bookService.delete(Book_id);
        Map<String,Boolean> map = new HashMap<>();
        map.put("success",true);
        return new ResponseEntity<>(map,HttpStatus.OK);

    }

}
