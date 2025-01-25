package com.codewithme.firstApp.Model;

import com.codewithme.firstApp.Service.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BooksDatabase {

    private ArrayList <Book> books;

    public BooksDatabase(){
        books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks(){
        return books;
    }

}
