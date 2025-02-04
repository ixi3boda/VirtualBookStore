package com.codewithme.firstApp.ControllerTest;

import com.codewithme.firstApp.Controller.APIPutController;
import com.codewithme.firstApp.Model.Book;
import com.codewithme.firstApp.Service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class APIPutControllerTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private APIPutController apiPutController;

    private Long bookId;
    private String newBookName;
    private Book book;

    @BeforeEach
    void setUp() {
        bookId = 1L;
        newBookName = "Updated Book Name";

        // Initialize the Book object
        book = new Book();
        book.setBookId(bookId);
        book.setBookName("Original Book Name");
        book.setBookAuthor("Author");

        // Update the book's name for testing purposes
        book.setBookName(newBookName);
    }

    @Test
    void testUpdateBookName_BookExists() {
        // Mock the bookService to return the updated book object
        when(bookService.updateBookName(bookId, newBookName)).thenReturn(book);

        // Perform the PUT request
        ResponseEntity<Book> response = apiPutController.updateBookName(bookId, newBookName);

        // Assert the response status and the updated book name
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(newBookName, response.getBody().getBookName());
    }

    @Test
    void testUpdateBookName_BookNotFound() {
        // Mock the bookService to return null when book is not found
        when(bookService.updateBookName(bookId, newBookName)).thenReturn(null);

        // Perform the PUT request
        ResponseEntity<Book> response = apiPutController.updateBookName(bookId, newBookName);

        // Assert the response status (will be null here, handle accordingly if needed)
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(null, response.getBody());
    }
}
