package com.codewithme.firstApp.Service;

import com.codewithme.firstApp.Mapper.BookMapper;
import com.codewithme.firstApp.Model.Book;
import com.codewithme.firstApp.Repository.BookRepository;
import com.codewithme.firstApp.Repository.UserRepository;
import com.codewithme.firstApp.Request.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

  //  @Autowired
  //  private User currentUser;

    public Book getBookById(String bookId){
        return bookRepository.findById(bookId).get();
    }

    public Book saveBook(BookRequest book){
        Book bookk = BookMapper.mapBookReqToBook(book);
        bookRepository.save(bookk);
        return bookk;
    }

    public List <Book> getBooks(){
        return bookRepository.findAll();
    }


 /*   public boolean deleteBook(String bookId){
        for(User user: userRepository.findAll()){
            if(user.getUserId().equals(currentUser.getUserId())  && user.getUserRole().equals("user")){
                return false;
            }
        }
        for(Book book: bookRepository.findAll()){
            if(book.getBookId().equals(bookId)){
                bookRepository.findAll().remove(book);
            }
        }
        return true;
    }

    public ArrayList <Book> suggestBooks(){
        ArrayList <Book> suggestedBooks = new ArrayList <>();
        return suggestedBooks;
    }

    public ArrayList <Book> searchForBooks(String bookName){
        ArrayList<Book> searchedBooks = new ArrayList <>();
        for(Book book: bookRepository.findAll()){
            if(book.getBookName().equals(bookName)){
                searchedBooks.add(book);
            }
        }
        return searchedBooks;
    }

 */




}
