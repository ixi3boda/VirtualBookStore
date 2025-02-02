package com.codewithme.firstApp.Controller;

import com.codewithme.firstApp.DTO.BookDTO;
import com.codewithme.firstApp.DTO.UserDTO;
import com.codewithme.firstApp.Model.Book;
import com.codewithme.firstApp.Model.User;
import com.codewithme.firstApp.Service.BookService;
import com.codewithme.firstApp.Service.UserService;
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
public class APIPostController {

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    @PostMapping("/addBook")
    public ResponseEntity <Book> addBook(@RequestBody BookDTO book){
        Book savedBook = bookService.saveBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @PostMapping("/addUser")
    public ResponseEntity <User> addUser(@RequestBody UserDTO user){
        User savedUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }





}
