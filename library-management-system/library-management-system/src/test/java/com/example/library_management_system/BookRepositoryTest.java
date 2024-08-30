package com.example.library_management_system;

import static org.junit.jupiter.api.Assertions.*;
import com.example.library_management_system.entity.Book;
import com.example.library_management_system.service.BookService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// ===================> This is unit test <====================
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional // used to reload to its new workspace for every test unit. i.e clears the workspace for every test;
// at end of test, it deletes the book we created. Roll back happens.

public class BookRepositoryTest {

    @Autowired
    private BookService bookService;

    @Test
    public void givenCreateBookThenExpectSameBook(){
        Book book = Book.builder()
                .name("Book 1")
                .description("Desc for book 1")
                .price(11.23)
                .build();

        Book actual = bookService.createBook(book);

        assertEquals(book.getName(), actual.getName());
        assertEquals(book.getDescription(), actual.getDescription());
        assertEquals(book.getPrice(), actual.getPrice());
    }
}
