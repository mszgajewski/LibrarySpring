package com.example.LibrarySpring.repository;

import com.example.LibrarySpring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE CONCAT( b.title, b.author) LIKE %?1%")
    public List<Book> findBookByKeyword(String keyword);

    List <Book> findAll();
/*
    void addBook(Book book);

*/

    Book findBookById(Long bookId);


}
