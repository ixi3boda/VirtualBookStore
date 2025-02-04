package com.codewithme.firstApp.Service;

import com.codewithme.firstApp.DTO.BookDTO;
import com.codewithme.firstApp.Mapper.BookMapper;
import com.codewithme.firstApp.Model.Book;
import com.codewithme.firstApp.Repository.BookRepository;
import com.codewithme.firstApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;


    public Book getBookById(Long bookId){
        return bookRepository.findById(bookId).get();
    }

    public Book saveBook(BookDTO book){
        Book bookk = BookMapper.mapBookDTOToBook(book);
        bookRepository.save(bookk);
        return bookk;
    }

    public List <Book> getBooks(){
        return bookRepository.findAll();
    }


    public List <Book> getBookSuggestions(String bookName){
       return bookRepository.findByBookName(bookName);
    }

    public Book deleteBookById(long bookId){
        Book book = bookRepository.findByBookId(bookId);
        if(book == null) return null;
        bookRepository.delete(book);
        return book;
    }

    public Book updateBookName(Long bookId,String newBookName){
        Book book = bookRepository.findByBookId(bookId);
        if(book == null) return null;
        book.setBookName(newBookName);
        return book;
    }






}
