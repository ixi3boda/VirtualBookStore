package com.codewithme.firstApp.Repository;


import com.codewithme.firstApp.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class BookRepositoryImp implements BookRepository {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findByBookName(String bookName) {
        List <Book> books = new ArrayList<Book>();
        for(Book book:bookRepository.findAll()){
            if(book.getBookName().equals(bookName)) books.add(book);
        }
        return books;
    }

    @Override
    public List<Book> findByBookRatingGreaterThanEqual(double bookRating) {
        return List.of();
    }

    @Override
    public List<Book> findByBookNameContainingIgnoreCase(String keyword) {
        return List.of();
    }

    @Override
    public List<Book> findByBookAuthor(String bookAuthor) {
        return List.of();
    }

    @Override
    public Book findByBookId(Long bookId) {
       for(Book book:bookRepository.findAll()){
           if(book.getBookId().equals(bookId)) return book;
       }
       return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Book> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Book> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Book> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Book getOne(String s) {
        return null;
    }

    @Override
    public Book getById(String s) {
        return null;
    }

    @Override
    public Book getReferenceById(String s) {
        return null;
    }

    @Override
    public <S extends Book> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Book> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Book> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Book> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Book> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Book> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Book, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Book> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Book> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Book> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<Book> findAll() {
        return List.of();
    }

    @Override
    public List<Book> findAllById(Iterable<String> strings) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Book entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Book> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Book> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return null;
    }
}
