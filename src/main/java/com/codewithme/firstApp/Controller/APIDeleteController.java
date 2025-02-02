package com.codewithme.firstApp.Controller;

import com.codewithme.firstApp.Service.BookService;
import com.codewithme.firstApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIDeleteController {

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @DeleteMapping("/{userId}")
    public ResponseEntity <String> deleteUser(@PathVariable long userId){
        if(userService.deleteUserByUserId(userId) != null){
            return ResponseEntity.ok("User with ID " + userId + " has been deleted.");
        }
        return ResponseEntity.ok("User with ID " + userId + "is not found");
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity <String> deleteBook(@PathVariable long bookId){
       if(bookService.deleteBookById(bookId) != null){
           return ResponseEntity.ok("Book with ID " + bookId + " has been deleted.");
       }
       return ResponseEntity.ok("Book with ID " + bookId + "is not found");
    }
}
