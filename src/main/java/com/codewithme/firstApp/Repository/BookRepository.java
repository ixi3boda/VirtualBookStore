package com.codewithme.firstApp.Repository;


import com.codewithme.firstApp.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    // Custom query methods

    // Find books by genre
    List<Book> findByBookName(String bookName);

    // Find books with a rating greater than or equal to a certain value
    List<Book> findByBookRatingGreaterThanEqual(double bookRating);

    // Find books containing a specific keyword in the name
    List<Book> findByBookNameContainingIgnoreCase(String keyword);

    // Find books by author
    List<Book> findByBookAuthor(String bookAuthor);

    Book findByBookId(Long bookId);


    Object find(long l);
}

