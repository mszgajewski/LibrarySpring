package com.example.LibrarySpring.controller;

import com.example.LibrarySpring.model.Book;
import com.example.LibrarySpring.service.BookService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/showBooks")
    public String showBooks(Model model){
        Book book = new Book();
        model.addAttribute("book", book);
        return "register_form_book";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/addBooks")
    public String submitForm(@ModelAttribute("book") Book book) {
        bookService.addBook(book);
        return "register_form_book";
    }

    @RequestMapping("/allBooks")
    public String showAllBooks(Model model) {
       List<Book> books = bookService.findAll();
       model.addAttribute("book", books);
        return "list_of_books";
    }

    @RequestMapping("/allBooksByKeyword")
    public String showAllBooksByKeyword(Model model, @Param("keyword") String keyword) {
        List<Book> books = bookService.findBookByKeyword(keyword);
        model.addAttribute("book", books);
        return "list_of_books";
    }

    @DeleteMapping("/deleteBook")
    public String deleteBook(@ModelAttribute("book") Book book){
        bookService.deleteBook(book);
        return "list_of_books";
    }
}
