package com.codewithme.firstApp.RepositoryTest;

import com.codewithme.firstApp.Model.Book;
import com.codewithme.firstApp.Repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;


    @Test
    void findByBookIdShouldReturnCorrectBook(){
        Book testBook = new Book();
        testBook.setBookAuthor("charles");
        testBook.setBookName("hello");
        testBook.setBookName("grg");
        testBook.setBookPrice(54.67);
        testBook.setBookGenre("rgrg");
        testBook.setBookDescription("rgrg");
        testBook.setBookRating(5);
        testBook.setBookImage("rgrg");
        testBook.setBookReview("rgrg");

        bookRepository.save(testBook);

        Book actualBook = bookRepository.findByBookId(testBook.getBookId());

        assertNotNull(actualBook);
        assertEquals(testBook.getBookId(),actualBook.getBookId());
        assertEquals(testBook.getBookName(),actualBook.getBookName());
        assertEquals(testBook.getBookAuthor(),actualBook.getBookAuthor());
    }

}
