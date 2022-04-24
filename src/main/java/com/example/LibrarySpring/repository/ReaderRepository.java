package com.example.LibrarySpring.repository;

import com.example.LibrarySpring.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader,Long> {
    public Reader getReaderByName(String name);
}
