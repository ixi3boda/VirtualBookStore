package com.codewithme.firstApp.Controller;

import com.codewithme.firstApp.Model.Book;
import com.codewithme.firstApp.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class APIGetController {


    private BookService bookService;

    @Autowired
    public APIGetController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/Book")
    public Book getBook(@RequestParam String bookId){
        return bookService.getBookById(bookId);
    }

    @GetMapping("/Books")
    public ResponseEntity <List<Book>> getBooks(){
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }


}
