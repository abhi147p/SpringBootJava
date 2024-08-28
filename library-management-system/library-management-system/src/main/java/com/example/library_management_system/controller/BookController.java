package com.example.library_management_system.controller;


import com.example.library_management_system.entity.Book;
import com.example.library_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String getAllBooks(Model model){
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books", books);
        return "index";
    }

    @PostMapping("/addBook")
    public String addNewBook(Book book){
        Book result = bookService.createBook(book);
        if(result==null){
            return "redirect:/";
        }
        return "redirect:/";
    }

    @RequestMapping({"/edit", "/edit/{id}"}) // as req mapping is table, so the args must be included in the closed braces
    public String editBook(Model model, @PathVariable("id")Optional<Long> id){
        if(id.isPresent()){
            Optional<Book> books = bookService.findBookById(id.get());
            if(books.isPresent()){
                model.addAttribute("book", books.get());
            }
            else{
                model.addAttribute("book", new Book());
            }
        }
        // even though id is not present, we need to create the empty book object, else we get error as book object is not binded.
        else {
            model.addAttribute("book", new Book()); // If no ID is provided, create a new empty Book object
        }
        return "add-edit-book";
    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return "redirect:/";
    }
}
