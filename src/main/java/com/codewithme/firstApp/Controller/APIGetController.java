package com.codewithme.firstApp.Controller;

import com.codewithme.firstApp.Model.Book;
import com.codewithme.firstApp.Service.BookService;
import com.codewithme.firstApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class APIGetController {

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;


    @GetMapping("/getBook")
    public ResponseEntity <Book> getBookById(@RequestParam Long bookId){
        return new ResponseEntity<>(bookService.getBookById(bookId),HttpStatus.OK);
    }

    @GetMapping("/Books")
    public ResponseEntity <List<Book>> getAllBooks(){
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    @GetMapping("/suggestions")
    public ResponseEntity <List<Book>> getBookSuggestionsByName(String bookName){
        return new ResponseEntity<>(bookService.getBookSuggestions(bookName), HttpStatus.OK);
    }





}
