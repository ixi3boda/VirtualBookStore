package com.codewithme.firstApp.Service;

import com.codewithme.firstApp.Model.BooksDatabase;
import com.codewithme.firstApp.Model.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;

public class BookManagement {

    @Autowired
    private BooksDatabase bookDatabase;
    @Autowired
    private UserDatabase userDatabase;
    private User currentUser;

    public boolean addBook(String bookName,String bookAuthor,double bookPrice,String bookDescription,String bookCategory){
        for(User user: userDatabase.getUsers()){
            if(user.getUserId().equals(currentUser.getUserId())  && user.getUserRole().equals("user")){
                return false;
            }
            if(user.getUserId().equals(currentUser.getUserId())  && user.getUserRole().equals("admin")){

                Book book = Book.builder()
                        .bookId(java.util.UUID.randomUUID())
                        .bookName(bookName)
                        .bookAuthor(bookAuthor)
                        .bookPrice(bookPrice)
                        .bookDescription(bookDescription)
                        .bookCategory(bookCategory)
                        .build();
                bookDatabase.getBooks().add(book);
            }
        }
        return true;
    }

    public boolean deleteBook(String bookId){
        for(User user: userDatabase.getUsers()){
            if(user.getUserId().equals(currentUser.getUserId())  && user.getUserRole().equals("user")){
                return false;
            }
        }
        for(Book book: bookDatabase.getBooks()){
            if(book.getBookId().equals(bookId)){
                bookDatabase.getBooks().remove(book);
            }
        }
        return true;
    }

    public boolean addBookToCart(String bookId){
        for(User user: userDatabase.getUsers()){
            if(user.getUserId().equals(currentUser.getUserId())){
                user.getUserCart().add(bookId);
                return true;
            }
        }
        return false;
    }

    public boolean purchaseBooksInCart(){
        for(User user: userDatabase.getUsers()){
            if(user.getUserId().equals(currentUser.getUserId())){

            }
        }
        return true;
    }



}
