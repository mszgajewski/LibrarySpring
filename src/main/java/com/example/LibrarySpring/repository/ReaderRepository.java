package com.example.LibrarySpring.repository;

import com.example.LibrarySpring.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReaderRepository extends JpaRepository<Reader,Long> {
    @Query("SELECT r FROM Reader r WHERE CONCAT( r.name, r.surname) LIKE %?1%")
    List<Reader> getReaderByName(String name);

    List <Reader> findAll();

    @Override
    void delete(Reader entity);



    Reader findReaderById(long bookId);
}
