package com.example.LibrarySpring.repository;

import com.example.LibrarySpring.model.Book;
import com.example.LibrarySpring.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LibraryRepository extends JpaRepository<Library,Long> {
    public List<Library> findById(int id);
}
