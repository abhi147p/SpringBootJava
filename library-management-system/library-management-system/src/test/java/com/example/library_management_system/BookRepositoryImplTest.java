package com.example.library_management_system;


import com.example.library_management_system.entity.Book;
import com.example.library_management_system.repository.BookRepository;
import com.example.library_management_system.service.BookService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


// =================> Mockito Test <======================
@SpringBootTest
@Transactional
@ExtendWith(MockitoExtension.class)
public class BookRepositoryImplTest {

    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;

    @Test
    public void addBookExpectCreated(){
        Book book = Book.builder()
                .name("Book 1")
                .description("Desc for book 1")
                .price(11.23)
                .build();

        Book actual = bookService.createBook(book);

        Mockito.verify(bookRepository, Mockito.times(1)).save(book);
    }
}
