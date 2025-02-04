package com.codewithme.firstApp.ServiceTest;


import com.codewithme.firstApp.DTO.BookDTO;
import com.codewithme.firstApp.Mapper.BookMapper;
import com.codewithme.firstApp.Model.Book;
import com.codewithme.firstApp.Service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

   @Mock
   private BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

   @Test
   void bookIdShouldReturnCorrectBook(){
        Book testBook = new Book();
        testBook.setBookName("hello");
        testBook.setBookAuthor("charles");
        testBook.setBookId(1L);
        when(bookService.getBookById(1L)).thenReturn(testBook);

        Book actualBook = bookService.getBookById(1L);

        assertNotNull(actualBook);
       assertEquals(testBook.getBookId(), actualBook.getBookId());
       assertEquals(testBook.getBookName(), actualBook.getBookName());
       assertEquals(testBook.getBookAuthor(), actualBook.getBookAuthor());
   }

   @Test
   void saveingBookDTOShouldSaveABook(){
       Book testBook = new Book();
       BookDTO testBookDto = BookMapper.mapBookToBookDTO(testBook);
       testBookDto.setBookId(2L);
       testBookDto.setBookAuthor("chr");
       testBookDto.setBookPrice(847.6);
       when(bookService.saveBook(testBookDto)).thenReturn(testBook);

       Book actualBook = bookService.saveBook(testBookDto);

       assertNotNull(actualBook);
       assertEquals(testBook.getBookId(), actualBook.getBookId());
       assertEquals(testBook.getBookName(), actualBook.getBookName());
       assertEquals(testBook.getBookAuthor(), actualBook.getBookAuthor());
   }



}
