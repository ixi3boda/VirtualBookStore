package com.codewithme.firstApp.DTOTest;

import com.codewithme.firstApp.DTO.UserDTO;
import com.codewithme.firstApp.Model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDTOTest {

    private UserDTO userDTO;

    @BeforeEach
    void setUp() {
        // Initialize the UserDTO object using the builder pattern
        ArrayList<Book> favoriteBooks = new ArrayList<>();
        Book book1 = new Book(1L, "Book One", "Author One", 19.99, "Description One", "Genre One", "Review One", 4.5, "Image One");
        Book book2 = new Book(2L, "Book Two", "Author Two", 29.99, "Description Two", "Genre Two", "Review Two", 4.8, "Image Two");
        favoriteBooks.add(book1);
        favoriteBooks.add(book2);

        userDTO = UserDTO.builder()
                .userId(1L)
                .userName("Test User")
                .userEmail("testuser@example.com")
                .userPassword("password123")
                .userRole("USER")
                .userFavoriteBooks(favoriteBooks)
                .build();
    }

    @Test
    void testUserDTOBuilder() {
        // Assert that all the fields match the expected values
        assertEquals(1L, userDTO.getUserId());
        assertEquals("Test User", userDTO.getUserName());
        assertEquals("testuser@example.com", userDTO.getUserEmail());
        assertEquals("password123", userDTO.getUserPassword());
        assertEquals("USER", userDTO.getUserRole());
        assertEquals(2, userDTO.getUserFavoriteBooks().size());  // Check if the favorite books list has 2 books
        assertEquals("Book One", userDTO.getUserFavoriteBooks().get(0).getBookName());
        assertEquals("Book Two", userDTO.getUserFavoriteBooks().get(1).getBookName());
    }


    @Test
    void testSettersAndGetters() {
        // Use the setters and assert the values after they are set
        userDTO.setUserId(3L);
        userDTO.setUserName("Updated User");
        userDTO.setUserEmail("updated@example.com");
        userDTO.setUserPassword("newPassword");
        userDTO.setUserRole("MODERATOR");

        ArrayList<Book> favoriteBooks = new ArrayList<>();
        Book book = new Book(4L, "Book Four", "Author Four", 49.99, "Description Four", "Genre Four", "Review Four", 4.2, "Image Four");
        favoriteBooks.add(book);
        userDTO.setUserFavoriteBooks(favoriteBooks);

        // Assert that the updated values match
        assertEquals(3L, userDTO.getUserId());
        assertEquals("Updated User", userDTO.getUserName());
        assertEquals("updated@example.com", userDTO.getUserEmail());
        assertEquals("newPassword", userDTO.getUserPassword());
        assertEquals("MODERATOR", userDTO.getUserRole());
        assertEquals(1, userDTO.getUserFavoriteBooks().size());
        assertEquals("Book Four", userDTO.getUserFavoriteBooks().get(0).getBookName());
    }
}
