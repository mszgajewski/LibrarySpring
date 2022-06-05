package com.example.LibrarySpring.service;

import com.example.LibrarySpring.model.Book;
import com.example.LibrarySpring.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBookById(long id) { bookRepository.deleteBookById(id); }

    public void deleteBook(Book book) { bookRepository.delete(book); }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> findBookByKeyword(String keyword) {
        return bookRepository.findBookByKeyword(keyword);
    }

    public Book findBookById(long id) {
        Optional <Book> optional = Optional.ofNullable(bookRepository.findBookById(id));
        Book book = null;
        if(optional.isPresent()) {
            book = optional.get();
        } else {
            throw new RuntimeException("Nie znaleziono książki po id :: " + id);
        }
        return book;
    }

}
