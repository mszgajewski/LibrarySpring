package com.example.LibrarySpring.repository;

import com.example.LibrarySpring.model.Book;
import com.example.LibrarySpring.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReaderRepository extends JpaRepository<Reader,Long> {
    @Query("SELECT b FROM Book b WHERE CONCAT( b.title, b.author) LIKE %?1%")
    List<Reader> getReaderByName(String name);

}
