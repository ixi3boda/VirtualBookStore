package com.codewithme.firstApp.Mapper;

import com.codewithme.firstApp.DTO.BookDTO;
import com.codewithme.firstApp.Model.Book;
import lombok.Data;


@Data
public class BookMapper {

    public static Book mapBookDTOToBook(BookDTO book){
        Book bookk = Book.builder()
                     .bookId(book.getBookId())
                     .bookAuthor(book.getBookAuthor())
                     .bookDescription(book.getBookDescription())
                     .bookReview(book.getBookReview())
                     .bookRating(book.getBookRating())
                     .bookGenre(book.getBookGenre())
                     .bookImage(book.getBookImage())
                     .bookName(book.getBookName())
                     .bookPrice(book.getBookPrice())
                     .build();
        return bookk;
    }

    public static BookDTO mapBookToBookDTO(Book book){
        BookDTO bookDTO = BookDTO.builder()
                          .bookId(book.getBookId())
                          .bookAuthor(book.getBookAuthor())
                          .bookDescription(book.getBookDescription())
                          .bookReview(book.getBookReview())
                          .bookRating(book.getBookRating())
                          .bookGenre(book.getBookGenre())
                          .bookImage(book.getBookImage())
                          .bookName(book.getBookName())
                          .bookPrice(book.getBookPrice())
                          .build();
        return bookDTO;
    }



}
