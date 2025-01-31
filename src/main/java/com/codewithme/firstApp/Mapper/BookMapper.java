package com.codewithme.firstApp.Mapper;

import com.codewithme.firstApp.Model.Book;
import com.codewithme.firstApp.Request.BookRequest;
import lombok.Data;


@Data
public class BookMapper {

    public static Book mapBookReqToBook(BookRequest book){
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




}
