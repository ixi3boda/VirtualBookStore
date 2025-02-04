package com.codewithme.firstApp.ControllerTest;

import com.codewithme.firstApp.Controller.APIDeleteController;
import com.codewithme.firstApp.Model.Book;
import com.codewithme.firstApp.Model.User;
import com.codewithme.firstApp.Service.BookService;
import com.codewithme.firstApp.Service.UserService;
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
public class APIDeleteControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private BookService bookService;

    @InjectMocks
    private APIDeleteController apiDeleteController;

    private Long userId;
    private Long bookId;
    private User user;
    private Book book;

    @BeforeEach
    void setUp() {
        userId = 1L;
        bookId = 1L;

        user = new User();
        user.setUserId(userId);
        user.setUserName("User1");
        user.setUserEmail("user1@example.com");

        book = new Book();
        book.setBookId(bookId);
        book.setBookName("Book1");
        book.setBookAuthor("Author1");
    }

    @Test
    void testDeleteUser_UserExists() {
        // Mock the userService to return the user object when deleting user
        when(userService.deleteUserByUserId(userId)).thenReturn(user);

        // Perform the DELETE request
        ResponseEntity<String> response = apiDeleteController.deleteUser(userId);

        // Assert the response status and body
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("User with ID 1 has been deleted.", response.getBody());
    }

    @Test
    void testDeleteUser_UserNotFound() {
        // Mock the userService to return null when deleting a non-existing user
        when(userService.deleteUserByUserId(userId)).thenReturn(null);

        // Perform the DELETE request
        ResponseEntity<String> response = apiDeleteController.deleteUser(userId);

        // Assert the response status and body
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("User with ID 1is not found", response.getBody());
    }

    @Test
    void testDeleteBook_BookExists() {
        // Mock the bookService to return the book object when deleting book
        when(bookService.deleteBookById(bookId)).thenReturn(book);

        // Perform the DELETE request
        ResponseEntity<String> response = apiDeleteController.deleteBook(bookId);

        // Assert the response status and body
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Book with ID 1 has been deleted.", response.getBody());
    }

    @Test
    void testDeleteBook_BookNotFound() {
        // Mock the bookService to return null when deleting a non-existing book
        when(bookService.deleteBookById(bookId)).thenReturn(null);

        // Perform the DELETE request
        ResponseEntity<String> response = apiDeleteController.deleteBook(bookId);

        // Assert the response status and body
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Book with ID 1is not found", response.getBody());
    }
}
