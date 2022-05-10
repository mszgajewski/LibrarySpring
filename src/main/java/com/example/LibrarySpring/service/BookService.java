package com.example.LibrarySpring.service;

import com.example.LibrarySpring.model.Book;
import com.example.LibrarySpring.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void removeBook(Book book){
        bookRepository.delete(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> findBookByKeyword(String keyword) {
        return bookRepository.findByKeyword(keyword);
    }
}
