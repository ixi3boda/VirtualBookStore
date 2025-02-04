package com.codewithme.firstApp.ControllerTest;

import com.codewithme.firstApp.Controller.APIPostController;
import com.codewithme.firstApp.DTO.BookDTO;
import com.codewithme.firstApp.DTO.UserDTO;
import com.codewithme.firstApp.Mapper.BookMapper;
import com.codewithme.firstApp.Mapper.UserMapper;
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
public class APIPostControllerTest {

    @Mock
    private BookService bookService;

    @Mock
    private UserService userService;

    @InjectMocks
    private APIPostController apiPostController;

    private BookDTO bookDTO;
    private UserDTO userDTO;
    private Book book;
    private User user;

    @BeforeEach
    void setUp() {
        Book befMap = new Book();
        befMap.setBookName("New Book");
        befMap.setBookAuthor("New Author");
        bookDTO = BookMapper.mapBookToBookDTO(befMap);

        User bef = new User();
        bef.setUserName("newUser");
        bef.setUserEmail("newuser@example.com");
        userDTO = UserMapper.mapUserToUserDTO(bef);

        book = new Book();
        book.setBookId(1L);
        book.setBookName("New Book");
        book.setBookAuthor("New Author");

        user = new User();
        user.setUserId(1L);
        user.setUserName("NewUser");
        user.setUserEmail("newuser@example.com");
    }

    @Test
    void testAddBook() {
        // Mock the bookService to return a saved book
        when(bookService.saveBook(bookDTO)).thenReturn(book);

        // Perform the POST request
        ResponseEntity<Book> response = apiPostController.addBook(bookDTO);

        // Assert the status and body of the response
        assertEquals(201, response.getStatusCodeValue());
        assertEquals(book, response.getBody());
    }

    @Test
    void testAddUser() {
        // Mock the userService to return a saved user
        when(userService.saveUser(userDTO)).thenReturn(user);

        // Perform the POST request
        ResponseEntity <User> response = apiPostController.addUser(userDTO);

        // Assert the status and body of the response
        assertEquals(201, response.getStatusCodeValue());
        assertEquals(user, response.getBody());
    }
}
