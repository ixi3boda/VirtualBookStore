package com.codewithme.firstApp.ModelTest;

import com.codewithme.firstApp.Model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    private Book book;

    @BeforeEach
    void setUp() {
        // Initialize the Book object using the builder pattern
        book = Book.builder()
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
    void testBookBuilder() {
        // Assert that all the fields match the expected values
        assertEquals(1L, book.getBookId());
        assertEquals("The Great Book", book.getBookName());
        assertEquals("Famous Author", book.getBookAuthor());
        assertEquals(29.99, book.getBookPrice());
        assertEquals("An incredible book about greatness.", book.getBookDescription());
        assertEquals("Non-fiction", book.getBookGenre());
        assertEquals("A brilliant work of literature.", book.getBookReview());
        assertEquals(4.8, book.getBookRating());
        assertEquals("image_url", book.getBookImage());
    }

    @Test
    void testBookConstructor() {
        // Create a new Book object using the constructor
        Book bookWithConstructor = new Book(2L, "Another Great Book", "Another Author", 19.99,
                "A fantastic book.", "Fiction", "An amazing story.", 4.5, "another_image_url");

        // Assert that all the fields match the expected values
        assertEquals(2L, bookWithConstructor.getBookId());
        assertEquals("Another Great Book", bookWithConstructor.getBookName());
        assertEquals("Another Author", bookWithConstructor.getBookAuthor());
        assertEquals(19.99, bookWithConstructor.getBookPrice());
        assertEquals("A fantastic book.", bookWithConstructor.getBookDescription());
        assertEquals("Fiction", bookWithConstructor.getBookGenre());
        assertEquals("An amazing story.", bookWithConstructor.getBookReview());
        assertEquals(4.5, bookWithConstructor.getBookRating());
        assertEquals("another_image_url", bookWithConstructor.getBookImage());
    }

    @Test
    void testSettersAndGetters() {
        // Use the setters and assert the values after they are set
        book.setBookId(3L);
        book.setBookName("Updated Book Name");
        book.setBookAuthor("Updated Author");
        book.setBookPrice(39.99);
        book.setBookDescription("Updated description of the book.");
        book.setBookGenre("Historical Fiction");
        book.setBookReview("A deeply engaging story.");
        book.setBookRating(4.9);
        book.setBookImage("updated_image_url");

        // Assert that the updated values match
        assertEquals(3L, book.getBookId());
        assertEquals("Updated Book Name", book.getBookName());
        assertEquals("Updated Author", book.getBookAuthor());
        assertEquals(39.99, book.getBookPrice());
        assertEquals("Updated description of the book.", book.getBookDescription());
        assertEquals("Historical Fiction", book.getBookGenre());
        assertEquals("A deeply engaging story.", book.getBookReview());
        assertEquals(4.9, book.getBookRating());
        assertEquals("updated_image_url", book.getBookImage());
    }
}
