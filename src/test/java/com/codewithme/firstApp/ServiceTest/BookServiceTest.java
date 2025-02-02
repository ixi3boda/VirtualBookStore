package com.codewithme.firstApp.ServiceTest;


import com.codewithme.firstApp.Model.Book;
import com.codewithme.firstApp.Repository.BookRepository;
import com.codewithme.firstApp.Repository.UserRepository;
import com.codewithme.firstApp.Service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private BookService bookService;

    private Book book;

    @BeforeEach
    void setUp() {
        // Initialize the Book object to be used in the tests
        book = new Book();
        book.setBookId(1L);
        book.setBookName("Old Book Title");
    }

    @Test
    void testUpdateBookName_Success() {
        // Mock bookRepository behavior
        when(bookRepository.findByBookId(1L)).thenReturn(book);
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        // Call the service method to update the book name
        Book updatedBook = bookService.updateBookName(1L, "New Book Title");

        // Assert the updated book name
        assertNotNull(updatedBook);
        assertEquals("New Book Title", updatedBook.getBookName());

        // Verify repository interaction
        verify(bookRepository).findByBookId(1L);
        verify(bookRepository).save(book);
    }

    @Test
    void testUpdateBookName_BookNotFound() {
        // Mock bookRepository behavior to return null
        when(bookRepository.findByBookId(1L)).thenReturn(null);

        // Call the service method and assert that the result is null
        Book updatedBook = bookService.updateBookName(1L, "New Book Title");

        // Assert the result is null as book doesn't exist
        assertNull(updatedBook);

        // Verify repository interaction
        verify(bookRepository).findByBookId(1L);
    }

    @Test
    void testDeleteBookById_Success() {
        // Mock bookRepository behavior
        when(bookRepository.findByBookId(1L)).thenReturn(book);

        // Call the service method to delete the book
        Book deletedBook = bookService.deleteBookById(1L);

        // Assert that the book is returned after deletion
        assertNotNull(deletedBook);
        assertEquals(1L, deletedBook.getBookId());

        // Verify repository interaction
        verify(bookRepository).findByBookId(1L);
        verify(bookRepository).delete(book);
    }

    @Test
    void testDeleteBookById_BookNotFound() {
        // Mock bookRepository behavior to return null
        when(bookRepository.findByBookId(1L)).thenReturn(null);

        // Call the service method and assert that the result is null
        Book deletedBook = bookService.deleteBookById(1L);

        // Assert that no book was deleted
        assertNull(deletedBook);

        // Verify repository interaction
        verify(bookRepository).findByBookId(1L);
        verify(bookRepository, never()).delete(any(Book.class));
    }

    @Test
    void testGetBookById_Success() {
        // Mock bookRepository behavior to return a book
        when(bookRepository.findByBookId(1L)).thenReturn(book);

        // Call the service method to get the book by ID
        Book retrievedBook = bookService.getBookById(1L);

        // Assert that the book is returned correctly
        assertNotNull(retrievedBook);
        assertEquals(1L, retrievedBook.getBookId());
        assertEquals("Old Book Title", retrievedBook.getBookName());

        // Verify repository interaction
        verify(bookRepository).findByBookId(1L);
    }

    @Test
    void testGetBookById_BookNotFound() {
        // Mock bookRepository behavior to return null
        when(bookRepository.findByBookId(1L)).thenReturn(null);

        // Call the service method and assert that the result is null
        Book retrievedBook = bookService.getBookById(1L);

        // Assert that the result is null as the book doesn't exist
        assertNull(retrievedBook);

        // Verify repository interaction
        verify(bookRepository).findByBookId(1L);
    }
}
