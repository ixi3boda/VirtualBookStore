package com.codewithme.firstApp.Controller;

import com.codewithme.firstApp.Model.Book;
import com.codewithme.firstApp.Service.BookService;
import com.codewithme.firstApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIPutController {

    @Autowired
    private BookService bookService;

    @PutMapping("/{bookId}")
    public ResponseEntity<Book> updateBookName(@PathVariable Long bookId, @RequestBody String newBookName){
        Book updatedBook = bookService.updateBookName(bookId, newBookName);
        return ResponseEntity.ok(updatedBook);
    }

}
