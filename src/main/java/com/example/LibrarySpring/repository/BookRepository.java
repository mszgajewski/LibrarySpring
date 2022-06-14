package com.example.LibrarySpring.repository;

import com.example.LibrarySpring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE CONCAT( b.title, b.author) LIKE %?1%")
    List<Book> findBookByKeyword(String keyword);

    List <Book> findAll();

    Book findBookById(long bookId);
}
