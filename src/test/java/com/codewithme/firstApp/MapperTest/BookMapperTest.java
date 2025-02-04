package com.codewithme.firstApp.MapperTest;

import com.codewithme.firstApp.DTO.BookDTO;
import com.codewithme.firstApp.Mapper.BookMapper;
import com.codewithme.firstApp.Model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookMapperTest {

    private BookDTO bookDTO;
    private Book book;

    @BeforeEach
    void setUp() {
        // Initialize the BookDTO object
        bookDTO = BookDTO.builder()
                .bookId(1L)
                .bookAuthor("Author Name")
                .bookDescription("Book Description")
                .bookReview("This is a review.")
                .bookRating(4.5)
                .bookGenre("Fiction")
                .bookImage("image_url")
                .bookName("Book Name")
                .bookPrice(19.99)
                .build();

        // Initialize the Book object with values to compare later
        book = Book.builder()
                .bookId(1L)
                .bookAuthor("Author Name")
                .bookDescription("Book Description")
                .bookReview("This is a review.")
                .bookRating(4.5)
                .bookGenre("Fiction")
                .bookImage("image_url")
                .bookName("Book Name")
                .bookPrice(19.99)
                .build();
    }

    @Test
    void testMapBookDTOToBook() {
        // Call the method to map BookDTO to Book
        Book mappedBook = BookMapper.mapBookDTOToBook(bookDTO);

        // Assert that all the fields match
        assertEquals(bookDTO.getBookId(), mappedBook.getBookId());
        assertEquals(bookDTO.getBookAuthor(), mappedBook.getBookAuthor());
        assertEquals(bookDTO.getBookDescription(), mappedBook.getBookDescription());
        assertEquals(bookDTO.getBookReview(), mappedBook.getBookReview());
        assertEquals(bookDTO.getBookRating(), mappedBook.getBookRating());
        assertEquals(bookDTO.getBookGenre(), mappedBook.getBookGenre());
        assertEquals(bookDTO.getBookImage(), mappedBook.getBookImage());
        assertEquals(bookDTO.getBookName(), mappedBook.getBookName());
        assertEquals(bookDTO.getBookPrice(), mappedBook.getBookPrice());
    }

    @Test
    void testMapBookToBookDTO() {
        // Call the method to map Book to BookDTO
        BookDTO mappedBookDTO = BookMapper.mapBookToBookDTO(book);

        // Assert that all the fields match
        assertEquals(book.getBookId(), mappedBookDTO.getBookId());
        assertEquals(book.getBookAuthor(), mappedBookDTO.getBookAuthor());
        assertEquals(book.getBookDescription(), mappedBookDTO.getBookDescription());
        assertEquals(book.getBookReview(), mappedBookDTO.getBookReview());
        assertEquals(book.getBookRating(), mappedBookDTO.getBookRating());
        assertEquals(book.getBookGenre(), mappedBookDTO.getBookGenre());
        assertEquals(book.getBookImage(), mappedBookDTO.getBookImage());
        assertEquals(book.getBookName(), mappedBookDTO.getBookName());
        assertEquals(book.getBookPrice(), mappedBookDTO.getBookPrice());
    }
}
