package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class BookController {
    @Autowired
    BookRepo bookRepo;

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }
    //create book
    @PostMapping("/book")
    public Book createBook(@RequestBody Book book){
        return bookRepo.save(book);
    }
    //get book by id
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookRepo.findById(id).get();
    }

    //update book
    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody boolean b){
        Book book1 = bookRepo.findById(id).get();
        book1.setEmprunte(b);
        return bookRepo.save(book1);

    }
    //delete book
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id){
        Book book = bookRepo.findById(id).get();
        bookRepo.delete(book);
    }


}
