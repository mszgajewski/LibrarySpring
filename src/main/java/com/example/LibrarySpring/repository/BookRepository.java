package com.example.LibrarySpring.repository;

import com.example.LibrarySpring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE CONCAT( b.title, b.author) LIKE %?1%")
    public List<Book> findByKeyword(String keyword);
}
