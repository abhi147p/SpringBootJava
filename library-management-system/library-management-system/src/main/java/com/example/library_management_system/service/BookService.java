package com.example.library_management_system.service;

import com.example.library_management_system.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAllBooks();

    Book createBook(Book book);

    void updateBook(Book book);

    void deleteBook(Long id);

    Optional<Book> findBookById(Long id); // Java 8 addition, which allows us to avoid the null pointer exception.
}
