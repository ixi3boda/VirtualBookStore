package com.codewithme.firstApp.Controller;

import com.codewithme.firstApp.Model.Book;
import com.codewithme.firstApp.Request.BookRequest;
import com.codewithme.firstApp.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/addBook")
public class APIPostController {


    private BookService bookService;

    @Autowired
    public APIPostController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity <Book> addBook(@RequestBody BookRequest book){
        Book savedBook = bookService.saveBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    

}
