package com.example.LibrarySpring.controller;

import com.example.LibrarySpring.model.Book;
import com.example.LibrarySpring.repository.BookRepository;
import com.example.LibrarySpring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/addBooks")
    public String showBooks(Model model){
        Book book = new Book();
        model.addAttribute("book", book);
        return "register_form_book";
    }

    @PostMapping("/addBooks")
    public String submitForm(@ModelAttribute("book") Book book) {
        bookService.addBook(book);
        return "register_success";
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

    @GetMapping("/updateBook/{id}")
    public String updateBook(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute("book", book);
        return "book_edit";
    }

    @PostMapping("/updateBook/{id}")
    public String updateBook(@ModelAttribute("book") Book editedBook, @PathVariable("id") Long id, Model model) {
        bookRepository.save(editedBook);
        model.addAttribute("book", editedBook);
        return "list_of_books";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id")Long id, Model model) {
        Book book = bookService.findBookById(id);
        bookRepository.delete(book);
        model.addAttribute("book", book);
        return "list_of_books";
    }
}

