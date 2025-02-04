package com.codewithme.firstApp.DTOTest;

import com.codewithme.firstApp.DTO.BookDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookDTOTest {

    private BookDTO bookDTO;

    @BeforeEach
    void setUp() {
        // Initialize the BookDTO object using the builder pattern
        bookDTO = BookDTO.builder()
                .bookId(1L)
                .bookName("The Great Book")
                .bookAuthor("Famous Author")
                .bookPrice(29.99)
                .bookDescription("An incredible book about greatness.")
                .bookGenre("Non-fiction")
                .bookReview("A brilliant work of literature.")
                .bookRating(4.8)
                .bookImage("image_url")
                .build();
    }

    @Test
    void testBookDTOBuilder() {
        // Assert that all the fields match the expected values
        assertEquals(1L, bookDTO.getBookId());
        assertEquals("The Great Book", bookDTO.getBookName());
        assertEquals("Famous Author", bookDTO.getBookAuthor());
        assertEquals(29.99, bookDTO.getBookPrice());
        assertEquals("An incredible book about greatness.", bookDTO.getBookDescription());
        assertEquals("Non-fiction", bookDTO.getBookGenre());
        assertEquals("A brilliant work of literature.", bookDTO.getBookReview());
        assertEquals(4.8, bookDTO.getBookRating());
        assertEquals("image_url", bookDTO.getBookImage());
    }


    @Test
    void testSettersAndGetters() {
        // Use the setters and assert the values after they are set
        bookDTO.setBookId(3L);
        bookDTO.setBookName("Updated Book Name");
        bookDTO.setBookAuthor("Updated Author");
        bookDTO.setBookPrice(39.99);
        bookDTO.setBookDescription("Updated description of the book.");
        bookDTO.setBookGenre("Historical Fiction");
        bookDTO.setBookReview("A deeply engaging story.");
        bookDTO.setBookRating(4.9);
        bookDTO.setBookImage("updated_image_url");

        // Assert that the updated values match
        assertEquals(3L, bookDTO.getBookId());
        assertEquals("Updated Book Name", bookDTO.getBookName());
        assertEquals("Updated Author", bookDTO.getBookAuthor());
        assertEquals(39.99, bookDTO.getBookPrice());
        assertEquals("Updated description of the book.", bookDTO.getBookDescription());
        assertEquals("Historical Fiction", bookDTO.getBookGenre());
        assertEquals("A deeply engaging story.", bookDTO.getBookReview());
        assertEquals(4.9, bookDTO.getBookRating());
        assertEquals("updated_image_url", bookDTO.getBookImage());
    }
}
