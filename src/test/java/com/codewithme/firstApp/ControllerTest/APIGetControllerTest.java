package com.codewithme.firstApp.ControllerTest;

import com.codewithme.firstApp.Controller.APIGetController;
import com.codewithme.firstApp.Model.Book;
import com.codewithme.firstApp.Service.BookService;
import com.codewithme.firstApp.Service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class APIGetControllerTest {

    @Mock
    private BookService bookService;

    @Mock
    private UserService userService;

    @InjectMocks
    private APIGetController apiGetController;

    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp() {
        book1 = new Book();
        book1.setBookId(1L);
        book1.setBookName("Book one");
        book1.setBookAuthor("Author one");
        book2 = new Book();
        book2.setBookId(2L);
        book2.setBookName("Book 2");
        book2.setBookAuthor("Author 2");
    }

    @Test
    void testGetBookById() {
        when(bookService.getBookById(1L)).thenReturn(book1);
        ResponseEntity <Book> response = apiGetController.getBookById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(book1, response.getBody());
    }

    @Test
    void testGetAllBooks() {
        List<Book> books = Arrays.asList(book1, book2);
        when(bookService.getBooks()).thenReturn(books);
        ResponseEntity <List<Book>> response = apiGetController.getAllBooks();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(books, response.getBody());
    }

    @Test
    void testGetBookSuggestionsByName() {
        List<Book> suggestions = Arrays.asList(book1);
        when(bookService.getBookSuggestions("Book One")).thenReturn(suggestions);
        ResponseEntity<List<Book>> response = apiGetController.getBookSuggestionsByName("Book One");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(suggestions, response.getBody());
    }
}
